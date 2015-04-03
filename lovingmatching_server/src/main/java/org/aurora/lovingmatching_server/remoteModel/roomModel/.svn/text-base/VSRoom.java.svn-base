package org.aurora.lovingmatching_server.remoteModel.roomModel;

import org.aurora.lovingmatching_server.remoteMessage.netConnector.MailBox;

public class VSRoom {
	private String id;
	private Room roomA;
	private Room roomB;
	
	public VSRoom(String id){
		roomA = new Room(id + "-A");
		roomB = new Room(id + "-B");
		
		roomA.run();
		roomB.run();
		
	}
	
	public VSRoom(String id, int n_A, int n_B){
		roomA = new Room(id + "-A", n_A);
		roomB = new Room(id + "-B", n_B);

		roomA.run();
		roomB.run();
	}
	
	public int addPlayer(String id, String side, MailBox box){
		Room room = null;
		if(side.equals("A"))
			room = roomA;
		else if(side.equals("B"))
			room = roomB;
		
		if(room == null)
			return -1;
		
		return room.addPlayer(id, box);

	}
	
	public int removePlayer(String id, String side){
		Room room = null;
		if(side.equals("A"))
			room = roomA;
		else if(side.equals("B"))
			room = roomB;
		
		if(room == null)
			return -1;

		return room.removerPlayer(id);
	}
	
	public RequestQueue getRequestQueue(String id, String side){
		Room room = null;
		if(side.equals("A"))
			room = roomA;
		else if(side.equals("B"))
			room = roomB;
		
		if(room == null)
			return null;
		
		return room.getRequestQueue(id);
	}

}
