package org.aurora.lovingmatching.view.roomAndHallView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.accessibility.Accessible;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.APasswordField;
import org.aurora.lovingmatching.view.compLibView.ATextField;
import org.aurora.lovingmatching.view.compLibView.RoomInfo;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;

/**
 * @Description 创建房间
 * @author m2o2o2d
 * 2014年5月17日上午1:18:19
 */
public class NewRoom extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel peo1Label;//人数1按钮
	private ALabel peo2Label;//人数2按钮
	private ALabel peo3Label;//人数3按钮
	private ALabel peo4Label;//人数4按钮
	private ATextField nameTextField;//房间名输入框
	private APasswordField keyPassField;//密码输入框
	private ALabel sureLabel;//确认按钮
	
	/*Logic*/
	String nameString;
	String maxPeo;
	String password;
	boolean isSave;
	
	public NewRoom() {
		/*UI-frame背景*/
		setSize(491,315);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"23",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(440, 23,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-房间名输入框*/
		nameTextField = new ATextField(217,68, 160, 35);
		backPanel.add(nameTextField.getTextField());
		/*UI-密码输入框*/
		keyPassField = new APasswordField(170,124,207,35);
		
		backPanel.add(keyPassField);
		/*UI-人数2按钮*/
		int x = 290;int y=176;
		int a = 45;
		peo2Label = new ALabel(x,y, "43",0,1);
		peo2Label.getLabel().addMouseListener(new Peo2MosListener());
		backPanel.add(peo2Label.getLabel());
		/*UI-人数1按钮*/
		peo1Label = new ALabel(x-a,y, "47",0,1);
		peo1Label.getLabel().addMouseListener(new Peo1MosListener());
		backPanel.add(peo1Label.getLabel());
		/*UI-人数3按钮*/
		peo3Label = new ALabel(x+a,y, "44",0,1);
		peo3Label.getLabel().addMouseListener(new Peo3MosListener());
		backPanel.add(peo3Label.getLabel());
		/*UI-人数4按钮*/
		peo4Label = new ALabel(x+2*a,y-4, "45",0,1);
		peo4Label.getLabel().addMouseListener(new Peo4MosListener());
		backPanel.add(peo4Label.getLabel());
		/*UI-确认按钮*/
		sureLabel  = new ALabel(190, 218, "46",0,1);
		sureLabel.getLabel().addMouseListener(new SureMosListener());
		backPanel.add(sureLabel.getLabel());
		
		setVisible(true);
	}
	
	/*事件-退出按钮*/
	class ExitMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			isSave = false;
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
	
	/*事件-确认按钮*/
	class SureMosListener implements MouseListener {

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
	
	/*事件-人数2按钮*/
	class Peo2MosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			recover(2);
			maxPeo = "1_2";
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
	
	/*事件-人数1按钮*/
	class Peo1MosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			recover(1);
			maxPeo = "1_1";
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
	
	/*事件-人数3按钮*/
	class Peo3MosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			recover(3);
			maxPeo = "1_3";
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
	
	/*事件-人数4按钮*/
	class Peo4MosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			recover(4);
			maxPeo = "1_4";
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
	
	/*函数-人数按钮还原*/
	public void recover(int i) {
		switch (i) {
		case 1:
			peo2Label.addLabelMouseListener();
			peo3Label.addLabelMouseListener();
			peo4Label.addLabelMouseListener();
			peo1Label.removeLabelMouseListener();
			peo1Label.setImage("47-1");
			repaint();
			break;
		case 2:
			peo1Label.addLabelMouseListener();
			peo3Label.addLabelMouseListener();
			peo4Label.addLabelMouseListener();
			peo2Label.removeLabelMouseListener();
			peo2Label.setImage("43-1");
			repaint();
			break;
		case 3:
			peo1Label.addLabelMouseListener();
			peo2Label.addLabelMouseListener();
			peo4Label.addLabelMouseListener();
			peo3Label.removeLabelMouseListener();
			peo3Label.setImage("44-1");
			repaint();
			break;
		case 4:
			peo1Label.addLabelMouseListener();
			peo4Label.setImage("45-1");
			peo3Label.addLabelMouseListener();
			peo2Label.addLabelMouseListener();
			peo4Label.removeLabelMouseListener();
			repaint();
			break;
		}
	}
	
	/*事件-房间名输入框*/
	class NameTextField implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			nameString = nameTextField.getTextField().getText();
		}
		
	}
	
	/*事件-密码输入框*/
	class KeyPassField implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			password = new String(keyPassField.getPassword());
		}
		
	}
	
	/*函数-获取房间信息*/
	public  ArrayList<RoomInfo> getInfo(ArrayList<RoomInfo> roomList) {
		if(isSave) {
			RoomInfo roomInfo = new RoomInfo(roomNum(roomList.get(roomList.size()-1).getNum()), nameString, maxPeo);
			roomList.add(roomInfo);
		}
		return roomList;
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
	
	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		new NewRoom();
	}

}
