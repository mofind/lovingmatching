package org.aurora.lovingmatching_server.databaseUtlity;

import java.util.ArrayList;

import org.aurora.lovingmatching_server.po.CoopHistoryPO;
import org.aurora.lovingmatching_server.po.HitInfoPO;
import org.aurora.lovingmatching_server.po.PKHistoryPO;
import org.aurora.lovingmatching_server.po.UserPO;

/**
 * 
 * @author ljing12[AT]software.nju.edu.cn 注意:UserID是不可更改的,会导致更新异常
 */
public interface AbstractDataBaseUtility {

	public boolean addUser(UserPO upo);

	public boolean updateUserInfo(UserPO upo);

	public boolean deleteUser(String uid);

	public UserPO getUserInfo(String uid);

	public boolean addCoopHistory(CoopHistoryPO chPO);

	public ArrayList<CoopHistoryPO> getCoopHistory(String uid);

	public ArrayList<CoopHistoryPO> getCoopHistory(int sum);

	public boolean addPKHistory(PKHistoryPO pkhpo);

	public ArrayList<PKHistoryPO> getPKHistory(String uid);

	public ArrayList<PKHistoryPO> getPKHistory(int sum);

	public ArrayList<String> getPartners(String uid);

	public ArrayList<String> getEnemis(String uid);

	public boolean addHit(HitInfoPO hitInfo);

	public ArrayList<HitInfoPO> getHitInfo(String uid);

	public ArrayList<HitInfoPO> getHitInfo(int sum);
}
