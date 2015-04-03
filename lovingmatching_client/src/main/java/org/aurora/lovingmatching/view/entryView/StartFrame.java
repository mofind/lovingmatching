package org.aurora.lovingmatching.view.entryView;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.aurora.lovingmatching.controller.netController.AbstractNetController;
import org.aurora.lovingmatching.controller.netController.NetController;
import org.aurora.lovingmatching.view.compLibView.*;
import org.aurora.lovingmatching.view.imageLibView.*;
import org.aurora.lovingmatching.view.mainView.LocalMainFrame;
import org.aurora.lovingmatching.view.specialEffects.visualEffects.LocalMapSpecial;


/**
 * @Description 游戏启动页面
 * @author m2o2o2d
 * 2014年5月5日上午12:10:33
 */
public class StartFrame extends JFrame{

	/*UI*/
	private ImageFactory image;
	private JPanel backPanel;//背景面板
	private ALabel backLabel;//背景标签
	private ALabel exitLabel;//退出按钮
	private ALabel localLabel;//单机模式
	private ALabel netLabel;//网络模式
	/*逻辑*/
	private AbstractNetController abstractNetController;
	
	public StartFrame() {
		/*UI-frame背景*/
		setSize(708,582);
		setLocationRelativeTo(null);//居中
		setUndecorated(true);//去标题栏
		 com.sun.awt.AWTUtilities.setWindowOpaque(this, false);
		 //com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.9f);
		//getRootPane().setOpaque(false);
		//((JComponent)getContentPane()).setOpaque(false);
		//((JComponent) getGlassPane()).setOpaque(false);
		setBackground(new Color(0,0,0,0));//frame透明
		image = new ImageFactory();
		backPanel = (JPanel)getContentPane();
		backPanel.setOpaque(false);
		backLabel = new ALabel(0,0,"1",1,0);
		backPanel.setLayout(null);
		getLayeredPane().add(backLabel.getLabel(),new Integer(Integer.MIN_VALUE));
		/*UI-退出按钮*/
		exitLabel = new ALabel(632, 158,"1",0,1);
		exitLabel.getLabel().addMouseListener(new ExitMosListener());
		backPanel.add(exitLabel.getLabel());
		/*UI-单机模式按钮*/
		localLabel = new ALabel(262,258,"2",0,1);
		localLabel.getLabel().addMouseListener(new LocalMosListener());
		backPanel.add(localLabel.getLabel());
		/*UI-网络模式按钮*/
		netLabel = new ALabel(262,360,"3",0,1);
		netLabel.getLabel().addMouseListener(new NetMosListener());
		backPanel.add(netLabel.getLabel());
		/*逻辑*/
		abstractNetController = new NetController();
		
		setVisible(true);
		
		setDragable();
		
	}
	
	
	Point loc = null;
    Point tmp = null;
    boolean isDragged = false;
    private void setDragable() {
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent e) {
               isDragged = false;
               setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            public void mousePressed(java.awt.event.MouseEvent e) {
               tmp = new Point(e.getX(), e.getY());
               isDragged = true;
               setCursor(new Cursor(Cursor.MOVE_CURSOR));
            }
        });
        this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent e) {
               if(isDragged) {
                   loc = new Point(getLocation().x + e.getX() - tmp.x,
                     getLocation().y + e.getY() - tmp.y);
                   setLocation(loc);
               }
            }
        });
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
	
	/*事件-单机模式按钮*/
	class LocalMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			LocalMapSpecial.main(null);
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
	
	/*事件-网络模式按钮*/
	class NetMosListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			abstractNetController.startNetwork();
			LoginFrame.main(null);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StartFrame();
	}

}
