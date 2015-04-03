package org.aurora.lovingmatching_server.remoteMessage.messageSet.Request;

public class Request {
	protected String type;
	protected boolean VALID;
	
	public Request(){
		
	}
	
	public Request(String request_string){
		
	}
	
	public boolean isValid(){
		return VALID;
	}
	
	public String getType(){
		return type;
	}
	
	@Override
	public String toString(){
		
		return type;
	}

}
