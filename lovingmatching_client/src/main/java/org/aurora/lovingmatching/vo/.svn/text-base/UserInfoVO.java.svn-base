package org.aurora.lovingmatching.vo;

import org.aurora.lovingmatching.po.UserInfoPO;

/**
 * @author ljing12[AT]software.nju.edu.cn
 */
public class UserInfoVO {
	String ID;
	String gender;
	int score = 0;
	int rank = 1;
	int money = 0;

	public UserInfoVO(String ID, String gender, int score, int money, int rank) {
		this.ID = ID;
		this.score = score;
		this.gender = gender;
		this.rank = rank;
		this.money = money;
	}

	public UserInfoVO(UserInfoPO userInfoPO) {
		this(userInfoPO.getID(), userInfoPO.getGender(), userInfoPO.getScore(),
				userInfoPO.getMoney(), userInfoPO.getRank());
	}

	/**
	 * 
	 * @param addition
	 * @return
	 */
	public int updateScore(int addition) {
		this.score += addition;
		return this.score;
	}

	/**
	 * 
	 * @param money
	 * @return
	 */
	public int updateMoney(int addition) {
		this.money += addition;
		return this.money;
	}

	/**
	 * 定义积分转化为等级的转化规则
	 */
	public int updateRank() {
		this.rank = computeRank(this.score);
		return this.rank;
	}

	public static int computeRank(int score) {
		return score / 1000 + 1;
	}

	public String getID() {
		return ID;
	}

	public int getScore() {
		return score;
	}

	public int getRank() {
		return rank;
	}

	public int getMoney() {
		return money;
	}

	public String getSex() {
		if (this.gender.equals("B")) {
			return "男";
		} else {
			return "女";
		}
	}

	public String toConsoleString() {
		return this.ID + "rank:" + this.rank + "money:" + this.money;
	}

	public String getGender() {
		return this.gender;
	}
}
