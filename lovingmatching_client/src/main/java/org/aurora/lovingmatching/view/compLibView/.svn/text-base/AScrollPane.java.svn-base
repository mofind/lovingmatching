package org.aurora.lovingmatching.view.compLibView;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @Description
 * @author m2o2o2d
 * 2014年5月10日下午4:49:34
 */
public class AScrollPane {
	
	private JScrollPane scroll;
    
    public AScrollPane(int x,int  y,int w,int h) {
        scroll = new JScrollPane();
        scroll.setBounds(x,y,w,h);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
    }
    
    public AScrollPane(int x,int  y,int w,int h,JList list) {
        scroll = new JScrollPane(list);
        scroll.setBounds(x,y,w,h);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
    }
    
    public AScrollPane(int x,int  y,int w,int h,JTextArea t) {
        scroll = new JScrollPane(t);
        scroll.setBounds(x,y,w,h);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
    }
    
    public JScrollPane getScrollPane() {
        return scroll;
    }

}
