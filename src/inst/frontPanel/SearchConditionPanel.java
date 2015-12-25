package inst.frontPanel;

import inst.common.Tools;
import inst.systemCtrl.GetOption;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

public class SearchConditionPanel extends JPanel {
	private static Logger log = Logger.getLogger(SearchConditionPanel.class);
	
	private JTextField textStartDate;
	private JTextField textEndDate;
	private JButton buttonSearch;
	private JTextField textFileName;
	private JTextField textKeyWord;
	public static final String CONDITION_STARTDATE="STARTDATE";
	public static final String CONDITION_ENDDATE="ENDDATE";
	public static final String CONDITION_FILENAME="FILENAME";
	public static final String CONDITION_KEYWORD="KEYWORD";
	
	private FrontPanel frontPanel;
	
	public SearchConditionPanel(){
		super();
		
		init();
	}
	
	private void init(){
		log.info("testlog");
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.setPreferredSize(new Dimension(GetOption.size_SearchConditionPanel_w,GetOption.size_SearchConditionPanel_h));
		GridBagConstraints constraints = new GridBagConstraints();

		//Line 1 *************************************************************************************************************************************************
		//StartDate
		JLabel labelStartDate = new JLabel("START",SwingConstants.RIGHT);
		labelStartDate.setPreferredSize(new Dimension(GetOption.size_Front_Search_date_label_w,GetOption.size_Front_Search_date_label_h));
		textStartDate = new JTextField("");
		textStartDate.setPreferredSize(new Dimension(GetOption.size_Front_Search_date_Text_w,GetOption.size_Front_Search_date_Text_h));
		
		//EndDate
		JLabel labelEndDate = new JLabel("END",SwingConstants.RIGHT);
		labelEndDate.setPreferredSize(new Dimension(GetOption.size_Front_Search_date_label_w,GetOption.size_Front_Search_date_label_h));
		textEndDate = new JTextField("");
		textEndDate.setPreferredSize(new Dimension(GetOption.size_Front_Search_date_Text_w,GetOption.size_Front_Search_date_Text_h));
		
		//buttonSearch
		buttonSearch = new JButton("search");
		buttonSearch.setActionCommand("search");
		buttonSearch.addActionListener(new SearchActionListener());
		
		Tools.addCompnentForGridLayout(this, labelStartDate, constraints, 0, 0, 1, 1);
		Tools.addCompnentForGridLayout(this, textStartDate, constraints, 1, 0, 1, 1);
		Tools.addCompnentForGridLayout(this, labelEndDate, constraints, 2, 0, 1, 1);
		Tools.addCompnentForGridLayout(this, textEndDate, constraints, 3, 0, 1, 1);
		Tools.addCompnentForGridLayout(this, Tools.getBlankLabel(50, 5), constraints, 4, 0, 1, 1);
		Tools.addCompnentForGridLayout(this, buttonSearch, constraints, 5, 0, 1, 1);

		//Line 2 *************************************************************************************************************************************************
		//FileName
		JLabel labelFileName = new JLabel("FileName",SwingConstants.RIGHT);
		labelFileName.setPreferredSize(new Dimension(GetOption.size_Front_Search_date_label_w,GetOption.size_Front_Search_date_label_h));
		textFileName = new JTextField("");
		textFileName.setPreferredSize(new Dimension(GetOption.size_Front_Search_File_Name_Text_w,GetOption.size_Front_Search_File_Name_Text_h));
		Tools.addCompnentForGridLayout(this, labelFileName, constraints, 0, 1, 1, 1);
		Tools.addCompnentForGridLayout(this, textFileName, constraints, 1, 1, 3, 1);

		//Line 3 *************************************************************************************************************************************************
		JLabel labelKeyWord = new JLabel("KeyWord",SwingConstants.RIGHT);
		labelKeyWord.setPreferredSize(new Dimension(GetOption.size_Front_Search_date_label_w,GetOption.size_Front_Search_date_label_h));
		textKeyWord = new JTextField("");
		textKeyWord.setPreferredSize(new Dimension(GetOption.size_Front_Search_File_Name_Text_w,GetOption.size_Front_Search_File_Name_Text_h));
		Tools.addCompnentForGridLayout(this, labelKeyWord, constraints, 0, 2, 1, 1);
		Tools.addCompnentForGridLayout(this, textKeyWord, constraints, 1, 2, 3, 1);
		
	}
	
	private class SearchActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			log.trace("SearchActionListener IN");
			Map<String,String> conditonMap = new HashMap<String,String>();
			if(!"".equals(textStartDate.getText().trim())){
				conditonMap.put(SearchConditionPanel.CONDITION_STARTDATE, textStartDate.getText().trim());
			}
			if(!"".equals(textEndDate.getText().trim())){
				conditonMap.put(SearchConditionPanel.CONDITION_ENDDATE, textEndDate.getText().trim());
			}
			if(!"".equals(textFileName.getText().trim())){
				conditonMap.put(SearchConditionPanel.CONDITION_FILENAME, textFileName.getText().trim());
			}
			frontPanel.setConditions(conditonMap);
			frontPanel.showData();
			log.trace("SearchActionListener OUT");
		}
	}

	public void setFrontPanel(FrontPanel frontPanel) {
		this.frontPanel = frontPanel;
	}

}
