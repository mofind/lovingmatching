package org.aurora.lovingmatching_server.po;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ljing12[AT]software.nju.edu.cn
 */
public class CoopHistoryPO {

    public String hostID;
    public Date timestamp;
    public int score;     //所有玩家分数和金钱相等
    public int money;
    private ArrayList<String> memberIDs = new ArrayList<String>();//MemBerIDs里面不包括host

    public CoopHistoryPO(String hostID, Date timestamp, int score, int money) {
        this.hostID = hostID;
        this.timestamp = timestamp;
        this.score = score;
        this.money = money;
    }

    public boolean addMember(String uid) {
        memberIDs.add(uid);
        return true;
    }
    public ArrayList<String> getMemberList(){
        return memberIDs;
    }

    public String getHostID() {
        return hostID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }
    
    public boolean contains(String id){
    	return memberIDs.contains(id) || hostID.equals(id);
    }
    
    public String toConsoleString(){
        return ""+this.hostID+" "+this.timestamp+" "+this.score+" "+this.money+"sum of member:"+memberIDs.size();
    }
}

