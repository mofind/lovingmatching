package org.aurora.lovingmatching_server.remoteMessage.messageSet.Request;

public class RoomRequest extends Request {
	private String action;		//{"create", "join", "drop"}
	private String playerId;	
	private String room_type;	//{"coop", "vs"}
	private String roomId;
	
	public RoomRequest(String action, String playerId, String room_type, String roomId){
		type = "room";
		this.action = action;
		this.playerId = playerId;
		this.room_type = room_type;
		this.roomId = roomId;		
	}

	public RoomRequest(String message){
		type = "room";
		String message_set[] = message.split(";");
		if(message_set.length == 4){
			action = message_set[0];
			playerId = message_set[1];
			room_type = message_set[2];
			roomId = message_set[3];
		}else{
			VALID = false;
		}
	}
	
	public String getAction(){
		return action;
	}
	
	public String getRoomType(){
		return room_type;
	}

	public String getRoomId(){
		return roomId;
	}
	
	public String getPlayerId(){
		return playerId;
	}
	
	public String toString(){
		return type + ":" +action + ";" + playerId + ";" + room_type + ";" + roomId;
	}
	

}
