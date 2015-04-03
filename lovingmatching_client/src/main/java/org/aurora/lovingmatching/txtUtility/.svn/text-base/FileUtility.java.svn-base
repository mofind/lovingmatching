package org.aurora.lovingmatching.txtUtility;

import java.util.ArrayList;

import org.aurora.lovingmatching.po.LocalAllHistoryPO;
import org.aurora.lovingmatching.po.LocalHistoryPO;
import org.aurora.lovingmatching.po.UserInfoPO;

/**
 * @author ljing12[at] software.nju.edu.cn
 */
public class FileUtility implements AbstractFileUtility {
	FileHelper userFileHelper;
	FileHelper createAndDeleteHelper;
	String userFileNameString;

	public FileUtility() {
		userFileNameString = FileNameHelper.getUserFileName();
		userFileHelper = new FileHelper(FileNameHelper.getDefaultPath()
				+ userFileNameString);
		createAndDeleteHelper = new FileHelper();
	}

	public boolean createPlayer(String id,String gender) {
		boolean result;
		UserInfoPO userInfoPO = new UserInfoPO(id, true);
		result = userFileHelper.append(userInfoPO.toStoreString());
		result = createAndDeleteHelper.createFile(
				FileNameHelper.getDefaultPath(),
				FileNameHelper.getUserHistoryFileName(id));
		return result;
	}

	public boolean updatePlayer(UserInfoPO userInfoPO) {
		boolean result;
		String resultString = userFileHelper.deleteOneline(0,
				userInfoPO.getID(), UserInfoPO.seperatorString);
		result = (resultString != null);
		result = userFileHelper.append(userInfoPO.toStoreString());
		return result;
	}

	public UserInfoPO getUserInfo(String id) {
		String resultString = userFileHelper.find(0, id,
				UserInfoPO.seperatorString);
		System.out.println(resultString);
		UserInfoPO userInfoPO = new UserInfoPO(resultString);
		return userInfoPO;
	}

	public boolean deletePlayer(String id) {
		boolean result;
		String str = userFileHelper.deleteOneline(0, id,
				UserInfoPO.seperatorString);
		result = (str != null);
		result = createAndDeleteHelper.deleteFile(
				FileNameHelper.getDefaultPath(),
				FileNameHelper.getUserHistoryFileName(id));
		return result;
	}

	public boolean addHistory(LocalHistoryPO localHistoryPO) {
		boolean result;
		FileHelper fileHelper = new FileHelper(FileNameHelper.getDefaultPath()
				+ FileNameHelper.getUserHistoryFileName(localHistoryPO
						.getUserID()));
		String storeString = localHistoryPO.toStoreString();
		result = fileHelper.append(storeString);
		UserInfoPO userInfoPO = new UserInfoPO(userFileHelper.find(0,
				localHistoryPO.getUserID(), UserInfoPO.seperatorString));
		userInfoPO.updateScore(localHistoryPO.getScore());
		userInfoPO.updateMoney(localHistoryPO.getMoney());
		userInfoPO.updateRank();
		FileUtility fileUtility = new FileUtility();
		fileUtility.updatePlayer(userInfoPO);
		return result;
	}

	public LocalAllHistoryPO getOneUserHistory(String uid) {
		FileHelper fileHelper = new FileHelper(FileNameHelper.getDefaultPath()
				+ FileNameHelper.getUserHistoryFileName(uid));
		ArrayList<String> storeStrings = fileHelper.find();
		LocalAllHistoryPO localAllHistoryPO = new LocalAllHistoryPO();
		for (String str : storeStrings) {
			localAllHistoryPO.addLocalHistoryPO(new LocalHistoryPO(uid, str));
		}
		return localAllHistoryPO;
	}
	public String initUser(){
		FileHelper fileHelper=new FileHelper(FileNameHelper.getDefaultPath()+FileNameHelper.getInitFileName());
		String s=fileHelper.find(1);
		System.out.println(s);
		return s;
	}
	public boolean updateInit(String s){
		FileHelper fHelper=new FileHelper(FileNameHelper.getDefaultPath()+FileNameHelper.getInitFileName());
		fHelper.clear();
		fHelper.append(s);
		return false;
	}
}
