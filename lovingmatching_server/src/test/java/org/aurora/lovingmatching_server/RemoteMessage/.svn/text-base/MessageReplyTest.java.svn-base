package org.aurora.lovingmatching_server.RemoteMessage;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageEnum;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageReply;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MessageReplyTest extends TestCase {
	MessageReply reply1, reply2, reply3;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		reply1 = new MessageReply();
		reply2 = new MessageReply();
		reply3 = new MessageReply();
		
		reply2.setSuccess();
		reply3.setAdditionMesg(MessageEnum.NO_SUCH_ROOM);
	}

	public void testToString() {
		Assert.assertEquals(false, reply1.isSuccessful());
		Assert.assertEquals(true, reply2.isSuccessful());
		Assert.assertEquals(false, reply3.isSuccessful());

	}

	public void testIsSuccessful() {
		Assert.assertEquals("message:FAILURE;NO_SUCH_ROOM", reply3.toString());
		Assert.assertEquals("message:FAILURE;NULL", reply1.toString());
		Assert.assertEquals("message:SUCCESS;NULL", reply2.toString());

	}

}
