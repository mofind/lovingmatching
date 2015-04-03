package org.aurora.lovingmatching.view.compLibView;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.aurora.lovingmatching.view.imageLibView.ImageFactory;

/**
 * @Description 按钮组件
 * @author m2o2o2d
 * 2014年3月22日上午11:26:44
 */

public class AButton {
	
	private ImageFactory  image;
	private JButton button;
	private int x;//组件横坐标
	private int y;//组件纵坐标
	private int cenx;//原按钮中心x
	private int ceny;//原按钮中心y
	private String content;//按钮内容
	private ImageIcon icon;//图标
	private AFont font;
	
	/*横坐标，纵坐标，图片*/
	public AButton(int x,int y,ImageIcon i) {
		this.x = x;
		this.y = y;
		icon = i;
		cenx = x+icon.getIconWidth()/2;
		ceny = y+icon.getIconHeight()/2;
		button = new JButton(icon);
		button.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
		button.setContentAreaFilled(false);//按钮设置透明
		image = new ImageFactory();
	}
	
	/*横坐标，纵坐标，长，高，文本*/
	public AButton(int x,int y,int w,int h,String content) {
		this.x = x;
		this.y = y;
		this.content = content;
		button = new JButton(content);
		font = new AFont();
		button.setFont(font.getFont(1));
		button.setBackground(Color.orange);
		button.setBounds(x,y,w,h);
	}
	
	/*重设图片*/
	public void setImage(String num) {
		icon = image.getIcon(num);
		button.setIcon(icon);
		x = cenx -  icon.getIconWidth()/2;
		//y = cenx - icon.getIconHeight()/2;
		button.setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
	}
	
	public JButton getButton() {//获取按钮
		return button;
	}

}