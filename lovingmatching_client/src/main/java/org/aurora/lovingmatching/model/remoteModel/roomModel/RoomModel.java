package org.aurora.lovingmatching.model.remoteModel.roomModel;

import org.aurora.lovingmatching.model.remoteModel.playerModel.PlayerModel;
import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching.remoteMessage.messageSet.Request.RoomRequest;
import org.aurora.lovingmatching.remoteMessage.netConnector.AbstractNetAssistant;
import org.aurora.lovingmatching.remoteMessage.netConnector.NetAssistant;
import org.aurora.lovingmatching.vo.MessageVO;

public class RoomModel implements AbstractRoomModel {
	private AbstractNetAssistant net_assistant;
	private String pid;
	private String rid;
	private boolean IN_ROOM;
	
	public RoomModel()
	{
		net_assistant = new NetAssistant();
		IN_ROOM = false;
	}

	public MessageVO createCoopRoom(String rid, int pnum) {
		return createRoom(rid, "coop", pnum, 0);
	}

	public MessageVO joinCoopRoom(String rid) {
		return joinRoom(rid, "coop");
	}

	public void dropCoopRoom() {
		dropRoom("coop");
	}

	public MessageVO createVSRoom(String rid, int pnum1, int pnum2) {
		return createRoom(rid, "vs", pnum1, pnum2);
	}

	public MessageVO joinVSRoom(String rid) {
		return joinRoom(rid, "vs");
	}

	public void dropVSRoom() {
		dropRoom("vs");
	}
	

	private MessageVO createRoom(String rid, String room_type, int pnum1, int pnum2) {
		MessageVO message;

		if(! getPlayerId())		//玩家未登录
		{
			message = new MessageVO();
			message.setSystemError();
			return message;
		}

		RoomRequest request = new RoomRequest("create", pid, room_type, rid);
		request.setNum1(pnum1);
		if(room_type.equals("vs"))
			request.setNum2(pnum2);
		
		MessageReply reply = (MessageReply)net_assistant.getReply(request);
		if(reply.isSuccessful()) 
		{
			message = new MessageVO(true);
			this.rid = rid;
			IN_ROOM = true;
		}else
		{
			message = new MessageVO(false, reply.getAdditionMesg());
		}

		return message;
	}

	private MessageVO joinRoom(String rid, String room_type) {
		MessageVO message;

		if((! getPlayerId()) || IN_ROOM)	// 玩家未登录或玩家已在房间内
		{
			message = new MessageVO();
			message.setSystemError();
			return message;
		}
		
		RoomRequest request = new RoomRequest("join", pid, room_type, rid);
		
		MessageReply reply = (MessageReply)net_assistant.getReply(request);
		if(reply.isSuccessful())
		{
			message = new MessageVO(true);
			IN_ROOM = true;
		}else
		{
			message = new MessageVO(false, reply.getAdditionMesg());
		}
		
		return message;
	}

	private void dropRoom(String room_type) {
		if((! getPlayerId()) || !IN_ROOM)	// 玩家未登录或玩家不在房间内
		{
			return;
		}
		
		RoomRequest request = new RoomRequest("drop", pid, room_type, rid);
		
		net_assistant.sendRequest(request);
		
	}

	private boolean getPlayerId()
	{
		return ((pid = PlayerModel.getPlayerId()) != null);
	}
}
