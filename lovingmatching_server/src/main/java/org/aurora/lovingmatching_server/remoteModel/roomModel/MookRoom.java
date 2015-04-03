package org.aurora.lovingmatching_server.remoteModel.roomModel;

import org.aurora.lovingmatching_server.remoteMessage.netConnector.MockMailBox;

public class MookRoom extends Room {

	public MookRoom(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public int addPlayer(String id, MockMailBox box){
		return 0;
	}
	
	public int removePlayer(String id){
		return 0;
	}
	
	public void run(){
		
	}
	
}
