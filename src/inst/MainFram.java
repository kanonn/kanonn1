package inst;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFram extends JFrame {
	
	public MainFram(){
		super();
		this.setVisible(true);
		this.setSize(new Dimension(300,200));
		this.setLocation(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
