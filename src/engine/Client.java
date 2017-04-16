package engine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Client {
	
	public static void main(String args[]){
		
		
		JSONObject targetLocations = new JSONObject();
		//targetLocations.put("shawacademy", "https://shawacademy.com");
		//targetLocations.put("yahoo", "https://yahoo.com");
		targetLocations.put("shawacademy-lead", "https://live.shawacademy.com/api/v1/leads/(lead)/(registration)?org=shaw");
		
		JSONArray targetLocationArray = new JSONArray();
		targetLocationArray.add(targetLocations);
		
		JSONObject workFlow = new JSONObject();
		workFlow.put("targetLocations", targetLocationArray);
		workFlow.put("csvFileLocation", "/Users/admin/solid/simple-artillery/src/engine/Lead.csv");
		
		HitTarget newHitTarget = new HitTarget(100,workFlow, "Scheme1", "TextReporter");
		newHitTarget.run();
	}
}
