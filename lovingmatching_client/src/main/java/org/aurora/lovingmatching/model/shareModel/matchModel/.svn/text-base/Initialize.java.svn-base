package org.aurora.lovingmatching.model.shareModel.matchModel;

import org.aurora.lovingmatching.view.matchView.PetLabel;
import org.aurora.lovingmatching.view.matchView.PlayPanel;

/**
 *该类主要用于初始化消除界面
 * @author 天
 *
 */
public class Initialize {

	/**
	 * ��Ϸ������ĳ�ʼ��������ÿ��λ�ó��������
	 * 
	 * @param pets
	 */
	public static void init(PetLabel[][] pets, PlayPanel p) {
		// TODO Auto-generated method stub
		int[][] initPo = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				initPo[i][j] = -1;
			}
		}
		

		int[] oneP = getRemoveblePosition();
		System.out.println("initP: ");
		int type = (int) (Math.random() * 7)+1;
		for(int i=0;i<3;i++){
			initPo[oneP[i]/10][oneP[i]%10] = type;
		}
		System.out.println("initP: ");
		for(int i=0;i<5;i++){
			System.out.println("initP:pppp ");
			int t = (int) (Math.random() * 7)+1;
			int[] oP = getRemoveblePosition();
			int loop=0;
			
			for(int j=0;j<3;j++){
				
				if(initPo[oP[j]/10][oP[j]%10] !=-1){
					break;
				}
				initPo[oP[j]/10][oP[j]%10] = t;
				
				if(isRemoveble(oP[j], initPo)){
					for(int k=0;k<=j;k++){
						initPo[oP[j]/10][oP[j]%10] = -1;
					}
					t=(t+1)%8;
					loop++;
					if(loop>=8){
						initPo[oP[j]/10][oP[j]%10] = -1;
						break;
					}
					if(t==0){
						t++;
					}
				   j=-1;	

				}
			}
		}
		System.out.println("afterP:pppp ");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(initPo[i][j]==-1){
					int t =  (int) (Math.random() * 7)+1;
					do{
						initPo[i][j] = t;
						t=t%7+1;
					}while(isRemoveble(i*10+j, initPo));
				}
			}
		}
		Algorithm.playPanel = p;
		AlgorithmLeft.playPanel = p;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				pets[i][j] = new PetLabel(initPo[i][j], i * 10 + j);
			}
		}
		//System.out.println("initNumRemo="+removebleNum(initPo));
		
	}
	

	public static boolean isRemoveble(int p,int[][] ps){
		int v1 = 0; // no1��ֱ������ͬ�ĸ���
		int tv1 = 0; // no1�Ϸ�������no1����ͬ�ĸ���
		int h1 = 0;
		int rh1 = 0;
		// �����ֱ������ͬ�ĸ���
		for (int i = 1;true; i++) {
			if (((p + i * 10 > 88) || (ps[p/10][p%10]!=ps[(p+i*10)/10][(p+i*10)%10]))) {
				tv1 = i;
				break;
			}
		}
		for (int i = 1; true; i++) {
			if ( (p - i * 10 < 0) || (ps[p/10][p%10]!=ps[(p-i*10)/10][(p-i*10)%10])) {
				v1 = i + tv1 - 1;
				break;
			}
			
		}
		// ���ˮƽ������ͬ�ĸ���
		for (int i = 1; true; i++) {
			if (((p + i) % 10 > 8) || (ps[p/10][p%10]!=ps[(p+i)/10][(p+i)%10])) {
				rh1 = i;
				break;
			}
		}
		
		for (int i = 1; true; i++) {
			if (((p - i) / 10 < p / 10 || (p - i) < 0) || (ps[p/10][p%10]!=ps[(p-i)/10][(p-i)%10])) {
				h1 = i + rh1 - 1;
				break;
			}
		}
		if (v1 > 2 || h1 > 2 ) {
			return true;
		}

		return false;
	}

	/**
	 * �����ɿ��������λ��
	 * 
	 * @return ���λ�õ����
	 */
	public static int[] getRemoveblePosition() {
		int[] position = new int[3];
		position[0] = (int) (Math.random() * 9) + ((int) (Math.random() * 9))
				* 10;
		// position[1] = (int) (Math.random() * 9)+((int)(Math.random()*9))*10;
		do {
			position[2] = (int) (Math.random() * 9)
					+ ((int) (Math.random() * 9)) * 10;
		} while (position[2] == position[0]);
		do {
			int diff = position[0] - position[2];
			System.out.println("position[0]="+position[0]+" position[2]="+position[2]);
			if (diff == 1 || diff == -1) {
				position[1] = position[0] + diff * 2;
				if (position[1] < 0 || (position[1]%10 ==9)
						|| (position[1] / 10 != position[2] / 10)) {
					position[1] = position[0] - diff * 3;
				}
				break;
			} else if (diff == 10 || diff == -10) {
				position[1] = position[0] + diff * 2;
				if (position[1] < 0 || position[1] > 88) {
					position[1] = position[0] - diff * 3;
				}
				break;
			} else if (diff == 20 || diff == -20) {
				position[1] = (position[0] + position[2]) / 2 + 1;
				if (position[1] % 10 == 9) {
					position[1] = position[1] - 2;
				}
				break;
			} else if (diff == 2 || diff == -2) {
				position[1] = (position[0] + position[2]) / 2 + 10;
				if(position[1]%10==9){
					position[2] = position[0] + diff*9;
					if(position[2]<0){
						position[2]+=10;
					}
					else if(position[2]>88){
						position[2]-=10;
					}
					continue;
				}
				if (position[1] >88) {
					position[1] = position[1] - 20;
				}
				break;
			} else if (diff == 9 || diff == -9 || diff == 11 || diff == -11) {
				int sign = diff / Math.abs(diff);
				position[1] = position[0] + sign * 10;
				if (position[1] < 0 || position[1] > 88) {
					position[1] = position[2] - sign * 10;
				}
				break;
			} else {
				System.out.println(diff);
				int sign = diff / Math.abs(diff);
				diff = Math.abs(diff) - 1;
				do {
					position[2] = position[0] - sign
							* ((int)( Math.random() * diff) + 1);
				} while (position[2] % 10 == 9);
			}
		} while (true);
		return position;
	}


}
