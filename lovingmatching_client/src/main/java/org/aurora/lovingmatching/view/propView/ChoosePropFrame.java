package org.aurora.lovingmatching.view.propView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.aurora.lovingmatching.view.compLibView.ALabel;
import org.aurora.lovingmatching.view.imageLibView.ImageFactory;
import org.aurora.lovingmatching.view.matchView.LocalBaiFrame;

/**
 * @Description
 * @author m2o2o2d
 * 2014年5月15日下午3:31:52
 */
public class ChoosePropFrame extends JFrame{
	
	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel lianyilianLabel;//连易连按钮
	private ALabel pantaoLabel;//千年蟠桃按钮
	private ALabel huoyanLabel;//火眼金睛按钮
	private ALabel jinguLabel;//紧箍咒按钮
	private ALabel timeLabel;//时光倒流按钮
	private boolean isLian;
	private boolean isPan;
	private boolean isHuo;
	private boolean isJin;
	private boolean isTime;
	private ALabel wukongLabel;//悟空
	private ALabel bajieLabel;//八戒
	private ALabel shasengLabel;//沙僧
	
	public ChoosePropFrame() {
		/*UI-frame背景*/
		setSize(697,510);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"18",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(660, 30,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-连易连按钮*/
		int x=70;int a=115;
		lianyilianLabel = new ALabel(x, 100, "22",0,1);
		lianyilianLabel.getLabel().addMouseListener(new LianMosListener());
		backPanel.add(lianyilianLabel.getLabel());
		/*UI-千年蟠桃按钮*/
		pantaoLabel = new ALabel(x+a, 100, "48",0,1);
		pantaoLabel.getLabel().addMouseListener(new PanMosListener());
		backPanel.add(pantaoLabel.getLabel());
		/*UI-火眼金睛按钮*/
		huoyanLabel = new ALabel(x+2*a, 100, "51",0,1);
		huoyanLabel.getLabel().addMouseListener(new HuoMosListener());
		backPanel.add(huoyanLabel.getLabel());
		/*UI-紧箍咒按钮*/
		jinguLabel = new ALabel(x+3*a, 100, "49",0,1);
		jinguLabel.getLabel().addMouseListener(new JinMosListener());
		backPanel.add(jinguLabel.getLabel());
		/*UI-时光倒流按钮*/
		timeLabel = new ALabel(x+4*a, 100, "50",0,1);
		timeLabel.getLabel().addMouseListener(new ShiMosListener());
		backPanel.add(timeLabel.getLabel());
		/*UI-道具布尔值初始化*/
		isLian = false;
		isPan = false;
		isHuo = false;
		isJin = false;
		isTime = false;
		/*UI-悟空按钮*/
		wukongLabel = new ALabel(100, 310, "23",0,1);
		wukongLabel.getLabel().addMouseListener(new WukongMosListener());
		backPanel.add(wukongLabel.getLabel());
		/*UI-八戒按钮*/
		bajieLabel = new ALabel(300, 310, "25",0,1);
		bajieLabel.getLabel().addMouseListener(new BajieMosLisenter());
		backPanel.add(bajieLabel.getLabel());
		/*UI-沙僧按钮*/
		shasengLabel = new ALabel(500, 310, "24",0,1);
		shasengLabel.getLabel().addMouseListener(new ShaSengMosListener());
		backPanel.add(shasengLabel.getLabel());
		setVisible(true);
	}
	
	/*事件-退出按钮*/
	class ExitMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			LocalBaiFrame.main(null);
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
	
	/*事件-道具：连易连*/
	class LianMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if(!isLian) {
				lianyilianLabel.removeLabelMouseListener();
				lianyilianLabel.setImage("22-1");
				isLian = true;
			}
			else {
				lianyilianLabel.addLabelMouseListener();
				isLian = false;
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
	
	/*事件-道具：千年蟠桃*/
	class PanMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			if(!isPan) {
				pantaoLabel.removeLabelMouseListener();
				pantaoLabel.setImage("48-1");
				isPan = true;
			}
			else {
				pantaoLabel.addLabelMouseListener();
				isPan = false;
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
	
	/*事件-道具：火眼金睛*/
	class HuoMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			if(!isHuo) {
				huoyanLabel.removeLabelMouseListener();
				huoyanLabel.setImage("51-1");
				isHuo = true;
			}
			else {
				huoyanLabel.addLabelMouseListener();
				isHuo = false;
			}		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	/*事件-道具：紧箍咒*/
	class JinMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			if(!isJin) {
				jinguLabel.removeLabelMouseListener();
				jinguLabel.setImage("49-1");
				isJin = true;
			}
			else {
				jinguLabel.addLabelMouseListener();
				isJin = false;
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
	
	/*事件-道具：时光倒流*/
	class ShiMosListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			if(!isTime) {
				timeLabel.removeLabelMouseListener();
				timeLabel.setImage("50-1");
				isTime = true;
			}
			else {
				timeLabel.addLabelMouseListener();
				isTime = false;
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
	
	/*事件-角色：悟空*/
	class WukongMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			wukongLabel.removeLabelMouseListener();
			wukongLabel.setImage("23-1");
			bajieLabel.addLabelMouseListener();
			shasengLabel.addLabelMouseListener();
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
	
	/*事件-角色：八戒*/
	class BajieMosLisenter implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			bajieLabel.removeLabelMouseListener();
			bajieLabel.setImage("25-1");
			wukongLabel.addLabelMouseListener();
			shasengLabel.addLabelMouseListener();
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
	
	/*事件-角色：沙僧*/
	class ShaSengMosListener implements MouseListener {
	
		public void mouseClicked(MouseEvent e) {
			shasengLabel.removeLabelMouseListener();
			shasengLabel.setImage("24-1");
			wukongLabel.addLabelMouseListener();
			bajieLabel.addLabelMouseListener();
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
		new ChoosePropFrame();
	}

}
