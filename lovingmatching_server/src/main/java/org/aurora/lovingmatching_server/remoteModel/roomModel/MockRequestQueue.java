package org.aurora.lovingmatching_server.remoteModel.roomModel;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.Request;

public class MockRequestQueue extends RequestQueue {

	public void addRequest(Request request)
	{
		System.out.println("Request queue got a request: " + request.toString());
	}

}
