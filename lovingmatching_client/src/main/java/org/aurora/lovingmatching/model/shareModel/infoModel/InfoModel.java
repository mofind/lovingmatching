package org.aurora.lovingmatching.model.shareModel.infoModel;

import java.util.ArrayList;

import org.aurora.lovingmatching.po.UserInfoPO;
import org.aurora.lovingmatching.txtUtility.AbstractFileUtility;
import org.aurora.lovingmatching.txtUtility.FileUtility;
import org.aurora.lovingmatching.view.StubView.StubInfoView;
import org.aurora.lovingmatching.vo.UserInfoVO;
/**
 * @author ljing12[AT]software.nju.edu.cn
 */
public class InfoModel implements AbstractInfoModel{
	AbstractFileUtility fileUtility;
	private ArrayList<StubInfoView> changeListeners=new ArrayList<StubInfoView>();
	
	public InfoModel() {
		fileUtility=new FileUtility();
	}
	
	public void addChangeListener(StubInfoView stubInfoView){
		changeListeners.add(stubInfoView);
	}
	
	public boolean createUser(UserInfoVO userInfoVO){
		return fileUtility.createPlayer(userInfoVO.getID(),userInfoVO.getGender());
	}
	
	public boolean updateUser(UserInfoVO userInfoVO){
		return fileUtility.updatePlayer(new UserInfoPO(userInfoVO));
	}
	public boolean deleteUser(String uid){
		return fileUtility.deletePlayer(uid);
	}
	public UserInfoVO getUserState(String uid){
		UserInfoPO userInfoPO=fileUtility.getUserInfo(uid);
		UserInfoVO userInfoVO=new UserInfoVO(userInfoPO);
		return userInfoVO;
	}
}
