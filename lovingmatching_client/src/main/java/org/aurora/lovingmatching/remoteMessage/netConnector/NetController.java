package org.aurora.lovingmatching.remoteMessage.netConnector;

public class NetController {
	public static void start()
	{
		Connector.open();
		
	}
	
	/**
	 * 
	 */
	public static void close()
	{
		Connector.close();
	}
	
	public static void main(String args[])
	{
		start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		close();
		
	}

}
