package org.aurora.lovingmatching_server.remoteModel.roomModel;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.Request;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.RoomRequest;

public class RoomProcessor {
	private RoomCenter room_center;
	private VSRoomCenter vs_room_center;

	public RoomProcessor()
	{
		room_center = RoomBase.getRoomCenter();
		vs_room_center = RoomBase.getVSRoomCenter();
	}
	
	//创建房间
	public MessageReply create(RoomRequest request){
		
		System.out.println("Got a create request");
		
		String room_type = request.getRoomType();
		
		MessageReply reply  = new MessageReply();
		
		if(room_type.equals("coop")){	//协作房间
			reply = room_center.createRoom(request.getRoomId());
		}else if(room_type.equals("vs")){	//对战房间
			reply = vs_room_center.createVSRoom(request.getRoomId());
		}
				

		System.out.println("Got a reply");		
		
		return reply;
	}
	
	//加入房间
	public MessageReply join(RoomRequest request){
		
		System.out.println("Got a join request");		
		
		String room_type = request.getRoomType();
		
		MessageReply reply = new MessageReply();
		
		if(room_type.equals("coop")){
			reply = room_center.joinRoom(request.getPlayerId(), request.getRoomId());
		}else if(room_type.equals("vs")){
			reply = vs_room_center.joinVSRoom(request.getPlayerId(), request.getRoomId());
		}
		

		System.out.println("Got a reply");		
		
		return reply;
	}
	
	//退出房间
	public MessageReply drop(RoomRequest request){
		String room_type = request.getRoomType();
		
		MessageReply reply = new MessageReply();
		
		if(room_type.equals("coop")){
			reply = room_center.dropRoom(request.getPlayerId(), request.getRoomId());
		}else if(room_type.equals("vs")){
			reply = room_center.dropRoom(request.getPlayerId(), request.getRoomId());
		}
		

		return reply;
	}
	
	//获得房间的消息队列
	public RequestQueue getRequestQueue(String pid, String rid, String room_type){		
		
		if(room_type.equals("coop")){
			return room_center.getRequestQueue(pid, rid);
		}else if(room_type.equals("vs")){
			return vs_room_center.getRequestQueue(pid, rid);
		}
		
		return null;
	}
	
}
