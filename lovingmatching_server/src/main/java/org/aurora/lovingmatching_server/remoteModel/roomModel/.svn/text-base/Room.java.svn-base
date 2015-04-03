package org.aurora.lovingmatching_server.remoteModel.roomModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.Reply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.Request;
import org.aurora.lovingmatching_server.remoteMessage.netConnector.MailBox;
import org.aurora.lovingmatching_server.remoteModel.playerModel.Player;

public class Room extends Thread{
	private String id;
	private HashMap<String, MailBox> player_list;
	private RequestQueue request_queue;
	
	private int PLAYER_NUM;
	
	private boolean ROOM_ON;
	private boolean IN_GAME;
	private int INTERRUPT;

	public Room(String id)
	{
		this.id = id;
		PLAYER_NUM = 2;
		
		initialize();
	}
	
	public Room(String id, int pnum)
	{
		this.id = id;

		if(pnum>0 && pnum <10){
			PLAYER_NUM = pnum;
		}else{
			PLAYER_NUM = 2;
		}
		
		initialize();
	}
	
	public int addPlayer(String id, MailBox box)
	{
		if(player_list.size() >= PLAYER_NUM){
			return 1;
		}
		
		if(player_list.containsKey(id)){
			return 3;
		}

		player_list.put(id, box);

		return 0;
	}
	
	public int removerPlayer(String id)
	{
		if(player_list.containsKey(id)){
			player_list.remove(id);
			
			if(player_list.size() == 0){	//当房间没有人的时候，房间关闭
				ROOM_ON = false;
			}
			
			if(IN_GAME){
				INTERRUPT = 1;	//如果在游戏进行中有玩家退出，执行中断1
			}
			
			return 0;
		}
		else
			return 1;
	}
	
	public void run()
	{
		while(ROOM_ON){	//当房间关闭后，循环终止
			if(! request_queue.isEmpty()){	//轮询request队列
				
				if(INTERRUPT != 0){
					handleInterrupt();
					INTERRUPT = 0;
				}
				
				Request request = request_queue.getRequest();
				process(request);
			}
		}
		
		RoomCenter.removeRoom(id);
	}
	
	public RequestQueue getRequestQueue(String id)
	{
		if(player_list.containsKey(id))
			return request_queue;
		else
			return null;
	}
	
	public void setInterrupt(int i)
	{
		INTERRUPT = i;
	}

	private void initialize()
	{
		player_list = new HashMap<String, MailBox>();
		request_queue = new RequestQueue();

		ROOM_ON = true;
		IN_GAME = false;
		INTERRUPT = 0;
	}

	private void handleInterrupt()
	{
		switch(INTERRUPT){
		case 1:
			
		}
		
	}

	private void process(Request request)
	{
		
	}

	private void sendAllReply(Reply reply)
    {
		Iterator iter = player_list.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
		    MailBox box = (MailBox)entry.getValue(); 
		    box.sendReply(reply);
		} 
	}
	
	

}
