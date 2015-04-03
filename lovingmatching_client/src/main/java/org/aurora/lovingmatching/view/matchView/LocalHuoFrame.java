package org.aurora.lovingmatching.view.matchView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;


/**
 * @Description 单机游戏界面：火焰山
 * @author m2o2o2d
 * 2014年5月10日下午7:11:22
 */
public class LocalHuoFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;
	private ALabel backLabel;
	private CardLayout cardlayout;
	private JPanel contain;
	private ALabel exitLabel;
	private ALabel returnLabel;
	
	/*逻辑*/
	private ALabel gradeLabel;//分数
	private String uid;//用户ID
	private PlayPanel playPanel;
	
	public LocalHuoFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel  = new ALabel(0, 0, "5",1,0);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		backPanel.setLayout(null);
		/*UI-退出按钮*/
		exitLabel = new ALabel(836, 63,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-返回按钮*/
		returnLabel = new ALabel(800,63,"4",0,1);
		returnLabel.getLabel().addMouseListener(new ReturnMosListener());
		backPanel.add(returnLabel.getLabel());
		
		/*逻辑-加入消除面板*/
		playPanel = new PlayPanel();
        add(playPanel);
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
		
		new LocalHuoFrame();
	}

}
