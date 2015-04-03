package org.aurora.lovingmatching.vo;

public class MessageVO {
	private String message;
	private boolean SUCCESS;
	
	public MessageVO()
	{
		SUCCESS = false;
	}
	
	public MessageVO(boolean success)
	{
		SUCCESS = success;
	}

	public MessageVO(boolean success, String mesg)
	{
		SUCCESS = success;
		message = mesg;
	}
	
	public boolean isSuccessful()
	{
		return SUCCESS;
	}
	
	public void setMessage(String mesg)
	{
		message = mesg;
	}
	
	public void setSystemError()
	{
		message = "SYSTEM_ERROR";
	}
	
	public String getMessage()
	{
		return message;
	}

}
