package org.aurora.lovingmatching_server.databaseUtlity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.aurora.lovingmatching_server.po.CoopHistoryPO;
import org.aurora.lovingmatching_server.po.HitInfoPO;
import org.aurora.lovingmatching_server.po.PKHistoryPO;
import org.aurora.lovingmatching_server.po.UserPO;

public class DataBaseUtilityStub implements AbstractDataBaseUtility {
	Date date1, date2, date3, date4, date5, date6, date7, date8, date9, date0;
	ArrayList<String> playerset1, playerset2;
	ArrayList<Integer> scoreset1, scoreset2;
	

	public DataBaseUtilityStub()
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			date1 = df.parse("2014-03-24 12:00:00");
			date2 = df.parse("2014-03-25 12:01:00");
			date3 = df.parse("2014-03-25 12:02:00");
			date4 = df.parse("2014-03-26 12:03:00");
			date5 = df.parse("2014-03-26 12:04:00");
			date6 = df.parse("2013-03-24 12:05:00");
			date7 = df.parse("2013-03-25 12:06:00");
			date8 = df.parse("2013-03-25 12:07:00");
			date9 = df.parse("2013-03-26 12:08:00");
			date0 = df.parse("2013-03-26 12:09:00");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		playerset1 = new ArrayList<String>();
		playerset2 = new ArrayList<String>();
		playerset1.add("001");
		playerset1.add("002");
		playerset2.add("003");
		playerset2.add("004");
		
		scoreset1 = new ArrayList<Integer>();
		scoreset2 = new ArrayList<Integer>();
		scoreset1.add(new Integer(500));
		scoreset1.add(new Integer(500));
		scoreset2.add(new Integer(300));
		scoreset2.add(new Integer(400));
	}

	public boolean addUser(UserPO upo) {
		return false;
	}

	public boolean updateUserInfo(UserPO upo) {
		return false;
	}

	public boolean deleteUser(String uid) {
		return false;
	}

	public UserPO getUserInfo(String uid) {
		UserPO user = new UserPO("001", "001", 5, 20000, 1000);
		return user;
	}

	public boolean addCoopHistory(CoopHistoryPO chPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<CoopHistoryPO> getCoopHistory(String uid) {
		CoopHistoryPO po1 = new CoopHistoryPO("001", date1, 1000, 0);
		CoopHistoryPO po2 = new CoopHistoryPO("001", date2, 1000, 0);
		CoopHistoryPO po3 = new CoopHistoryPO("001", date3, 1000, 0);
		CoopHistoryPO po4 = new CoopHistoryPO("001", date4, 1000, 0);
		CoopHistoryPO po5 = new CoopHistoryPO("001", date5, 1000, 0);
		po1.addMember("002");
		po2.addMember("002");
		po3.addMember("002");
		po4.addMember("002");
		po5.addMember("002");
		ArrayList<CoopHistoryPO> list = new ArrayList<CoopHistoryPO>();
		list.add(po1);
		list.add(po2);
		list.add(po3);
		list.add(po4);
		list.add(po5);
		
		return list;
	}

	public ArrayList<CoopHistoryPO> getCoopHistory(int sum) {
		return null;
	}

	public boolean addPKHistory(PKHistoryPO pkhpo) {
		return false;
	}

	public ArrayList<PKHistoryPO> getPKHistory(String uid) {
		CoopHistoryPO po1 = new CoopHistoryPO("001", date6, 1000, 0);
		CoopHistoryPO po2 = new CoopHistoryPO("001", date7, 1000, 0);
		CoopHistoryPO po3 = new CoopHistoryPO("001", date8, 1000, 0);
		CoopHistoryPO po4 = new CoopHistoryPO("001", date9, 700, 0);
		CoopHistoryPO po5 = new CoopHistoryPO("001", date0, 1000, 0);
		CoopHistoryPO po1_ = new CoopHistoryPO("003", date6, 1000, 0);
		CoopHistoryPO po2_ = new CoopHistoryPO("003", date7, 1000, 0);
		CoopHistoryPO po3_ = new CoopHistoryPO("003", date8, 700, 0);
		CoopHistoryPO po4_ = new CoopHistoryPO("003", date9, 1000, 0);
		CoopHistoryPO po5_ = new CoopHistoryPO("003", date0, 1000, 0);
		po1.addMember("002");
		po2.addMember("002");
		po3.addMember("002");
		po4.addMember("002");
		po5.addMember("002");
		po1_.addMember("004");
		po2_.addMember("004");
		po3_.addMember("004");
		po4_.addMember("004");
		po5_.addMember("004");

		PKHistoryPO p1 = new PKHistoryPO(po1, po1_);
		PKHistoryPO p2 = new PKHistoryPO(po2, po2_);
		PKHistoryPO p3 = new PKHistoryPO(po3, po3_);
		PKHistoryPO p4 = new PKHistoryPO(po4, po4_);
		PKHistoryPO p5 = new PKHistoryPO(po5, po5_);
		
		ArrayList<PKHistoryPO> list = new ArrayList<PKHistoryPO>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		return list;
	}

	public ArrayList<PKHistoryPO> getPKHistory(int sum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getPartners(String uid) {
		return null;
	}

	public ArrayList<String> getEnemis(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addHit(HitInfoPO hitInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<HitInfoPO> getHitInfo(String uid) {
		HitInfoPO h1 = new HitInfoPO(date1);
		HitInfoPO h2 = new HitInfoPO(date2);
		HitInfoPO h3 = new HitInfoPO(date3);
		HitInfoPO h4 = new HitInfoPO(date4);
		HitInfoPO h5 = new HitInfoPO(date5);
		HitInfoPO h6 = new HitInfoPO(date6);
		HitInfoPO h7 = new HitInfoPO(date7);
		HitInfoPO h8 = new HitInfoPO(date8);
		HitInfoPO h9 = new HitInfoPO(date9);
		HitInfoPO h0 = new HitInfoPO(date0);
		
		h1.setIds(playerset1);
		h2.setIds(playerset1);
		h3.setIds(playerset1);
		h4.setIds(playerset1);
		h5.setIds(playerset1);
		h6.setIds(playerset1);
		h7.setIds(playerset1);
		h8.setIds(playerset1);
		h9.setIds(playerset1);
		h0.setIds(playerset1);
		
		h1.setHits(scoreset1);
		h2.setHits(scoreset1);
		h3.setHits(scoreset1);
		h4.setHits(scoreset1);
		h5.setHits(scoreset1);
		h6.setHits(scoreset1);
		h7.setHits(scoreset1);
		h8.setHits(scoreset1);
		h9.setHits(scoreset2);
		h0.setHits(scoreset1);
		
		ArrayList<HitInfoPO> list = new ArrayList<HitInfoPO>();
		list.add(h1);
		list.add(h2);
		list.add(h3);
		list.add(h4);
		list.add(h5);
		list.add(h6);
		list.add(h7);
		list.add(h8);
		list.add(h9);
		list.add(h0);
		
		return list;
	}

	public ArrayList<HitInfoPO> getHitInfo(int sum) {
		// TODO Auto-generated method stub
		return null;
	}

}
