package org.aurora.lovingmatching.view.mainView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.WatchEvent.Modifier;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.controller.netController.AbstractNetController;
import org.aurora.lovingmatching.controller.netController.NetController;
import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.APanel;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame.ExitMosListener;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame.ReturnMosListener;
import org.aurora.lovingmatching.view.roomAndHallView.CoopHallFrame;

/**
 * @Description 网络模式主页面
 * @author m2o2o2d
 * 2014年5月15日下午6:56:51
 */
public class NetMainFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel returnLabel;//返回按钮
	private CardLayout cardlayout;
	private APanel contain;
	private ALabel perInfoLabel;//个人信息按钮
	private ALabel paihangLabel;//排行榜按钮
	private ALabel guizeLabel;//游戏规则按钮
	private ALabel coopLabel;//协作模式按钮
	private ALabel fightLabel;//对战模式按钮
	private APanel perInfoPanel;//----------------------------------个人信息面板
	private ALabel modifyInfoLabel;//修改个人信息按钮
	private ALabel dayTimesLabel;//每日局数曲线按钮
	private ALabel avgDayLabel;//每日平均得分曲线按钮
	private ALabel avgTimeLabel;//每局平均得分曲线
	private ALabel totalLabel;//总记录按钮
	private APanel perContain;//-----------个人信息卡式布局
	private APanel modifyPanel;//修改个人信息面板
	private APanel dayTimesPanel;//每日局数曲线面板
	private APanel avgDayPanel;//每日平均得分曲线面板
	private APanel avgTimePanel;//每局平均得分曲线面板
	private APanel totalPanel;//总记录面板
	private APanel paihangPanel;//----------------------------------排行榜面板
	private ALabel totalTimesLabel;//总局数按钮
	private ALabel avgScoreLabel;//平均得分按钮
	private ALabel lianjiLabel;//最高连击数按钮
	private ALabel highScoreLabel;//最高得分按钮
	private APanel paiContain;//-----------排行榜卡式布局
	private APanel totalTimesPanel;//总局数面板
	private APanel avgScorePanel;//平均得分面板
	private APanel lianjiPanel;//最高连击数面板
	private APanel highScorePanel;//最高得分面板
	private APanel guizePanel;//----------------------------------游戏规则面板
	/*逻辑*/
	private AbstractNetController  abstractNetController;
	
	
	
	public NetMainFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"20",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(836, 63,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-返回按钮*/
		returnLabel = new ALabel(800,63,"4",0,1);
		returnLabel.getLabel().addMouseListener(new ReturnMosListener());
		backPanel.add(returnLabel.getLabel());
		/*UI-个人信息按钮*/
		int y=240;int a=60;
		perInfoLabel = new ALabel(670, y+a, "28",0,1);
		perInfoLabel.getLabel().addMouseListener(new PerInfoMosListener());
		backPanel.add(perInfoLabel.getLabel());
		/*UI-排行榜按钮*/
		paihangLabel = new ALabel(670, y+2*a, "29",0,1);
		paihangLabel.getLabel().addMouseListener(new PaihangMosListener());
		backPanel.add(paihangLabel.getLabel());
		/*UI-游戏规则按钮*/
		guizeLabel = new ALabel(670, y+3*a, "30",0,1);
		guizeLabel.getLabel().addMouseListener(new GuizeMosListener());
		backPanel.add(guizeLabel.getLabel());
		/*UI-协作模式按钮*/
		coopLabel = new ALabel(670, y+4*a, "31",0,1);
		coopLabel.getLabel().addMouseListener(new CoopMosListener());
		backPanel.add(coopLabel.getLabel());
		/*UI-对战模式按钮*/
		fightLabel = new ALabel(670, y+5*a, "32",0,1);
		fightLabel.getLabel().addMouseListener(new FightMosListener());
		backPanel.add(fightLabel.getLabel());
		setVisible(true);
		/*UI-卡式布局*/
		cardlayout = new CardLayout();
		contain = new APanel(90,120,540,460);
		contain.setLayout(cardlayout);
		backPanel.add(contain);
		/*UI-------------------------------------------------------------------------个人信息面板*/
		perInfoPanel = new APanel(0,0,"21");
		contain.add(perInfoPanel,"per");
		/*UI-修改个人信息按钮*/
	    int x1 = 20;int y1=170; int a1=55;
		modifyInfoLabel = new ALabel(x1, y1, "33",0,1);
		modifyInfoLabel.getLabel().addMouseListener(new ModifyMosListener());
		perInfoPanel.add(modifyInfoLabel.getLabel());
		/*UI-每日局数曲线按钮*/
		dayTimesLabel = new ALabel(x1, y1+a1, "34",0,1);
		dayTimesLabel.getLabel().addMouseListener(new DayTimesMosListener());
		perInfoPanel.add(dayTimesLabel.getLabel());
		/*UI-每日平均得分按钮*/
		avgDayLabel = new ALabel(x1, y1+2*a1, "35",0,1);
		avgDayLabel.getLabel().addMouseListener(new AvgDayMosListener());
		perInfoPanel.add(avgDayLabel.getLabel());
		/*UI-每局得分曲线按钮*/
		avgTimeLabel = new ALabel(x1, y1+3*a1, "36",0,1);
		avgTimeLabel.getLabel().addMouseListener(new AvgTimeMosListener());
		perInfoPanel.add(avgTimeLabel.getLabel());
		/*UI-其他数据记录按钮*/
		totalLabel = new ALabel(x1, y1+4*a1, "37",0,1);
		totalLabel.getLabel().addMouseListener(new TotalMosListener());
		perInfoPanel.add(totalLabel.getLabel());
		/*UI-----------------------------------个人信息卡式布局*/
		perContain = new APanel(150,170,370,270);
		perContain.setLayout(cardlayout);
		perInfoPanel.add(perContain);
		/*UI-修改个人信息面板*/
		modifyPanel = new APanel(0, 0, "");
		perContain.add(modifyPanel,"perInfo");
		/*UI-每日局数曲线面板*/
		dayTimesPanel = new APanel(0, 0, "");
		perContain.add(dayTimesPanel,"dayTimes");
		/*UI-每日平均得分面板*/
		avgDayPanel = new APanel(0, 0, "");
		perContain.add(avgDayPanel,"avgDay");
		/*UI-每局平均得分面板*/
		avgTimePanel = new APanel(0, 0, "");
		perContain.add(avgTimePanel,"avgTime");
		/*UI-总记录面板*/
		totalPanel = new APanel(0, 0, "");
		perContain.add(totalPanel,"total");
		/*UI-------------------------------------------------------------------------排行榜面板*/
		paihangPanel = new APanel(0,0,540,460);
		contain.add(paihangPanel,"paihang");
		/*UI-总局数按钮*/
		int x2 = 20;int y2 = 20;int a2 = 130;
		totalTimesLabel = new ALabel(x2, y2, "38",0,1);
		totalTimesLabel.getLabel().addMouseListener(new TotalTimesMosListener());
		paihangPanel.add(totalTimesLabel.getLabel());
		/*UI-平均得分按钮*/
		avgScoreLabel = new ALabel(x2+a2,y2,"39",0,1);
		avgScoreLabel.getLabel().addMouseListener(new AvgScoreMosListener());
		paihangPanel.add(avgScoreLabel.getLabel());
		/*UI-最高连击数按钮*/
		lianjiLabel = new ALabel(x2+2*a2,y2,"40",0,1);
		lianjiLabel.getLabel().addMouseListener(new LianjiMosListener());
		paihangPanel.add(lianjiLabel.getLabel());
		/*UI-最高得分按钮*/
		highScoreLabel = new ALabel(x2+3*a2, y2, "41",0,1);
		highScoreLabel.getLabel().addMouseListener(new HighScoreMosListener());
		paihangPanel.add(highScoreLabel.getLabel());
		/*UI-----------------------------------排行版卡式布局*/
		paiContain = new APanel(150,170,370,270);
		paiContain.setLayout(cardlayout);
		paihangPanel.add(paiContain);
		/*UI-总局数面板*/
		totalTimesPanel = new APanel(0, 0, "");
		paiContain.add(totalTimesPanel,"totalTimes");
		/*UI-平均得分面板*/
		avgScorePanel = new APanel(0, 0, "");
		paiContain.add(avgScorePanel,"avg");
		/*UI-最高连击数面板*/
		lianjiPanel = new APanel(0, 0, "");
		paiContain.add(lianjiPanel,"lianji");
		/*UI-最高得分面板*/
		highScorePanel = new APanel(0, 0, "");
		paiContain.add(highScorePanel,"highScore");
		/*UI-------------------------------------------------------------------------游戏规则面板*/
		guizePanel = new APanel(0,0,540,460);
		contain.add(guizePanel,"guize");
		
		cardlayout.show(contain, "per");
		/*逻辑*/
		abstractNetController = new NetController();
		
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
			abstractNetController.closeNetwork();
			dispose();
			StartFrame.main(null);
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
	
	/*事件-个人信息按钮*/
	class PerInfoMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "per");
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
	
	/*事件-排行榜按钮*/
	class PaihangMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "paihang");
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
	
	/*事件-游戏规则按钮*/
	class GuizeMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "guize");
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
	
	/*事件-协作模式按钮*/
	class CoopMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			CoopHallFrame.main(null);
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
	
	/*事件-对战模式按钮*/
	class FightMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			
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
	
	/*事件-个人信息面板：修改个人信息*/
	class ModifyMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(perContain, "perInfo");
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
	
	/*事件-个人信息面板：每日局数曲线信息*/
	class DayTimesMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(perContain, "dayTimes");
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
	
	/*事件-个人信息面板：每日平均得分信息*/
	class AvgDayMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(perContain, "avgDay");
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
	
	/*事件-个人信息面板：每局平均得分信息*/
	class AvgTimeMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(perContain, "avgTime");
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
	
	/*事件-个人信息面板：总记录信息*/
	class TotalMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(perContain, "total");
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
	
	/*事件-排行榜面板：总局数按钮*/
	class TotalTimesMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(paiContain, "totalTimes");
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
	
	/*事件-排行榜面板：平均得分按钮*/
	class AvgScoreMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			cardlayout.show(paiContain, "avg");
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
	
	/*事件-排行榜面板：最高连击数按钮*/
	class LianjiMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			cardlayout.show(paiContain, "lianji");
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
	
	/*事件-排行榜面板：最高得分按钮*/
	class HighScoreMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			cardlayout.show(paiContain, "highScore");
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
		new NetMainFrame();
	}

}
