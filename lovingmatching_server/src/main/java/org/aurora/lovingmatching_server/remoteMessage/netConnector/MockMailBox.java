package org.aurora.lovingmatching_server.remoteMessage.netConnector;

import java.net.Socket;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.MatchRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.Request;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.RoomRequest;

public class MockMailBox extends MailBox {
	private Request request;
	private boolean hasMail;
	

	public MockMailBox() 
	{
		hasMail = false;
	}
	
	public void run()
	{
		try{
			Thread.sleep(2000);
			request = new RoomRequest("create", "12345", "coop", "123");
			hasMail = true;
			Thread.sleep(2000);
			request = new RoomRequest("join", "12345", "coop", "123");
			hasMail = true;
			Thread.sleep(2000);
			request = new RoomRequest("join", "12345", "coop", "123");
			hasMail = true;
			Thread.sleep(2000);
			request = new RoomRequest("join", "12355", "coop", "123");
			hasMail = true;
			Thread.sleep(2000);
			request = new RoomRequest("join", "12344", "coop", "123");
			hasMail = true;
			
		}catch(Exception e){}
		
		
	}
	
	public boolean hasMail(){
		if(hasMail){
			hasMail = false;
			return true;
		}
		else
			return false;
	}
	
	public Request getRequest()
	{
		return request;
	}
	
	public void sendReply(Reply reply)
	{
		System.out.println("Got a reply: " + reply.toString());
		
	}
	
	
}
