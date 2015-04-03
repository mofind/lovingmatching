package org.aurora.lovingmatching.model.shareModel.matchModel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/**
 * 计时类
 * @author 天
 *
 */
public class TimeRecorder extends TimerTask{

	int time = 60;   //一局的时间数
	Timer timer;

	public TimeRecorder(){
		timer = new Timer();
	    timer.schedule(this, 0, 1000);
	}

	public void run() {
		time--;
		//调用显示函数
		System.out.println("---------------------------------");
		System.out.println("------------------"+time+"--------------");
		System.out.println("---------------------------------");
		if(time==0){
			this.cancel();
		
		}
	}
	
	public void setTime(int t){
		time =t;
	}
	public int getTime(){
		return time;
	}
}

