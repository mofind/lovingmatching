package org.aurora.lovingmatching.model.shareModel.matchModel;

import org.aurora.lovingmatching.view.matchView.PetLabel;
import org.aurora.lovingmatching.view.matchView.PlayPanel;

/**
 * 左边补充的消除算法
 * @author 天
 *
 */
public class AlgorithmLeft {
	public static PlayPanel playPanel;
	
	/**
	 * �жϳ���p�Ƿ��γ��������������������������γ�
	 * ��������
	 * @param p�����λ��
	 * @return �Ƿ��γ��������γɷ���true
	 */
	public static boolean EveryJudgeAndRemmveL(int p) {
		int v1 = 0; // no1��ֱ������ͬ�ĸ���
		int tv1 = 0; // no1�Ϸ�������no1����ͬ�ĸ�
		int h1 = 0;
		int rh1 = 0;
		// �����ֱ������ͬ�ĸ���
		for (int i = 1;true; i++) {
			if ((p + i * 10 > 88) || (PlayPanel.pets[p/10][p%10].type!=PlayPanel.pets[(p+i*10)/10][(p+i*10)%10].type)) {
				tv1 = i;
				break;
			}
		}
		for (int i = 1; true; i++) {
			if ( (p - i * 10 < 0) || (PlayPanel.pets[p/10][p%10].type!=PlayPanel.pets[(p-i*10)/10][(p-i*10)%10].type)) {
				v1 = i + tv1 - 1;
				break;
			}
			
		}
		// ���ˮƽ������ͬ�ĸ���
		for (int i = 1; true; i++) {
			if (((p + i) % 10 > 8) || (PlayPanel.pets[p/10][p%10].type!=PlayPanel.pets[(p+i)/10][(p+i)%10].type)) {
				rh1 = i;
				break;
			}
		}
		
		for (int i = 1; true; i++) {
			if (((p - i) / 10 < p / 10 || (p - i) < 0) || (PlayPanel.pets[p/10][p%10].type!=PlayPanel.pets[(p-i)/10][(p-i)%10].type)) {
				h1 = i + rh1 - 1;
				break;
			}
		}
		if (!(v1 > 2 || h1 > 2) ) {
			return false;
		}
		tv1 = v1 - tv1 + 1;
		// �˴������жϵ��ߵ���ɺͷ�����ɹ���

		int[][] p1 = generateRemBorderL(p, h1, rh1, v1, tv1);
		int ii=0;
		for( ii=0;ii<9&&p1[ii][0]!=-1;ii++);
		int[][] p2 = new int[ii][2];
		for(int j=0;j<ii;j++){
			p2[j][0] = p1[j][0];
			p2[j][1] = p1[j][1];
 		}
		//int[][] p2 = generateRemBorderL(no2, h2, rh2, v2, tv2);
		System.out.println("no1=" + p + " h1=" + h1 + " rh1=" + rh1 + " v1="
				+ v1 + " tv1=" + tv1);
		System.out.println("p2:");
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < p2.length; i++) {
				System.out.print(p2[i][j] + " ");
			}
			System.out.println();
		}
		playPanel.removeAndFillL(p2);
		return true;
	}

	
	/**
	 * ���no1λ���γɵ����������ı߽�
	 * @param no1
	 * @param h1
	 * @param rh1
	 * @param v1
	 * @param tv1
	 * @return
	 */
	private static int[][] generateRemBorderL(int no1, int h1, int rh1, int v1,
			int tv1) {
		int[][] p = new int[9][2];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 2; j++) {
				p[i][j] = -1;
			}
		}

		if (v1 > 2) {
			for (int i = 0; i < v1; i++) {
				p[i][0] = no1 - (tv1-1 -i)*10;
				p[i][1] = 1;
			}
		}
		if (h1 > 2) {
			if (p[0][0] == -1) {
				p[0][0] = no1 -(h1-rh1);
				p[0][1] = h1;
			} else {
				for (int i = 0; i < 9; i++) {
					if (p[i][0] == no1) {
						p[i][0] = no1 - (h1-rh1);
						p[i][1] = h1;
						break;
					}
				}
			}
		}
		return p;
	}
	
	/**
	 * ���ƶ�����������Բ�������߽����Ϊһ��
	 * 
	 * @param p1
	 * @param p2
	 * @return
	 */
	private static int[][] manageBordersL(int[][] p1, int[][] p2) {
		// TODO Auto-generated method stub
		int i = 0;
		int k = 0;
		int jj = 0;
		for (; jj < 9 && p2[jj][0] != -1; jj++)
			;
		for (; i < 9 && p1[i][0] != -1; i++) {
			for (int j = 0; j < 9 && p2[j][1] != -1; j++) {
				if (p1[i][0] / 10 == p2[j][0] / 10) {
					if (p1[i][0] %10 == p2[j][0] % 10) {
						k++;
						continue;
					}
					p1[i][1] = p1[i][1] + p2[j][1];
					p1[i][0] = p1[i][0] < p2[j][0] ? p1[i][0] : p2[j][0];
					p2[j][0] = -1;
					k++;
					break;
				}
			}
		}
		int[][] p = new int[i + jj - k][2];
		for (int m = 0; m < i; m++) {
			p[m][0] = p1[m][0];
			p[m][1] = p1[m][1];
		}
		int l = 0;
		for (int m = 0; m < jj - k; m++) {
			for (int n = l; n < 5; n++)
				if (p2[n][0] != -1) {
					p[m + i][0] = p2[n][0];
					p[m + i][1] = p2[n][1];
					l = n + 1;
					break;
				}
		}
		return p;
	}
	/**
	 * ���������ĳ���
	 * @param p���ı߽�
	 * @return�����γ�������������ش�ʱ����λ��
	 */
	public static int[] fillpetsL(int[][] p) {
		// TODO Auto-generated method stub
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i][1]; j++) {
				int t = (int) (Math.random()*7+1);
				PlayPanel.pets[p[i][0] / 10][j] = new PetLabel(t  , j 
						+ (p[i][0] / 10)*10);
				PlayPanel.pets[p[i][0] / 10][j].setLocation(-( (p[i][1]-j)* 50),
						((p[i][0]/10) * 50));
				PlayPanel.pets[p[i][0] / 10][j].isMove = true;
				playPanel.add(PlayPanel.pets[p[i][0] / 10][j]);

			}
		}
		return null;
	}
	


}
