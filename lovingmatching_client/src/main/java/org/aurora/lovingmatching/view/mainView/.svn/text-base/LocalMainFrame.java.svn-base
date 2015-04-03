package org.aurora.lovingmatching.view.mainView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.controller.infoController.InfoController;
import org.aurora.lovingmatching.model.shareModel.infoModel.InfoModel;
import org.aurora.lovingmatching.txtUtility.AbstractFileUtility;
import org.aurora.lovingmatching.txtUtility.FileUtility;
import org.aurora.lovingmatching.view.StubView.StubInfoView;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.historyView.LocalHistoryFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.infoView.ChangeUserFrame;
import org.aurora.lovingmatching.view.infoView.DocuFrame;
import org.aurora.lovingmatching.view.infoView.MyDocuFrame;
import org.aurora.lovingmatching.view.infoView.NewUserFrame;
import org.aurora.lovingmatching.view.matchView.LocalBaiFrame;
import org.aurora.lovingmatching.view.matchView.LocalCheFrame;
import org.aurora.lovingmatching.view.matchView.LocalDaFrame;
import org.aurora.lovingmatching.view.matchView.LocalHuoFrame;
import org.aurora.lovingmatching.view.propView.BaiguPropFrame;
import org.aurora.lovingmatching.view.propView.ChoosePropFrame;
import org.aurora.lovingmatching.view.specialEffects.soundEffects.sound;
import org.aurora.lovingmatching.vo.UserInfoVO;

/**
 * @Description 单机模式主界面
 * @author m2o2o2d
 * 2014年5月6日下午8:15:30
 */
public class LocalMainFrame extends JFrame implements StubInfoView{
	
	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel returnLabel;//返回按钮
	private ALabel baiguLabel;//白骨岭按钮
	private ALabel chechiLabel;//车迟国按钮
	private ALabel huoyanLabel;//火焰山按钮
	private ALabel datangLabel;//大唐按钮
	private ALabel docuLabel;//我的档案按钮
	private ALabel histoLabel;//历史记录按钮
	private ALabel changeUserLabel;//切换用户按钮
	private ALabel newUserLabel;//创建用户按钮
	/*逻辑*/
	private String uid;//用户ID
	private InfoController infoController;
	private InfoModel infoModel;
	private UserInfoVO userInfoVO;
	/*音乐*/
	private sound sound;
	
	public LocalMainFrame(String uid) {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"localmap",1,0);
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
		/*UI-大唐*/
		datangLabel = new ALabel(520, 358, "10",0,1);
		datangLabel.getLabel().addMouseListener(new DaMosListener());
		backPanel.add(datangLabel.getLabel());
		/*UI-车迟国*/
		chechiLabel = new ALabel(670, 230, "8",0,1);
		chechiLabel.getLabel().addMouseListener(new CheMosListener());
		backPanel.add(chechiLabel.getLabel());
		/*UI-白骨岭*/
		baiguLabel = new ALabel(323, 272, "5",0,1);
		baiguLabel.getLabel().addMouseListener(new BaiMosListener());
		backPanel.add(baiguLabel.getLabel());
		/*UI-火焰山*/
		huoyanLabel = new ALabel(202, 415, "9",0,1);
		huoyanLabel.getLabel().addMouseListener(new HuoMosListener());
		backPanel.add(huoyanLabel.getLabel());
		/*UI-我的档案*/
		int x=683;int y=390;
		int a=54;
		docuLabel = new ALabel(x,y,"mydocu",0,1);
		docuLabel.getLabel().addMouseListener(new DocuMosListener());
		backPanel.add(docuLabel.getLabel());
		/*UI-历史记录*/
		histoLabel = new ALabel(x,y+a,"history",0,1);
		histoLabel.getLabel().addMouseListener(new HistoMosListener());
		backPanel.add(histoLabel.getLabel());
		/*UI-切换用户*/
		histoLabel = new ALabel(x,y+2*a,"changeUser",0,1);
		histoLabel.getLabel().addMouseListener(new ChangeMosListener());
		backPanel.add(histoLabel.getLabel());
		/*UI-创建用户*/
		histoLabel = new ALabel(x,y+3*a,"newUser",0,1);
		histoLabel.getLabel().addMouseListener(new NewMosListener());
		backPanel.add(histoLabel.getLabel());
		/*逻辑*/
		this.uid = uid;
		infoModel = new InfoModel();
		infoController = new InfoController(this, infoModel);
		userInfoVO = infoModel.getUserState(uid);
		/*音乐*/
		sound = new sound();
		sound.playBGM("localFrame");
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
			dispose();
			StartFrame.main(null);
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
	
	/*事件-我的档案按钮*/
	class DocuMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			MyDocuFrame.main(userInfoVO);
			System.out.println("@LocalMain"+uid);//ft
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
	
	/*事件-历史记录按钮*/
	class HistoMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			LocalHistoryFrame.main(uid);
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
	
	/*事件-切换用户按钮*/
	class ChangeMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			ChangeUserFrame.main(uid);
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
	
	/*事件-创建用户按钮*/
	class NewMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			NewUserFrame.main(uid);
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
	
	/*事件-白骨岭按钮*/
	class BaiMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			//LocalBaiFrame.main(null);
			BaiguPropFrame.main(uid);
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
	
	/*事件-大唐按钮*/
	class DaMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			LocalDaFrame.main(uid);
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
	
	/*事件-车迟国按钮*/
	class CheMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			//dispose();
			LocalCheFrame.main(null);
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
	
	/*事件-火焰山按钮*/
	class HuoMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			//dispose();
			LocalHuoFrame.main(null);
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
	
	/*接口方法-*/
	public void addInfoGestureListener(InfoController infoController) {
		// TODO Auto-generated method stub
		
	}
	
	/*接口方法-*/
	public void displayUserInfo(UserInfoVO userInfoVO) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String uid) {
		// TODO Auto-generated method stub
		new LocalMainFrame(uid);
	}


}
