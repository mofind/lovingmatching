package org.aurora.lovingmatching.view.matchView;

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

/**
 * @Description 协作版游戏界面
 * @author m2o2o2d
 * 2014年5月15日下午5:32:35
 */
public class CoopFrame extends JFrame{
	
	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private Timer timer;//-------------------------------------------------时间条
	private ALabel timeLabel;
	int height;
	int width;
	int a;
	int i;
	private ALabel lianjiLabel;//连击数
	private ALabel stopLabel;//暂停按钮
	private ALabel startLabel;//开始按钮
	private JLabel scoreLabel;//得分
	
	public CoopFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"19",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(836, 63,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-时间条*/
		//timer = new Timer(1000, new TimeListener());
		timer = new Timer(250, new TimeListener());
		timeLabel = new ALabel(129, 566, "31",1,0);
		timeLabel.getLabel().setHorizontalAlignment(SwingConstants.RIGHT);
		backPanel.add(timeLabel.getLabel());
		height= timeLabel.getLabel().getHeight();
		width = timeLabel.getLabel().getWidth();
		//a = 9;
		a = 2;
		i = 1;
		timer.start();
		/*UI-连击数*/
		lianjiLabel = new ALabel(130, 440, "24",1,0);
		backPanel.add(lianjiLabel.getLabel());
		/*UI-暂停按钮*/
		stopLabel = new ALabel(190, 300, "52",0,1);
		stopLabel.getLabel().addMouseListener(new StopMosListener());
		backPanel.add(stopLabel.getLabel());
		/*UI-开始按钮*/
		startLabel = new ALabel(190, 300, "53",0,1);
		startLabel.getLabel().addMouseListener(new StartMosListener());
		startLabel.getLabel().setVisible(false);
		backPanel.add(startLabel.getLabel());
		/*UI-得分*/
		scoreLabel = new JLabel("12345678000");
		scoreLabel.setBounds(140, 210, 200, 40);
		scoreLabel.setForeground(Color.yellow);
		scoreLabel.setFont(new AFont().getFont(3));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setOpaque(false);
		backPanel.add(scoreLabel);
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
	
	/*事件-时间条*/
	class TimeListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(width>0&i<241) {
				width = width - a;
				timeLabel.getLabel().setSize(width, height);
				System.out.println(i);
				i = i+1;
				repaint();
			}
			else {
				timer.stop();
			}
		}
		
	}
	
	/*函数-设置连击数*/
	public void setLianji(int i) {//i：连击次数
		switch (i) {
		case 0:
			lianjiLabel.setPicture("24");
			break;
		case 1:
			lianjiLabel.setPicture("25");
			break;
		case 2:
			lianjiLabel.setPicture("26");
			break;
		case 3:
			lianjiLabel.setPicture("27");
			break;
		case 4:
			lianjiLabel.setPicture("28");
			break;
		default:
			break;
		}
	}
	
	/*事件-暂停按钮*/
	class StopMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			timer.stop();
			startLabel.getLabel().setVisible(true);
			stopLabel.getLabel().setVisible(false);
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
	
	/*事件-开始按钮*/
	class StartMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			timer.start();
			startLabel.getLabel().setVisible(false);
			stopLabel.getLabel().setVisible(true);
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
		new CoopFrame();
	}

}
