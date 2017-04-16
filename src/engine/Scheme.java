package engine;

import org.json.simple.JSONObject;

public interface Scheme {	
	public void run(int numberOfTargetUser, JSONObject workFlow, Reporter reporter);
}
