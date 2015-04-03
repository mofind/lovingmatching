package org.aurora.lovingmatching_server.po;

import java.util.Date;

/**
 *
 * @author ljing12[AT]software.nju.edu.cn
 */
public class EnemyPO {
    private String uid;
    private Date timestamp;
    private String ehostuid;
    

    public EnemyPO(String uid, Date timestamp, String ehostuid) {
        this.uid = uid;
        this.timestamp = timestamp;
        this.ehostuid = ehostuid;
    }

    public String getUid() {
        return uid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getEhostuid() {
        return ehostuid;
    }
    
}

