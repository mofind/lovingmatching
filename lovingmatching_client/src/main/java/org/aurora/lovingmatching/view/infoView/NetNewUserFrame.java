package org.aurora.lovingmatching.view.infoView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.controller.infoController.AbstractInfoController;
import org.aurora.lovingmatching.controller.infoController.AbstractNetInfoController;
import org.aurora.lovingmatching.controller.infoController.InfoController;
import org.aurora.lovingmatching.controller.infoController.NetInfoController;
import org.aurora.lovingmatching.model.shareModel.infoModel.InfoModel;
import org.aurora.lovingmatching.view.StubView.StubInfoView;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.APasswordField;
import org.aurora.lovingmatching.view.compLibView.ARadioButton;
import org.aurora.lovingmatching.view.compLibView.ATextField;
import org.aurora.lovingmatching.view.entryView.LoginFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;
import org.aurora.lovingmatching.vo.MessageVO;
import org.aurora.lovingmatching.vo.UserInfoVO;

/**
 * @Description 创建用户
 * @author m2o2o2d
 * 2014年5月25日上午9:42:35
 */
public class NetNewUserFrame extends JFrame implements StubInfoView{
	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel returnLabel;//返回按钮
	private ALabel newUserLabel;//创建用户按钮
	private ATextField nameTextField;//昵称输入框
	private ARadioButton nanRadioButton;//男性别单选框
	private ARadioButton nvRadioButton;//女性别单选框
	private ButtonGroup buttonGroup;
	private APasswordField keyPassField;//密码输入框
	private APasswordField key2PassField;//密码确认输入框
	private ALabel nullNameLabel;//“请输入昵称”
	private ALabel nullKeyLabel1;//"请输入密码"
	private ALabel nullKeyLabel2;//"请输入确认密码"
	private ALabel notSameLabel;//"密码不一致，请重新输入"
	private ALabel successLabel;//"创建成功"
	
	/*逻辑*/
	private String uid;//用户ID
	private String sex;
	private String keyword1;
	private String keyword2;
	private static final String GIRL="G";
	private static final String BOY="B";
	private AbstractNetInfoController abstractNetInfoController;
	
	public NetNewUserFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"newUser",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(836, 63,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-返回按钮*/
		returnLabel = new ALabel(800,63,"4",0,1);
		returnLabel.getLabel().addMouseListener(new ReturnMosListener());
		backPanel.add(returnLabel.getLabel());
		/*UI-昵称输入框*/
		int x=378;int w=202;int h=35;
		nameTextField = new ATextField(x, 190, w,h);
		backPanel.add(nameTextField.getTextField());
		/*UI-性别单选框*/
		int y=265;
		int x1=372;
		nanRadioButton = new ARadioButton(x1, y, true);
		nanRadioButton.setSelected(true);
		nanRadioButton.addActionListener(new RadioListener());
		backPanel.add(nanRadioButton);
		nvRadioButton = new ARadioButton(x1+111, y, false);
		nvRadioButton.addActionListener(new RadioListener());
		backPanel.add(nvRadioButton);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(nanRadioButton);
		buttonGroup.add(nvRadioButton);
		/*UI-密码输入框*/
		keyPassField = new APasswordField(x,342,w,h);
		backPanel.add(keyPassField);
		/*UI-确认密码输入框*/
		key2PassField = new APasswordField(x,429,w,h);
		backPanel.add(key2PassField);
		setVisible(true);
		/*UI-“请输入昵称”*/
		nullNameLabel = new ALabel(x-10,120, "errorInputName", 1, 0);
		backPanel.add(nullNameLabel.getLabel());
		nullNameLabel.getLabel().setVisible(false);
		/*UI-“创建成功”*/
		successLabel = new ALabel(378,120, "hintNewUser", 1, 0);
		backPanel.add(successLabel.getLabel());
		successLabel.getLabel().setVisible(false);
		/*UI-"请输入密码"*/
		nullKeyLabel1 = new ALabel(x-10, 120, "inputkey",1,0);
		backPanel.add(nullKeyLabel1.getLabel());
		nullKeyLabel1.getLabel().setVisible(false);
		/*UI-"请输入确认密码"*/
		nullKeyLabel2 = new ALabel(360, 120, "inputsurekey",1,0);
		backPanel.add(nullKeyLabel2.getLabel());
		nullKeyLabel2.getLabel().setVisible(false);
		/*UI-"密码不一致"*/
		notSameLabel = new ALabel(380, 120, "inputsamekey",1,0);
		backPanel.add(notSameLabel.getLabel());
		notSameLabel.getLabel().setVisible(false);
		/*UI-创建用户*/
		newUserLabel = new ALabel(380,502,"newUser",0,1);
		newUserLabel.getLabel().addMouseListener(new NewUserMosListener());
		backPanel.add(newUserLabel.getLabel());
		/*逻辑*/
		abstractNetInfoController = new NetInfoController();
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
	
	/*事件-返回按钮*/
	class ReturnMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			LoginFrame.main(null);
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
	
	/*事件-单选按钮*/
	class RadioListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == nanRadioButton) {
				sex = "B";
			}
			if(e.getSource() == nvRadioButton) {
				sex = "G";
				System.out.println("you are a girl");
			}
		}
		
	}
	
	
	/*事件-创建用户*/
	class NewUserMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			System.out.println("@click");
			if(isValid()) {
				MessageVO messageVO = abstractNetInfoController.register(uid, keyword1);
				System.err.println(messageVO.getMessage());
				System.out.println("创建成功");
			}
		}
		
		/*方法-判断用户信息是否合法*/
		public boolean isValid() {
			if(nameTextField.getTextField().getText()!=null) {
				uid = nameTextField.getTextField().getText();
			}
			System.out.println("@uid "+uid);//ft
			keyword1 = new String(keyPassField.getPassword());
			keyword2 = new String(key2PassField.getPassword());
			System.out.println("@key1+"+keyword1);
			if(uid==null || uid.length()==0) {//"请输入昵称"
				System.out.println("@0");
				display(0);
				return false;
			}
			else if(keyword1==null || keyword1.length()==0) {//"请输入密码"
				System.out.println("@1");
				display(1);
				return false;
			}
			else if(keyword2==null || keyword2.length()==0) {//"请确认密码"
				System.out.println("@2");
				display(2);
				return false;
			}
			else if(!keyword1.equals(keyword2)) {//"密码不一致，请重新输入"
				System.out.println("@3");
				display(3);
				return false;
			}
			else {
				System.out.println("@4");
				display(4);
				return true;
			}
		}
		
		/*方法-提示信息显示*/
		public void display(int num) {
			nullNameLabel.getLabel().setVisible(false);
			nullKeyLabel1.getLabel().setVisible(false);
			nullKeyLabel2.getLabel().setVisible(false);
			notSameLabel.getLabel().setVisible(false);
			successLabel.getLabel().setVisible(false);
			switch (num) {
			case 0://请输入昵称
				nullNameLabel.getLabel().setVisible(true);
				break;
			case 1://请输入密码
				nullKeyLabel1.getLabel().setVisible(true);
				break;
			case 2://请输入确认密码
				nullKeyLabel2.getLabel().setVisible(true);
				break;
			case 3://密码不一致
				notSameLabel.getLabel().setVisible(true);
				break;
			case 4://创建成功
				successLabel.getLabel().setVisible(true);
				break;
			}
			repaint();
			
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NetNewUserFrame();
	}

	public void addInfoGestureListener(InfoController infoController) {
		// TODO Auto-generated method stub
		
	}

	public void displayUserInfo(UserInfoVO userInfoVO) {
		// TODO Auto-generated method stub
		
	}

}