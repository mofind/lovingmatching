package org.aurora.lovingmatching.view.compLibView;

import java.awt.Font;

/**
 * @Description字体
 * @author m2o2o2d
 * 2014年4月15日下午5:52:17
 */
public class AFont {
	
	private Font font;
	
	 public Font getFont(int index) {
		 choose(index);
		 return font;
	 }
	 
	 void choose(int index) {
		switch(index) {
		case 0:font0();break;
		case 1:font1();break;
		case 2:font2();break;
		case 3:font3();break;
		case 4:font4();break;
		}
	}
	 
	 /*单机玩家档案*/
	 void font0() {
		 font = new Font("迷你简胖娃",Font.BOLD,26);
	 }
	 
	 void font1() {
		 font = new Font("微软雅黑",Font.PLAIN,22);
	 }
	 
	/*房间名字*/
	 void font2() {
		 font = new Font("微软雅黑",Font.PLAIN,14);
	 }
	 
	 /*我方得分*/
	 void font3() {
		 font = new Font("迷你简华隶",Font.PLAIN,28);
	 }
	 
	 /*对手得分*/
	 void font4() {
		 font = new Font("迷你简华隶",Font.PLAIN,22);
	 }
	 
}
