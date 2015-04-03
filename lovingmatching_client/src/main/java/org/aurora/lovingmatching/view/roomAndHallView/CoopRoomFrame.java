package org.aurora.lovingmatching.view.roomAndHallView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.AScrollPane;
import org.aurora.lovingmatching.view.compLibView.ATable;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.matchView.CoopFrame;
import org.aurora.lovingmatching.view.propView.ChoosePropFrame;
import org.aurora.lovingmatching.view.roomAndHallView.FightRoomFrame.ChooseMosListener;
import org.aurora.lovingmatching.view.roomAndHallView.FightRoomFrame.ExitMosListener;
import org.aurora.lovingmatching.view.roomAndHallView.FightRoomFrame.ReadyMosListener;
import org.aurora.lovingmatching.view.roomAndHallView.FightRoomFrame.ReturnMosListener;

/**
 * @Description 协作版房间
 * @author m2o2o2d
 * 2014年5月16日上午1:33:15
 */
public class CoopRoomFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel outRoomLabel;//退出房间按钮
	private ALabel chooseLabel;//选择装备按钮
	private ALabel readyLabel;//准备按钮
	private AScrollPane scrollPane;
	private ATable table;//玩家列表
	ExitRoomMosListener exitRoomMosListener;
	ChooseMosListener chooseMosListener;
	
	public CoopRoomFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"22",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(836, 63,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-退出房间按钮*/
		int x = 220;int a = 160;int y = 510;
		outRoomLabel = new ALabel(x, y, "19",0,1);
		exitRoomMosListener = new ExitRoomMosListener();
		outRoomLabel.getLabel().addMouseListener(exitRoomMosListener);
		backPanel.add(outRoomLabel.getLabel());
		/*UI-选择装备按钮*/
		chooseLabel = new ALabel(x+a, y, "20",0,1);
		chooseMosListener = new ChooseMosListener();
		chooseLabel.getLabel().addMouseListener(chooseMosListener);
		backPanel.add(chooseLabel.getLabel());
		/*UI-准备按钮*/
		readyLabel = new ALabel(x+2*a, y, "21",0,1);
		readyLabel.getLabel().addMouseListener(new ReadyMosListener());
		backPanel.add(readyLabel.getLabel());
		/*UI-玩家列表*/
		scrollPane = new AScrollPane(140, 180, 640, 300);
		String[][] c = {{"1","2","3"},{"1","2","3"},{"1","2","3"},{"1","2","3"},{"1","2","3"}};
		String[] h  = {"1","2","3"};
		table = new ATable(c,h);
		scrollPane.getScrollPane().setViewportView(table.getTable());
		backPanel.add(scrollPane.getScrollPane());
		
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

	
	/*事件-退出房间按钮*/
	class ExitRoomMosListener implements MouseListener {
		
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
	
	/*事件-选择道具按钮*/
	class ChooseMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			ChoosePropFrame.main(null);
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
	
	/*事件-准备好了按钮*/
	class ReadyMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			/*outRoomLabel.removeLabelMouseListener();
			outRoomLabel.getLabel().removeMouseListener(exitRoomMosListener);
			outRoomLabel.setImage("19-3");*/
			chooseLabel.removeLabelMouseListener();
			chooseLabel.getLabel().removeMouseListener(chooseMosListener);
			chooseLabel.setImage("20-3");
			//CoopFrame.main(null);
			//dispose();
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
		new CoopRoomFrame();
	}

}
