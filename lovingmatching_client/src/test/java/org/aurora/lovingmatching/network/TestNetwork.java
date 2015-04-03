package org.aurora.lovingmatching.network;

import org.aurora.lovingmatching.controller.infoController.AbstractNetInfoController;
import org.aurora.lovingmatching.controller.infoController.NetInfoController;
import org.aurora.lovingmatching.controller.netController.AbstractNetController;
import org.aurora.lovingmatching.controller.netController.NetController;
import org.aurora.lovingmatching.vo.MessageVO;

public class TestNetwork {
	AbstractNetController net_controller;
	AbstractNetInfoController info_controller;

	public TestNetwork()
	{
		net_controller = new NetController();
		info_controller = new NetInfoController();
	}
	
	public void testStart()
	{
		net_controller.startNetwork();
	}
	
	public void testClose()
	{
		net_controller.closeNetwork();
	}
	
	public void testPlayer()
	{
		String id = "player638";
		String pw = "password";
		String mesg;

		mesg = info_controller.register(id, pw).getMessage();
		System.out.println("Register message: " + mesg);
		
		mesg = info_controller.logout().getMessage();
		System.out.println("Logout message: " + mesg);
		/*

		mesg = info_controller.login(id, pw).getMessage();
		System.out.println("Login message: " + mesg);

		mesg = info_controller.logout().getMessage();
		System.out.println("Logout message: " + mesg);
		*/

	}
	
	public static void main(String[] args) {
		TestNetwork net = new TestNetwork();
		net.testStart();
		net.testPlayer();

	}

}
