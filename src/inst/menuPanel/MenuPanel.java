package inst.menuPanel;

import inst.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	
//	private FrontPanel frontPanel;
	private MainPanel mainPanel;
	private String testStr = "testStr";
	
	public JMenuBar CreateMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(CreateMenuList());
		
		return menuBar;
	}
	
	private JMenu CreateMenuList(){
		JMenu menu = new JMenu("ˆê——");
		menu.add(CreateMenuListItem("listShow"));
		
		return menu;
	}
	
	private JMenuItem CreateMenuListItem(String menuName){
		JMenuItem menuItem = null;
		if("listShow".equals(menuName)){
			menuItem = new JMenuItem("listShow");
			menuItem.addActionListener(new listListenerA());
		};
		
		return menuItem;
	}
	
	//list
	private class listListenerA implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("listShow");
			if(mainPanel==null){System.out.println("mainPanel is null ");}
//			if(frontPanel==null){System.out.println("frontPanel is null "+testStr);}
			mainPanel.getFrontPanel().showData();
		}
	}

//	public void setFrontPanel(FrontPanel frontPanel) {
//		this.frontPanel = frontPanel;
//	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
}
