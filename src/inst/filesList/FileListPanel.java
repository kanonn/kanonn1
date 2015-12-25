package inst.filesList;

import inst.common.DBOpretor;
import inst.frontPanel.SearchConditionPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class FileListPanel {
	
	private String[][] tableData;
	private String[] tabletitle;
	private JComponent dataPanel;

	public void getData(Map<String,String> conditonMap){
		StringBuffer sql = new StringBuffer("SELECT file_name FROM TEMP_JAVA_SOURCE_BYP WHERE 1=1");
		List<String> condition = new ArrayList<String>();
		
		
		
		if(conditonMap!=null&&conditonMap.size()>0){
			if(conditonMap.get(SearchConditionPanel.CONDITION_STARTDATE) != null){
				sql.append(" AND update_time >= ?");
				condition.add(conditonMap.get(SearchConditionPanel.CONDITION_STARTDATE));
			}
			if(conditonMap.get(SearchConditionPanel.CONDITION_ENDDATE) != null){
				sql.append(" AND update_time <= ?");
				condition.add(conditonMap.get(SearchConditionPanel.CONDITION_ENDDATE));
			}
			if(conditonMap.get(SearchConditionPanel.CONDITION_KEYWORD) != null){
				sql.append(" AND note LIKE ?");
				condition.add(conditonMap.get(SearchConditionPanel.CONDITION_KEYWORD));
			}
			if(conditonMap.get(SearchConditionPanel.CONDITION_FILENAME) != null){
				sql.append(" AND note LIKE ?");
				condition.add("%"+conditonMap.get(SearchConditionPanel.CONDITION_FILENAME)+"%");
			}
			
			DBOpretor db = new DBOpretor();
			db.setSQLSelect(sql.toString());
			db.setParameter(condition);
			db.printSQLLog();
			List<List<String>> listResAll = db.getResultSelect();
			
			if(listResAll.size()>0){
				tableData = new String[listResAll.size()][listResAll.get(0).size()];
				
				for(int i=0 ; i<listResAll.size() ; i++){
					for(int j=0 ; j<listResAll.get(0).size() ; j++){
						tableData[i][j] = listResAll.get(i).get(j);
					}
				}
			}
			
			
//			for(List<String> listData : listResAll){
//				for(String str : listData){
//					System.out.println(str);
//				}
//				System.out.println("-----------------------------------------------");
//			}
			
			
			
		}else{
			dataPanel = new JLabel("no data");
		}
	}

	public void getDataTitle(){
		String[] tableDataTitle = new  String[1];
		tableDataTitle[0]="A";
//		tableDataTitle[1]="B";
		
		this.tabletitle = tableDataTitle;
	}
	
	public JComponent getDataPanel(){
		JComponent dataPanel;
		
		if(tableData==null){
			dataPanel = new JLabel("no data");
		}else{
			TableModel dataTableModel = new DefaultTableModel(this.tableData, this.tabletitle);
			JTable data = new JTable(dataTableModel);
			
			dataPanel = new JScrollPane(data);
		}
		
		return dataPanel;
	}
}
