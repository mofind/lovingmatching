package org.aurora.lovingmatching_server.remoteMessage.messageTrannslator;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.HistoryRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.PlayerRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.QuitRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.RecordRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.Request;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.RoomRequest;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.TrendRequest;

public class Translator {
	
	public Translator(){
		
	}
	
	public Request translate(String message){
		if(message == null)
			return null;
		
		Type type = Type.valueOf(message.split(":")[0]);
		
		switch(type){
		case player:
			return new PlayerRequest(message.split(":")[1]);
		case room:
			return new RoomRequest(message.split(":")[1]);
		case history:
			return new HistoryRequest(message.split(":")[1]);
		case trend:
			return new TrendRequest(message.split(";")[1]);
		case record:
			return new RecordRequest(message.split(";")[1]);
		case quit:
			return new QuitRequest();
			
		
		}
		
		return null;
			
	}

}
