package org.aurora.lovingmatching_server.RoomModel;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageEnum;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching_server.remoteModel.roomModel.RoomBase;
import org.aurora.lovingmatching_server.remoteModel.roomModel.RoomCenter;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RoomCenterTest extends TestCase {
	RoomBase roomBase = new RoomBase();
	RoomCenter center;

	protected void setUp() throws Exception {
		super.setUp();
		center = roomBase.getRoomCenter();
	}

	public void testCreateRoom() {
		MessageReply reply = center.createRoom("12345");
		Assert.assertTrue(reply.isSuccessful());
	}

	public void testJoinRoom() {
		center.createRoom("54321");
		
		MessageReply reply1 = new MessageReply();
		MessageReply reply2 = new MessageReply();
		MessageReply reply3 = new MessageReply();
		MessageReply reply4 = new MessageReply();
		reply1.setSuccess();
		reply2.setAdditionMesg(MessageEnum.ALREADY_JOINED);
		reply3.setAdditionMesg(MessageEnum.FULL_ROOM);
		reply4.setAdditionMesg(MessageEnum.NO_SUCH_ROOM);
		MessageReply reply;
		reply = center.joinRoom("1", "54321");
		Assert.assertEquals(reply1, reply);
		reply = center.joinRoom("1", "54321");
		Assert.assertEquals(reply2, reply);
		center.joinRoom("2", "54321");
		reply = center.joinRoom("3", "54321");
		Assert.assertEquals(reply3, reply);
		reply = center.joinRoom("4", "55321");
		Assert.assertEquals(reply4, reply);
		
	}

	public void testDropRoom() {
		MessageReply reply1 = new MessageReply();
		MessageReply reply2 = new MessageReply();
		MessageReply reply3 = new MessageReply();
	}

}
