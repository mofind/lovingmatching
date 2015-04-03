package org.aurora.lovingmatching.remoteMessage.netConnector;

import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.MessageEnum;
import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching.remoteMessage.messageSet.Request.Request;

public class NetAssistant implements AbstractNetAssistant {

	public Reply getReply(Request request) {
		Connector.sendRequest(request);

		long begin_time = System.currentTimeMillis();
		long now_time, diff_time;
		
		while(true)
		{
			if(!ReplyProcessor.isEmpty())
			{
				Reply reply = ReplyProcessor.getReply();
				return reply;
			}
			
			now_time = System.currentTimeMillis();
			diff_time = now_time - begin_time;
			
			if(diff_time > 30000)
			{
				MessageReply reply = new MessageReply();
				reply.setAdditionMesg(MessageEnum.OUT_OF_TIME);
				return reply;
			}
			
		}
	}

	public void sendRequest(Request request) {
		Connector.sendRequest(request);

	}

}
