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
import org.aurora.lovingmatching.view.matchView.CoopFrame.ExitMosListener;
import org.aurora.lovingmatching.view.matchView.CoopFrame.StartMosListener;
import org.aurora.lovingmatching.view.matchView.CoopFrame.StopMosListener;
import org.aurora.lovingmatching.view.matchView.CoopFrame.TimeListener;

/**
 * @Description 对战版游戏界面
 * @author m2o2o2d
 * 2014年5月17日下午6:21:56
 */
public class FightFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel returnLabel;//返回按钮
	private Timer timer;//-------------------------------------------------时间条
	private ALabel timeLabel;
	int height;
	int width;
	int a;
	int i;
	private ALabel lianjiLabel;//连击数
	private JLabel weScoreLabel;//我方得分
	private JLabel theyScoreLabel;//对手得分
	
	public FightFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"29",1,0);
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
		/*UI-我方得分*/
		weScoreLabel = new JLabel("12345678000");
		setLabel(weScoreLabel, 140, 180, 3);
		/*UI-对手得分*/
		theyScoreLabel = new JLabel("12345670");
		setLabel(theyScoreLabel, 140,260, 4);
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
		repaint();
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FightFrame();
	}

}
