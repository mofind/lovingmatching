package org.aurora.lovingmatching.controller.infoController;

import org.aurora.lovingmatching.model.shareModel.infoModel.InfoModel;
import org.aurora.lovingmatching.view.StubView.StubInfoView;
import org.aurora.lovingmatching.vo.UserInfoVO;
/**
 * @author ljing12[AT]software.nju.edu.cn
 */
public class InfoController {
	private StubInfoView infoView;
	private InfoModel infoModel;
	
	public InfoController(StubInfoView infoView,InfoModel infoModel){
		this.infoModel=infoModel;
		this.infoView=infoView;
	}
	public boolean createUser(UserInfoVO userInfoVO){
		return infoModel.createUser(userInfoVO);
	}
	public boolean deleteUser(String uid){
		return infoModel.deleteUser(uid);
	}
}
