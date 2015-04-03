package org.aurora.lovingmatching.remoteMessage.netConnector;

import java.util.LinkedList;
import java.util.Queue;

import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.Reply;

public class ReplyProcessor {
	private static Queue<Reply> reply_queue;

	public ReplyProcessor()
	{
		reply_queue = new LinkedList<Reply>();
		
	}
	
	public static void addReply(Reply reply)
	{
		synchronized(reply_queue)
		{
			if(reply.getType().equals("message"))
				
			{
			reply_queue.add(reply);
			}
		
			if(reply.getType().equals("game"))
			{
			
			}
		}
	}
	
	public static boolean isEmpty()
	{
		synchronized(reply_queue){
			return reply_queue.isEmpty();
		}
	}
	
	public static Reply getReply()
	{
		synchronized(reply_queue){
			return reply_queue.poll();
		}
	}

}
