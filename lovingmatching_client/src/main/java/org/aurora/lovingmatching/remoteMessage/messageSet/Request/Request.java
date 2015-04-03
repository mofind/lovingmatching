package org.aurora.lovingmatching.remoteMessage.messageSet.Request;

public class Request {
	protected String type;
	protected boolean VALID = false;
	
	public Request(){
		
	}
	
	public Request(String request_string){
		
	}
	
	public boolean isValid(){
		
		return true;
	}
	
	public String getType(){
		return type;
	}
	
	@Override
	public String toString(){
		
		return type;
	}
}
