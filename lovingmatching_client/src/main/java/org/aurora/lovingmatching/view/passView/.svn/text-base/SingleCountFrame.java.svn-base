package org.aurora.lovingmatching.view.passView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import org.aurora.lovingmatching.view.compLibView.AFont;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;
import org.aurora.lovingmatching.view.roomAndHallView.CoopRoomFrame;

/**
 * @Description 单人及协作版结算界面
 * @author m2o2o2d
 * 2014年5月17日下午8:42:50
 */
public class SingleCountFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel closeLabel;//关闭结算按钮
	private ALabel gradeLabel;//等级经验条
	private Timer timer;//
	private int a;
	private int grade;
	private int i;
	private int width;
	private int height;
	/*逻辑*/
	private JLabel scoreLabel;
	private JLabel jingyanLabel;
	private JLabel jinbiLabel;
	private String uid;
	
	public SingleCountFrame(String uid) {
		
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"34",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(836, 63,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-关闭结算页面按钮*/
		closeLabel = new ALabel(675, 195, "1",0,1);
		closeLabel.getLabel().addMouseListener(new CloseMosListener());
		backPanel.add(closeLabel.getLabel());
		/*UI-时间*/
		timer = new Timer(200,new TimerListener());
		a = 0;
		timer.start();
		/*UI-等级经验条*/
		gradeLabel = new ALabel(408, 379, "35",1,0);
		gradeLabel.getLabel().setHorizontalAlignment(SwingConstants.LEFT);
		height = gradeLabel.getLabel().getHeight();
		gradeLabel.getLabel().setBounds(408,379,0,height);
		grade = 80;//经验条上限
		i = 8;//经验条增量
		backPanel.add(gradeLabel.getLabel());
		/*UI-加成*/
		scoreLabel = new JLabel("121231");
		jingyanLabel = new JLabel("+80");
		jinbiLabel = new JLabel("+100");
		setLabel(scoreLabel, 350, 245, 0);
		scoreLabel.setForeground(Color.black);
		setLabel(jingyanLabel, 470, 370, 4);
		setLabel(jinbiLabel, 370, 425, 4);
		/*逻辑*/
		this.uid = uid;
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
			LocalMainFrame.main(uid);
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
	
	/*事件-时间*/
	class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if(a==0) {
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
			}
			if(width<=grade) {
				gradeLabel.getLabel().setSize(width,height);
				width = width+i;
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
	
	public static void main(String uid) {
		// TODO Auto-generated method stub
		new SingleCountFrame(uid);
	}

}
