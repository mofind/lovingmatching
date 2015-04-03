package org.aurora.lovingmatching.view.infoView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.controller.infoController.InfoController;
import org.aurora.lovingmatching.model.shareModel.infoModel.InfoModel;
import org.aurora.lovingmatching.view.StubView.StubInfoView;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.APasswordField;
import org.aurora.lovingmatching.view.compLibView.ARadioButton;
import org.aurora.lovingmatching.view.compLibView.ATextField;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;
import org.aurora.lovingmatching.vo.UserInfoVO;

/**
 * @Description 创建用户
 * @author m2o2o2d
 * 2014年5月25日上午9:42:35
 */
public class NewUserFrame extends JFrame implements StubInfoView{
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
	private ALabel errorLabel;//“请输入昵称”
	private ALabel successLabel;//"创建成功"
	/*逻辑*/
	private String uid;//用户ID
	private String sex;
	private static final String GIRL="G";
	private static final String BOY="B";
	private InfoController infoController;
	private InfoModel infoModel;
	
	public NewUserFrame(String uid) {
		this.uid = uid;
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"newUser2",1,0);
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
		/*UI-创建用户*/
		newUserLabel = new ALabel(380,450,"newUser",0,1);
		newUserLabel.getLabel().addMouseListener(new NewUserMosListener());
		backPanel.add(newUserLabel.getLabel());
		/*UI-昵称输入框*/
		int x=378;int w=202;int h=35;
		nameTextField = new ATextField(x, 252, w,h);
		backPanel.add(nameTextField.getTextField());
		/*UI-“请输入昵称”*/
		errorLabel = new ALabel(x-10,180, "errorInputName", 1, 0);
		backPanel.add(errorLabel.getLabel());
		errorLabel.getLabel().setVisible(false);
		/*UI-“创建成功”*/
		successLabel = new ALabel(x-10,180, "hintNewUser", 1, 0);
		backPanel.add(successLabel.getLabel());
		successLabel.getLabel().setVisible(false);
		/*UI-性别单选框*/
		int y=359;
		int x1=369;
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
		/*逻辑*/
		infoModel = new InfoModel();
		infoController = new InfoController(this, infoModel);
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
			LocalMainFrame.main(uid);
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
	
	/*逻辑-*/
	public void addGestuerListener(InfoController infoController) {
		this.infoController = infoController;
	}
	
	/*事件-创建用户*/
	class NewUserMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if(nameTextField.getTextField().getText()!=null) {
				uid = nameTextField.getTextField().getText();
			}
			System.out.println("sex:"+sex);//ft
			if(uid!=null && uid.length()!=0) {
				infoController.createUser(new UserInfoVO(uid,sex,0,0,0));
				errorLabel.getLabel().setVisible(false);
				successLabel.getLabel().setVisible(true);
			}
			else {
				errorLabel.getLabel().setVisible(true);
			}
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
	
	public static void main(String uid) {
		// TODO Auto-generated method stub
		new NewUserFrame(uid);
	}

	public void addInfoGestureListener(InfoController infoController) {
		// TODO Auto-generated method stub
		
	}

	public void displayUserInfo(UserInfoVO userInfoVO) {
		// TODO Auto-generated method stub
		
	}

}
