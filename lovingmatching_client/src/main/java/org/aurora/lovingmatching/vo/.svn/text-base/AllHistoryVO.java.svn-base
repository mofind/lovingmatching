package org.aurora.lovingmatching.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.aurora.lovingmatching.po.LocalAllHistoryPO;
import org.aurora.lovingmatching.po.LocalHistoryPO;

/**
 * 
 * @author ljing12[AT]software.nju.edu.cn
 * 
 */
public class AllHistoryVO {
	int totalCount;
	ArrayList<Date> dayList = new ArrayList<Date>();
	Set<Date> daySet = new HashSet<Date>();
	SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");

	ArrayList<Integer> countsPerDay = new ArrayList<Integer>();
	ArrayList<Integer> scorePerGame = new ArrayList<Integer>();
	int avgScore;
	ArrayList<Integer> scorePerDay = new ArrayList<Integer>();
	int maxDoubleHit;
	int maxScore;

	public AllHistoryVO(LocalAllHistoryPO localAllHistoryPO) {
		this.totalCount = localAllHistoryPO.getCount();
		this.maxDoubleHit = localAllHistoryPO.getMaxHit();
		this.maxScore = localAllHistoryPO.getMaxScore();
		ArrayList<LocalHistoryPO> historyPOs = localAllHistoryPO.getHistorys();

		Collections.sort(historyPOs); // sort the history records by time,for
										// the statics
		initDaySet(historyPOs);
		initDayList();

		initCountsAndScorePerDay(historyPOs);
		initScorePerGame(historyPOs);
	}

	public void initCountsAndScorePerDay(ArrayList<LocalHistoryPO> historyPOs) {
		for (Date date : dayList) {
			int dayCount = 0;
			int dayScore = 0;
			for (LocalHistoryPO historyPO : historyPOs) {
				Date date2 = historyPO.getTimeStamp();
				String date2String = dayFormat.format(date2);
				if (date2String.equals(dayFormat.format(date))) {
					dayCount++;
					dayScore += historyPO.getScore();
				}
			}
			scorePerDay.add(dayScore);
			countsPerDay.add(dayCount);
		}
	}

	public void initDaySet(ArrayList<LocalHistoryPO> historyPOs) {
		for (LocalHistoryPO historyPO : historyPOs) {
			Date date = historyPO.getTimeStamp();
			String dateString = dayFormat.format(date);
			Date dayDate = null;
			try {
				dayDate = dayFormat.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			daySet.add(dayDate);
		}
	}

	public void initScorePerGame(ArrayList<LocalHistoryPO> historyPOs) {
		for (LocalHistoryPO historyPO : historyPOs) {
			scorePerGame.add(historyPO.getScore());
		}
	}

	public void initDayList() {
		dayList.addAll(daySet);
	}

}
