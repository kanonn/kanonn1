package inst.filesList.fileListCompare;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class LogicReadFileList {
	
//	private static String[] exceptFiles;
//	
//	static{
//		exceptFiles = new String[1];
//		exceptFiles[0] = "System Volume Information";
//	}
	
	public List<String> getFileListForA(String path){
		List<String> fileListTemp = new ArrayList<String>();
		
		if(path==null){
			return fileListTemp;
		}

		FileFilter filter = new FileFilter();
		
		if(filter.isRefusedFold(path)==true){
			return fileListTemp;
		}
		
		File file = new File(path);
		if(!file.canRead()){
			return fileListTemp;
		}
		
		if(file.isFile()){
			fileListTemp.add(file.getAbsolutePath());
		}else{
			File[] filesArray = file.listFiles(filter);
			
			if(filesArray==null){
				return fileListTemp;
			}
			
			for(int i=0 ; i<filesArray.length ; i++){
				if(filesArray[i].canRead()==false){
					continue;
				}
				if(filesArray[i].canWrite()==false){
					continue;
				}
				if(filesArray[i].canExecute()==false){
					continue;
				}
				
				if(filesArray[i].isDirectory()){
					fileListTemp.addAll(getFileListForA(filesArray[i].getAbsolutePath()));
				}else{
					fileListTemp.add(filesArray[i].getAbsolutePath());
				}
			}
		}
		
		return fileListTemp;
		
	}

}
