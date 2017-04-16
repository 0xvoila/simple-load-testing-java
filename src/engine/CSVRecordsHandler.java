package engine;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CSVRecordsHandler {
    
	public static CSVRecordsHandler csvRecordHandler = null;
	private BufferedReader csvFileHandler = null;
	private ArrayList<String> columnList = null;
	private String csvFileLocation = null;
	public CSVRecordsHandler(String CSVFileLocation,int isSequence){
		
            try {
            	this.csvFileLocation = CSVFileLocation;
				this.csvFileHandler = new BufferedReader(new FileReader(CSVFileLocation));
				String line = this.csvFileHandler.readLine();
				this.columnList = new ArrayList<String>(Arrays.asList(line.split(",")));
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public HashMap<String,String> getReplacedValuesForCSVFields(ArrayList<String> csvFieldsToReplace){
		HashMap<String,String> str = new HashMap<String,String>();
		ArrayList<String> valueArray = getRecordFromCSVFile();
		for(int i=0;i< this.columnList.size();i++){
			str.put(this.columnList.get(i), valueArray.get(i));
		}
		
		return str;
		
	}
	
	private ArrayList<String> getRecordFromCSVFile (){
		
		String line;
		ArrayList<String> valueArray = new ArrayList<String>();
		try {
			line = this.csvFileHandler.readLine();
			if(line == null){
				//this.csvFileHandler.close();
				this.csvFileHandler = new BufferedReader(new FileReader(this.csvFileLocation));
				this.csvFileHandler.readLine();
				line = this.csvFileHandler.readLine();
			}
			 valueArray = new ArrayList<String>(Arrays.asList(line.split(",")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return valueArray;
	}
}
