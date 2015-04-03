package org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply;

import java.util.ArrayList;

public class CoopRecordReply extends Reply {
	ArrayList<String> records;
	
	public CoopRecordReply()
	{
		type = "coop_reply";
		records = new ArrayList<String>();
	}
	
	public void addRecord(String record)
	{
		records.add(record);
	}
	
	public String toString()
	{
		StringBuffer str = new StringBuffer(type + ":");
		for(String s : records)
		{
			str.append(s + ";");
		}
		
		return str.toString();
	}
	
	

}
