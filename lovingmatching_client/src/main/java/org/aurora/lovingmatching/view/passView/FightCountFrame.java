package org.aurora.lovingmatching.view.passView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import org.aurora.lovingmatching.view.compLibView.AFont;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.roomAndHallView.CoopRoomFrame;

/**
 * @Description 对战版结算界面
 * @author m2o2o2d
 * 2014年5月17日下午11:37:41
 */
public class FightCountFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel closeLabel;//关闭结算按钮
	private ALabel grade1Label;//等级经验条
	private ALabel grade2Label;
	private Timer timer;//
	private int a;
	private int grade1;
	private int grade2;
	private int i;
	private int width1;
	private int height1;
	private int width2;
	private int height2;
	/*逻辑*/
	private JLabel scoreLabel1;
	private JLabel jingyanLabel1;
	private JLabel jinbiLabel1;
	private JLabel scoreLabel2;
	private JLabel jingyanLabel2;
	private JLabel jinbiLabel2;
	private ALabel winLabel;
	
	public FightCountFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"36",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(836, 63,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-关闭结算页面按钮*/
		closeLabel = new ALabel(675, 342, "1",0,1);
		closeLabel.getLabel().addMouseListener(new CloseMosListener());
		backPanel.add(closeLabel.getLabel());
		/*UI-时间*/
		timer = new Timer(200,new TimerListener());
		a = 0;
		timer.start();
		/*UI-等级经验条1*/
		grade1Label = new ALabel(408, 279, "35",1,0);
		grade1Label.getLabel().setHorizontalAlignment(SwingConstants.LEFT);
		height1 = grade1Label.getLabel().getHeight();
		grade1Label.getLabel().setBounds(448,228,0,height1);
		grade1 = 80;//经验条上限
		/*UI-等级经验条2*/
		grade2Label = new ALabel(408, 579, "35",1,0);
		grade2Label.getLabel().setHorizontalAlignment(SwingConstants.LEFT);
		height2 = grade2Label.getLabel().getHeight();
		grade2Label.getLabel().setBounds(448,464,0,height2);
		grade2 = 80;//经验条上限
		i = 8;//经验条增量
		backPanel.add(grade1Label.getLabel());
		backPanel.add(grade2Label.getLabel());
		/*UI-加成1*/
		scoreLabel1 = new JLabel("121231");
		jingyanLabel1 = new JLabel("+80");
		jinbiLabel1 = new JLabel("+100");
		setLabel(scoreLabel1, 200, 235, 3);
		setLabel(jingyanLabel1, 520, 220, 4);
		setLabel(jinbiLabel1, 410, 275, 4);
		/*UI-加成2*/
		scoreLabel2 = new JLabel("121231");
		jingyanLabel2 = new JLabel("+80");
		jinbiLabel2 = new JLabel("+100");
		setLabel(scoreLabel2, 200, 465, 3);
		setLabel(jingyanLabel2, 520, 450, 4);
		setLabel(jinbiLabel2, 410, 505, 4);
		/*UI-胜利标签*/
		winLabel = new ALabel(500, 340, "37",1,0);
		backPanel.add(winLabel.getLabel());
		winLabel.getLabel().setVisible(false);
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
	
	/*事件-关闭结算按钮*/
	class CloseMosListener implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			
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
	
	/*事件-时间*/
	class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			/*if(a==0) {
				backLabel.setPicture("30");
				a = 1;
			}
			else if(a==1) {
				backLabel.setPicture("32");
				a = 2;
			}
			else if(a==2) {
				backLabel.setPicture("33");
				a = 3;
			}
			else if(a==3) {
				backLabel.setPicture("34");
				a = 0;
			}*/
			if(width1<=grade1) {
				grade1Label.getLabel().setSize(width1,height1);
				width1 = width1+i;
			}
			if(width2<=grade2) {
				grade2Label.getLabel().setSize(width2,height2);
				width2 = width2+i;
			}
			repaint();
		}
		
	}
	
	/*函数-设置label*/
	public void setLabel(JLabel label,int x,int y,int f) {
		label.setBounds(x,y, 200, 40);
		label.setForeground(Color.yellow);
		label.setFont(new AFont().getFont(f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(false);
		backPanel.add(label);
	}
	
	/*函数-设置胜利标签位置*/
	public void setLocation(int i) {//i:1——A队胜利
		if(i==1) {
			winLabel.getLabel().setLocation(500,90);
		}
		else if(i==2) {
			winLabel.getLabel().setLocation(500,340);
		}
		winLabel.getLabel().setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FightCountFrame();
	}

}
