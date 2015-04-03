package org.aurora.lovingmatching.model.shareModel.matchModel;

import org.aurora.lovingmatching.view.matchView.PetLabel;
import org.aurora.lovingmatching.view.matchView.PlayPanel;


public class Algorithm {
	public static PlayPanel playPanel;


	
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
	 * �ж϶�Ӧ��ŵĳ����Ƿ��ܹ���� ����ܹ���������ȫС����
	 * 
	 * @param no1
	 *            �������ڱ�ŵĳ���
	 * @param no2
	 * @return����������true
	 */
	public static boolean judgeAndRemmve(int no1, int no2) {
		int v1 = 0; // no1��ֱ������ͬ�ĸ���
		int tv1 = 0; // no1�Ϸ�������no1����ͬ�ĸ���
		int h1 = 0;
		int rh1 = 0;
		int v2 = 0;
		int tv2 = 0;
		int h2 = 0; // no2ˮƽ������ͬ�ĸ���
		int rh2 = 0;
		// �����ֱ������ͬ�ĸ���
		boolean t1 = true;
		boolean t2 = true;
		for (int i = 1; t1 || t2; i++) {
			if (t1
					&& ((no1 + i * 10 > 88) || (!(PlayPanel.getPetLabel(no1).type == PlayPanel
							.getPetLabel(no1 + i * 10).type)))) {
				t1 = false;
				tv1 = i;
			}
			if (t2
					&& ((no2 + i * 10 > 88) || (!(PlayPanel.getPetLabel(no2).type == PlayPanel
							.getPetLabel(no2 + i * 10).type)))) {
				t2 = false;
				tv2 = i;
			}
		}

		t1 = t2 = true;
		for (int i = 1; t1 || t2; i++) {
			if (t1
					&& ((no1 - i * 10 < 0) || (!(PlayPanel.getPetLabel(no1).type == PlayPanel
							.getPetLabel(no1 - i * 10).type)))) {
				t1 = false;
				v1 = i + tv1 - 1;
			}
			if (t2
					&& ((no2 - i * 10 < 0) || (!(PlayPanel.getPetLabel(no2).type == PlayPanel
							.getPetLabel(no2 - i * 10).type)))) {
				t2 = false;
				v2 = i - 1 + tv2;
			}
		}
		// ���ˮƽ������ͬ�ĸ���
		t1 = t2 = true;
		for (int i = 1; t1 || t2; i++) {
			if (t1
					&& (((no1 + i) % 10 > 8) || (!(PlayPanel.getPetLabel(no1).type == PlayPanel
							.getPetLabel(no1 + i).type)))) {
				t1 = false;
				rh1 = i;
			}
			if (t2
					&& (((no2 + i) % 10 > 8) || (!(PlayPanel.getPetLabel(no2).type == PlayPanel
							.getPetLabel(no2 + i).type)))) {
				t2 = false;
				rh2 = i;
			}
		}
		t1 = t2 = true;
		for (int i = 1; t1 || t2; i++) {
			if (t1
					&& (((no1 - i) / 10 < no1 / 10 || (no1 - i) < 0) || (!(PlayPanel
							.getPetLabel(no1).type == PlayPanel.getPetLabel(no1
							- i).type)))) {
				t1 = false;
				h1 = i + rh1 - 1;
			}
			if (t2
					&& (((no2 - i) / 10 < no2 / 10 || (no2 - i) < 0) || (!(PlayPanel
							.getPetLabel(no2).type == PlayPanel.getPetLabel(no2
							- i).type)))) {
				t2 = false;
				h2 = i - 1 + rh2;
			}
		}
		if (!(v1 > 2 || h1 > 2 || v2 > 2 || h2 > 2)) {
			return false;
		}
		
		System.out.println("init panel:-----------------:");
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(PlayPanel.pets[i][j].type+" ");
			}
			System.out.println();
		}

		tv1 = v1 - tv1 + 1;
		tv2 = v2 - tv2 + 1;
		// �˴������жϵ��ߵ���ɺͷ�����ɹ���

		int[][] p1 = generateRemBorder(no1, h1, rh1, v1, tv1);
		int[][] p2 = generateRemBorder(no2, h2, rh2, v2, tv2);
		int p1Num = 0;   //��¼�γ����ĸ���
		int p2Num = 0;
		
		int maxNum1 =0; //��¼�л��������һ�����ĸ���
		int maxNum2 = 0;
		//�ֱ����no1��no2�γ����ĸ���
		int p1L = 0;   //记录p1长度
		int p2L = 0;
		for(;p1L<p1.length;p1L++){
			if(p1[p1L][1]>0){
				p1Num+=p1[p1L][1];
				maxNum1 = maxNum1>p1[p1L][1]?maxNum1:p1[p1L][1];
			}
			else{
			    break;
			}
		}
		for(;p2L<p2.length;p2L++){
			if(p2[p2L][1]>0){
				p2Num+=p2[p2L][1];
				maxNum2 = maxNum2>p2[p2L][1]?maxNum2:p2[p2L][1];
			}
			else{
				break;
			}
		}
		int[] tool1= new int[2];  //������ĵ���
		int[] tool2 = new int[2]; 
		//���������������Ӧ����
		if((p1L==3&&maxNum1==3)||(maxNum1==4&&p1L<3)||(p1L==4&&maxNum1<3)){
			tool1[0] = no1;
			tool1[1] = PlayPanel.getPetLabel(no1).type%10*11;
		}
		else if((p1L+maxNum1==7)||(maxNum1==5)||p1L==5){
			tool1[0] = no1;
			tool1[1] = 8;
		}
		
		if((p2L==3&&maxNum2==3)||(maxNum2==4&&p2L<3)||(p2L==4&&maxNum2<3)){
			tool2[0] = no2;
			tool2[1] = PlayPanel.getPetLabel(no2).type%10*11;
		}
		else if((p2L+maxNum2==7)||(maxNum2==5)||p2L==5){
			tool2[0] = no2;
			tool2[1] = 8;
		}
		for(int i=0;i<2;i++){
			System.out.println("tool1:"+tool1[0]+" "+tool1[1]);
			System.out.println("tool2:"+tool2[0]+" "+tool2[1]);
		}
		//��������̲���ķ���
				//int score1 = 0;
				int score = 0;
				score = getScore(p1Num)+getScore(p2Num);
				
		
		
		System.out.println("no1=" + no1 + " h1=" + h1 + " rh1=" + rh1 + " v1="
				+ v1 + " tv1=" + tv1);
		System.out.println("no2=" + no2 + " h2=" + h2 + " rh2=" + rh2 + " v2="
				+ v2 + " tv2=" + tv2);
		int[][] p12;   //���p1��p2��Ϻ�ĵ����
		if(p1[0][0]<0){
			int jj = 0;
			for (; jj < p2.length&& p2[jj][0] != -1; jj++)
				;
			p12 = new int[jj][2];
			for(int i=0;i<jj;i++){
				p12[i][0] = p2[i][0];
				p12[i][1] = p2[i][1];
			}
		}
		else if(p2[0][0]<0){
			int jj = 0;
			for (; jj < p1.length&& p1[jj][0] != -1; jj++)
				;
			p12 = new int[jj][2];
			for(int i=0;i<jj;i++){
				p12[i][0] = p1[i][0];
				p12[i][1] = p1[i][1];
			}
		}
		else{
		    p12 = manageBorders(p1, p2);
		}
		int[][] p = new int[p12.length][11];
		for(int i=0;i<p12.length;i++){
			p[i][0] = p12[i][0];
			p[i][1] = p12[i][1];
			for(int j=0;j<9;j++){
				p[i][2+j] = 0;
			}
		}
		
	    //int[] [] p = p12;    //���������������
		//�ж�������Ƿ���ڵ��߳���
A:    for(int i=0;i<p.length;i++){
			for(int j=0;j<p[i][1]; j++){
				if(p[i][p[i][0]/10+j+2]==1){
					continue;
				}
				//�Ƿ��ǵ���B
				if(PlayPanel.getPetLabel(p[i][0]+j*10).type == 8){
					score+=1000;
					PlayPanel.getPetLabel(p[i][0]+j*10).type=0;
					p = toolBAddBorder(p,i,j);
					i =-1;
					continue A;
				}
				//�Ƿ��ǵ���A
				if(PlayPanel.getPetLabel(p[i][0]+j*10).isToolPet()){
					score+=600;
					PlayPanel.getPetLabel(p[i][0]+j*10).setToolPet(false);
					p = addBorder(p,i,j);
					i =-1;
					continue A;
				}
			}
		}
		
		//��ʾ����
		System.out.println("score1="+score+" score2="+score);
		
		System.out.println("p1:");
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < p1.length; i++) {
				System.out.print(p1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("p2:");
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < p2.length; i++) {
				System.out.print(p2[i][j] + " ");
			}
			System.out.println();
		}

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < p.length; i++) {
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}
		//����
		/*TestToolAAddBorder test = new TestToolAAddBorder();
		p=test.testToolBAdd();
		int[] nn = {14,11};
		playPanel.removeAndFill(p,nn,null);*/
		//��
		playPanel.removeAndFill(p,tool1,tool2);
		return true;
	}

	/**
	 * ���������÷�
	 * @param p2Num���ĸ���
	 * @return�����÷�
	 */
	private static int getScore(int p2Num) {
		// TODO Auto-generated method stub
		return p2Num>2?(p2Num -2)*100:0;
	}

	/**
	 * ����border[po1]+10*po2λ��Ϊ���Ĵ�ֱ·��λ�ü���border��
	 * ���������B�漰���ĳ���
	 * @param border��������߽�
	 * @param po1 no��border�е�һά��ά��
	 * @param po2no��border�е�2ά��ά��
	 * @return
	 */
	public static int[][] toolBAddBorder(int[][] border,int po1,int po2){
		if (border.length < 9) {
			int[][] newBorder = new int[9][11];
			// �����������ӵ���
			for (int i = 0; i < border[0][0] % 10; i++) {
				newBorder[i][0] = (border[po1][0] / 10 + po2) * 10 + i;
				newBorder[i][1] = 1;
			}
			// ����Ҳ������ӵ���
			for (int i = border[border.length - 1][0] % 10 + 1; i < newBorder.length; i++) {
				newBorder[i][0] = (border[po1][0] / 10 + po2) * 10 + i;
				newBorder[i][1] = 1;
			}
			// ����غϵ���
			int start = border[0][0] % 10;
			for (int i = border[0][0] % 10; i <= border[border.length - 1][0] % 10; i++) {
				// ����B�Ĵ�ֱ·��
				if (i == po1 + start) {
					newBorder[i][0] = border[i - start][0] % 10;
					newBorder[i][1] = 9;
				} else {
					int addPo = (border[po1][0] / 10 + po2) * 10 + i; // Ҫ���ӵ�λ��
					// Ҫ���ӵ�λ������ԭ������
					if (border[i - start][0] <= addPo
							&& (border[i - start][0] + border[i - start][1]
									* 10 - 10 >= addPo)) {
						newBorder[i][0] = border[i - start][0];
						newBorder[i][1] = border[i - start][1];
						for (int j = 0; j < 9; j++) {
							newBorder[i][j + 2] = border[i - start][j + 2];
						}
						newBorder[i][addPo / 10 + 2] = 0;
					}
					// Ҫ���ӵ�λ����ԭ������֮��
					else if (addPo < border[i-start][0]) {
						newBorder[i][0] = addPo;
						newBorder[i][1] = (border[i - start][0] - addPo) / 10
								+ border[i - start][1];
						System.out.println("newBorder=" + newBorder[i][1]
								+ "border=" + newBorder[i][0]);
						for (int j = 0; j < 9; j++) {
							newBorder[i][j + 2] = border[i - start][j + 2];
						}
						for (int j = addPo / 10 + 1; j < border[i - start][0] / 10; j++) {
							newBorder[i][j + 2] = 1;
						}
					}
					// Ҫ���ӵ�λ����ԭ������֮��
					else {
						newBorder[i][0] = border[i - start][0];
						newBorder[i][1] = (addPo - border[i - start][0]) / 10 + 1;
						for (int j = 0; j < 9; j++) {
							newBorder[i][j + 2] = border[i - start][j + 2];
						}
						for (int j = border[i - start][0] / 10
								+ border[i - start][1]; j < addPo / 10; j++) {
							newBorder[i][j + 2] = 1;
						}
					}

				}
			}
			System.out.println("newBorder="+newBorder[1][1]+"  "+newBorder[1][0]);
			return newBorder;
		}
		//ԭ����ά������
		else{
			for(int i=0;i<border.length;i++){
				//����B�Ĵ�ֱ·��
				if(i==po1){
					border[i][0] = border[i][0]%10;
					border[i][1] = 9;
					for (int j = 0; j < 9; j++) {
						border[i][j + 2] = 0;
					}
				} else {
					int addPo = (border[po1][0] / 10 + po2) * 10 + i; // Ҫ���ӵ�λ��
					// Ҫ���ӵ�λ������ԭ������
					if (border[i][0] <= addPo
							&& (border[i][0] + border[i][1] * 10 - 10 >= addPo)) {
						border[i][addPo / 10 + 2] = 0;
					}
					// Ҫ���ӵ�λ����ԭ������֮��
					else if (addPo < border[i][0]) {
						
						for (int j = addPo / 10 + 1; j < border[i][0] / 10; j++) {
							border[i][j + 2] = 1;
						}
						
						border[i][1] = (border[i][0] - addPo) / 10
								+ border[i][1];
						border[i][0] = addPo;
					}
					// Ҫ���ӵ�λ����ԭ������֮��
					else {
						
						for (int j = border[i][0] / 10 + border[i][1]; j < addPo / 10; j++) {
							border[i][j + 2] = 1;
						}
						border[i][1] = (addPo - border[i][0]) / 10 + 1;
					}

				}
			}
			return border;
		}
	}
	/**
	 * ����border[po1]+10*po2λ��Ϊ���ĵ�9��λ�ü���border��
	 * ���������A�漰���ĳ���
	 * @param border��������߽�
	 * @param po1 no��border�е�һά��ά��
	 * @param po2no��border�е�2ά��ά��
	 * @return
	 */
	public static int[][] addBorder(int[][] border,int po1,int po2){
		int [][] p = new int[2][2];  //��¼Ҫ���ӵ���
		int index = 0;  //��¼���ӵ�����
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				p[i][j] = -1;
			}
		}
		int tmin=0;
		int tmax = 0;
		int tpo = border[po1][0]+po2*10;
		//�м�����
		if(tpo-10>=0){
			tmin = tpo-10;
		}
		else{
			tmin = tpo;
		}
		if(tpo+10<=88){
			tmax = tpo+10;
		}
		else{
			tmax = tpo;
		}
		if(tmin<border[po1][0]){
			border[po1][1]++;
			border[po1][0] = tmin;
		}
		else{
			border[po1][tmin/10+2] = 0;
		}
		if(tmax>border[po1][0]+border[po1][1]*10-10){
			border[po1][1]++;
		}
		else{
			border[po1][tmax/10+2] = 0;
		}
		//po1���γ����߽���м�
		if(0<po1&&po1<border.length-1){
			
			//�����������
			if(tpo-11>=0){
				tmin = tpo-11;
			}
			else{
				tmin = tpo-1;
			}
			if(tpo+9<=88){
				tmax = tpo+9;
			}
			else{
				tmax = tpo-1;
			}
			if ((border[po1-1][0] >= tmin && border[po1-1][0] <= tmax)
					|| ((border[po1-1][0] + border[po1-1][1]*10 - 10 >= tmin) &&( border[po1-1][0]
							+ border[po1-1][1]*10 - 10 <= tmax))) {
				
				int max =( border[po1-1][0] + border[po1-1][1]*10 - 10)<tmax?tmax:( border[po1-1][0] + border[po1-1][1]*10 - 10);
				border[po1-1][0] = border[po1-1][0]<tmin?border[po1-1][0]:tmin;
				border[po1-1][1] = (max - border[po1-1][0])/10 + 1;
				for(int i=tmin/10;i<=tmax/10;i++){
					border[po1-1][i+2] = 0;
				}
			}
			else if(border[po1-1][0] <=tmin&&(border[po1-1][0] + border[po1-1][1]*10 - 10 >= tmax)){
				for(int i=tmin/10;i<=tmax/10;i++){
					border[po1-1][i+2] = 0;
				}
			}
			else{
				if(border[po1-1][0]<tmin){
					for(int i=border[po1-1][0]/10+border[po1-1][1];i<tmin/10;i++){
						border[po1-1][i+2] = 1; 
					}
					border[po1-1][1] = (tmax-border[po1-1][0])/10+1;
				}
				else{
					for(int i=tmax/10+1;i<border[po1-1][0]/10;i++){
						border[po1-1][i+2] = 1;
					}
					border[po1-1][1] = (border[po1-1][0]+border[po1-1][1]*10-tmin)/10;
					border[po1-1][0] = tmin;
				}
				
			}
			
			//�ұ�����
			if(tpo-9>=0){
				tmin = tpo-9;
			}
			else{
				tmin = tpo+1;
			}
			if(tpo+11<=88){
				tmax = tpo+11;
			}
			else{
				tmax = tpo+1;
			}
			if ((border[po1+1][0] >= tmin && border[po1+1][0] <= tmax)
					|| ((border[po1+1][0] + border[po1+1][1]*10 - 10 >= tmin) &&( border[po1+1][0]
							+ border[po1+1][1]*10 - 10 <= tmax))) {
				
				int max =( border[po1+1][0] + border[po1+1][1]*10 - 10)<tmax?tmax:( border[po1+1][0] + border[po1+1][1]*10 - 10);
				border[po1+1][0] = border[po1+1][0]<tmin?border[po1+1][0]:tmin;
				border[po1+1][1] = (max - border[po1+1][0])/10 + 1;
				for(int i=tmin/10;i<=tmax/10;i++){
					border[po1+1][i+2] = 0;
				}
			}
			else if(border[po1+1][0] <=tmin&&(border[po1+1][0] + border[po1+1][1]*10 - 10 >= tmax)){
				for(int i=tmin/10;i<=tmax/10;i++){
					border[po1+1][i+2] = 0;
				}
			}
			else{
				if(border[po1+1][0]<tmin){
					for(int i=border[po1+1][0]/10+border[po1+1][1];i<tmin/10;i++){
						border[po1+1][i+2] = 1; 
					}
					border[po1+1][1] = (tmax-border[po1+1][0])/10+1;
				}
				else{
					for(int i=tmax/10+1;i<border[po1+1][0]/10;i++){
						border[po1+1][i+2] = 1;
					}
					border[po1+1][1] = (border[po1+1][0]+border[po1+1][1]*10-tmin)/10;
					border[po1+1][0] = tmin;
				}
				
			}
		}
		//�����߳��￿�����߽������,�Ҳ�����
		else if(po1==0&&border.length>=2){
			// �������
			if (tpo % 10 != 0) {
				if (tpo - 11 >= 0) {
					tmin = tpo - 11;
				} else {
					tmin = tpo - 1;
				}
				if (tpo + 9 <= 88) {
					tmax = tpo + 9;
				} else {
					tmax = tpo - 1;
				}
				p[0][0] = tmin;
				p[0][1] = (tmax - tmin) / 10 + 1;
				index++;
			}
			//�ұ�����
			if(tpo-9>=0){
				tmin = tpo-9;
			}
			else{
				tmin = tpo+1;
			}
			if(tpo+11<=88){
				tmax = tpo+11;
			}
			else{
				tmax =tpo+1;
			}
			if ((border[po1+1][0] >= tmin && border[po1+1][0] <= tmax)
					|| ((border[po1+1][0] + border[po1+1][1]*10 - 10 >= tmin) &&( border[po1+1][0]
							+ border[po1+1][1]*10 - 10 <= tmax))) {
				
				int max =( border[po1+1][0] + border[po1+1][1]*10 - 10)<tmax?tmax:( border[po1+1][0] + border[po1+1][1]*10 - 10);
				border[po1+1][0] = border[po1+1][0]<tmin?border[po1+1][0]:tmin;
				border[po1+1][1] = (max - border[po1+1][0])/10 + 1;
				for(int i=tmin/10;i<=tmax/10;i++){
					border[po1+1][i+2] = 0;
				}
			}
			else if(border[po1+1][0] <=tmin&&(border[po1+1][0] + border[po1+1][1]*10 - 10 >= tmax)){
				for(int i=tmin/10;i<=tmax/10;i++){
					border[po1+1][i+2] = 0;
				}
			}
			else{
				if(border[po1+1][0]<tmin){
					for(int i=border[po1+1][0]/10+border[po1+1][1];i<tmin/10;i++){
						border[po1+1][i+2] = 1; 
					}
					border[po1+1][1] = (tmax-border[po1+1][0])/10+1;
				}
				else{
					for(int i=tmax/10+1;i<border[po1+1][0]/10;i++){
						border[po1+1][i+2] = 1;
					}
					border[po1+1][1] = (border[po1+1][0]+border[po1+1][1]*10-tmin)/10;
					border[po1+1][0] = tmin;
				}
				
			}
		}
		//�����߳��￿�����߽����Ҳ�,�������
		else if((po1==border.length-1)&&border.length>=2){
			//�������
			if(tpo-11>=0){
				tmin = tpo-11;
			}
			else{
				tmin = tpo-1;
			}
			if(tpo+9<=88){
				tmax = tpo+9;
			}
			else{
				tmax = tpo-1;
			}
			if ((border[po1-1][0] >= tmin && border[po1-1][0] <= tmax)
					|| ((border[po1-1][0] + border[po1-1][1]*10 - 10 >= tmin) &&( border[po1-1][0]
							+ border[po1-1][1]*10 - 10 <= tmax))) {
				
				int max =( border[po1-1][0] + border[po1-1][1]*10 - 10)<tmax?tmax:( border[po1-1][0] + border[po1-1][1]*10 - 10);
				border[po1-1][0] = border[po1-1][0]<tmin?border[po1-1][0]:tmin;
				border[po1-1][1] = (max - border[po1-1][0])/10 + 1;
				for(int i=tmin/10;i<=tmax/10;i++){
					border[po1-1][i+2] = 0;
				}
			}
			else if(border[po1-1][0] <=tmin&&(border[po1-1][0] + border[po1-1][1]*10 - 10 >= tmax)){
				for(int i=tmin/10;i<=tmax/10;i++){
					border[po1-1][i+2] = 0;
				}
			}
			else{
				if(border[po1-1][0]<tmin){
					for(int i=border[po1-1][0]/10+border[po1-1][1];i<tmin/10;i++){
						border[po1-1][i+2] = 1; 
					}
					border[po1-1][1] = (tmax-border[po1-1][0])/10+1;
				}
				else{
					for(int i=tmax/10+1;i<border[po1-1][0]/10;i++){
						border[po1-1][i+2] = 1;
					}
					border[po1-1][1] = (border[po1-1][0]+border[po1-1][1]*10-tmin)/10;
					border[po1-1][0] = tmin;
				}
				
			}
			// �ұ�����
			if (tpo % 10 != 8) {
				if (tpo - 9 >= 0) {
					tmin = tpo - 9;
				} else {
					tmin = tpo + 1;
				}
				if (tpo + 11 <= 88) {
					tmax = tpo + 11;
				} else {
					tmax = tpo + 1;
				}
				p[1][0] = tmin;
				p[1][1] = (tmax - tmin) / 10 + 1;
				//p[index][2] = po1 - 1;
				index++;
			}
		}
		//borderֻ��һ��
		else{
			// �������
			if (tpo % 10 != 0) {
				if (tpo - 11 >= 0) {
					tmin = tpo - 11;
				} else {
					tmin = tpo - 1;
				}
				if (tpo + 9 <= 88) {
					tmax = tpo + 9;
				} else {
					tmax = tpo - 1;
				}
				p[0][0] = tmin;
				p[0][1] = (tmax - tmin) / 10 + 1;
				//p[0][2] = po1 - 1;
				index++;
			}
			// �ұ�����
			if (tpo % 10 != 8) {
				if (tpo - 9 >= 0) {
					tmin = tpo - 9;
				} else {
					tmin = tpo + 1;
				}
				if (tpo + 11 <= 88) {
					tmax = tpo + 11;
				} else {
					tmax = tpo + 1;
				}
				p[1][0] = tmin;
				p[1][1] = (tmax - tmin) / 10 + 1;
				//p[index][2] = po1 + 1;
				index++;
			}
		}
		if(index==0){
			System.out.println("toolA:");
			for(int i=0;i<border.length;i++){
				for(int j=0;j<11;j++){
					System.out.print(border[i][j]+" ");
				}
				System.out.println();
			}
			return border;
		}
		else{
			int k=0;
			int[][] newBorder = new int[border.length+index][11];
			if(p[0][0]!=-1){
				k++;
				newBorder[0][0] = p[0][0];
				newBorder[0][1] = p[0][1];
				for(int i=0;i<9;i++){
					newBorder[0][i+2] = 0;
				}
			}
			for(int i=0;i<border.length;i++){
				for(int j = 0;j<11;j++){
				newBorder[k+i][j] = border[i][j];
				}
			}
			k+=border.length;
			if(p[1][0]!=-1){
				newBorder[k][0] = p[1][0];
				newBorder[k][1] = p[1][1];
				for(int i=0;i<9;i++){
					newBorder[k][i+2] = 0;
				}
			}
			
			System.out.println("toolA:");
			for(int i=0;i<newBorder.length;i++){
				for(int j=0;j<11;j++){
				     System.out.print(newBorder[i][j]+" ");
				}
				System.out.println();
			}
			return newBorder;
		}
		
	}
	/**
	 * ���ƶ�����������Բ�������߽����Ϊһ��
	 * 
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static int[][] manageBorders(int[][] p1, int[][] p2) {
		// TODO Auto-generated method stub
		int i = 0;
		int k = 0;
		int jj = 0;
		for (; jj < p2.length&& p2[jj][0] != -1; jj++)
			;
		int min = p1[0][0]%10<p2[0][0]%10?p1[0][0]%10:p2[0][0]%10;
		
		for (; i < p1.length&& p1[i][0] != -1; i++) {
			for (int j = 0; j < p2.length && p2[j][1] != -1; j++) {
				if (p1[i][0] % 10 == p2[j][0] % 10) {
					if (p1[i][0] / 10 == p2[j][0] / 10) {
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
		//int max = p1[i-1][0]%10>p2[jj-1][0]%10?p1[i-1][0]%10:p2[jj-1][0]%10;
		
		int[][] p = new int[i + jj - k][2];
		for (int m = 0; m < i; m++) {
			p[p1[m][0]%10-min%10][0] = p1[m][0];
			p[p1[m][0]%10-min%10][1] = p1[m][1];
		}
		int l = 0;
		for (int m = 0; m < jj - k; m++) {
			for (int n = l; n < p2.length; n++)
				if (p2[n][0] != -1) {
					p[p2[n][0]%10-min%10][0] = p2[n][0];
					p[p2[n][0]%10-min%10][1] = p2[n][1];
					l = n + 1;
					break;
				}
		}
		return p;
	}

	/**
	 * ���Ҫ���ı߽�
	 * 
	 * @param no1
	 * @param h1
	 * @param rh1
	 * @param v1
	 * @param tv1
	 * @return
	 */
	private static int[][] generateRemBorder(int no1, int h1, int rh1, int v1,
			int tv1) {
		int[][] p = new int[9][2];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 2; j++) {
				p[i][j] = -1;
			}
		}

		if (h1 > 2) {
			for (int i = 0; i < h1; i++) {
				p[i][0] = no1 - (h1 - rh1) + i;
				p[i][1] = 1;
			}
		}
		if (v1 > 2) {
			if (p[0][0] == -1) {
				p[0][0] = no1 - (tv1 - 1) * 10;
				p[0][1] = v1;
			} else {
				for (int i = 0; i < 5; i++) {
					if (p[i][0] == no1) {
						p[i][0] = no1 - (tv1 - 1) * 10;
						p[i][1] = v1;
						break;
					}
				}
			}
		}
		return p;
	}

	/**
	 * �������
	 * 
	 * @param p �γ���������
	 * @param tool �Ƿ��γɵ���
	 */
	public static int[] fillpets(int[][] p,boolean tool) {
		// TODO Auto-generated method stub
		
		int[][] ps = new int[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				ps[i][j] = PlayPanel.pets[i][j].type;
			}
		}
		//���������ʱ��Ϊһϵ�в���ȵĴ���
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i][1]; j++) {
				ps[j][p[i][0] % 10] = 100*i+j+100;
			}
		}
		int removebleNum = removebleNum(ps);
		System.out.println("rmNum="+removebleNum);
		//��������С��10��ʱ�򣬵����γɿ�����
		int k=-1;
		if (removebleNum < 10&&(!tool)) {
			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < p[i][1]; j++) {
					if(j==2){
						k = i;
					}
					int t =  (int) (Math.random() * 7)+1;
					do{
						ps[j][p[i][0] % 10] = t;
						t=t%7+1;
					}while(isRemoveble(j*10+p[i][0]%10, ps));

				}
			}
		
			int[] remP = new int[2];
			remP[0] = -1;
			remP[1] = -1;
			if(k!=-1){
				int rand = (int) (Math.random()*(p[k][1]));
				int dir = (int) (Math.random()*2) - 1;
				 if(dir==0){
					 dir++;
				 }
				 System.out.println("rand="+rand+"  dir="+dir);
				int distP = p[k][0]%10+rand*10+dir;
				if(distP<0||distP%10==9){
					distP = distP-2*dir;
				}
				int pi =  distP/10;
				int pj = distP%10;
				int cj = p[k][0]%10;
				if(pi+2>p[k][1]){
					ps[pi-1][cj] = ps[pi][pj];
					ps[pi-2][cj] = ps[pi][pj];
					if(isRemoveble(cj+pi*10-10, ps)){
						remP[0] = cj+pi*10-10;
					}
					if(isRemoveble(cj+pi*10-20, ps)){
						if(remP[0]==-1){
							remP[0] = cj+pi*10-20;
						}
						else{
							remP[1] = cj+pi*10-20;
						}
					}
				}
				else if(pi+3>p[k][1]){
					ps[pi-1][cj] = ps[pi][pj];
					ps[pi+1][cj] = ps[pi][pj];
				
					if(isRemoveble(cj+pi*10-10, ps)){
						remP[0] = cj+pi*10-10;
					}
					if(isRemoveble(cj+(pi+1)*10, ps)){
						if(remP[0]==-1){
							remP[0] = cj+(pi+1)*10;
						}
						else{
							remP[1] = cj+(pi+1)*10;
						}
					}
				}
				else{
					ps[pi+1][cj] = ps[pi][pj];
					ps[pi+2][cj] = ps[pi][pj];
					
					if(isRemoveble(cj+pi*10+10, ps)){
						remP[0] = cj+pi*10+10;
					}
					if(isRemoveble(cj+(pi+2)*10, ps)){
						if(remP[0]==-1){
							remP[0] = cj+(pi+2)*10;
						}
						else{
							remP[1] = cj+(pi+2)*10;
						}
					}
				}
			}
			else{
				int rand = (int) (Math.random()*(p.length));
				System.out.println("rand="+rand);
				int distP = p[0][0]%10+rand;
				int pj =  distP%10;
				if(rand+2>p.length){
					ps[0][pj-1] = ps[1][pj];
					ps[0][pj-2] = ps[1][pj];
					if(isRemoveble(pj-1, ps)){
						remP[0] = pj-1;
					}
					if(isRemoveble(pj-2, ps)){
						if(remP[0]==-1){
							remP[0] = pj-2;
						}
						else{
							remP[1] = pj-2;
						}
					}
				}
				else if(rand+3>p.length){
					ps[0][pj-1] = ps[1][pj];
					ps[0][pj+1] = ps[1][pj];
					
					if(isRemoveble(pj-1, ps)){
						remP[0] = pj-1;
					}
					if(isRemoveble(pj+1, ps)){
						if(remP[0]==-1){
							remP[0] = pj+1;
						}
						else{
							remP[1] = pj+1;
						}
					}
				}
				else{
					ps[0][pj+1] = ps[1][pj];
					ps[0][pj+2] = ps[1][pj];
					
					if(isRemoveble(pj+1, ps)){
						remP[0] = pj+1;
					}
					if(isRemoveble(pj+2, ps)){
						if(remP[0]==-1){
							remP[0] = pj+2;
						}
						else{
							remP[1] = pj+2;
						}
					}
				}
			}
			
			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < p[i][1]; j++) {
					System.out.println(j+" "+p[i][0] % 10+" "+ps[j][p[i][0] % 10]);
					PlayPanel.pets[j][p[i][0] % 10] = new PetLabel(ps[j][p[i][0] % 10], j * 10
							+ p[i][0] % 10);
					PlayPanel.pets[j][p[i][0] % 10].setLocation(
							p[i][0] % 10 * 50, -((p[i][1] - j) * 50));
					PlayPanel.pets[j][p[i][0] % 10].isMove = true;
					playPanel.add(PlayPanel.pets[j][p[i][0] % 10]);

				}
			}
			System.out.println("remP[0]="+remP[0]+" remP[1]="+remP[1]);
			return remP;
		} else {
			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < p[i][1]; j++) {
					int t =  (int) (Math.random() * 7)+1;
					do{
						ps[j][p[i][0] % 10] = t;
						t=t%7+1;
					}while(isRemoveble(j*10+p[i][0]%10, ps));
					System.out.println(j+" "+p[i][0] % 10+" "+ps[j][p[i][0] % 10]);
					PlayPanel.pets[j][p[i][0] % 10] = new PetLabel(ps[j][p[i][0] % 10], j * 10
							+ p[i][0] % 10);
					PlayPanel.pets[j][p[i][0] % 10].setLocation(
							p[i][0] % 10 * 50, -((p[i][1] - j) * 50));
					PlayPanel.pets[j][p[i][0] % 10].isMove = true;
					playPanel.add(PlayPanel.pets[j][p[i][0] % 10]);

				}
			}
			return null;
		}
		
	}
	
	/**
	 * ����ܹ��γɿ����������ܵĸ���
	 * @param ps��������
	 */
	public static int removebleNum(int[][] ps){
		int rNum = 0;   //  �����ĸ���
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				//�����潻��
				int k = ps[i][j];
				ps[i][j] = ps[i+1][j];
				ps[i+1][j] = k;
				if(isRemoveble(i*10+j,ps)){
					rNum++;
					System.out.println(i*10+j);
				}
				if(isRemoveble((i+1)*10+j,ps)){
					rNum++;
					System.out.println((i+1)*10+j);
				}
				ps[i+1][j] = ps[i][j];
				//ps[i][j] = k;
				//����߽���
				ps[i][j] = ps[i][j+1];
				ps[i][j+1] = k;
				if(isRemoveble(i*10+j,ps)){
					rNum++;
					System.out.println(i*10+j);
				}
				if(isRemoveble(i*10+j+1,ps)){
					rNum++;
					System.out.println(i*10+j+1);
				}
				ps[i][j+1] = ps[i][j];
				ps[i][j] = k;
			}
			
		}
		//�������һ�к�һ��
		for(int i=0;i<8;i++){
			//�����潻��
			int k = ps[i][8];
			ps[i][8] = ps[i+1][8];
			ps[i+1][8] = k;
			if(isRemoveble(i*10+8,ps)){
				rNum++;
				System.out.println(i*10+8);
			}
			if(isRemoveble((i+1)*10+8,ps)){
				rNum++;
				System.out.println(i*10+8);
			}
			ps[i+1][8] = ps[i][8];
			ps[i][8] = k;
		}
		for(int i =0;i<8;i++){
			//�����潻��
			int k = ps[8][i];
			ps[8][i] = ps[8][i+1];
			ps[8][i+1] = k;
			if(isRemoveble(80+i,ps)){
				rNum++;
				System.out.println(80+i);
			}
			if(isRemoveble(80+i+1,ps)){
				rNum++;
				System.out.println(80+i+1);
			}
			ps[8][i+1] = ps[8][i];
			ps[8][i] = k;
		}
		
		return rNum;
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
	 * �жϳ���p�Ƿ��γ��������������������������γ�
	 * ��������
	 * @param p�����λ��
	 * @return �Ƿ��γ��������γɷ���true
	 */
	public static boolean EveryJudgeAndRemmve(int p) {
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
		System.out.println("in middle init panel:-----------------:");
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(PlayPanel.pets[i][j].type+" ");
			}
			System.out.println();
		}
		
		int[][] p1 = generateRemBorder(p, h1, rh1, v1, tv1);
		int ii=0;
		for( ii=0;ii<9&&p1[ii][0]!=-1;ii++);
		int[][] p2 = new int[ii][2];
		for(int j=0;j<ii;j++){
			p2[j][0] = p1[j][0];
			p2[j][1] = p1[j][1];
 		}
		
		
		int pNum = 0;   //��¼�γ����ĸ���
		int maxNum =0; //��¼�л��������һ�����ĸ�
		//����p�γ����ĸ���
		for(int i=0;i<p2.length;i++){
			if(p2[i][1]>0){
				pNum+=p2[i][1];
				maxNum = maxNum>p2[i][1]?maxNum:p2[i][1];
			}
		}
		int[] tool= new int[2];  //������ĵ���
		
		//���������������Ӧ����
		if(pNum-maxNum==3||maxNum==4){
			tool[0] = p;
			tool[1] = PlayPanel.getPetLabel(p).type%10*11;;
		}
		else if(pNum-maxNum==3||maxNum==5){
			tool[0] = p;
			tool[1] = 8;
		}
		
		//��������̲���ķ���
		int score = 0;
				
		 score += getScore(pNum);
				     
		 int[][] p3 = new int[p2.length][11];
			for(int i=0;i<p3.length;i++){
				p3[i][0] = p2[i][0];
				p3[i][1] = p2[i][1];
				for(int j=0;j<9;j++){
					p3[i][2+j] = 0;
				}
			}
			
		    //int[] [] p = p12;    //���������������
			//�ж�������Ƿ���ڵ��߳���
	A:    for(int i=0;i<p3.length;i++){
				for(int j=0;j<p3[i][1]; j++){
					if(p3[i][p3[i][0]/10+j+2]==1){
						continue;
					}
					//�Ƿ��ǵ���B
					if(PlayPanel.getPetLabel(p3[i][0]+j*10).type == 8){
						score+=1000;
						PlayPanel.getPetLabel(p3[i][0]+j*10).type=0;
						p3 = toolBAddBorder(p3,i,j);
						i =-1;
						continue A;
					}
					//�Ƿ��ǵ���A
					if(PlayPanel.getPetLabel(p3[i][0]+j*10).isToolPet()){
						score+=600;
						PlayPanel.getPetLabel(p3[i][0]+j*10).setToolPet(false);
						p3 = addBorder(p3,i,j);
						i =-1;
						continue A;
					}
				}
			}		   
		//��ʾ����
		System.out.println("score="+score);
		
		//int[][] p2 = generateRemBorderL(no2, h2, rh2, v2, tv2);
		System.out.println("no1=" + p + " h1=" + h1 + " rh1=" + rh1 + " v1="
				+ v1 + " tv1=" + tv1);
		System.out.println("p2:");
		for (int j = 0; j < 11; j++) {
			for (int i = 0; i < p3.length; i++) {
				System.out.print(p3[i][j] + " ");
			}
			System.out.println();
		}
		playPanel.removeAndFill(p3,tool,null);
		return true;
	}

	/**
	 * ˫��������A����������Ч��
	 * @param po ����A��λ��
	 */
	public static void  toolARemove(int po){
		int score = 0;  //��¼�γɵķ���
		
		int[][] p = new int[1][11];
		p[0][0] = po;
		p[0][1] = 1;
		for(int j=0;j<9;j++){
			p[0][2+j] = 0;
		}
		
	    //int[] [] p = p12;    //���������������
		//�ж�������Ƿ���ڵ��߳���
A:    for(int i=0;i<p.length;i++){
			for(int j=0;j<p[i][1]; j++){
				if(p[i][p[i][0]/10+j+2]==1){
					continue;
				}
				//�Ƿ��ǵ���B
				if(PlayPanel.getPetLabel(p[i][0]+j*10).type == 8){
					score+=1000;
					PlayPanel.getPetLabel(p[i][0]+j*10).type=0;
					p = toolBAddBorder(p,i,j);
					i =-1;
					continue A;
				}
				//�Ƿ��ǵ���A
				if(PlayPanel.getPetLabel(p[i][0]+j*10).isToolPet()){
					score+=600;
					PlayPanel.getPetLabel(p[i][0]+j*10).setToolPet(false);
					p = addBorder(p,i,j);
					i =-1;
					continue A;
				}
			}
		}
		for(int i=0;i<p.length;i++){
			for(int j=0;j<11;j++){
				System.out.print(p[i][j]+" ");
			}
			System.out.println();
		}
		playPanel.removeAndFill(p,null,null);
	}

	/**
	 * ˫��������B����������Ч��
	 * @param po ����B��λ��
	 */
	public static void toolBRemove(int po){
       int score = 0;  //��¼�γɵķ���
		
		int[][] p = new int[9][11];
		for(int i=0;i<9;i++){
			p[i][0] = po/10*10+i;
			p[i][1] = 1;
		}
		p[po%10][0] =po%10;
		p[po%10][0] =9;
		//�ж�������Ƿ���ڵ��߳���
A:    for(int i=0;i<p.length;i++){
			for(int j=0;j<p[i][1]; j++){
				if(p[i][p[i][0]/10+j+2]==1){
					continue;
				}
				//�Ƿ��ǵ���B
				if(PlayPanel.getPetLabel(p[i][0]+j*10).type == 8){
					score+=1000;
					PlayPanel.getPetLabel(p[i][0]+j*10).type=0;
					p = toolBAddBorder(p,i,j);
					i =-1;
					continue A;
				}
				//�Ƿ��ǵ���A
				if(PlayPanel.getPetLabel(p[i][0]+j*10).isToolPet()){
					score+=600;
					PlayPanel.getPetLabel(p[i][0]+j*10).setToolPet(false);
					p = addBorder(p,i,j);
					i =-1;
					continue A;
				}
			}
		}
		playPanel.removeAndFill(p,null,null);
	}
}

