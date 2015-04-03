package org.aurora.lovingmatching.remoteMessage.netConnector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching.remoteMessage.messageSet.Request.QuitRequest;
import org.aurora.lovingmatching.remoteMessage.messageSet.Request.Request;
import org.aurora.lovingmatching.remoteMessage.messageTranslator.Translator;

public class Connector {
	private static final String HOST = "localhost";
	private static final int PORT = 1025;
	
	private static Socket socket;
	private static BufferedReader reader;
	private static PrintWriter writer;
	
	private static boolean QUIT;
	
	public Connector(){
		
		QUIT = false;
		
		new ReplyProcessor();
	}
	
	
	public static boolean open(){
		ReaderThread readerthread;
		
		try{
			socket = new Socket(HOST, PORT);
			
			reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			writer = new PrintWriter(socket.getOutputStream(), true);
			
			readerthread = new ReaderThread();
			readerthread.start();
			
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			QUIT = true;
			return false;
		}
	}
	
	public static boolean close(){
		try{
			sendRequest(new QuitRequest());
			Thread.sleep(1000);
			socket.close();
			writer.close();
			reader.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static void sendRequest(Request request){
		try{
			writer.println(request.toString());

			///////////////////////////////
			System.out.println("Sent a request: " + request.toString());
			///////////////////////////////

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static class ReaderThread extends Thread{
		public void run(){
			
			String message;
			try{
				while((message = reader.readLine()) != null){

					/////////////////////////
					System.out.println("Got a reply message: " + message);
					////////////////////////

					Reply reply = Translator.translate(message);
					ReplyProcessor.addReply(reply);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	

}
