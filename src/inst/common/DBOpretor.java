package inst.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBOpretor {

	private Connection conn = null;
	private PreparedStatement pstat = null;
	private ResultSet rs = null;

	private String url = "jdbc:db2://172.28.24.208:20020/BWPRO";
	private String user = "upinst3";
	private String pass = "upinst3";
	
	private String SQLSelect = "";
	private List<String> parameter = null;
	
	private Connection getConnection(){
		try {
			this.conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("conn success");
		return this.conn;
	}
	
//	private
	public List<List<String>> getResultSelect(){
		List<List<String>> resultAll = new ArrayList<List<String>>();
		
		try {
			getConnection();
			pstat = conn.prepareStatement(SQLSelect);
			if(parameter!=null){
				for(int i=1 ; i<=parameter.size() ; i++){
					pstat.setString(i, parameter.get(i-1));
				}
			}
			
			System.out.println(SQLSelect);
			rs = pstat.executeQuery();
			
			System.out.println(String.valueOf(rs.getMetaData().getColumnCount()));
			System.out.println();
		
			int colCount = rs.getMetaData().getColumnCount();
			while(rs.next()){
				List<String> resultLine = new ArrayList<String> ();
				for(int i=1 ; i<=colCount ; i++){
					resultLine.add(rs.getString(i));
				}
				resultAll.add(resultLine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
		return resultAll;
	}
	
	public void closeAll(){
		try {
			this.rs.close();
			this.pstat.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setSQLSelect(String sQLSelect) {
		SQLSelect = sQLSelect;
	}

	public void setParameter(List<String> parameter) {
		this.parameter = parameter;
	}
	
	public String printSQLLog(){
		String strResultSQL = SQLSelect;
		for(String para : parameter){
			strResultSQL = strResultSQL.replaceFirst("\\?", "'"+para+"'");
		}

		System.out.println("parameter.size() : " + parameter.size());
		System.out.println("SQLSelect : " + SQLSelect);
		System.out.println(strResultSQL);
		
		return strResultSQL;
	}

}
