package engine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Client {
	
	public static void main(String args[]){
		
		
		JSONObject targetLocations = new JSONObject();
		targetLocations.put("lead", "https://live.shawacademy.com/api/v1/leads/(lead_id)?org=shaw");
		targetLocations.put("webinar", "https://live.shawacademy.com/api/v1/webinar?campaign_id=(campaign_id)&lead_id=(lead_id)&lesson_id=(lesson_id)");
		targetLocations.put("profile", "https://live.shawacademy.com/api/v1/leads/(lead_id)/profile");
		targetLocations.put("attendance", "https://live.shawacademy.com/api/v1/attendance/lesson/(lesson_id)/registration/(registration_id)");
		
		JSONArray targetLocationArray = new JSONArray();
		targetLocationArray.add(targetLocations);
		
		JSONObject workFlow = new JSONObject();
		workFlow.put("targetLocations", targetLocationArray);
		workFlow.put("csvFileLocation", "/Users/admin/solid/simple-artillery/src/engine/lead.csv");
		
		HitTarget newHitTarget = new HitTarget(100,workFlow, "Scheme1", "TextReporter");
		newHitTarget.run();
	}
}
