package org.aurora.lovingmatching.remoteMessage.messageSet.Reply;

public class Reply {
	protected String type;
	protected boolean VALID;
	
	public Reply(){
		
	}
	
	public Reply(String reply_string){
		
	}
	
	public boolean isValid(){
		
		return VALID;
	}
	
	public String getType(){
		
		return type;
	}
	
	@Override
	public String toString(){
		
		return "";
	}
}
