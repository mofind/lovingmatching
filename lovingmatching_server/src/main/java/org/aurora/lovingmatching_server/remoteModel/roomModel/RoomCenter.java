package org.aurora.lovingmatching_server.remoteModel.roomModel;

import java.util.HashMap;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageEnum;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching_server.remoteMessage.netConnector.MailBox;
import org.aurora.lovingmatching_server.remoteModel.playerModel.PlayerCenter;

public class RoomCenter {
	private static HashMap<String, Room> room_list;
	
	public RoomCenter()
	{
		room_list = new HashMap<String, Room>();
	}
	
	//创建房间
	public MessageReply createRoom(String id)
	{
		Room room = new Room(id);
		room_list.put(id, room);
		room.start();
		MessageReply reply = new MessageReply();
		reply.setSuccess();
		
		return reply;
	}
	
	//加入房间
	public MessageReply joinRoom(String pid, String rid)
	{
		MessageReply reply = new MessageReply();

		if(!room_list.containsKey(rid))
		{
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.NO_SUCH_ROOM);
			
			return reply;
		}
		
		Room room = room_list.get(rid);
		MailBox box = PlayerCenter.getMailBox(pid);
		
		int k = room.addPlayer(pid, box);
		
		reply = getJoinReply(k);
		
		return reply;
	}
	
	//退出房间
	public MessageReply dropRoom(String pid, String rid)
	{
		MessageReply reply = new MessageReply();
		
		if(! room_list.containsKey(rid))
		{
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.NO_SUCH_ROOM);
			
			return reply;
		}
		
		Room room = room_list.get(rid);
		
		int k = room.removerPlayer(pid);
		
		reply = getDropReply(k);
		
		return reply;
	}
	
	public RequestQueue getRequestQueue(String pid, String rid)
	{
		if(!room_list.containsKey(rid))
			return null;
		
		Room room = room_list.get(rid);
		
		return room.getRequestQueue(pid);
	}

	protected MessageReply getJoinReply(int k)
	{
		MessageReply reply = new MessageReply();

		switch(k){
		case 0:
			reply.setSuccess();
			break;
		case 1:
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.FULL_ROOM);
			break;
		case 2:
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.NO_PERMISSION_JOIN);
			break;
		case 3:
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.ALREADY_JOINED);
			break;
		case -1:
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.SYSTEM_ERROR);
			break;
		}
		
		return reply;
		
	}
	
	protected MessageReply getDropReply(int k)
	{
		MessageReply reply = new MessageReply();

		switch(k){
		case 0:
			reply.setSuccess();
			break;
		case 1:
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.NOT_IN_ROOM);
			break;
		case -1:
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.SYSTEM_ERROR);
			break;
		}
		
		return reply;
		
	}

	public static void removeRoom(String id)
	{
		room_list.remove(id);
	}
	

}
