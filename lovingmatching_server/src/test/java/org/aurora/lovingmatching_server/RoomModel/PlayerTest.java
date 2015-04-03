package org.aurora.lovingmatching_server.RoomModel;

import org.aurora.lovingmatching_server.remoteMessage.netConnector.MockMailBox;
import org.aurora.lovingmatching_server.remoteModel.infoModel.Player;
import org.aurora.lovingmatching_server.remoteModel.infoModel.PlayerCenter;
import org.aurora.lovingmatching_server.remoteModel.roomModel.RoomBase;

public class PlayerTest {

	public static void main(String[] args) {
		new RoomBase();
		new PlayerCenter();
		MockMailBox box = new MockMailBox();
		Player player = new Player(box);
		PlayerCenter.addPlayer(player);
		
		player.start();
		
		while(true){}

	}

}
