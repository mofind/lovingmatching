package org.aurora.lovingmatching.remoteMessage.messageTranslator;

import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.Reply;

public class Translator {
	
	public static Reply translate(String message){
		if(message == null)
			return null;
		
		String type = message.split(":")[0];
		
		switch(type){
		case "message":
			return new MessageReply(message.split(":")[1]);
		
		}
		
		return null;
			
		
	}

}
