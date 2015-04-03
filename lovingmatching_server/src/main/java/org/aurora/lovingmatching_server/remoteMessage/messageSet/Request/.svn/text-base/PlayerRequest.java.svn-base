package org.aurora.lovingmatching_server.remoteMessage.messageSet.Request;

public class PlayerRequest extends Request {
	private String action; 	//{"register", "login", "logout", "changePW"}
	private String id;
	private String pw;
	private String new_pw;
	
	public PlayerRequest()
	{
		type = "player";
	}

	public PlayerRequest(String mesg)
	{
		type = "player";
		
		String mesg_set[] = mesg.split(";");
		
		if((mesg_set.length == 2) && (mesg_set[0].equals("logout")))
		{
			action = mesg_set[0];
			id = mesg_set[1];
			VALID = true;

		}else if((mesg_set.length == 3) && (mesg_set[0].equals("login") || mesg_set[0].equals("register")))
		{
			action = mesg_set[0];
			id = mesg_set[1];
			pw = mesg_set[2];
			VALID = true;

		}else if((mesg_set.length == 4) && (mesg_set[0].equals("changePW")))
		{
			action = mesg_set[0];
			id = mesg_set[1];
			pw = mesg_set[2];
			new_pw = mesg_set[3];
			VALID = true;
		
		}else
			VALID = false;
		
	}
	
	public String getAction()
	{
		return action;
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getPW()
	{
		return pw;
	}
	
	public String getNewPW()
	{
		return new_pw;
	}
	
	public void setQuit()
	{
		action = "quit";
	}
	
	public String toString()
	{
		return type + ":" + action + ";" + id + ";" + pw + ";" + new_pw;
	}


}
