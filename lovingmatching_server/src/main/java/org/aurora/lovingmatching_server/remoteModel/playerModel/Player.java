package org.aurora.lovingmatching_server.remoteModel.playerModel;


import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageEnum;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.NullReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.HistoryRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.PlayerRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.RecordRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.Request;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.RoomRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.TrendRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageTrannslator.Type;
import org.aurora.lovingmatching_server.remoteMessage.netConnector.MailBox;
import org.aurora.lovingmatching_server.remoteModel.historyModel.AbstractHistoryModel;
import org.aurora.lovingmatching_server.remoteModel.historyModel.History;
import org.aurora.lovingmatching_server.remoteModel.roomModel.RequestQueue;
import org.aurora.lovingmatching_server.remoteModel.roomModel.RoomProcessor;
import org.aurora.lovingmatching_server.remoteModel.roomModel.StubRoomProcessor;

public class Player extends Thread{
	private String id;

	private MailBox mail_box;
	private RequestQueue  request_queue;
	
	private RoomProcessor room_processor;
	private InfoCenter info_center;

	private AbstractHistoryModel history;
	
	private boolean LOGIN;
	private boolean QUIT;
	private boolean IN_ROOM;
	

	public Player(MailBox box){
		mail_box = box;
		request_queue = null;
		QUIT = false;
		room_processor = new RoomProcessor();
		info_center = new InfoCenter();
		history = new History();
		
		box.start();
	}

	public String getPlayerId(){
		return id;
	}
	
	public MailBox getMailBox(){
		return mail_box;
	}
	
	@Override
	public void run(){
		Request request;
		
		/////////////////////////////
		System.out.println("Player is running....");
		/////////////////////////////
		
		while(!QUIT){
			if(mail_box.hasMail()){
				request = mail_box.getRequest();
				process(request);
			}
		}
		
	}
	
	private void process(Request request){
		Type type = Type.valueOf(request.getType());
		switch(type){
		case player:
			playerProcess(request);
			break;
		case room:
			roomProcess(request);
			break;
		case history:
			historyProcess(request);
			break;
		case trend:
			trendProcess(request);
			break;
		case record:
			recordProcess(request);
			break;
		case match:
			if(request_queue != null){
				request_queue.addRequest(request);
			}
			break;
		case quit:
			quit();
			break;
		}
	}
	
private void playerProcess(Request r){
		PlayerRequest request = (PlayerRequest)r;
		String action = request.getAction();
		MessageReply reply = new MessageReply();
		
		switch(action){
		case "register":
			if(info_center.register(request.getID(), request.getPW())){
				reply.setSuccess();
				this.id = request.getID();
				PlayerCenter.addMailBox(id, mail_box);
				LOGIN = true;
			}else{
				reply.setAdditionMesg(MessageEnum.ID_ALREADY_EXISTED);
				LOGIN = false;
			}
			sendReply(reply);
			
			break;

		case "login":
			if(info_center.testLogin(request.getID(), request.getPW())){
				reply.setSuccess();
				this.id = request.getID();
				PlayerCenter.addMailBox(id, mail_box);
				LOGIN = true;
			}else{
				reply.setAdditionMesg(MessageEnum.INVALID_ID_OR_PW);
				LOGIN = false;
			}
			sendReply(reply);
			break;

		case "changePW":
			if(info_center.changePW(request.getID(), request.getPW(), request.getNewPW())){
				reply.setSuccess();
			}else{
				reply.setAdditionMesg(MessageEnum.INVALID_ID_OR_PW);
			}
			sendReply(reply);
			break;

		case "logout":
			logout();
			break;
		}
		
	}
	
	private void roomProcess(Request r){
		RoomRequest request = (RoomRequest)r;
		String action = request.getAction();
		MessageReply reply;
		
		switch(action){
		case "create":
			reply = room_processor.create(request);
			sendReply(reply);
			break;
		case "join":
			reply = room_processor.join(request);
			if(reply.isSuccessful()){
				request_queue = room_processor.getRequestQueue(id, request.getRoomId(), request.getRoomType());
				IN_ROOM = true;
			}
			sendReply(reply);
			break;
		case "drop":
			reply = room_processor.drop(request);
			if(reply.isSuccessful()){
				request_queue = null;
				IN_ROOM = false;
			}
			sendReply(reply);
			break;
		}
	}
	

	private void historyProcess(Request r)
	{
		HistoryRequest request = (HistoryRequest)r;
		
		String game_type = request.getGameType();
		String id = request.getID();
		
		Reply reply = new Reply();
		
		if(game_type.equals("coop"))
			reply = history.getCoopHistory(id);

		if(game_type.equals("vs"))
			reply = history.getPKHistory(id);
		
		sendReply(reply);
	}
	
	private void trendProcess(Request r)
	{
		TrendRequest request = (TrendRequest)r;
		
		String game_type = request.getGameType();
		String data_type = request.getDataType();
		String id = request.getID();
		String limit = request.getLimit();
		
		Reply reply = new Reply();
		
		if(game_type.equals("coop"))
			reply = history.getCoopTrendHistory(id, data_type, limit);

		if(game_type.equals("vs"))
			reply = history.getPKTrendHistory(id, data_type, limit);
		
		sendReply(reply);
	}

	private void recordProcess(Request r)
	{
		RecordRequest request = (RecordRequest)r;
		
		String game_type = request.getGameType();
		String id = request.getID();
		String limit = request.getLimit();
		
		Reply reply = new Reply();
		
		if(game_type.equals("coop"))
			reply = history.getCoopRecordHistory(id, limit);

		if(game_type.equals("vs"))
			reply = history.getPKRecordHistory(id, limit);
		
		sendReply(reply);
	}

	private void sendReply(Reply reply){
		mail_box.sendReply(reply);
	}
	
	private void logout(){
		PlayerCenter.removeMailBox(id);
		id = null;
		LOGIN = false;
	}
	
	private void quit(){
		QUIT = true;
		mail_box.close();
		
		////////////////////
		System.out.println("mail box has closed!");
		///////////////////
		
		PlayerCenter.removePlayer(this);
	}

}
