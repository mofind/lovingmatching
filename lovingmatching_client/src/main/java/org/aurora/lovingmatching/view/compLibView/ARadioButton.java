package org.aurora.lovingmatching.view.compLibView;

import javax.swing.JRadioButton;

import org.aurora.lovingmatching.view.imageLibView.ImageFactory;

/**
 * @Description 单选按钮
 * @author m2o2o2d
 * 2014年5月25日上午9:59:57
 */
public class ARadioButton extends JRadioButton{

	private ImageFactory image;
	
	public ARadioButton (int x, int y,boolean state) {
		image = new ImageFactory();
		setBounds(x, y, 40, 40);
		setSelected(state);
		setOpaque(false);
		setIcon(image.getImage("radioButton"));
		setSelectedIcon(image.getImage("radioButton1"));
	}
	
}
