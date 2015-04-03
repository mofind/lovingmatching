package org.aurora.lovingmatching_server.remoteMessage.messageSet.Request;

public class TrendRequest extends Request {
	private String id;
	private String game_type;
	private String data_type;
	private String limit;
	
	public TrendRequest(String id, String game_type, String data_type, String limit)
	{
		type = "trend";
		this.id = id;
		this.game_type = game_type;
		this.data_type = data_type;
		this.limit = limit;
		
	}
	
	public TrendRequest(String str)
	{
		type = "trend";
		String set[] = str.split(";");
		if(set.length == 4)
		{
			id = set[0];
			game_type = set[1];
			data_type = set[2];
			limit = set[3];
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
	
	public String getDataType()
	{
		return data_type;
	}
	
	public String getLimit()
	{
		return limit;
	}

}
