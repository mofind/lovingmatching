package org.aurora.lovingmatching.view.compLibView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.aurora.lovingmatching.view.compLibView.ATextField.TextFieldMosListener;

/**
 * @Description 密码输入口
 * @author m2o2o2d
 * 2014年5月15日下午2:59:46
 */
public class APasswordField extends JPasswordField{

	private AFont font;
	
	public APasswordField(int x,int y,int w,int h) {
		font = new AFont();
		setBounds(x,y,w,h);
        setFont(font.getFont(1));
        setForeground(Color.white);
        setOpaque(false);
        setBorder(new LineBorder(new Color(0,0,0,0),2));
         addMouseListener(new PasswordFieldMosListener());
	}
	
	/*事件-鼠标效果*/
	class PasswordFieldMosListener implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			setBorder(new LineBorder(new Color(221,240,7),2));
		}

		public void mouseEntered(MouseEvent arg0) {
			setBorder(new LineBorder(new Color(221,240,7),2));
		}

		public void mouseExited(MouseEvent arg0) {
			setBorder(new LineBorder(new Color(0,0,0,0),2));
		}

		public void mousePressed(MouseEvent arg0) {
			setBorder(new LineBorder(new Color(221,240,7),2));
		}

		public void mouseReleased(MouseEvent arg0) {
			setBorder(new LineBorder(new Color(221,240,7),2));
		}
		
	}
}
