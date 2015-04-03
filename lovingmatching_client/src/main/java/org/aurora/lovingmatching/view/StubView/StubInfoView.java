package org.aurora.lovingmatching.view.StubView;

import java.util.ArrayList;

import org.aurora.lovingmatching.controller.infoController.InfoController;
import org.aurora.lovingmatching.model.shareModel.infoModel.InfoModel;
import org.aurora.lovingmatching.vo.UserInfoVO;

/**
 * @author ljing12[AT]software.nju.edu.cn 与底层用户信息更新有关以及显示用户信息的界面需要implements此类
 * 
 */
public interface StubInfoView {


	/**
	 * add controllers as listener to handle the user's request
	 * @param infoController
	 */
	public void addInfoGestureListener(InfoController infoController);

	/**
	 * 每个显示信息方式不同的类需要overriding 此方法提供不同的实现
	 * 
	 * @param userInfoVO
	 */
	public void displayUserInfo(UserInfoVO userInfoVO) ;
}
