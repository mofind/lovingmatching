package org.aurora.lovingmatching_server.remoteModel.playerModel;

import org.aurora.lovingmatching_server.remoteMessage.netConnector.MailBox;

public class MockPlayer extends Player {

	public MockPlayer(MailBox box) {
		super(box);
		// TODO Auto-generated constructor stub
	}
	
	public String getPlayerId()
	{
		
		return "";
	}

	public MailBox getMailBox()
	{
		
		return null;
	}
	
	public void run()
	{
		
	}
	
}
