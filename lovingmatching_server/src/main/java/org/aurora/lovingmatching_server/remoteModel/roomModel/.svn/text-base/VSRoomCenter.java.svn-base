package org.aurora.lovingmatching_server.remoteModel.roomModel;

import java.util.HashMap;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageEnum;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching_server.remoteMessage.netConnector.MailBox;
import org.aurora.lovingmatching_server.remoteModel.playerModel.PlayerCenter;

public class VSRoomCenter extends RoomCenter{
	private HashMap<String, VSRoom> vs_room_list;
	
	public VSRoomCenter()
	{
		vs_room_list = new HashMap<String, VSRoom>();
	}
	
	public MessageReply createVSRoom(String id)
	{
		VSRoom vs_room = new VSRoom(id);
		vs_room_list.put(id, vs_room);
		MessageReply reply = new MessageReply();
		reply.setSuccess();

		return reply;
	}
	
	public MessageReply joinVSRoom(String pid, String rid)
	{
		MessageReply reply = new MessageReply();
		
		String[] id_split = rid.split("-");
		
		if(id_split.length != 2)
		{
			reply.setAdditionMesg(MessageEnum.SYSTEM_ERROR);
			return reply;
		}
		
		String id = id_split[0];
		String side = id_split[1];
		
		if(!vs_room_list.containsKey(id))
		{
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.NO_SUCH_ROOM);
			
			return reply;
		}
		
		VSRoom room = vs_room_list.get(id);
		MailBox box = PlayerCenter.getMailBox(pid);
		
		int k = room.addPlayer(pid, side, box);
		
		reply = getJoinReply(k);
		
		return reply;
	}
	
	public MessageReply dropVSRoom(String pid, String rid)
	{
		MessageReply reply = new MessageReply();

		String[] id_split = rid.split("-");
		
		if(id_split.length != 2)
		{
			reply.setAdditionMesg(MessageEnum.SYSTEM_ERROR);
			return reply;
		}
		
		String id = id_split[0];
		String side = id_split[1];
		
		if(!vs_room_list.containsKey(id))
		{
			reply.setFailure();
			reply.setAdditionMesg(MessageEnum.NO_SUCH_ROOM);
			
			return reply;
		}
		
		VSRoom room = vs_room_list.get(id);
		
		int k = room.removePlayer(pid, side);
		
		reply = getDropReply(k);
		
		return reply;
		
	}
	
	public RequestQueue getRequestQueue(String pid, String rid)
	{
		String[] id_split = rid.split("-");
		
		if(id_split.length != 2)
			return null;
		
		String id = id_split[0];
		String side = id_split[1];
		
		if(!vs_room_list.containsKey(id))
			return null;
		
		VSRoom vs_room = vs_room_list.get(id);
		
		return vs_room.getRequestQueue(pid, side);
	}

}
