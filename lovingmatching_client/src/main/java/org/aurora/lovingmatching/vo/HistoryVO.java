package org.aurora.lovingmatching.vo;

import java.util.Date;

import org.aurora.lovingmatching.po.LocalHistoryPO;

/**
 * 
 * @author ljing12[AT]software.nju.edu.cn
 * 
 */
public class HistoryVO {
	String userID;
	Date timestamp;
	int score;
	int money;
	int maxDoubleHit;

	public HistoryVO(String userID, int score, int money, int maxDoubleHit) {
		this.userID = userID;
		this.score = score;
		this.money = money;
		this.maxDoubleHit = maxDoubleHit;
		this.timestamp = new Date();
	}

	public HistoryVO(LocalHistoryPO historyPO) {
		this(historyPO.getUserID(), historyPO.getScore(), historyPO.getMoney(),
				historyPO.getMaxDoubleHit());
	}

	public String getUserID() {
		return userID;

	}

	public int getScore() {
		return score;
	}

	public int getMoney() {
		return money;
	}

	public int getMaxDoubleHit() {
		return maxDoubleHit;
	}

	public Date getTimeStamp() {
		return timestamp;
	}

}
