package org.aurora.lovingmatching.view.roomAndHallView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.propView.ChoosePropFrame;
import org.aurora.lovingmatching.view.roomAndHallView.CoopHallFrame.ExitMosListener;
import org.aurora.lovingmatching.view.roomAndHallView.CoopHallFrame.ReturnMosListener;

/**
 * @Description
 * @author m2o2o2d
 * 2014年5月15日下午3:10:15
 */
public class FightRoomFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel returnLabel;//返回按钮
	private ALabel outRoomLabel;//退出房间按钮
	private ALabel chooseLabel;//选择装备按钮
	private ALabel readyLabel;//准备按钮
	private ALabel joinALabel;//加入甲按钮
	private ALabel joinBLabel;//加入乙按钮
	
	
	public FightRoomFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"13",1,0);
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
		/*UI-退出房间按钮*/
		int x = 220;int a = 160;
		outRoomLabel = new ALabel(x, 323, "19",0,1);
		backPanel.add(outRoomLabel.getLabel());
		/*UI-选择装备按钮*/
		chooseLabel = new ALabel(x+a, 323, "20",0,1);
		chooseLabel.getLabel().addMouseListener(new ChooseMosListener());
		backPanel.add(chooseLabel.getLabel());
		/*UI-准备按钮*/
		readyLabel = new ALabel(x+2*a, 323, "21",0,1);
		readyLabel.getLabel().addMouseListener(new ReadyMosListener());
		backPanel.add(readyLabel.getLabel());
		/*UI-加入甲按钮*/
		joinALabel = new ALabel(730,120,"42",0,1);
		joinALabel.getLabel().addMouseListener(new JoinAMosListener());
		backPanel.add(joinALabel.getLabel());
		/*UI-加入乙按钮*/
		joinBLabel = new ALabel(728, 362, "42",0,1);
		joinBLabel.getLabel().addMouseListener(new JoinBMosListener());
		backPanel.add(joinBLabel.getLabel());
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
	
	/*事件-退出房间按钮*/
	class EixtRoomMosListener implements MouseListener {
		
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
	
	/*事件-选择道具按钮*/
	class ChooseMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			ChoosePropFrame.main(null);
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
	
	/*事件-准备好了按钮*/
	class ReadyMosListener implements MouseListener {
		
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
	
	/*事件-加入甲按钮*/
	class JoinAMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			joinBLabel.removeLabelMouseListener();
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
	
	/*事件-加入乙按钮*/
	class JoinBMosListener implements MouseListener {
		
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FightRoomFrame();
	}

}
