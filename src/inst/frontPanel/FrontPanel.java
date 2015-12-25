package inst.frontPanel;

import inst.filesList.FileListPanel;
import inst.systemCtrl.GetOption;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JPanel;

public class FrontPanel extends JPanel {
	
	private Map<String,String> conditions;
	private Component fileListPanel;

	public FrontPanel(){
		super();
		init();
	}
	
	private void init(){
		this.setBackground(GetOption.mianPanelColor);
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(GetOption.size_Main_Frame_w,GetOption.size_Main_Frame_h));
		
//		this.add(new JLabel("test"),BorderLayout.NORTH);
		SearchConditionPanel searchPanel = new SearchConditionPanel();
		searchPanel.setFrontPanel(this);
		this.add(searchPanel,BorderLayout.NORTH);
		
//		FileListPanel fileListPanel = new FileListPanel();
//		fileListPanel.getDataTitle();
//		fileListPanel.getData();
//		this.add(fileListPanel.getDataPanel(),BorderLayout.SOUTH);
	}
	
	public void showData(){
//		if(conditions==null||conditions.size()==0){
//			JComponent noDataPanel = new JLabel("no data");
//			this.removeAll();
//			this.add(noDataPanel,BorderLayout.SOUTH);
//		}else{
//			
//		}
		
		FileListPanel fileListPanel = new FileListPanel();
		fileListPanel.getDataTitle();
		fileListPanel.getData(conditions);
		
		if(this.fileListPanel != null){
			this.remove(this.fileListPanel);
		}
		
		this.fileListPanel = fileListPanel.getDataPanel();
		this.add(this.fileListPanel,BorderLayout.SOUTH);
		
//		this.repaint();
//		this.invalidate();
//		this.validate();
		this.updateUI();
	}
	
	public void setConditions(Map<String,String> conditions){
		this.conditions = conditions;
	}
	
}
