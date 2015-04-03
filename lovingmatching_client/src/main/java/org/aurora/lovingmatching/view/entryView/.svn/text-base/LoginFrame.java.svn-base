package org.aurora.lovingmatching.view.entryView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.RescaleOp;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.controller.netController.AbstractNetController;
import org.aurora.lovingmatching.controller.netController.NetController;
import org.aurora.lovingmatching.view.compLibView.ACheckBox;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.APasswordField;
import org.aurora.lovingmatching.view.compLibView.ATextField;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.infoView.NetNewUserFrame;
import org.aurora.lovingmatching.view.mainView.NetMainFrame;

/**
 * @Description 网络模式：登陆界面
 * @author m2o2o2d
 * 2014年5月15日上午8:07:01
 */
public class LoginFrame extends JFrame{
	
	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel loginLabel;//登陆按钮
	private ALabel registerLabel;//注册按钮
	private ALabel toMainLabel;//返回主页按钮
	private ALabel forgiveLabel;//忘记密码按钮
	private ALabel aboutLabel;//关于我们按钮
	private ATextField nameTextField;//昵称输入框
	private APasswordField keyPassField;//密码输入框
	private ACheckBox nameCheckBox;//记住我复选框
	private ACheckBox keyCheckBox;//记住密码复选框
	/*逻辑*/
	private AbstractNetController  abstractNetController;

	public LoginFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"10",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(836, 63,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-登陆按钮*/
		loginLabel = new ALabel(560, 380, "15",0,1);
		loginLabel.getLabel().addMouseListener(new LoginMosListener());
		backPanel.add(loginLabel.getLabel());
		/*UI-注册按钮*/
		registerLabel = new ALabel(430, 381,"16",0,1);
		registerLabel.getLabel().addMouseListener(new RegisterMosListener());
		backPanel.add(registerLabel.getLabel());
		/*UI-返回主页按钮*/
		toMainLabel = new ALabel(240, 245, "18",0,1);
		toMainLabel.getLabel().addMouseListener(new ToMainMosListener());
		backPanel.add(toMainLabel.getLabel());
		/*UI-忘记密码按钮*/
		forgiveLabel = new ALabel(240, 320, "17",0,1);
		forgiveLabel.getLabel().addMouseListener(new FindKeyMosListener());
		backPanel.add(forgiveLabel.getLabel());
		/*UI-关于我们按钮*/
		aboutLabel = new ALabel(240, 395, "27",0,1);
		backPanel.add(aboutLabel.getLabel());
		/*UI-昵称输入框*/
		nameTextField = new ATextField(502, 240, 150, 35);
		backPanel.add(nameTextField.getTextField());
		/*UI-密码输入框*/
		keyPassField = new APasswordField(502,294,150,35);
		backPanel.add(keyPassField);
		/*UI-记住我复选框*/
		nameCheckBox = new ACheckBox(430, 336, false);
		backPanel.add(nameCheckBox);
		/*UI-记住密码复选框*/
		keyCheckBox = new ACheckBox(547, 336, false);
		backPanel.add(keyCheckBox);
		/*逻辑*/
		abstractNetController = new NetController();
		setVisible(true);
	}
	
	/*事件-退出按钮*/
	class ExitMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			System.exit(1);
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-返回主页按钮*/
	class ToMainMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			abstractNetController.closeNetwork();
			StartFrame.main(null);
			dispose();
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-登陆按钮*/
	class LoginMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			NetMainFrame.main(null);
			dispose();
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-注册按钮*/
	class RegisterMosListener implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			NetNewUserFrame.main(null);
			dispose();
		}

		public void mouseEntered(MouseEvent arg0) {
			
		}

		public void mouseExited(MouseEvent arg0) {
			
		}

		public void mousePressed(MouseEvent arg0) {
			
		}

		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	
	/*事件-忘记密码*/
	class FindKeyMosListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			FindKeyFrame.main(null);
			dispose();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		new LoginFrame();
	}

}
