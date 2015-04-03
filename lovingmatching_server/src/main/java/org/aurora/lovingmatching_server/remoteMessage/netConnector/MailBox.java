package org.aurora.lovingmatching_server.remoteMessage.netConnector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.PlayerRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.QuitRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.Request;
import org.aurora.lovingmatching_server.remoteMessage.messageTrannslator.Translator;

public class MailBox extends Thread {
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private Translator translator;
	
	private Queue<Request> request_list;
	
	public MailBox(){}
	
	public MailBox(Socket socket){
		try{
			this.socket = socket;
			reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		translator = new Translator();
		request_list = new LinkedList<Request>();
	
	}
	
	@Override
	public void run(){
		String message;
		try{
			while((message = reader.readLine())!=null){
				Request request = translator.translate(message);
				

				///////////////////////////
				System.out.println("Got a request: " + message);
				///////////////////////////

				
				if(request != null){
					request_list.offer(request);
					if(request.getType().equals("quit"))
						break;
				}
			}
		}catch(Exception e){
			request_list.offer(new QuitRequest());
			e.printStackTrace();
		}
	}
	
	public boolean hasMail(){
		return request_list.size() != 0;
	}

	public Request getRequest(){
		if(request_list.size() == 0){
			return null;
		}

		return request_list.poll();		
	}
	
	public void sendReply(Reply reply){
		try{
			writer.println(reply.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		///////////////////////////
		System.out.println("Sent s reply: " + reply.toString());
		//////////////////////////
	}
	
	public void close(){
		try{
			writer.close();
			reader.close();
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
