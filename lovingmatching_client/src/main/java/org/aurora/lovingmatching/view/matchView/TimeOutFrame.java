package org.aurora.lovingmatching.view.matchView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.passView.SingleCountFrame;
import org.aurora.lovingmatching.view.specialEffects.soundEffects.sound;

/**
 * @Description 时间结束
 * @author m2o2o2d
 * 2014年6月8日下午11:30:09
 */
public class TimeOutFrame extends JFrame{

	/*UI*/
	private JFrame jFrame;
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private Timer timer;
	private int i;
	/*音乐*/
	
	public TimeOutFrame(JFrame jFrame) {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"end",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		setAlwaysOnTop(true);
		/*UI-时间条*/
		timer = new Timer(3000, new TimerListener());
		i = 1;
		timer.start();
		this.jFrame = jFrame;
		
		setVisible(true);
	}
	
	/*事件-时间条*/
	class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(i>1) {
				timer.stop();
				SingleCountFrame.main(null);
				dispose();
				jFrame.dispose();
			}
			i = i+1;
		}
		
	}
	public static void main(JFrame jFrame) {
		// TODO Auto-generated method stub
		new TimeOutFrame(jFrame);
	}

}
