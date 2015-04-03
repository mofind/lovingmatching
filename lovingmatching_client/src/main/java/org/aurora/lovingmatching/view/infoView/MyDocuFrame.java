package org.aurora.lovingmatching.view.infoView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.controller.infoController.InfoController;
import org.aurora.lovingmatching.model.shareModel.infoModel.InfoModel;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.APasswordField;
import org.aurora.lovingmatching.view.compLibView.ATextField;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;
import org.aurora.lovingmatching.view.StubView.*;
import org.aurora.lovingmatching.vo.UserInfoVO;

/**
 * @Description 我的档案
 * @author m2o2o2d
 * 2014年5月25日上午8:28:13
 */
public class MyDocuFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel returnLabel;//返回按钮
	private ALabel nameLabel;//昵称标签
	private ALabel sexLabel;//性别标签
	private ALabel gradeLabel;//等级标签
	private ALabel expLabel;//经验标签
	private ALabel moneyLabel;//金币标签
	/*逻辑*/
	private String uid;//用户ID
	private String sexString;
	private String gradeString;
	private String expString;
	private String moneyString;
	
	public MyDocuFrame (UserInfoVO userInfoVO) {
		/*逻辑*/
		uid = userInfoVO.getID();
		//sexString = userInfoVO.getSex();
		gradeString = userInfoVO.getRank()+"";
		expString = userInfoVO.getScore()+"";
		moneyString = userInfoVO.getMoney()+"";
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"myDocu",1,0);
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
		/*昵称标签*/
		int x=400;int y=192;
		int a=65;
		int w=150;
		int h=30;
		nameLabel = new ALabel(x,y,w,h,uid);
		backPanel.add(nameLabel.getLabel());
		/*性别标签*/
		sexLabel = new ALabel(x,y+a,w,h,sexString);
		backPanel.add(sexLabel.getLabel());
		/*等级标签*/
		gradeLabel = new ALabel(x,y+2*a,w,h,gradeString);
		backPanel.add(gradeLabel.getLabel());
		/*经验标签*/
		expLabel = new ALabel(x,y+3*a,w,h,expString);
		backPanel.add(expLabel.getLabel());
		/*金币标签*/
		moneyLabel = new ALabel(x,y+4*a+3,w,h,moneyString);
		backPanel.add(moneyLabel.getLabel());
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

	
	public static void main(UserInfoVO userInfoVO) {
		// TODO Auto-generated method stub
		new MyDocuFrame(userInfoVO);
	}

	

}
