package inst.filesList.fileListCompare;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilter implements FilenameFilter {
	
	private static String[] exceptFiles;
	
	private static String[] exceptFolds;
	
	public FileFilter(){
		//
		exceptFiles = new String[4];

		exceptFiles[0] = "System Volume Information";
		exceptFiles[1] = "$RECYCLE.BIN";
		exceptFiles[2] = "Lotus";
		exceptFiles[3] = ".log";
		
		//
		exceptFolds = new String[2];

		exceptFolds[0] = "D:\\03_01_ã∆ñ±ÉtÉçÅ[";
		exceptFolds[1] = "D:\\00100_åéïÒ";
		
		
	}

	@Override
	public boolean accept(File dir, String name) {
		for(int i=0 ; i<exceptFiles.length ; i++){
			if(exceptFiles[i].equals(name)){
				return false;
			}
		}

		return true;
	}
	
	//
	public boolean isRefusedFold(String path){
		if(path==null){
			return true;
		}
		
		for(int i=0 ; i<exceptFolds.length ; i++){
			if(exceptFolds[i].equals(path)){
				return true;
			}
		}
		
		return false;
	}

}
