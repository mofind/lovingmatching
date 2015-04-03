package org.aurora.lovingmatching.controller.netController;

import org.aurora.lovingmatching.remoteMessage.netConnector.Connector;

public class NetController implements AbstractNetController {
	
	public NetController()
	{
		new Connector();
	}

	public boolean startNetwork() 
	{
		return Connector.open();
	}

	public boolean closeNetwork() 
	{
		return Connector.close();
	}

}
