package inst.common;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

public class Tools {
	
	public static void addCompnentForGridLayout(Container conr, Component comp, GridBagConstraints cons, int x, int y, int w, int h){
		cons.gridx = x;
		cons.gridy = y;
		cons.gridwidth = w;
		cons.gridheight = h;
		
		conr.add(comp, cons);
	}
	
	public static JLabel getBlankLabel(int x, int y){
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(x,y));
		
		return label;
	}

}
