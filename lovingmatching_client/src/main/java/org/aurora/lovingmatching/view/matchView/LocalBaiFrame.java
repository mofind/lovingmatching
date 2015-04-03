package org.aurora.lovingmatching.view.matchView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;
import org.aurora.lovingmatching.view.matchView.CoopFrame.StartMosListener;
import org.aurora.lovingmatching.view.matchView.CoopFrame.StopMosListener;
import org.aurora.lovingmatching.view.passView.SingleCountFrame;
import org.aurora.lovingmatching.view.propView.ChoosePropFrame;
import org.aurora.lovingmatching.view.specialEffects.soundEffects.sound;

/**
 * @Description 单机游戏界面：白骨岭
 * @author m2o2o2d
 * 2014年5月10日下午6:53:09
 */
public class LocalBaiFrame extends JFrame{

	/*UI*/
	private JFrame jFrame;
	private ImageFactory image;
	private JPanel backPanel;
	private ALabel backLabel;
	private CardLayout cardlayout;
	private JPanel contain;
	private ALabel exitLabel;
	private ALabel returnLabel;
	private Timer timer;
	private ALabel timeLabel;
	private int width;
	private int widthini;
	private int height;
	private int a;
	private int i;
	private ALabel stopLabel;//暂停按钮
	private ALabel startLabel;//开始按钮
	private ALabel musicLabel;//音乐按钮
	private ALabel silenceLabel;//静音按钮
	private ALabel lianjiLabel;//连击数
	/*音乐*/
	private sound sound;
	/*逻辑*/
	private PlayPanel playPanel;
	private ALabel gradeLabel;//分数
	private String uid;//用户ID
	
	public LocalBaiFrame(String uid) {
		/*UI-frame背景*/
		jFrame = this;
		setSize(912,650);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel  = new ALabel(0, 0, "baigu",1,0);
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
		/*UI-时间条*/
		timer = new Timer(250,new TimerListener());
		timeLabel = new ALabel(245,588,"baiguTime",1,0);
		backPanel.add(timeLabel.getLabel());
		width = timeLabel.getLabel().getWidth();
		widthini = width;
		height = timeLabel.getLabel().getHeight();
		a = 1;i = 1;//a是时间条每次减少的长度
		timer.start();
		/*UI-暂停按钮*/
		int x=620;int y=230;
		stopLabel = new ALabel(x, y, "stop",0,1);
		stopLabel.getLabel().addMouseListener(new StopMosListener());
		backPanel.add(stopLabel.getLabel());
		/*UI-开始按钮*/
		startLabel = new ALabel(x, y, "start",0,1);
		startLabel.getLabel().addMouseListener(new StartMosListener());
		startLabel.getLabel().setVisible(false);
		backPanel.add(startLabel.getLabel());
		/*UI-音乐按钮*/
		int x1= x+100;
		musicLabel = new ALabel(x1,y,"music",0,1);
		musicLabel.getLabel().addMouseListener(new MusicMosListener());
		backPanel.add(musicLabel.getLabel());
		/*UI-静音按钮*/
		silenceLabel = new ALabel(x1, y, "silence", 0,1);
		silenceLabel.getLabel().addMouseListener(new SilenceMosListener());
		silenceLabel.getLabel().setVisible(false);
		backPanel.add(silenceLabel.getLabel());
		/*UI-连击数*/
		lianjiLabel = new ALabel(545, 320, "lianji4",1,0);
		backPanel.add(lianjiLabel.getLabel());
		/*音乐*/
		sound = new sound();
		sound.playBGM("game");
		/*逻辑-分数*/
		gradeLabel = new ALabel(620, 150, 150, 50, "125000");
		backPanel.add(gradeLabel.getLabel());
		this.uid = uid;
		/*逻辑-加入消除面板*/
		//69,110
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
	
	/*事件-时间条*/
	class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if( i<241) {
				timeLabel.getLabel().setSize(width,height);
				width = width-a;
				System.out.println("@width="+width);
				i = i+1;
				if(i>=50) {
					a=2;
				}
			}
			else {
				timer.stop();
				TimeOutFrame.main(jFrame);
				sound.playBGM("gameOver");
				sound.stopBGM();
			}
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
	
	/*事件-音乐按钮*/
	class MusicMosListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			sound.stopBGM();
			musicLabel.getLabel().setVisible(false);
			silenceLabel.getLabel().setVisible(true);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-静音按钮*/
	class SilenceMosListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			sound.playBGM("game");
			silenceLabel.getLabel().setVisible(false);
			musicLabel.getLabel().setVisible(true);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	public static void main(String uid) {
		// TODO Auto-generated method stub
		new LocalBaiFrame(uid);
	}

}
