package org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply;

public class MessageReply extends Reply {
	MessageEnum key_mesg;
	MessageEnum additional_mesg;
	
	public MessageReply()
	{
		type = "message";
		key_mesg = MessageEnum.FAILURE;
		additional_mesg = MessageEnum.NULL;
	}
	
	public void setSuccess()
	{
		key_mesg = MessageEnum.SUCCESS;
	}
	
	public void setFailure()
	{
		key_mesg = MessageEnum.FAILURE;
	}

	public void setAdditionMesg(MessageEnum mesg)
	{
		additional_mesg = mesg;
	}
	
	public boolean isSuccessful(){
		return key_mesg.equals(MessageEnum.SUCCESS);
	}
	
	public String toString()
	{
		return type + ":" + key_mesg + ";" + additional_mesg;
	}
	

}
