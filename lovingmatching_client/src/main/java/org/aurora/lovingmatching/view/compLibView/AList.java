package org.aurora.lovingmatching.view.compLibView;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import org.aurora.lovingmatching.view.imageLibView.ImageFactory;

/**
 * @Description 图片列表
 * @author m2o2o2d
 * 2014年5月10日下午3:58:36
 */
public class AList {

	private ImageFactory imageFactory;
	private ImageIcon icon;
	private ImageIcon[] icons;
	private JList jList;
	private DefaultListModel model;
	
	public AList(int x,int y,int w,int h) {
		imageFactory = new ImageFactory();
		icons = imageFactory.getImageList();
		model = new DefaultListModel();
		for(int i=0;i<4;i++) {
			model.add(0,"");
		}
		jList = new JList(model);
		jList.setBounds(x, y, w, h);
		jList.setCellRenderer(new MyCellRenderer(icons));
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setOpaque(false);
	}
	
	public JList getList() {
		return jList;
	}
}

class MyCellRenderer extends JLabel implements ListCellRenderer {
	
	ImageIcon[] icons;
	
	public MyCellRenderer(ImageIcon[] icons) {
		this.icons = icons;
	}
	
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {  
			setBackground(list.getSelectionBackground());  
			setForeground(list.getSelectionForeground());  
		} else {  
			setBackground(list.getBackground());  
			setForeground(list.getForeground());  
		 } 
		setIcon(icons[index]);
		setEnabled(list.isEnabled()); 
		setOpaque(false);
		return this;
	}
}

