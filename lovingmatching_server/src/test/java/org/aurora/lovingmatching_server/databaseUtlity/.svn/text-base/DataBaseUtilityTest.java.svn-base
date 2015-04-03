package org.aurora.lovingmatching_server.databaseUtlity;

import java.util.ArrayList;
import java.util.Date;

import org.aurora.lovingmatching_server.po.CoopHistoryPO;
import org.aurora.lovingmatching_server.po.PKHistoryPO;
import org.aurora.lovingmatching_server.po.UserPO;

import junit.framework.TestCase;

/**
 * 
 * @author ljing12[AT]software.nju.edu.cn
 *
 */
public class DataBaseUtilityTest extends TestCase {
	DataBaseUtility dbu = new DataBaseUtility();
	UserPO upo = new UserPO("testuid", "12345678");
	UserPO upo2 = new UserPO("testuid", "87654321", 5, 1000, 1000);

	//the add and delete test do not execute easily, will course error!!!!!!!!!!
	/**public void testAddUser() {
		boolean result = dbu.addUser(upo);
		// System.out.println(result);
		assertTrue(result);
	}**/

	/**public void testUpdateUserInfo() {
		boolean result = dbu.updateUserInfo(upo2);
		// System.out.println(result);
		assertTrue(result);
	}

	public void testDeleteUser() {
		boolean result = dbu.deleteUser(upo.getUid());
		System.out.println(result);
	}**/

	public void testGetUserInfo() {
		UserPO upo = dbu.getUserInfo("testuid");
		if (upo != null) {
			System.out.println(upo.toConsoleString());
		} else {
			System.out.println("userpo is null");
		}
		assertNotNull(upo);
	}

	
	/**public void testAddCoopHistory() {
		String hostuid = "testuid";
		Date date = new Date();
		CoopHistoryPO chpo = new CoopHistoryPO(hostuid, date, 100, 100);
		chpo.addMember("id1");
		chpo.addMember("id2");
		boolean result = dbu.addCoopHistory(chpo);
		assertTrue(result);
		System.out.println(result);
	}**/

	public void testGetCoopHistoryString() {
		String uid = "id1";
		ArrayList<CoopHistoryPO> chpos = dbu.getCoopHistory(uid);
		if (chpos != null) {
			for (CoopHistoryPO cpo : chpos) {
				System.out.println(cpo.toConsoleString());
			}
		} else {
			System.out.println("chpo is null");
		}
		assertNotNull(chpos);
	}

	public void testGetCoopHistoryInt() {
		ArrayList<CoopHistoryPO> chpos = dbu.getCoopHistory(3);
		if (chpos != null) {
			for (CoopHistoryPO cpo : chpos) {
				System.out.println(cpo.toConsoleString());
			}
		} else {
			System.out.println("chpo is null");
		}
		assertNotNull(chpos);
	}

	
	/**public void testAddPKHistory() {
		String host1 = "testhost1";
		String host2 = "testhost2";
		Date date = new Date();
		int score1 = 1000;
		int money1 = 1000;
		int score2 = 50;
		int money2 = 50;
		CoopHistoryPO chpo1 = new CoopHistoryPO(host1, date, score1, money1);
		chpo1.addMember("mem1");
		chpo1.addMember("mem2");
		CoopHistoryPO chpo2 = new CoopHistoryPO(host2, date, score2, money2);
		chpo2.addMember("mem3");
		chpo2.addMember("mem4");
		PKHistoryPO pKHistoryPO = new PKHistoryPO(chpo1, chpo2);
		boolean result = dbu.addPKHistory(pKHistoryPO);
		assertTrue(result);
	}**/

	public void testGetPKHistoryString() {
		String uid = "mem1";
		ArrayList<PKHistoryPO> pkhpos = dbu.getPKHistory(uid);
		if (pkhpos != null) {
			for (PKHistoryPO pkhpo : pkhpos) {
				System.out.println(pkhpo.toConsoleString());
			}
		} else {
			System.out.println("pkhpos is null");
		}
		assertNotNull(pkhpos);
	}

	public void testGetPKHistoryInt() {
		ArrayList<PKHistoryPO> getPKHistoryPOs = dbu.getPKHistory(1);
		if (getPKHistoryPOs != null) {
			for (PKHistoryPO pko : getPKHistoryPOs) {
				System.out.println(pko.toConsoleString());
			}
		} else {
			System.out.println("is null");
		}
		assertNotNull(getPKHistoryPOs);
	}

	public void testGetPartners() {
		ArrayList<String> partners = dbu.getPartners("id1");
		if (partners != null) {
			for (String p : partners) {
				System.out.println(p);
			}
		} else {
			System.out.println("null");
		}
		assertNotNull(partners);
	}

	public void testGetEnemis() {
		String uid = "mem1";
        ArrayList<String> uids = dbu.getEnemis(uid);
        if (uids != null) {
            for (String s : uids) {
                System.out.println(s);
            }
        } else {
            System.out.println("is null");
        }
        assertNotNull(uids);
	}

}
