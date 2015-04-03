package org.aurora.lovingmatching.remoteMessage.messageSet.Reply;

public class MessageReply extends Reply {
	MessageEnum key_mesg;
	MessageEnum additional_mesg;
	
	public MessageReply()
	{
		type = "message";
		key_mesg = MessageEnum.FAILURE;
		additional_mesg = MessageEnum.NULL;
	}
	
	public MessageReply(String mesg)
	{
		type = "message";
		String mesg_set[] = mesg.split(";");
		if(mesg_set.length == 2)
		{
			key_mesg = MessageEnum.valueOf(mesg_set[0]);
			additional_mesg = MessageEnum.valueOf(mesg_set[1]);
		}else
		{
			VALID = false;
		}
		
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
	
	public String getAdditionMesg()
	{
		return additional_mesg.toString();
	}
	
	public boolean isSuccessful(){
		return key_mesg.equals(MessageEnum.SUCCESS);
	}
	
	
}
