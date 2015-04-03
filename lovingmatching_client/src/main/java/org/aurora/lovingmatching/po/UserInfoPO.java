package org.aurora.lovingmatching.po;

import org.aurora.lovingmatching.vo.UserInfoVO;

/**
 * @author ljing12[AT]software.nju.edu.cn
 */
public class UserInfoPO {
	public static String seperatorString = "%"; // use to separate the item of
												// one line in file

	String ID;
	String gender = "B";
	int score = 0;
	int money = 0;
	int rank = 1;

	public UserInfoPO(String ID, String gender, int score, int money, int rank) {
		this.ID = ID;
		this.score = score;
		this.money = money;
		this.gender = gender;
		this.rank = rank;

	}

	public UserInfoPO(String ID, boolean isDefault) {
		this.ID = ID;
	}

	/**
	 * use one line from file of user to construct
	 * 
	 * @param storeString
	 */
	public UserInfoPO(String storeString) {
		String[] strs = storeString.split(seperatorString);
		int sumOfTerm = strs.length;
		if (sumOfTerm != 5) {
			System.err.println("error when read data, the data is not valid!");
		}
		this.ID = strs[0];
		this.gender=strs[1];
		this.score = Integer.parseInt(strs[2]);
		this.money = Integer.parseInt(strs[3]);
		this.rank = Integer.parseInt(strs[4]);
	}

	public UserInfoPO(UserInfoVO userInfoVO) {
		this(userInfoVO.getID(), userInfoVO.getGender(), userInfoVO.getScore(),
				userInfoVO.getMoney(), userInfoVO.getRank());
	}

	/**
	 * getters
	 * 
	 * @return
	 */
	public String getID() {
		return ID;
	}

	public int getScore() {
		return score;
	}

	public int getMoney() {
		return money;
	}

	public int getRank() {
		return rank;
	}

	public String getGender() {
		return this.gender;
	}

	/**
	 * offer the rule to transfer score to rank
	 * 
	 * @return
	 */
	public void updateScore(int score) {
		this.score += score;
	}

	public void updateMoney(int money) {
		this.money += money;
	}

	public int updateRank() {
		this.rank = UserInfoVO.computeRank(this.score);
		return this.rank;
	}

	/**
	 * for test output
	 * 
	 * @return
	 */
	public String toConsoleString() {
		return this.ID + ":" + this.score + ":" + this.money + "rank:"
				+ this.rank;
	}

	/**
	 * 
	 * @return
	 */
	public String toStoreString() {
		String toStoreString = "";
		toStoreString += (this.ID + seperatorString + this.gender
				+ seperatorString + this.score + seperatorString + this.money
				+ seperatorString + this.rank);
		return toStoreString;
	}
}
