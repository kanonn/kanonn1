package inst;

import inst.menuPanel.MenuPanel;
import inst.systemCtrl.GetOption;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFram extends JFrame {
	
	private MainPanel mainPanel;
	private MenuPanel menuP;
	
	public MainFram(){
		super();
		
//		MenuPanel menuP = new MenuPanel();
		menuP = new MenuPanel();
		mainPanel = new MainPanel();
		menuP.setMainPanel(mainPanel);
		
		this.setJMenuBar(menuP.CreateMenuBar());
//		mainPanel.init();
		this.add(mainPanel,BorderLayout.CENTER);
//		this.add(new MainPanel(),BorderLayout.CENTER);
		
		
		
		
		
		
		this.setVisible(true);
		this.setSize(new Dimension(GetOption.size_Main_Frame_w,GetOption.size_Main_Frame_h));
		this.setLocation(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
