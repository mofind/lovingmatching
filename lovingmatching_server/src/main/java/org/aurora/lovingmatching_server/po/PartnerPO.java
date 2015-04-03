package org.aurora.lovingmatching_server.po;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author ljing12[AT]software.nju.edu.cn
 */
public class PartnerPO {
    public String uid;
    public Date timestamp;
    public String hostID;
    public ArrayList<String> partners;

    public PartnerPO(String uid, Date timestamp, String hostID, ArrayList<String> partners) {
        this.uid = uid;
        this.timestamp = timestamp;
        this.hostID = hostID;
        this.partners = partners;
    }

    public String getUid() {
        return uid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getHostID() {
        return hostID;
    }

    public ArrayList<String> getPartners() {
        return partners;
    }
   
    
}

