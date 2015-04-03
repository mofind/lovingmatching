package org.aurora.lovingmatching_server.po;

import java.util.Date;

/**
 *
 * @author ljing12[AT]software.nju.edu.cn
 */
public class PKHistoryPO {
   private CoopHistoryPO chpo1;
   private CoopHistoryPO chpo2;
   private String host1;
   private String host2;
   private Date timestamp;
   private int score1;
   private int score2;
   private int money1;
   private int money2;

    public PKHistoryPO(CoopHistoryPO chpo1, CoopHistoryPO chpo2) {
        this.chpo1 = chpo1;
        this.chpo2 = chpo2;
        this.host1 =chpo1.getHostID();
        this.host2 =chpo2.getHostID();
        this.timestamp =chpo1.getTimestamp();
        this.score1 =chpo1.getScore();
        this.score2 = chpo2.getScore();
        this.money1 = chpo1.getMoney();
        this.money2 = chpo2.getMoney();
    }

    

    public CoopHistoryPO getChpo1() {
        return chpo1;
    }

    public CoopHistoryPO getChpo2() {
        return chpo2;
    }

    public String getHost1() {
        return host1;
    }

    public String getHost2() {
        return host2;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getMoney1() {
        return money1;
    }

    public int getMoney2() {
        return money2;
    }
    public String toConsoleString(){
        String s=""+this.chpo2.getMemberList().size();
        return this.host1+" vs "+this.host2+":"+this.score1+" vs "+this.score2+" "+this.chpo1.getMemberList().size()+" : "+s;
        
    }
             
}