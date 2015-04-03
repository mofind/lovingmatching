package org.aurora.lovingmatching.view.specialEffects.visualEffects;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.aurora.lovingmatching.controller.infoController.InfoController;
import org.aurora.lovingmatching.model.shareModel.infoModel.InfoModel;
import org.aurora.lovingmatching.txtUtility.AbstractFileUtility;
import org.aurora.lovingmatching.txtUtility.FileUtility;
import org.aurora.lovingmatching.view.StubView.StubInfoView;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;
import org.aurora.lovingmatching.view.specialEffects.visualEffects.StartLogoSpecial.TimeListener;
import org.aurora.lovingmatching.vo.UserInfoVO;

/**
 * @Description
 * @author m2o2o2d
 * 2014年5月29日下午11:58:35
 */
public class LocalMapSpecial extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private Timer timer;//
	int i;
	
	public LocalMapSpecial() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"wukong1",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-time*/
		timer = new Timer(120, new TimeListener());
		i=0;
		timer.start();
		setVisible(true);
	}
	
	class TimeListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (i) {
			case 0:
				backLabel.setPicture("wukong2");
				break;
			case 1:
				backLabel.setPicture("wukong3");
				break;
			case 2:
				backLabel.setPicture("wukong4");
				break;
			case 3:
				backLabel.setPicture("wukong5");
				timer.setDelay(80);
				break;
			case 4:
				backLabel.setPicture("wukong6");
				break;
			case 5:
				backLabel.setPicture("wukong7");
				break;
			case 6:
				AbstractFileUtility fileUtility=new FileUtility();
				String uid = fileUtility.initUser();
				LocalMainFrame.main(uid);
				timer.stop();
				dispose();
			}
			i = i+1;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LocalMapSpecial();
	}

}
