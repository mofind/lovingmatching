package org.aurora.lovingmatching_server.po;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author ljing12[AT]software.nju.edu.cn
 * 
 */
public class HitInfoPO {

	ArrayList<String> ids = new ArrayList<String>();
	ArrayList<Integer> hits = new ArrayList<Integer>();
	Date date;

	public HitInfoPO(Date date) {
		this.date = date;
	}

	public void addHitInfo(String id, int hit) {
		ids.add(id);
		hits.add(hit);
	}
	
	public void setIds(ArrayList<String> ids){
		this.ids = ids;
	}
	
	public void setHits(ArrayList<Integer> hits){
		this.hits = hits;
	}

	public ArrayList<String> getIDs() {
		return this.ids;
	}

	public ArrayList<Integer> getHits() {
		return this.hits;
	}

	public Date getTime() {
		return this.date;
	}

	public int getHitByID(String id) {
		int result = 0;
		int i = 0;
		for (String s : ids) {
			if (s.equals(id)) {
				result = hits.get(i);
				break;
			}
			i++;
		}
		return result;
	}
}
