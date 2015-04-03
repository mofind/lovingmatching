package org.aurora.lovingmatching_server.remoteMessage.netConnector;

import java.net.ServerSocket;
import java.net.Socket;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching_server.remoteModel.playerModel.Player;
import org.aurora.lovingmatching_server.remoteModel.playerModel.PlayerCenter;

public class ServerStart {
	private final int PORT = 1025;
	
	public ServerStart(){
		
	}
	
	public void Start(){
		try{
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("Server is started...");
			
			Socket socket = null;
			while((socket = server.accept()) != null){
				
				System.out.println("a client is connected...");
				
				MailBox box = new MailBox(socket);
				
				Player player = new Player(box);
				PlayerCenter.addPlayer(player);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		ServerStart server = new ServerStart();
		server.Start();
	}
}
