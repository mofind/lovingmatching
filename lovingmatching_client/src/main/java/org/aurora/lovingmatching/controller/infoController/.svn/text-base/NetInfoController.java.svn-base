package org.aurora.lovingmatching.controller.infoController;

import org.aurora.lovingmatching.model.remoteModel.playerModel.AbstractPlayerModel;
import org.aurora.lovingmatching.model.remoteModel.playerModel.PlayerModel;
import org.aurora.lovingmatching.vo.MessageVO;

public class NetInfoController implements AbstractNetInfoController{
	AbstractPlayerModel player_model;
	
	public NetInfoController()
	{
		player_model = new PlayerModel();
	}

	public MessageVO register(String id, String pw) {
		return player_model.register(id, pw);
	}

	public MessageVO login(String id, String pw) {
		return player_model.login(id, pw);
	}

	public void logout() {
		player_model.logout();
	}

	@Override
	public MessageVO changePW(String old_pw, String new_pw) {
		return player_model.changePW(old_pw, new_pw);
	}

}
