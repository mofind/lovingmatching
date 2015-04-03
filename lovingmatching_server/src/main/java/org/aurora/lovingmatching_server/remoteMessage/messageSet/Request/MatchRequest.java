package org.aurora.lovingmatching_server.remoteMessage.messageSet.Request;

public class MatchRequest extends Request {
	
	public MatchRequest()
	{
		type = "match";
	}

	public String toString()
	{
		return type;
	}
}
