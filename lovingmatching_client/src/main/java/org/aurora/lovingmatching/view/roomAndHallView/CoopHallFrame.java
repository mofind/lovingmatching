package org.aurora.lovingmatching.view.roomAndHallView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.APanel;
import org.aurora.lovingmatching.view.compLibView.RoomInfo;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.NetMainFrame;

/**
 * @Description 协作版游戏大厅
 * @author m2o2o2d
 * 2014年5月13日上午9:45:31
 */
public class CoopHallFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel returnLabel;//返回按钮
	private ALabel leftLabel;
	private ALabel rightLabel;
	private ALabel magnifierLabel;//放大镜
	
	private int page;//当前房间页数，第一页记为0
	private int maxPage;//最大房间页数
	private ArrayList<RoomInfo> roomList;//已开放房间列表
	private RoomPanel roomPanel1;
	private RoomPanel roomPanel2;
	private RoomPanel roomPanel3;
	private RoomPanel roomPanel4;
	private RoomPanel roomPanel5;
	private RoomPanel roomPanel6;
	private RoomPanel room1;
	
	public CoopHallFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"7",1,0);
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
		/*UI-左右按钮*/
		leftLabel = new ALabel(580, 508, "11",0,1);
		rightLabel = new ALabel(673,510,"12",0,1);
		leftLabel.getLabel().addMouseListener(new LeftMosListener());
		rightLabel.getLabel().addMouseListener(new RightMosListener());
		backPanel.add(leftLabel.getLabel());
		backPanel.add(rightLabel.getLabel());
		/*UI-放大镜按钮*/
		magnifierLabel = new ALabel(220, 500, "14",0,1);
		backPanel.add(magnifierLabel.getLabel());
		/*UI-第一页*/
		roomList = new ArrayList<RoomInfo>();
		page = 0;
		int x=80;int y=120;
		int a = 260;int b =180;
		roomPanel1 = new RoomPanel(false,x,y);
		roomPanel2 = new RoomPanel(false,x+a,y);
		roomPanel3 = new RoomPanel(false,x+2*a,y);
		roomPanel4 = new RoomPanel(false,x,y+b);
		roomPanel5 = new RoomPanel(false,x+a,y+b);
		roomPanel6 = new RoomPanel(false,x+2*a,y+b);
		roomPanel6.addMouseListener(new RoomMosListener(roomPanel6));
		backPanel.add(roomPanel1);
		backPanel.add(roomPanel2);
		backPanel.add(roomPanel3);
		backPanel.add(roomPanel4);
		backPanel.add(roomPanel5);
		backPanel.add(roomPanel6);
		roomList.add(new RoomInfo("001", "决战紫禁之巅", "1_2"));
		roomList.add(new RoomInfo("001", "决战紫禁之巅", "1_2"));
		roomList.add(new RoomInfo("001", "决战紫禁之巅", "1_2"));
		roomList.add(new RoomInfo("001", "决战紫禁之巅", "1_2"));
		roomList.add(new RoomInfo("001", "决战紫禁之巅", "1_2"));
		roomList.add(new RoomInfo("001", "决战紫禁之巅", "1_2"));
		roomList.add(new RoomInfo("001", "决战紫禁之巅", "1_2"));
		countMaxPage();
		refresh();
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
			NetMainFrame.main(null);
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
	
	/*事件-左按钮*/
	class LeftMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if(page>0) {
				page = page-1;
				refresh();
				repaint();
			}
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
	
	/*事件-右按钮*/
	class RightMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if(page<maxPage-1) {
				page = page + 1;
				refresh();
			}
			else {
				System.out.println("已到最后一页！");
			}
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
	
	/*函数-填充房间信息*/
	public void refresh() {
		int index = page*6;//当前页第一个房间对应的列表索引
		int size = roomList.size();
		/*if(roomList.size()<=(index+5)) {
			int a = index+5-roomList.size();
			for(int i=0;i<=a;i++) {
				roomList.add(new RoomInfo("null", "",""));
			}
		}*/
		roomPanel1.setRoomInfo(roomList.get(index));
		roomPanel2.closeRoom();
		roomPanel3.closeRoom();
		roomPanel4.closeRoom();
		roomPanel5.closeRoom();
		roomPanel6.closeRoom();
		if(index+1<size) {
			roomPanel2.setRoomInfo(roomList.get(index+1));
			if(index+2<size) {
				roomPanel3.setRoomInfo(roomList.get(index+2));
				if(index+3<size) {
					roomPanel4.setRoomInfo(roomList.get(index+3));
					if(index+4<size) {
						roomPanel5.setRoomInfo(roomList.get(index+4));
						if(index+5<size) {
							roomPanel6.setRoomInfo(roomList.get(index+5));
						}
					}
				}
			}
		}
		repaint();
	}
	
	/*事件-点击房间*/
	class RoomMosListener implements MouseListener {

		private RoomPanel room;
		public RoomMosListener(RoomPanel room) {
			// TODO Auto-generated constructor stub
			this.room = room;
		}
		
		public void mouseClicked(MouseEvent e) {
			if(room.isOpen()) {//房间已开放
				//进入房间
			}
			else {//房间未开放??????
				NewRoom newRoom = new NewRoom();
				roomList = newRoom.getInfo(roomList);
				countMaxPage();
				refresh();
				}
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
	
	/*函数-计算最大页数*/
	public void countMaxPage() {
		maxPage = roomList.size()/6;
		if(roomList.size()%6!=0) {
			maxPage = maxPage +1;
		}
	}
	
	/*函数-房间号加1*/
	public String roomNum(String num) {
		int i =Integer.parseInt(num)+1;
		String str = null;
		if(i<10) {
			str = "00"+String.valueOf(i);
		}
		else if(9<i&i<100) {
			str = "0"+String.valueOf(i);
		}
		else if(99<i&i<1000) {
			str = String.valueOf(i);
		}
		return str;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CoopHallFrame();
		
	}

}
