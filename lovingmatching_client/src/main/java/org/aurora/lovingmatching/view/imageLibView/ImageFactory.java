package org.aurora.lovingmatching.view.imageLibView;

import java.util.ArrayList;

import javax.swing.ImageIcon;


/**
 * @Description 图片集合
 * @author m2o2o2d
 * 2014年3月22日上午11:35:05
 */

public class ImageFactory {
	
	private String p;//图片文件夹路径
	private String f;//图片格式
	
	public ImageFactory() {
		p = new Paths().getCompPath();
		f = ".png";
	}
	
	public ImageIcon getIcon(String num) {//获取按钮图标
		p = new Paths().getCompPath();
		return new ImageIcon(p+num+f);
	}
	
	public ImageIcon getImage(String num) {//获取背景图片
		p = new Paths().getBackPath();
		return new ImageIcon(p+num+f);
	}
	
	public ImageIcon getSpecial(String num) {//获取特效图片
		p = new Paths().getSpecialPath();
		return new ImageIcon(p+num+".gif");
	}
	
	public ImageIcon[] getImageList() {
		p = new Paths().getBackPath();
		ImageIcon icon1 = new ImageIcon(p+"t-1"+f);
		ImageIcon icon2 = new ImageIcon(p+"t-2"+f);
		ImageIcon icon3 = new ImageIcon(p+"t-3"+f);
		ImageIcon icon4 = new ImageIcon(p+"t-4"+f);
		ImageIcon icon5 = new ImageIcon(p+"t-5"+f);
		ImageIcon icon6 = new ImageIcon(p+"t-6"+f);
		ImageIcon icon7 = new ImageIcon(p+"t-7"+f);
		ImageIcon icon8 = new ImageIcon(p+"t-8"+f);
		ImageIcon[]  list = {icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8};		
		return list;
	}
	
}
