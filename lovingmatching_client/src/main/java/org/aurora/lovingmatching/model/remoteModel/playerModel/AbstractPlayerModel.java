package org.aurora.lovingmatching.model.remoteModel.playerModel;

import org.aurora.lovingmatching.vo.MessageVO;

public interface AbstractPlayerModel {
	public MessageVO register(String id, String pw);
	public MessageVO login(String id, String pw);
	public MessageVO changePW(String old_pw, String new_pw);
	public void logout();

}
