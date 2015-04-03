package org.aurora.lovingmatching.view.matchView;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.aurora.lovingmatching.model.shareModel.matchModel.Algorithm;
import org.aurora.lovingmatching.view.imageLibView.Paths;

/**
 * 宠物类
 * 主要是将此label上的显示为宠物图片
 * @author 天
 *
 */
public class PetLabel extends JLabel{

	private static final long serialVersionUID = 2L;
	int no; // 该宠物的编号
	static int preNo = -1000; // 鼠标选中的之前一个宠物的编号
	static PetLabel prePet = null;
	int cpreNo = -100;        //作为preNo副本，实现对preNo异步操作
	PetLabel cprePet = null;
	public boolean isMove = false;  //指示当前宠物是否移动，如果在移动则禁止拖动他
	public int type;                   //----宠物类型
	boolean isToolPet =false;  //是否是道具宠物
	
	public PetLabel(int type, int no) {
		setOpaque(false);
		int i = type%10;
		this.type = i;
		
		ImageIcon ii=new ImageIcon(Paths.getPetPath()+type+".gif");
	
		setIcon(ii);
		
		this.no = no;
		this.setBounds(no % 10 * 50, no / 10 * 50, 50, 50);

		MouseAct m = new MouseAct();
		this.addMouseListener(m);
		this.addMouseMotionListener(m);
		
	
	}
	
	/**
	 * 设置此宠物是否为道具宠物，ture表示是宠物道具
	 * @param isTool
	 */
	public void setToolPet(boolean isTool){
		isToolPet = isTool;
	}
	
	public boolean isToolPet(){
		return isToolPet;
	}

	public  void changePet(int p){
		
		ImageIcon ii=new ImageIcon("50x\\"+p+".gif");
		setIcon(ii);
		this.type = p;
		repaint();
	}
	class MouseAct implements MouseListener, MouseMotionListener {

		Point point = new Point(0, 0);
		boolean move = false;        //表示鼠标拖动时，宠物是否动
		boolean clicked = false;    //防止宠物移动时，再次单击
		/**
		 * 添加单击效果以及与周边相邻选中的宠物交换，进而消除
		 */
		public void mouseClicked(MouseEvent e) {
			//双击
			if(e.getClickCount()==2){
				//判断是否是道具
				if(isToolPet){
					new Thread() {
						public void run() {
							Algorithm.toolARemove(no);
						}
					}.start();
					
				}
				else if(type==8){
					new Thread() {
						public void run() {
							Algorithm.toolBRemove(no);
						}
					}.start();
				}
				else
					return;
			}
			System.out.println("cliced"+" no="+no+" type="+type);
			if(clicked||isMove){
				System.out.println("true"+" clicked"+clicked+" isMove"+isMove);
				return;
			}
			// 取消上次选择的边框
			if (preNo >= 0) {
				PlayPanel.removeBoder(preNo);
			}
			
			// 添加此次选中的宠物边框
			setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
			final int diff = no - preNo;
			if (diff == 1 || diff == -1 || diff == 10 || diff == -10) { // 存在周边相邻选中的宠物
				clicked = true;
				cpreNo = preNo;
				preNo = -100;
				isMove = true;
				PlayPanel.getPetLabel(cpreNo).isMove = true;
				new Thread() {
					public void run() {
						switchPositionAndRem(); // -----------交换两宠物的位置并判断是否可以消除并消除
					}
				}.start();
				setBorder(null);
			} else {
				preNo = no;
			}

		}

		/**
		 * 交换两宠物的位置并判断是否可以消除 如果能消除则消除计分
		 * @return 
		 */
		private  void switchPositionAndRem() {
			
				switchPet();
			
			if(!Algorithm.judgeAndRemmve(no, cpreNo)){    //如果不存在消除，将宠物交换回来
				switchPet();
			}
			synchronized(this){
			   clicked = false;
			   PlayPanel.getPetLabel(cpreNo).isMove = false;
			   isMove = false;
			}
		}

		/**
		 * 交换宠物
		 * @param diff交换的方向
		 */
		void switchPet(){
			int x1 = no % 10 * 50;
			int y1 = no / 10 * 50;
			int x2 = cpreNo % 10 * 50;
			int y2 = cpreNo / 10 * 50;
			int dx = 0;
			int dy = 0;
			int diff = no - cpreNo;
			switch (diff) {
			case -1:
				dx = 5;
				break;
			case 1:
				dx = -5;
				break;
			case 10:
				dy = -5;
				break;
			case -10:
				dy = 5;
				break;
			}
			PetLabel prePet = PlayPanel.getPetLabel(cpreNo); // 得到要交换宠物的对象

			for (int i = 1; i <= 5; i++) {

				//setLocation(x1 + dx * i, y1 + dy * i);
				//prePet.setLocation(x2 - dx * i, y2 - dy * i);
				setLocation(getLocation().x+2*dx,getLocation().y+2*dy);
				prePet.setLocation(prePet.getLocation().x-2*dx,prePet.getLocation().y-2*dy);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			PlayPanel.switchPets(no, cpreNo); // 将两个宠物交换
			cpreNo = cpreNo+diff;
		}
		public void mousePressed(MouseEvent e) {
			JLabel l = (JLabel) e.getSource();
			point = SwingUtilities.convertPoint(l, e.getPoint(), l.getParent());
			mouseClicked(e);
		}

		public  void mouseReleased(MouseEvent e) {
			move = false;
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	  public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		// 拖动鼠标实现宠物交换
		public void mouseDragged(MouseEvent e) {
			if(move||clicked||isMove){
				return;
			}
			move =true;
			final PetLabel l = (PetLabel) e.getSource();
			Point newPoint = SwingUtilities.convertPoint(l, e.getPoint(),
					l.getParent());
			//判断拖动的方向
			int x=newPoint.x - point.x;
			int y = newPoint.y - point.y;
			if(x==0&&y==0){
				return;
			}
			else if(x==0){
				if(y>0){
					cpreNo = l.no +10;
				}
				else{
					cpreNo = l.no - 10;
				}
			}
			double t = ((double) (y))
					/ (x);
			if((t>1||t<-1)){
				if(y>0){
				   cpreNo = l.no + 10;
				}
				else{
					cpreNo = l.no -10;
				}
			}
			else{
				if(x>0){
					cpreNo = l.no + 1;
				}
				else{
					cpreNo = l.no-1;
				}
			}
			//此方向无宠物
			if(cpreNo<0||cpreNo>88||cpreNo%10>8){
				return;
			}
			//如果要移动方向那个宠物正在移动，则不做出里
			if(PlayPanel.getPetLabel(cpreNo).isMove){
				return;
			}
			preNo = -100;
			PlayPanel.getPetLabel(cpreNo).isMove = true;
			isMove = true;
			new Thread() {
				public void run() {
					switchPositionAndRem(); // -----------交换两宠物的位置并判断是否可以消除并消除
				}
			}.start();
			setBorder(null);
			
		}

		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}


	}


}
