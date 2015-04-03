package org.aurora.lovingmatching.model.remoteModel.playerModel;

import org.aurora.lovingmatching.remoteMessage.messageSet.Reply.MessageReply;
import org.aurora.lovingmatching.remoteMessage.messageSet.Request.PlayerRequest;
import org.aurora.lovingmatching.remoteMessage.netConnector.AbstractNetAssistant;
import org.aurora.lovingmatching.remoteMessage.netConnector.NetAssistant;
import org.aurora.lovingmatching.vo.MessageVO;

public class PlayerModel implements AbstractPlayerModel {
	private AbstractNetAssistant net_assistant;
	private static String playerID;
	private static boolean LOGIN;
	
	public PlayerModel()
	{
		net_assistant = new NetAssistant();
		LOGIN = false;
	}

	public MessageVO register(String id, String pw)
	{
		PlayerRequest request = new PlayerRequest("register", id, pw);
		MessageReply reply = (MessageReply)net_assistant.getReply(request);
		
		MessageVO message;
		if(reply.isSuccessful())
		{
			message = new MessageVO(true);
			playerID = id;
			LOGIN = true;
		}else
		{
			message = new MessageVO(false, reply.getAdditionMesg());
		}
		
		return message;
	}
	
	public MessageVO login(String id, String pw) {
		PlayerRequest request = new PlayerRequest("login", id, pw);
		MessageReply reply = (MessageReply)net_assistant.getReply(request);
		
		MessageVO message;
		if(reply.isSuccessful())
		{
			message = new MessageVO(true);
			playerID = id;
			LOGIN = true;
			
		}else
		{
			message = new MessageVO(false, reply.getAdditionMesg());
		}

		return message;
	}

	public void logout() {
		PlayerRequest request = new PlayerRequest("logout", playerID);
		net_assistant.sendRequest(request);
		
		LOGIN = false;

	}

	public MessageVO changePW(String old_pw, String new_pw) {
		if(!LOGIN)
		{
			MessageVO message = new MessageVO();
			message.setSystemError();
			
			return message;
		}

		PlayerRequest request = new PlayerRequest("changePW", playerID, old_pw, new_pw);
		MessageReply reply = (MessageReply)net_assistant.getReply(request);
		
		MessageVO message;
		if(reply.isSuccessful())
		{
			message = new MessageVO(true);
		}else
		{
			message = new MessageVO(false, reply.getAdditionMesg());
		}

		return message;
	}
	
	public static String getPlayerId()
	{
		if(LOGIN)
			return playerID;
		else
			return null;
	}

}
