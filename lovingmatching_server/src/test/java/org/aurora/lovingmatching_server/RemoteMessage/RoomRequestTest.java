package org.aurora.lovingmatching_server.RemoteMessage;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.RoomRequest;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RoomRequestTest extends TestCase {
	RoomRequest request1,request2;

	protected void setUp() throws Exception {
		super.setUp();
		
		request1 = new RoomRequest("create", "12345", "coop", "123");
		request2 = new RoomRequest("create;12345;coop;123");
	}

	public void testGetAction() {
		Assert.assertEquals("create", request1.getAction());
		Assert.assertEquals("create", request2.getAction());
	}

	public void testGetRoomType() {
		Assert.assertEquals("coop", request1.getRoomType());
		Assert.assertEquals("coop", request2.getRoomType());
	}

	public void testGetRoomId() {
		Assert.assertEquals("123", request1.getRoomId());
		Assert.assertEquals("123", request2.getRoomId());
	}

	public void testGetPlayerId() {
		Assert.assertEquals("12345", request1.getPlayerId());
		Assert.assertEquals("12345", request2.getPlayerId());
	}
	
	public void testToString() {
		Assert.assertEquals("room:create;12345;coop;123", request1.toString());
		Assert.assertEquals("room:create;12345;coop;123", request2.toString());
	}

}
