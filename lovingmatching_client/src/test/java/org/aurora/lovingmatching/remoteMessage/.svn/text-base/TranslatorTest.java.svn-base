package org.aurora.lovingmatching.remoteMessage;

import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching.remoteMessage.messageTranslator.Translator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TranslatorTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testTranslate() {
		MessageReply reply;
		String mesg1 = "message:SUCCESS;NULL";
		String mesg2 = "message:FAILURE;NO_SUCH_ROOM";
		reply = (MessageReply)Translator.translate(mesg1);
		Assert.assertEquals(true, reply.isSuccessful());
		reply = (MessageReply)Translator.translate(mesg2);
		Assert.assertEquals(false, reply.isSuccessful());
		Assert.assertEquals("NO_SUCH_ROOM", reply.getAdditionMesg());
	}

}
