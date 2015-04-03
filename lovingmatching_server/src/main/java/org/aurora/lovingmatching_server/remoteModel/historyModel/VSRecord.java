package org.aurora.lovingmatching_server.remoteModel.historyModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VSRecord {
	private ArrayList<String> partern_id_list;
	private ArrayList<String> enemy_id_list;
	private ArrayList<Integer> partern_score_list;
	private int partern_score;
	private int enemy_score;
	private Date date;
	
	public VSRecord(Date date, int p_score, ArrayList<String> p_ids, ArrayList<Integer> p_scores, 
			int e_score, ArrayList<String> e_ids)
	{
		this.date = date;
		this.partern_score = p_score;
		this.partern_id_list = p_ids;
		this.partern_score_list = p_scores;
		this.enemy_score = e_score;
		this.enemy_id_list = e_ids;
	}

	public String toString()
	{
		StringBuffer str = new StringBuffer();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		str.append(df.format(date) + "$");
		str.append(partern_score + "$");
		for (String s : partern_id_list)
		{
			str.append(s + ",");
		}
		str.append("$");
		for (Integer i : partern_score_list)
		{
			str.append(i.toString() + ",");
		}
		str.append("$");
		str.append(enemy_score + "$");
		for (String s : enemy_id_list)
		{
			str.append(s + ",");
		}
		
		return str.toString();
	}
}
