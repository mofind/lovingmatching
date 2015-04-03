package org.aurora.lovingmatching.view.matchView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.aurora.lovingmatching.model.shareModel.matchModel.Algorithm;
import org.aurora.lovingmatching.model.shareModel.matchModel.Initialize;
import org.aurora.lovingmatching.model.shareModel.matchModel.TimeRecorder;


/**
 * 消除的面板
 * 负责添加81个宠物，以及对宠物进行替换和消除
 * @author 天
 *
 */
public class PlayPanel extends JPanel{


	private static final long serialVersionUID = 1L;
	TimeRecorder time;   //计时
	
	public static PetLabel pets[ ][ ] = new PetLabel[9][9];   //界面上的各种宠物集合 
	static int[][] ps = new int[9][9];
	public PlayPanel(){
		setBounds(69, 110, 450, 450);
		//this.setPreferredSize(new Dimension(450,450));
		this.setLayout(null);
		//setBackground(Color.BLACK);
		setOpaque(false);
		init();
		//time = new TimeRecorder();
	}
	/**.
	 * 初始化界面
	 */
	private void init() {
		Initialize.init(pets,this);
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				add(pets[i][j]);
				}
		}	
	}
	/**
	 * 获取游戏剩余时间
	 * @return
	 */
	public int getTime(){
		return time.getTime();
	}
	/**
	 * 取消相关宠物选中状态，即取消宠物边框
	 */
	public static void removeBoder(int no){
		pets[no/10][no%10].setBorder(null);
	}
	
	/**
	 * 返回no编号的宠物
	 * @param no宠物编号
	 * @return
	 */
	public static PetLabel getPetLabel(int no){
		return pets[no/10][no%10];
	}

	/**
	 * 将对一个编号的宠物交换
	 * @param no1
	 * @param no2
	 */
	public static void switchPets(int no1, int no2) {
		PetLabel p = pets[no1/10][no1%10];
		int j = pets[no1/10][no1%10].no;
		pets[no1/10][no1%10].no = pets[no2/10][no2%10].no;
		pets[no2/10][no2%10].no = j;
		pets[no1/10][no1%10] = pets[no2/10][no2%10];
		pets[no2/10][no2%10] = p;
		
	}
	
	/**
	 * 消除和填补
	 * @param h1 要消除水平方向的第一编号
	 * @param h2要消除水平方向的最后一编号
	 * @param v1要消除垂直方向的第一编号
	 * @param v2要消除垂直方向的最后一编号
	 */
	public  void removeAndFill(int[][] p,int[] tool1,int[] tool2){
		removePets(p);
		fillAndDropPets(p,tool1,tool2);
		//只有水平方向的消除
		/*if(v1<0){
			int y = h1/10;
			int x1 = h1%10;
			int x2 = h2%10 +1;
			for(int x =x1;x<x2;x++){
				pets[y][x].setEnabled(false);
			}
			hFillPets(y,x1,x2);
		}*/
	}
	
	
	/**
	 * 横向消除
	 * @param p
	 */
	public  void removeAndFillL(int[][] p){
		removePets(p);
		fillAndDropPetsL(p);
		//只有水平方向的消除
		/*if(v1<0){
			int y = h1/10;
			int x1 = h1%10;
			int x2 = h2%10 +1;
			for(int x =x1;x<x2;x++){
				pets[y][x].setEnabled(false);
			}
			hFillPets(y,x1,x2);
		}*/
	}
	/**
	 * 将宠物落下，并填充
	 * @param p
	 */
	private  void fillAndDropPets(int[][] p,int[] tool1,int[] tool2) {
		boolean isTool = false;      //记录是否有道具形成
		//抹掉要消除的宠物
		System.out.println("-------------------------");
		for(int x=0;x<p.length;x++){
			for(int i=0;i<p[x][1];i++){
				this.remove(pets[p[x][0]/10+i][p[x][0]%10]);
				System.out.println("x="+x+" i="+i);
			//this.add(new PetLabel(8,p[x][0]+10*i));
				//pets[p[x][0]/10+i][p[x][0]%10].changePet(8);
			}
		}
		
		//判断是否形成道具,如果形成道具则换成道具图片
		if(tool1!=null&&tool1[1]>0){
			pets[tool1[0]/10][tool1[0]%10] = new PetLabel(tool1[1],tool1[0]);
			pets[tool1[0]/10][tool1[0]%10].setToolPet(true);
			this.add(pets[tool1[0]/10][tool1[0]%10]);
			for(int i=0;i<p.length;i++){
				if(tool1[0]%10==p[i][0]%10){
					p[i][1] -= 1;
					isTool = true;
					pets[p[i][0]/10][p[i][0]%10] = pets[tool1[0]/10][tool1[0]%10];
					p[i][0] +=10;
					break;
				}
			}
		}
		if(tool2!=null&&tool2[1]>0){
			pets[tool2[0]/10][tool2[0]%10] = new PetLabel(tool2[1],tool2[0]);
			pets[tool2[0]/10][tool2[0]%10].setToolPet(true);
			this.add(pets[tool2[0]/10][tool2[0]%10]);
			for(int i=0;i<p.length;i++){
				if(tool2[0]%10==p[i][0]%10){
					p[i][1] -= 1;
					isTool = true;
					pets[p[i][0]/10][p[i][0]%10] = pets[tool2[0]/10][tool2[0]%10];
					p[i][0] +=10;
					break;
				}
			}
		}
		//道具A形成的爆炸
		if(p[0].length>2){
			for(int i=0;i<p.length;i++){
				for(int j=0;j<9;j++){
					if(p[i][j+2]==1){
						p[i][1] -= 1;
						pets[p[i][0]/10][p[i][0]%10] = pets[j][p[i][0]%10];
						this.add(pets[p[i][0]/10][p[i][0]%10]);
						p[i][0] +=10;
					}
				}
			}
		}
		repaint();
		

       for(int x=0;x<p.length;x++){
    	   for(int y=p[x][0]%10;y<p[x][0];y+=10){
    		   pets[y/10][y%10].no = pets[y/10+p[x][1]][y%10].no;
    		   pets[y/10][y%10].isMove = true;
    	   }
    	   for(int y=p[x][0];y>=10;y-=10){
    		   pets[y/10+(p[x][1]-1)][y%10] =pets[y/10-1][y%10];
    	   }
		}
       //补充宠物
       int[] remP=Algorithm.fillpets(p,isTool);
       
       int[][] copyP = new int[p.length][2];
       for(int i=0;i<p.length;i++){
    	   p[i][0] = p[i][0]+(p[i][1]-1)*10;
    	   copyP[i][0] = p[i][0];
    	   copyP[i][1] = p[i][1];
       }
		boolean t = true;
		int sleep = 0;
		while(t){
			t =false;
			sleep += 5;
		for(int i = 1;i<=2;i++){
			for(int x=0;x<p.length;x++){
				if(p[x][1]>0){
					t = true;
				for(int y=p[x][0];y>=0;y-=10){
					if((int)pets[y/10][y%10].getLocation().getY()==y/10*50)
						continue;
					pets[y/10][y%10].setLocation(pets[y/10][y%10].getLocation().x,pets[y/10][y%10].getLocation().y+25);
				}
				}
		    }
	try {
		Thread.sleep(50-sleep);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
		for(int x=0;x<p.length;x++){
			p[x][1] -=1;
		}
	}
		for(int x=0;x<p.length;x++){
			for(int y=p[x][0];y>=0;y-=10){
				pets[y/10][y%10].isMove=false;
			
			}
	    }
		if(remP!=null){
			System.out.println("remp.Play="+remP.length);
			for(int i=0;i<remP.length;i++){
				if(remP[i]!=-1){
					Algorithm.EveryJudgeAndRemmve(remP[i]);
				}
			}
		}
		//递归判断落下的宠物是否还会形成消除的情况
		for(int i=copyP[0][0];i>=(copyP[0][1])*10;i-=10){
			boolean bo = Algorithm.EveryJudgeAndRemmve(i);
			System.out.println("i="+i+" bo="+bo);
		}
		if(copyP.length!=1){
			for(int i=copyP[copyP.length-1][0];i>=copyP[copyP.length-1][1]*10;i-=10){
				boolean bo = Algorithm.EveryJudgeAndRemmve(i);
				System.out.println("i="+i+" bo="+bo);
			}
			for(int i=1;i<copyP.length-1;i++){
				boolean bo = Algorithm.EveryJudgeAndRemmve(copyP[i][0]);
				System.out.println("i="+i+" bo="+bo);
			}
		}
	
	}

	private static void removePets(int[][] p) {
		// TODO Auto-generated method stub
		
	}

	public static void hFillPets(int y,int x1,int x2){
		for(int i = 1;i<=10;i++){
					for(int yi=0;yi<y;yi++){
						for(int xj=x1;xj<x2;xj++){
							pets[yi][xj].setLocation(xj*50,yi*50+i*5);
						}
				}			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		for(int yi=y;yi>0;yi--){
			for(int xj=x1;xj<x2;xj++){
				pets[yi][xj] = pets [yi-1][xj];
				pets[yi][xj].no = pets[yi][xj].no +10;
				
			}
		}
	}
	
	
	/**
	 * 将宠物从左边落下，并填充
	 * @param p
	 */
	private  void fillAndDropPetsL(int[][] p) {
		
		for(int x=0;x<p.length;x++){
			for(int i=0;i<p[x][1];i++){
			this.remove(pets[p[x][0]/10][p[x][0]%10+i]);
			}
		}
		repaint();
       for(int x=0;x<p.length;x++){
    	   for(int y=0;y<p[x][0]%10;y+=1){
    		   pets[p[x][0]/10][y].no = pets[p[x][0]/10][y+p[x][1]].no;
    		   pets[p[x][0]/10][y].isMove = true;
    	   }
    	   for(int y=p[x][0]%10;y>=1;y-=1){
    		   pets[p[x][0]/10][y-1+p[x][1]] =pets[p[x][0]/10][y-1];
    	   }
		}
      int[] remP= Algorithm.fillpetsL(p);
       int[][] copyP = new int[p.length][2];
       for(int i=0;i<p.length;i++){
    	   p[i][0] = p[i][0]+(p[i][1]-1);
    	   copyP[i][0] = p[i][0];
    	   copyP[i][1] = p[i][1];
       }
		boolean t = true;
		int sleep = 0;
		while(t){
			t =false;
			sleep+=5;
		for(int i = 1;i<=2;i++){
			for(int x=0;x<p.length;x++){
				if(p[x][1]>0){
					t = true;
				for(int y=p[x][0]%10;y>=0;y-=1){
					pets[p[x][0]/10][y].setLocation(pets[p[x][0]/10][y].getLocation().x+25,pets[p[x][0]/10][y].getLocation().y);
				}
				}
		    }
	try {
		Thread.sleep(200-sleep);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
		for(int x=0;x<p.length;x++){
			p[x][1] -=1;
		}
	}
		for(int x=0;x<p.length;x++){
			for(int y=p[x][0]%10;y>=0;y-=1){
				pets[p[x][0]/10][y].isMove=false;
			
			}
	    }
		if(remP!=null){
			System.out.println("remp.Play="+remP.length);
			for(int i=0;i<remP.length;i++){
				if(remP[i]!=-1){
					Algorithm.EveryJudgeAndRemmveL(remP[i]);
				}
			}
		}
		for(int i=copyP[0][0];i>copyP[0][0]/10*10+copyP[0][1]-1;i--){
			boolean bo = Algorithm.EveryJudgeAndRemmveL(i);
			System.out.println("i="+i+" bo="+bo);
		}
		if(copyP.length!=1){
			for(int i=copyP[copyP.length-1][0];i>copyP[copyP.length-1][0]/10*10+copyP[copyP.length-1][1]-1;i--){
				boolean bo = Algorithm.EveryJudgeAndRemmveL(i);
				System.out.println("i="+i+" bo="+bo);
			}
			for(int i=1;i<copyP.length-1;i++){
				boolean bo = Algorithm.EveryJudgeAndRemmveL(copyP[i][0]);
				System.out.println("i="+i+" bo="+bo);
			}
		}
		
	}


}
