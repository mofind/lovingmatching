package org.aurora.lovingmatching.remoteMessage.netConnector;

import java.util.ArrayList;

import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching.remoteMessage.messageSet.Request.Request;

public class Transaction {
	private static ArrayList<Reply> reply_list;
	
	public Transaction(){
		reply_list = new ArrayList<Reply>();
		
	}
	
	public static void addReply(Reply reply){
		reply_list.add(reply);
		synchronized(reply_list){
			reply_list.notifyAll();
		}
	}
	
	public Reply getReply(Request request){
		Connector.sendRequest(request);
		ReplyMonitor monitor = null;
		try{
			monitor = new ReplyMonitor();
			monitor.start();
			monitor.join();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(monitor == null)
			return null;
		
		return monitor.getReply();		
	}
	

	private class ReplyMonitor extends Thread{
		private boolean out_of_time;
		private Reply reply;
		
		public ReplyMonitor(){
			out_of_time = false;
			reply = null;
		}
		
		public void run(){
			while(reply_list.isEmpty()){
				try{
					reply_list.wait(20000);
					if(reply_list.isEmpty()){
						out_of_time = true;
						break;
					}
				}catch(Exception e){
				}
			}
			reply = reply_list.remove(0);			
		}
		
		public boolean isOutOfTime(){
			return out_of_time;
		}
		
		public Reply getReply(){
			return reply;
		}
		
	}
}
