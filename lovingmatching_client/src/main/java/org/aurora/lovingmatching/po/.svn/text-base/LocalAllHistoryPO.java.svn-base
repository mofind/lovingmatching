package org.aurora.lovingmatching.po;

import java.util.ArrayList;

/**
 * @author ljing12[AT]software.nju.edu.cn contains all the history items of one
 *         user
 */
public class LocalAllHistoryPO {
	ArrayList<LocalHistoryPO> localHistoryPOs;
	int totalScore = 0;
	int maxDoubleHit = 0;
	int maxScore = 0;
	int count = 0;

	public LocalAllHistoryPO() {
		localHistoryPOs = new ArrayList<LocalHistoryPO>();
	}

	public boolean addLocalHistoryPO(LocalHistoryPO localHistoryPO) {
		localHistoryPOs.add(localHistoryPO);
		if (localHistoryPO.getMaxDoubleHit() > maxDoubleHit) {
			maxDoubleHit = localHistoryPO.getMaxDoubleHit();
		}
		if (localHistoryPO.getScore() > maxScore) {
			this.maxScore = localHistoryPO.getScore();

		}
		totalScore += localHistoryPO.getScore();
		count += 1;
		return true;
	}

	public String getUserID() {
		return localHistoryPOs.get(0).getUserID();
	}

	public int getMaxHit() {
		return maxDoubleHit;
	}

	public int getCount() {
		return count;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public ArrayList<LocalHistoryPO> getHistorys() {
		return localHistoryPOs;
	}

	public int getAvgScore() {
		return totalScore / count;
	}

	public String toConsoleString() {
		StringBuffer strbuffer = new StringBuffer();
		for (LocalHistoryPO historyPO : this.localHistoryPOs) {
			strbuffer.append(historyPO.toConsoleString());
			strbuffer.append("\n");
		}
		return strbuffer.toString();
	}
}
