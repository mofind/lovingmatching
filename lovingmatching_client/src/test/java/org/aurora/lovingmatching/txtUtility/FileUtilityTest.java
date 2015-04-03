package org.aurora.lovingmatching.txtUtility;

import org.aurora.lovingmatching.po.LocalAllHistoryPO;
import org.aurora.lovingmatching.po.LocalHistoryPO;
import org.aurora.lovingmatching.po.UserInfoPO;

import junit.framework.TestCase;

/**
 * 
 * @author ljing12[AT]software.nju.edu.cn
 * 
 */
public class FileUtilityTest extends TestCase {
	AbstractFileUtility fileUtility = new FileUtility();

	public void testCreatePlayer() {
		// fileUtility.createPlayer("jiangyoudang");
	//	fileUtility.createPlayer("mmd","B");
	}

	public void testGetUserInfo() {
		 UserInfoPO userInfoPO = fileUtility.getUserInfo("jiangyoudang");
		 System.out.println(userInfoPO.toConsoleString());
		// assertNotNull(userInfoPO);
	}

	public void testUpdatePlayer() {
		UserInfoPO userInfoPO = new UserInfoPO("mmd", "B", 100, 100, 4);
	 fileUtility.updatePlayer(userInfoPO);
	}

	public void testDeletePlayer() {
		// boolean resultt=fileUtility.deletePlayer("testdelete");
		// assertTrue(resultt);
	}

	public void testAddHistory() {
		//LocalHistoryPO historyPO = new LocalHistoryPO("jiangyoudang", 120, 144,
			//	2);
		// System.out.println(historyPO.toStoreString());
		// fileUtility.addHistory(historyPO);
	}

	public void testGetOneUserHistory() {
		LocalAllHistoryPO allHistoryPO = fileUtility
				.getOneUserHistory("jiangyoudang");
		System.out.println(allHistoryPO.toConsoleString());
		assertNotNull(allHistoryPO);
	}

	public void testInitUser() {
		String s = fileUtility.initUser();

	}

	public void testUpdateInit() {
		// fileUtility.updateInit("test");
	}
}
