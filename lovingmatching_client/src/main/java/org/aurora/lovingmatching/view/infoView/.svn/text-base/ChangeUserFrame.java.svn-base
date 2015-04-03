package org.aurora.lovingmatching.view.infoView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.controller.infoController.InfoController;
import org.aurora.lovingmatching.model.shareModel.infoModel.InfoModel;
import org.aurora.lovingmatching.view.StubView.StubInfoView;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.AScrollPane;
import org.aurora.lovingmatching.view.compLibView.ATable;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.infoView.MyDocuFrame.ExitMosListener;
import org.aurora.lovingmatching.view.infoView.MyDocuFrame.ReturnMosListener;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;
import org.aurora.lovingmatching.vo.UserInfoVO;

/**
 * @Description 单机版：切换用户
 * @author m2o2o2d
 * 2014年5月25日上午9:30:00
 */
public class ChangeUserFrame extends JFrame implements StubInfoView{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel returnLabel;//返回按钮
	private ALabel changeLabel;//切换用户按钮
	private AScrollPane scrollPane;//
	private ATable userTable;//
	/*逻辑*/
	private String uid;//用户ID
	private InfoController infoController;
	private InfoModel infoModel;
	
	public ChangeUserFrame(String uid) {
		/*逻辑*/
		this.uid = uid;
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"changeUser",1,0);
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
		/*UI-切换用户*/
		changeLabel = new ALabel(390,510,"changeUser",0,1);
		changeLabel.getLabel().addMouseListener(new ChangeMosListener());
		backPanel.add(changeLabel.getLabel());
		/*逻辑*/
		infoModel = new InfoModel();
		infoController = new InfoController(this, infoModel);
		/*UI-用户列表*/
		scrollPane = new AScrollPane(190, 185, 540, 300);
		String[][] c = {{"古美萌","男","23"},{"古美萌","男","23"},{"古美萌","男","23"},{"古美萌","男","23"}};
		String[] h  = {"姓名","性别","等级"};
		userTable = new ATable(c,h);
		scrollPane.getScrollPane().setViewportView(userTable.getTable());
		backPanel.add(scrollPane.getScrollPane());
		
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
	
	/*事件-切换用户*/
	class ChangeMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			
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
		new ChangeUserFrame(uid);
	}


	@Override
	public void addInfoGestureListener(InfoController infoController) {
		
	}


	@Override
	public void displayUserInfo(UserInfoVO userInfoVO) {
		
	}

}
