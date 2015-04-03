package org.aurora.lovingmatching.view.compLibView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.aurora.lovingmatching.view.imageLibView.ImageFactory;

/**
 * @Description
 * @author m2o2o2d 2014年5月10日下午4:57:42
 */
public class ATable {

	private JTable table;
	private DefaultTableModel model;
	private DefaultTableCellRenderer render;// 渲染器
	private JTableHeader header;
	private String[][] content;
	private String[] head;

	public ATable(ArrayList<String> c, ArrayList<String> h, String s) {// 每行内容，表头，每行内容分隔符
		table = new JTable() {
			public boolean isCellEditable(int row, int column) { 
			    return false;
		   }
		};
		table.setOpaque(false);
		table.setFont(new AFont().getFont(1));
		content = new String[c.size()][h.size()];
		for (int i = 0; i < c.size(); i++) {
			content[i] = c.get(i).split(s);
		}
		head = new String[h.size()];
		for (int j = 0; j < h.size(); j++) {
			head[j] = h.get(j);
		}
		model = new DefaultTableModel(content, head);
		table.setModel(model);
		opaque();
		
	}

	public ATable(String[][] c, String[] h) {
        table = new JTable() {
        	public boolean isCellEditable(int row, int column) { 
        	    return false;
           }
        };
        table.setFont(new AFont().getFont(1));
        model = new DefaultTableModel(c, h);
        table.setModel(model);
        opaque();
    }
	
	public void opaque() {
		table.setOpaque(false);
		render = new DefaultTableCellRenderer();
		render.setOpaque(false);
		render.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, render);
		header = table.getTableHeader();
		header.setDefaultRenderer(render);
		table.setTableHeader(header);
		header.setBackground(new Color(69,36,7));
		table.setForeground(Color.yellow);
		table.setSelectionForeground(new Color(50,255,23));
		table.setFont(new AFont().getFont(1));
		table.setRowHeight(26);
	}

	public JTable getTable() {
		return table;
	}

}