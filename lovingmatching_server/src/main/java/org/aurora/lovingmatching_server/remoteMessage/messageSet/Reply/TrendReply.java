package org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TrendReply extends Reply {
	private ArrayList<Date> date_set;
	private ArrayList<Integer> value_set;
	
	public TrendReply(ArrayList<Date> date, ArrayList<Integer> value)
	{
		type = "trend";
		date_set = date;
		value_set = value;
	}
	
	public String toString()
	{
		if((date_set == null) || (value_set == null))
			return type;
	
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		StringBuffer str = new StringBuffer(type + ":");
		
		for(Date date : date_set)
		{
			str.append(df.format(date) + ",");
		}
		
		str.append(";");
		
		for (Integer i : value_set)
		{
			str.append(i.toString() + ",");
		}
		
		return str.toString();
	}

}
