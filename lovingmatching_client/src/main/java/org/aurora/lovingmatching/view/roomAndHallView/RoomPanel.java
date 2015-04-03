package org.aurora.lovingmatching.view.roomAndHallView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.aurora.lovingmatching.view.compLibView.AFont;
import org.aurora.lovingmatching.view.compLibView.RoomInfo;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;

/**
 * @Description 房间面板
 * @author m2o2o2d
 * 2014年5月16日上午1:43:58
 */
public class RoomPanel extends JPanel{
	
	private ImageFactory imageFactory;
	private ImageIcon icon;
	private Image image;
	private String num;//房间号
	private String name;//房间名
	private String people;//人数
	private boolean isOpen;//是否开放
	private JLabel numLabel;
	private JLabel nameLabel;
	private JLabel peoLabel;
	
	public RoomPanel(Boolean isOpen,int x,int y) {
		this.isOpen = isOpen;
		imageFactory = new ImageFactory();
		icon = imageFactory.getImage("9");
		image = icon.getImage();
		setBounds(x, y, icon.getIconWidth(),icon.getIconHeight());
		setLayout(null);
		setOpaque(false);
	}
	
	/*设置房间号、房间名、人数*/
	public void setRoom(String num,String name,String people) {
		isOpen = true;
		
		icon = imageFactory.getImage("8");
		image = icon.getImage();
		
		numLabel = new JLabel(imageFactory.getIcon(num));
		numLabel.setBounds(15,10,70,50);
		
		nameLabel = new JLabel(name);
		nameLabel.setBounds(100, 16, 100, 30);
		nameLabel.setFont(new AFont().getFont(2));
		nameLabel.setForeground(Color.yellow);
		nameLabel.setBackground(Color.black);
		
		peoLabel = new JLabel(imageFactory.getIcon(people));
		peoLabel.setBounds(110,55,100,100);
		
		this.add(numLabel);
		this.add(nameLabel);
		this.add(peoLabel);
	}
	
	/*根据RoomInfo设置房间信息*/
	public void setRoomInfo(RoomInfo info) {
		if(info.getNum()!="null") {
			setRoom(info.getNum(),info.getName(),info.getPeople());
		}
		else {
			closeRoom();
		}
	}
	
	/*关闭房间*/
	public void closeRoom() {
		icon = imageFactory.getImage("9");
		image = icon.getImage();
		removeAll();
		isOpen = false;
	}
	
	/*Getter&Setter*/
	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		RoomPanel rPanel = new RoomPanel(true,0,0);
		rPanel.setRoom("001", "决战紫禁之巅", "1_2");
		frame.add(rPanel);	
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	

	
}
