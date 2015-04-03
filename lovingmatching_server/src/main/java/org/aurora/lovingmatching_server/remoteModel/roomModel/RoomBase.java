package org.aurora.lovingmatching_server.remoteModel.roomModel;

public class RoomBase {
	private static RoomCenter room_center;
	private static VSRoomCenter vs_room_center;
	
	public RoomBase()
	{
		room_center = new RoomCenter();
		vs_room_center = new VSRoomCenter();
	}
	
	public static RoomCenter getRoomCenter()
	{
		return room_center;
	}
	
	public static VSRoomCenter getVSRoomCenter(){
		return vs_room_center;
	}

}
