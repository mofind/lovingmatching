package org.aurora.lovingmatching_server.remoteModel.historyModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CoopRecord {
	private ArrayList<String> id_list;
	private ArrayList<Integer> score_list;
	private int total_score;
	private Date date;
	
	public CoopRecord(Date date, int score, ArrayList<String> ids, ArrayList<Integer> scores)
	{
		this.date = date;
		this.total_score = score;
		id_list = ids;
		score_list = scores;
	}
	
	public String toString()
	{
		StringBuffer str = new StringBuffer();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		str.append(df.format(date) + "$");
		str.append(total_score + "$");
		for (String s : id_list)
		{
			str.append(s + ",");
		}
		str.append("$");
		for (Integer i : score_list)
		{
			str.append(i.toString() + ",");
		}
		
		return str.toString();
	}

}
