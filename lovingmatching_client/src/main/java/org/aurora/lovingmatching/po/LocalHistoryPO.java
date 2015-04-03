package org.aurora.lovingmatching.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aurora.lovingmatching.vo.HistoryVO;

/**
 * 
 * @author ljing12[AT]software.nju.edu.cn
 * 
 */
public class LocalHistoryPO implements Comparable<LocalHistoryPO> {
	String userID;
	Date timestamp;
	String timeString;
	int score;
	int money;
	int maxDoubleHit;
	public static String seperatorString = "%";
	public static SimpleDateFormat historyDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");

	public LocalHistoryPO(String userID, int score, int money, int maxDoubleHit) {
		this.userID = userID;
		this.score = score;
		this.money = money;
		this.maxDoubleHit = maxDoubleHit;
		this.timestamp = new Date();
		this.timeString = historyDateFormat.format(timestamp);
	}

	public LocalHistoryPO(HistoryVO historyVO) {
		this(historyVO.getUserID(), historyVO.getScore(), historyVO.getMoney(),
				historyVO.getMaxDoubleHit());
	}

	public LocalHistoryPO(String uid, String storeString) {
		this.userID = uid;
		String[] strs = storeString.split(seperatorString);
		int sumOfTerm = strs.length;
		if (sumOfTerm != 4) {
			System.err.println("error when read data, the data is not valid!");
		}
		try {
			this.timestamp = historyDateFormat.parse(strs[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.score = Integer.parseInt(strs[1]);
		this.money = Integer.parseInt(strs[2]);
		this.maxDoubleHit = Integer.parseInt(strs[3]);

	}

	/**
	 * getters
	 * 
	 * @return
	 */
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

	/**
	 * 
	 * @return the formatted string to store in the file
	 */
	public String toStoreString() {
		return this.timeString + seperatorString + this.score + seperatorString
				+ this.money + seperatorString + this.maxDoubleHit;
	}

	/**
	 * 
	 * @return the string shown in console,just for test
	 */
	public String toConsoleString() {
		return this.userID + " score:" + this.score + " moeny:" + this.money
				+ " hitMax:" + this.maxDoubleHit;
	}

	public int compareTo(LocalHistoryPO o) {
		return this.timestamp.compareTo(o.timestamp);
	}
}
