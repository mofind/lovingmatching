package org.aurora.lovingmatching.view.specialEffects.visualEffects;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.ldap.StartTlsRequest;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;

/**
 * @Description 开始前的logo显示
 * @author m2o2o2d
 * 2014年5月29日下午11:15:31
 */
public class StartLogoSpecial extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private Timer timer;//
	int i;
	
	public StartLogoSpecial() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"logo3",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-time*/
		timer = new Timer(80, new TimeListener());
		i=0;
		timer.start();
		setVisible(true);
	}
	
	class TimeListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (i) {
			case 0:
				backLabel.setPicture("logo2");
				break;
			case 1:
				backLabel.setPicture("logo1");
				timer.setDelay(1200);
				break;
			case 2:
				backLabel.setPicture("logo");
				timer.setDelay(120);
				break;
			case 3:
				backLabel.setPicture("logo1");
				break;
			case 4:
				backLabel.setPicture("logo2");
				break;
			case 5:
				backLabel.setPicture("logo3");
				timer.setDelay(120);
				break;
			case 6:
				StartFrame.main(null);
				timer.stop();
				dispose();
			}
			i = i+1;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StartLogoSpecial();
	}

}
