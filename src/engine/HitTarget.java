package engine;

import org.json.simple.JSONObject;
import schemes.Scheme1;
import schemes.Scheme1Executioner;
import schemes.Scheme2;
import schemes.Scheme2Executioner;

public class HitTarget {
	
	private int numberOfTargetuser = 0;
	private JSONObject workFlow = null;
	private String scheme = null;
	private String reporter = null;
	
	public HitTarget(int numberOfTargetUser, JSONObject workFlow, String scheme, String reporterType){
		this.numberOfTargetuser = numberOfTargetUser;
		this.workFlow = workFlow;
		this.scheme = scheme;
		this.reporter = reporterType;
	}
	
	public void run(){
		Class<?> schemeExecutioner = null;
		Class<?> reporterExecutioner = null;
		try {
			schemeExecutioner = Class.forName("schemes." + this.scheme);
			reporterExecutioner = Class.forName("reporters." + this.reporter);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			Scheme x;
			Reporter y;
			x = (Scheme)schemeExecutioner.newInstance();
			y = (Reporter)reporterExecutioner.newInstance();
			
			// Now instead of passing targetlocation like this, pass the workflow 
			//Workflow workFlow = new Workflow(this.workFlow);
			
			String csvFileLocation = (String)workFlow.get("csvFileLocation");
			if(csvFileLocation != null){
				CSVRecordsHandler.csvRecordHandler = new CSVRecordsHandler(csvFileLocation,0); 
			}
			
			x.run(this.numberOfTargetuser, this.workFlow, y);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
