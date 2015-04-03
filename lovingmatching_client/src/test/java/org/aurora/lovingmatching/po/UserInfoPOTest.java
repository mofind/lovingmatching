package org.aurora.lovingmatching.po;

import junit.framework.TestCase;
/**
 * @author ljing12[AT]software.nju.edu.cn
 */
public class UserInfoPOTest extends TestCase {
	UserInfoPO upo1=new UserInfoPO("testID", true);
	UserInfoPO upo2=new UserInfoPO("testid","B", 100, 200, 2);
	public void testToConsoleString() {
		System.out.println(upo1.toConsoleString());
		System.out.println(upo2.toConsoleString());
	}

	public void testToStoreString() {
		System.out.println(upo1.toStoreString());
		System.out.println(upo2.toStoreString());
	}

}
