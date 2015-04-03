package org.aurora.lovingmatching.remoteMessage.messageSet.Request;

public class RoomRequest extends Request {
	private String action;		//{"create", "join", "drop"}
	private String playerId;	
	private String room_type;	//{"coop", "vs"}
	private String roomId;
	private int num1;
	private int num2;
	
	public RoomRequest(String action, String playerId, String room_type, String roomId){
		type = "room";
		this.action = action;
		this.playerId = playerId;
		this.room_type = room_type;
		this.roomId = roomId;		
		
		num1 = 2;
		num2 = 2;
	}

	public RoomRequest(String message){
		type = "room";
		String message_set[] = message.split(";");
		if(message_set.length == 6){
			action = message_set[0];
			playerId = message_set[1];
			room_type = message_set[2];
			roomId = message_set[3];
			
			num1 = Integer.parseInt(message_set[4]);
			num2 = Integer.parseInt(message_set[5]);
		}else{
			VALID = false;
		}
	}
	
	public void setNum1(int i)
	{
		num1 = i;
	}
	
	public void setNum2(int i)
	{
		num2 = i;
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
		return type + ":" +action + ";" + playerId + ";" + room_type + ";" + roomId + ";" + num1 + ";" + num2;
	}
}
