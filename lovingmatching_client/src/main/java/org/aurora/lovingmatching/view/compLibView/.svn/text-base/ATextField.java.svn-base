package org.aurora.lovingmatching.view.compLibView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * @Description 
 * @author m2o2o2d
 * 2014年5月10日下午3:21:03
 */
public class ATextField {
	
	private JTextField textfield;
	private AFont font;
	
	public ATextField(int x,int y,int w,int h) {
		textfield = new JTextField();
		font = new AFont();
		textfield.setBounds(x,y,w,h);
        textfield.setFont(font.getFont(1));
        textfield.setForeground(Color.white);
        //textfield.setBackground(new Color(38,14,3));
        textfield.setOpaque(false);
        textfield.setBorder(new LineBorder(new Color(0,0,0,0),2));
        textfield.addMouseListener(new TextFieldMosListener());
	}
	
	public JTextField getTextField() {
		return textfield;
	}
	
	/*事件-鼠标效果*/
	class TextFieldMosListener implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			textfield.setBorder(new LineBorder(new Color(221,240,7),2));
		}

		public void mouseEntered(MouseEvent arg0) {
			textfield.setBorder(new LineBorder(new Color(221,240,7),2));
		}

		public void mouseExited(MouseEvent arg0) {
			textfield.setBorder(new LineBorder(new Color(0,0,0,0),2));
		}

		public void mousePressed(MouseEvent arg0) {
			textfield.setBorder(new LineBorder(new Color(221,240,7),2));
		}

		public void mouseReleased(MouseEvent arg0) {
			textfield.setBorder(new LineBorder(new Color(221,240,7),2));
		}
		
	}
}
