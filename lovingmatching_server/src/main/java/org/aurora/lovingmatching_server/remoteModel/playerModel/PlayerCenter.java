package org.aurora.lovingmatching_server.remoteModel.playerModel;

import java.util.ArrayList;
import java.util.HashMap;

import org.aurora.lovingmatching_server.remoteMessage.netConnector.MailBox;
import org.aurora.lovingmatching_server.remoteMessage.netConnector.MockMailBox;

public class PlayerCenter {
	private static ArrayList<Player> player_list = new ArrayList<Player>();
	private static HashMap<String, MailBox> mail_box_list = new HashMap<String, MailBox>();
	
	public static void addPlayer(Player player){
		player_list.add(player);
		player.start();
	}
	
	public static void removePlayer(Player player){
		player_list.remove(player);
		
	}
	
	public static void addMailBox(String id, MailBox box){
		mail_box_list.put(id, box);
	}
	
	public static void removeMailBox(String id){
		mail_box_list.remove(id);
	}

	public static MailBox getMailBox(String id){
		return mail_box_list.get(id);
		
	}

}
