package org.aurora.lovingmatching_server.remoteMessage.messageSet.Request;

public class HistoryRequest extends Request {
	private String id;
	private String game_type;
	
	public HistoryRequest(String id, String game_type)
	{
		type = "history";
		this.id = id;
		this.game_type = game_type;
	}
	
	public HistoryRequest(String str)
	{
		String set[] = str.split(";");
		if(set.length == 2)
		{
			id = set[0];
			game_type = set[1];
			VALID = true;
		}else
		{
			VALID = false;
		}
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getGameType()
	{
		return game_type;
	}

}
