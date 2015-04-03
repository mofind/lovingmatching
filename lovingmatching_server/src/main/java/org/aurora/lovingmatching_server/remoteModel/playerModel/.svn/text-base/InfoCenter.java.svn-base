package org.aurora.lovingmatching_server.remoteModel.playerModel;

import org.aurora.lovingmatching_server.databaseUtlity.AbstractDataBaseUtility;
import org.aurora.lovingmatching_server.databaseUtlity.DataBaseUtility;
import org.aurora.lovingmatching_server.po.UserPO;

public class InfoCenter {
	AbstractDataBaseUtility database_utility;
	
	public InfoCenter()
	{
		database_utility = new DataBaseUtility();
	}
	
	public boolean testLogin(String id, String pw)
	{
		UserPO user = database_utility.getUserInfo(id);
		
		return user.getUpsw().equals(pw);
	}
	
	public boolean changePW(String id, String o_pw, String n_pw)
	{
		UserPO user = database_utility.getUserInfo(id);
		
		if(! user.getUpsw().equals(o_pw))
		{
			return false;
		}
		
		user.setUpsw(n_pw);
		

		return database_utility.updateUserInfo(user);
	}
	
	public boolean register(String id, String pw)
	{
		UserPO user = new UserPO(id, pw);
		
		return database_utility.addUser(user);
	}

	public UserPO getUserInfo(String id)
	{
		return database_utility.getUserInfo(id);
	}
}
