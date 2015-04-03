package org.aurora.lovingmatching.remoteMessage.messageSet.Request;

public class PlayerRequest extends Request {
	private String action; 	//{"register", "login", "logout", "changePW"}
	private String id;
	private String pw;
	private String new_pw;
	
	
	public static void main(String args[])
	{
		PlayerRequest re = new PlayerRequest("register", "player", "password");
		System.out.println(re.toString());
	}
	
	public PlayerRequest(String action, String id)
	{
		type = "player";
		this.action = action;
		this.id = id;
	}
	
	public PlayerRequest(String action, String id, String pw)
	{
		type = "player";
		this.action = action;
		this.id = id;
		this.pw = pw;
	}
	
	public PlayerRequest(String action, String id, String pw, String new_pw)
	{
		type = "player";
		this.action = action;
		this.id = id;
		this.pw = pw;
		this.new_pw = pw;
	}
	
	public String toString()
	{
		String str = type + ":" + action+ ";";
		if(id != null)
			str += id + ";";
		if(pw != null)
			str += pw + ";";
		if(new_pw != null)
			str += new_pw;
		
		return str;
	}


}
