package org.aurora.lovingmatching.view.compLibView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.specialEffects.soundEffects.sound;


/**
 * @Description 标签组件
 * @author m2o2o2d
 * 2014年4月15日下午5:38:11
 */
public class ALabel {

	private ImageFactory  image;
	private JLabel label;
	private int x;//组件横坐标
	private int y;//组件纵坐标
	private int cenx;//原按钮中心x
	private int ceny;//原按钮中心y
	private String num;//图片编号
	private String content;//标签文字
	private ImageIcon icon;//图标
	private AFont font;
	private LabelMouseListener labelMouseListener;
	private boolean isListener;
	/*音乐*/
	private sound sound;
	
	/*横坐标，纵坐标，图片，图片类型，标签效果类型*/
	public ALabel(int x,int y,String num,int kind,int effect) {
		image = new ImageFactory();
		sound = new sound();
		this.x = x;
		this.y = y;
		this.num = num;
		switch (kind) {
		case 0://comp文件夹
			setButton();
			break;
		case 1://back文件夹
			setBack(num);
			break;
		case 2://special文件夹
			setSpecial();
			break;
		}
		switch (effect) {
		case 0://无效果
			break;
		case 1://放大-缩小
			labelMouseListener = new  LabelMouseListener();
			label.addMouseListener(labelMouseListener);
			isListener = true;
			break;
		case 2://
			break;
		default:
			break;
		}
	}
	
	/*横坐标，纵坐标，图片，按钮型*/
	public void setButton() {
		icon = image.getIcon(num);
		cenx = x+icon.getIconWidth()/2;
		ceny = y+icon.getIconHeight()/2;
		label = new JLabel(icon);
		label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
	}
	
	/*横坐标，纵坐标，图片，背景型*/
	public void setBack(String num) {
		icon = image.getImage(num);
		cenx = x+icon.getIconWidth()/2;
		ceny = y+icon.getIconHeight()/2;
		label = new JLabel(icon);
		label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
	}
	
	/*横坐标，纵坐标，图片，特效型*/
	public void setSpecial() {
		icon = image.getSpecial(num);
		cenx = x+icon.getIconWidth()/2;
		ceny = y+icon.getIconHeight()/2;
		label = new JLabel(icon);
		label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
	}
	
	/*横坐标，纵坐标，长，高，文本*/
	public ALabel(int x,int y,int w,int h,String content) {
		this.x = x;
		this.y = y;
		this.content = content;
		label = new JLabel(content);
		font = new AFont();
		label.setFont(font.getFont(0));
		label.setForeground(Color.white);
		label.setBounds(x, y, w, h);
		label.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	/*重设图标*/
	public void setImage(String num) {
		icon = image.getIcon(num);
		label.setIcon(icon);
		x = cenx -  icon.getIconWidth()/2;
		label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
	}
	
	/*重设背景*/
	public void setPicture(String num) {
		this.num = num;
		icon = image.getImage(num);
		label.setIcon(icon);
		x = cenx -  icon.getIconWidth()/2;
		label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
	}
	
	/*重设背景*/
	public void setPicture(ImageIcon c) {
		icon = c;
		label.setIcon(icon);
		x = cenx -  icon.getIconWidth()/2;
		label.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
	}
	
	/*获取标签*/
	public JLabel getLabel() {
		return label;
	}
	
	/*取消图片鼠标效果*/
	public void removeLabelMouseListener() {
		label.removeMouseListener(labelMouseListener);
		isListener = false;
	}
	
	/*恢复图片鼠标效果*/
	public void addLabelMouseListener() {
		if(!isListener) {
			label.addMouseListener(labelMouseListener);
			isListener = true;
		}
		setImage(num);
	}
	
	/*事件-图片鼠标效果*/
	class LabelMouseListener implements MouseListener,MouseMotionListener {

		public void mouseClicked(MouseEvent arg0) {
			sound.playSound("anjian");
		}

		public void mouseEntered(MouseEvent arg0) {
			sound.playSound("huaguo");
			setImage(num+"-1");
		}

		public void mouseExited(MouseEvent arg0) {
			sound.stopSound();
			setImage(num);
		}

		public void mousePressed(MouseEvent arg0) {
			setImage(num+"-2");
		}

		public void mouseReleased(MouseEvent arg0) {
			setImage(num);
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			
		}
		
	}
	
	/*事件-文本鼠标效果*/
	class LabelTextMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			
		}

		public void mouseEntered(MouseEvent arg0) {
			label.setForeground(Color.yellow);
		}

		public void mouseExited(MouseEvent arg0) {
			label.setForeground(Color.white);
		}

		public void mousePressed(MouseEvent arg0) {
			label.setForeground(Color.yellow);
		}

		public void mouseReleased(MouseEvent arg0) {
			label.setForeground(Color.white);
		}
		
	}
	
}