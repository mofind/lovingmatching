package org.aurora.lovingmatching.view.historyView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.APanel;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;

/**
 * @Description 单机历史记录
 * @author m2o2o2d
 * 2014年5月10日下午6:34:51
 */
public class LocalHistoryFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;
	private ALabel backLabel;
	private CardLayout cardlayout;
	private JPanel contain;
	private ALabel exitLabel;
	private ALabel returnLabel;
	private ALabel dayTimesLabel;//
	private ALabel avgScoreLabel;//
	private ALabel scorePerTimeLabel;//
	private ALabel totalLabel;//
	private APanel dayTimesPanel;//
	private APanel avgScorePanel;//
	private APanel scorePerTimePanel;//
	private APanel totalPanel;//
	/*特效*/
	private ALabel monkeyLabel;
	private ALabel pigLabel;
	/*逻辑*/
	private String uid;//用户ID
	
	public LocalHistoryFrame(String uid) {
		/*逻辑*/
		this.uid = uid;
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel  = new ALabel(0, 0, "history",1,0);
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
		/*UI-统计量按钮*/
		int x=690;int y=180;
		int a=60;
		dayTimesLabel = new ALabel(x,y,"dayTimes",0,1);
		backPanel.add(dayTimesLabel.getLabel());
		avgScoreLabel = new ALabel(x,y+a, "avgScore",0,1);
		backPanel.add(avgScoreLabel.getLabel());
		scorePerTimeLabel = new ALabel(x,y+2*a, "timeScore",0,1);
		backPanel.add(scorePerTimeLabel.getLabel());
		totalLabel = new ALabel(x,y+3*a,"otherReco",0,1);
		backPanel.add(totalLabel.getLabel());
		/*UI-卡式布局*/
		int w = 545;int h = 305;
		cardlayout = new CardLayout();
		contain = new JPanel();
		contain.setBounds(110, 145,w,h);
		backPanel.add(contain);
		contain.setLayout(cardlayout);
		contain.setOpaque(false);
		/*UI-每日局数曲线面板*/
		dayTimesPanel = new APanel(0,0,w,h);
		dayTimesLabel.getLabel().addMouseListener(new DayMosListener());
		dayTimesPanel.setBackground(Color.black);//
		contain.add(dayTimesPanel,"dayTimes");
		/*UI-平均得分曲线面板*/
		avgScorePanel = new APanel(0,0,w,h);
		avgScoreLabel.getLabel().addMouseListener(new AvgMosListener());
		avgScorePanel.setBackground(Color.yellow);//
		contain.add(avgScorePanel,"avgScore");
		/*UI-每局得分曲线面板*/
		scorePerTimePanel = new APanel(0,0,w,h);
		scorePerTimeLabel.getLabel().addMouseListener(new ScoreMosListener());
		scorePerTimePanel.setBackground(Color.red);//
		contain.add(scorePerTimePanel,"scorePerTime");
		/*UI-总记录面板*/
		totalPanel = new APanel(0,0,w,h);
		totalLabel.getLabel().addMouseListener(new TotalMosListener());
		totalPanel.setBackground(Color.pink);//
		contain.add(totalPanel,"total");		
		cardlayout.show(contain,"dayTimes");
		/*特效*/
		monkeyLabel = new ALabel(700, 510, "mRun",2,0);
		backPanel.add(monkeyLabel.getLabel());
		pigLabel = new ALabel(130, 500,"pRun",2,0);
		backPanel.add(pigLabel.getLabel());
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
	
	/*事件-每日局数按钮*/
	class DayMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "dayTimes");
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
	
	/*事件-平均得分按钮*/
	class AvgMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "avgScore");
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
	
	/*事件-每局得分按钮*/
	class ScoreMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "scorePerTime");

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
	
	/*事件-总记录按钮*/
	class TotalMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "total");

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
		new LocalHistoryFrame(uid);
	}

}
