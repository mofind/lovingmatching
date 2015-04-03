package org.aurora.lovingmatching.view.compLibView;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.aurora.lovingmatching.view.imageLibView.ImageFactory;

/**
 * @Description 可添背景图的Panel
 * @author m2o2o2d
 * 2014年5月10日上午9:29:55
 */
public class APanel extends JPanel {

	private ImageFactory imageFactory;
	private ImageIcon icon;
	private Image image;
	
	public APanel(int x,int y,String num) {
		imageFactory = new ImageFactory();
		icon = imageFactory.getImage(num);
		image = icon.getImage();
		setBounds(x, y, icon.getIconWidth(),icon.getIconHeight());
		setLayout(null);
		setOpaque(false);
	}
	
	public APanel(int x,int y,int w,int h) {
		setBounds(x, y, w, h);
		setLayout(null);
		setOpaque(false);
	}
	
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	    }
	 
}