package org.aurora.lovingmatching_server.remoteMessage.messageSet.Request;

public class RecordRequest extends Request {
	private String id;
	private String game_type;
	private String limit;
	
	public RecordRequest(String id, String game_type, String limit)
	{
		type = "record";
		this.id = id;
		this.game_type = game_type;
		this.limit = limit;
	}
	
	public RecordRequest(String str)
	{
		type = "record";
		String set[] = str.split(";");
		if(set.length == 3)
		{
			id = set[0];
			game_type = set[1];
			limit = set[2];
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
	
	public String getLimit()
	{
		return limit;
	}
	

}
