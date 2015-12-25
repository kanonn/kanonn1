package inst;

import inst.frontPanel.FrontPanel;
import inst.menuPanel.MenuPanel;
import inst.systemCtrl.GetOption;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	private FrontPanel frontPanel; 
//	private MenuPanel mainMenuP;
	
	public MainPanel(){
		super();
		this.frontPanel = new FrontPanel();
		init();
//		this.mainMenuP = new MenuPanel();
	}
	

	public void init(){
//		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setSize(new Dimension(GetOption.size_Main_Frame_w,GetOption.size_Main_Frame_h));
//		mainMenu.setMainPanel(this);
		
//		this.add(mainMenuP);
		this.add(frontPanel);
	}


	public FrontPanel getFrontPanel() {
		return frontPanel;
	}
//	public void init
	
}
