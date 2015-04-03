package org.aurora.lovingmatching_server.remoteModel.roomModel;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.RoomRequest;

public class StubRoomProcessor extends RoomProcessor{
	public MessageReply create(RoomRequest request){
		MessageReply reply = new MessageReply();
		reply.setSuccess();
		return reply;
	}
	
	public MessageReply join(RoomRequest request){
		MessageReply reply = new MessageReply();
		reply.setSuccess();
		return reply;
	}

	public MessageReply drop(RoomRequest request){
		MessageReply reply = new MessageReply();
		reply.setSuccess();
		return reply;
	}

	public RequestQueue getRequestQueue(String pid, String rid, String room_type){
		return new MockRequestQueue();
	}
}
