package org.aurora.lovingmatching_server.po;
/**
*
* @author ljing12[AT]software.nju.edu.cn
*/
public class UserPO {

   private String uid = "";
   private String upsw = "11111111";
   private int rank = 1;
   private int totalScore = 0;
   private int money = 0;

   public UserPO(String uid, String upsw, int rank, int totalScore, int money) {
       this.uid = uid;
       this.upsw = upsw;
       this.rank = rank;
       this.totalScore = totalScore;
       this.money = money;
   }

   public UserPO(String uid, String upsw) {
       this(uid, upsw, 1, 0, 0);
   }

   public String getUid() {
       return uid;
   }

   public String getUpsw() {
       return upsw;
   }

   public int getRank() {
       return rank;
   }

   public int getTotalScore() {
       return totalScore;
   }

   public int getMoney() {
       return money;
   }
   
   public void setUpsw(String pw) {
	   upsw = pw;
   }
   
   public void setRank(int rank) {
	   this.rank = rank;
   }
   
   public void setTotalScore(int score) {
	   totalScore = score;
   }
   
   public void setMoney(int money) {
	   this.money = money;
   }
   
   public String toConsoleString(){
       return uid+" "+upsw+" "+rank+" "+totalScore+" "+money;
   }
}
