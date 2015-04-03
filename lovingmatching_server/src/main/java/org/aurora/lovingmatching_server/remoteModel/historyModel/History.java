package org.aurora.lovingmatching_server.remoteModel.historyModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.aurora.lovingmatching_server.databaseUtlity.AbstractDataBaseUtility;
import org.aurora.lovingmatching_server.databaseUtlity.DataBaseUtility;
import org.aurora.lovingmatching_server.databaseUtlity.DataBaseUtilityStub;
import org.aurora.lovingmatching_server.po.CoopHistoryPO;
import org.aurora.lovingmatching_server.po.HitInfoPO;
import org.aurora.lovingmatching_server.po.PKHistoryPO;
import org.aurora.lovingmatching_server.po.UserPO;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.CoopRecordReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.HistoryReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.TrendReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.VSRecordReply;

public class History implements AbstractHistoryModel {
	private UserPO player;
	private ArrayList<CoopHistoryPO> coop_history;
	private ArrayList<PKHistoryPO> vs_history;
	private ArrayList<HitInfoPO> hit_history;
	private String id;
	
	private AbstractDataBaseUtility database;
	
	public History()
	{
		//database = new DataBaseUtility();
		database = new DataBaseUtilityStub();
	}
	
	public HistoryReply getCoopHistory(String id) 
	{
		update(id);
		
		int total_game = coop_history.size();
		int total_score = player.getTotalScore();
		int score = 0;
		for(CoopHistoryPO coop : coop_history)
		{
			score += coop.getScore();
		}
		int avg_score = (total_game ==0) ? 0 : score / total_game;
		
		HistoryReply reply = new HistoryReply("coop", total_game, total_score, avg_score);
		
		return reply;
	}
	
	public TrendReply getCoopTrendHistory(String id, String type, String limit)
	{
		update(id);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date limit_date = new Date();
		try
		{
			limit_date = df.parse(limit);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		ArrayList<Date> date_set = new ArrayList<Date>();
		ArrayList<Integer> value_set = new ArrayList<Integer>();
		
		if(type.equals("num"))
		{
			date_set = new ArrayList<Date>();
			for (CoopHistoryPO po : coop_history)
			{
				Date date = paseDate(po.getTimestamp());

				if(date.after(limit_date))
					if(! date_set.contains(date))
						date_set.add(date);
			}
			
			value_set = new ArrayList<Integer>();
			for (int i = 0; i < date_set.size(); i++)
			{
				value_set.add(new Integer(0));
			}
			
			for (CoopHistoryPO po : coop_history)
			{
				Date date = paseDate(po.getTimestamp());
				if(date_set.contains(date))
				{
					int i = date_set.indexOf(date);
					int n = value_set.get(i) + 1;
					value_set.set(i, new Integer(n));
				}
			}
		}

		if(type.equals("score"))
		{
			date_set = new ArrayList<Date>();
			value_set = new ArrayList<Integer>();

			for (CoopHistoryPO po : coop_history)
			{
				Date date = po.getTimestamp();
				Integer score = new Integer(po.getScore());

				if(date.after(limit_date))
				{
					date_set.add(date);
					value_set.add(score);
				}
			}
		}
		
		TrendReply reply = new TrendReply(date_set, value_set);

		return reply;
	}

	public CoopRecordReply getCoopRecordHistory(String id, String limit)
	{
		update(id);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date_limit = new Date();
		try {
			date_limit = df.parse(limit);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		CoopRecordReply reply = new CoopRecordReply();
		
		for (CoopHistoryPO po : coop_history)
		{
			Date date = po.getTimestamp();
			if(date.after(date_limit))
			{
				int total_score = po.getScore();
				HitInfoPO hit = getHitInfo(date);
				CoopRecord record = new CoopRecord(date, total_score, hit.getIDs(), hit.getHits());
				reply.addRecord(record.toString());
			}
		}
		
		return reply;
	}

	public HistoryReply getPKHistory(String id) 
	{
		update(id);
		
		int total_game = vs_history.size();
		
		int win_game = 0;
		int total_score = 0;
		int avg_score = 0;
		for(PKHistoryPO po : vs_history)
		{
			int score;
			if(po.getChpo1().contains(id))
				score = po.getScore1() - po.getScore2();
			else
				score = po.getScore2() - po.getScore1();
			
			if(score > 0)
				win_game++;
			
			total_score += score;
		}
		
		if(total_game != 0)
			avg_score = total_score / total_game;
		
		HistoryReply reply = new HistoryReply("vs", total_game, win_game, avg_score);
		
		return reply;
	}

	public TrendReply getPKTrendHistory(String id, String type, String limit) 
	{
		update(id);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date limit_date = new Date();
		try
		{
			limit_date = df.parse(limit);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		ArrayList<Date> date_set = new ArrayList<Date>();
		ArrayList<Integer> value_set = new ArrayList<Integer>();
		
		if(type.equals("num"))
		{
				
			date_set = new ArrayList<Date>();
			for (PKHistoryPO po : vs_history)
			{
				Date date = paseDate(po.getTimestamp());

				if(date.after(limit_date))
					if(! date_set.contains(date))
						date_set.add(date);
			}
			
			value_set = new ArrayList<Integer>();
			for (int i = 0; i < date_set.size(); i++)
			{
				value_set.add(new Integer(0));
			}
			
			for (PKHistoryPO po : vs_history)
			{
				Date date = paseDate(po.getTimestamp());
				if(date_set.contains(date))
				{
					int i = date_set.indexOf(date);
					int n = value_set.get(i) + 1;
					value_set.set(i, new Integer(n));
				}
			}
		}
		
		if(type.equals("score"))
		{
			date_set = new ArrayList<Date>();
			value_set = new ArrayList<Integer>();

			for (PKHistoryPO po : vs_history)
			{
				Date date = po.getTimestamp();
				Integer score;
		
				if(po.getChpo1().contains(id) || po.getChpo1().getHostID().equals(id))
					score = new Integer(po.getScore1() - po.getScore2());
				else
					score = new Integer(po.getScore2() - po.getScore1());

				if(date.after(limit_date))
				{
					date_set.add(date);
					value_set.add(score);
				}
			}
		}
		
		
		TrendReply reply = new TrendReply(date_set, value_set);
		
		return reply;
	}

	public VSRecordReply getPKRecordHistory(String id, String limit)
	{
		update(id);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date_limit = new Date();
		try {
			date_limit = df.parse(limit);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		VSRecordReply reply = new VSRecordReply();
		
		for (PKHistoryPO po : vs_history)
		{
			Date date = po.getTimestamp();
			if(date.after(date_limit))
			{
				int partern_score, enemy_score;
				ArrayList<String> enemy_ids;
				
				if(po.getChpo1().contains(id) || po.getChpo1().hostID.equals(id))
				{
					partern_score = po.getScore1();
					enemy_score = po.getScore2();
					enemy_ids = po.getChpo2().getMemberList();
					enemy_ids.add(po.getChpo2().getHostID());
				}else
				{
					partern_score = po.getScore2();
					enemy_score = po.getScore1();
					enemy_ids = po.getChpo1().getMemberList();
					enemy_ids.add(po.getChpo1().getHostID());
				}
					
				HitInfoPO hit = getHitInfo(date);
				VSRecord record = new VSRecord(date, partern_score, hit.getIDs(), hit.getHits(), 
												enemy_score, enemy_ids);
				reply.addRecord(record.toString());
			}
		}
		
		return reply;
	}

	private boolean update(String id)
	{
		player = database.getUserInfo(id);
		coop_history = database.getCoopHistory(id);
		vs_history = database.getPKHistory(id);
		hit_history = database.getHitInfo(id);
		
		if((player == null) || (coop_history == null) || (vs_history == null) || (hit_history != null))
			return false;
		
		return true;
	}
	
	private Date paseDate(Date date)
	{
		Date new_date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			new_date = df.parse(df.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new_date;
	}


	
	private HitInfoPO getHitInfo(Date date)
	{
		for (HitInfoPO po : hit_history)
		{
			if(po.getTime().equals(date))
				return po;
		}
		
		return null;
	}
}
