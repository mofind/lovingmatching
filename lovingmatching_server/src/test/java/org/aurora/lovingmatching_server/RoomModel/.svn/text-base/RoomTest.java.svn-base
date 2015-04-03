package org.aurora.lovingmatching_server.RoomModel;

import org.aurora.lovingmatching_server.remoteMessage.netConnector.MockMailBox;
import org.aurora.lovingmatching_server.remoteModel.roomModel.Room;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RoomTest extends TestCase {
	private Room room;
	private MockMailBox box;
	
	protected void setUp() throws Exception {
		super.setUp();
		box = new MockMailBox();
		room = new Room("12345");
	}

	public void testPlayer() {
		Assert.assertEquals(0, room.addPlayer("1", box));
		Assert.assertEquals(3, room.addPlayer("1", box));
		Assert.assertEquals(0, room.addPlayer("2", box));
		Assert.assertEquals(1, room.addPlayer("3", box));
		Assert.assertEquals(0, room.removerPlayer("1"));
		Assert.assertEquals(1, room.removerPlayer("4"));
	}


}
