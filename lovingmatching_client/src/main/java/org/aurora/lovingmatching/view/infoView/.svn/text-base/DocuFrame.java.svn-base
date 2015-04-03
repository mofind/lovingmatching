package org.aurora.lovingmatching.view.infoView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.security.auth.x500.X500Principal;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.compLibView.AList;
import org.aurora.lovingmatching.view.compLibView.APanel;
import org.aurora.lovingmatching.view.compLibView.ATable;
import org.aurora.lovingmatching.view.compLibView.ATextField;
import org.aurora.lovingmatching.view.entryView.StartFrame;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;

/**
 * @Description
 * @author m2o2o2d
 * 2014年5月9日上午10:10:58
 */
public class DocuFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;
	private ALabel backLabel;
	private CardLayout cardlayout;
	private JPanel contain;
	private ALabel exitLabel;
	private ALabel returnLabel;
	private APanel docuPanel;//-------------档案面板
	private ALabel close1Label;
	private ALabel info1Label;
	private ALabel info2Label;
	private ALabel info3Label;
	private ALabel info4Label;
	private ALabel info5Label;
	private ALabel info6Label;
	private APanel newPanel;//--------------新角色面板
	private ALabel close2Label;
	private ALabel saveLabel;
	private ALabel leftLabel;
	private ALabel rightLabel;
	private ATextField nameTextField;
	private APanel photoPanel;//--//----头像列表
	private int index;//第一张头像索引
	private ImageIcon[] icons;
	private ALabel phoLabel1;
	private ALabel phoLabel2;
	private ALabel phoLabel3;
	private ALabel phoLabel4;
	
	public DocuFrame() {
		/*UI-frame背景*/
		setSize(912,650);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel  = new ALabel(0, 0, "2",1,0);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		backPanel.setLayout(null);
		/*UI-退出按钮*/
		exitLabel = new ALabel(836, 63,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		/*UI-返回按钮*/
		returnLabel = new ALabel(800,63,"4",0,1);
		returnLabel.getLabel().addMouseListener(new ReturnMosListener());
		/*UI-卡式布局*/
		cardlayout = new CardLayout();
		contain = new JPanel();
		contain.setBounds(0, 0, 912, 650);
		backPanel.add(contain);
		contain.setLayout(cardlayout);
		contain.setOpaque(false);
		/*UI-----------------------------------------------------------------------玩家档案面板*/
		docuPanel = new APanel(0,0,"4");
		docuPanel.setLayout(null);
		docuPanel.add(exitLabel.getLabel());
		docuPanel.add(returnLabel.getLabel());
		/*UI-关闭档案按钮*/
		close1Label = new ALabel(720,190,"1",0,1);
		close1Label.getLabel().addMouseListener(new CloseMosListener());
		docuPanel.add(close1Label.getLabel());
		/*UI-玩家档案按钮*/
		int x = 260;int y = 170;
		int w = 200;int h = 150;
		int subx = 265;int suby = 110;
		info1Label = new ALabel(x,y,w,h,"古美萌");
		docuPanel.add(info1Label.getLabel());
		info2Label = new ALabel(x+subx,y,w,h,"空存档");
		info2Label.getLabel().addMouseListener(new NewMosListener());
		docuPanel.add(info2Label.getLabel());
		info3Label = new ALabel(x,y+suby,w,h,"空存档");
		docuPanel.add(info3Label.getLabel());
		info4Label = new ALabel(x+subx,y+suby,w,h,"空存档");
		docuPanel.add(info4Label.getLabel());
		info5Label = new ALabel(x,y+2*suby,w,h,"空存档");
		docuPanel.add(info5Label.getLabel());
		info6Label = new ALabel(x+subx,y+2*suby,w,h,"空存档");
		docuPanel.add(info6Label.getLabel());
		/*UI----------------------------------------------------------------------新建角色面板*/
		newPanel = new APanel(0,0,"3");
		newPanel.setLayout(null);
		newPanel.add(exitLabel.getLabel());
		newPanel.add(returnLabel.getLabel());
		/*UI-左右按钮*/
		leftLabel = new ALabel(200, 440, "11",0,1);
		rightLabel = new ALabel(673,442,"12",0,1);
		leftLabel.getLabel().addMouseListener(new LeftMosListener());
		rightLabel.getLabel().addMouseListener(new RightMosListener());
		newPanel.add(leftLabel.getLabel());
		newPanel.add(rightLabel.getLabel());
		/*UI-输入框*/
		nameTextField = new ATextField(500, 291, 135, 40);
		newPanel.add(nameTextField.getTextField());
		/*UI-头像列表*///----------------------------------------------有问题
		photoPanel = new APanel(250,418,430,95);
		photoPanel.setLayout(null);
		photoPanel.setOpaque(false);
		icons = image.getImageList();
		index = 0;
		int a = 7;int b = 105;
		phoLabel1 = new ALabel(a, 2, "t-1",1,0);
		phoLabel2 = new ALabel(a+b, 2, "t-2",1,0);
		phoLabel3 = new ALabel(a+2*b, 2, "t-3",1,0);
		phoLabel4 = new ALabel(a+3*b, 2, "t-4",1,0);
		photoPanel.add(phoLabel1.getLabel());
		photoPanel.add(phoLabel2.getLabel());
		photoPanel.add(phoLabel3.getLabel());
		photoPanel.add(phoLabel4.getLabel());
		newPanel.add(photoPanel);
		/*UI-关闭创建按钮*/
		close2Label = new ALabel(720,190,"1",0,1);
		close2Label.getLabel().addMouseListener(new Close2MosListener());
		newPanel.add(close2Label.getLabel());
		/*UI-保存按钮*/
		saveLabel = new ALabel(720,225,"13",0,1);
		saveLabel.getLabel().addMouseListener(new SaveMosListener());
		newPanel.add(saveLabel.getLabel());
		
		contain.add(docuPanel,"docu");
		contain.add(newPanel,"new");
		cardlayout.show(contain,"new");
		setVisible(true);
	}
	
	/*事件-退出按钮*/
	class ExitMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			System.exit(1);
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-返回按钮*/
	class ReturnMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			dispose();
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-关闭档案按钮*/
	class CloseMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			dispose();
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-打开空存档*/
	class NewMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "new");
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-关闭新建按钮*/
	class Close2MosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "docu");
			newPanel.invalidate();
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-保存按钮*/
	class SaveMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			cardlayout.show(contain, "docu");
			newPanel.invalidate();
			docuPanel.invalidate();
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-左按钮*/
	class LeftMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if(index+4<icons.length) {
				index = index+1;
				phoLabel1.setPicture(icons[index]);
				phoLabel2.setPicture(icons[index+1]);
				phoLabel3.setPicture(icons[index+2]);
				phoLabel4.setPicture(icons[index+3]);
			    photoPanel.repaint();
			}
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-右按钮*/
	class RightMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if(index>0) {
				index = index-1;
				phoLabel1.setPicture(icons[index]);
				phoLabel2.setPicture(icons[index+1]);
				phoLabel3.setPicture(icons[index+2]);
				phoLabel4.setPicture(icons[index+3]);
			    photoPanel.repaint();
			}
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DocuFrame();
	}

}
