package schemes;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;

import engine.Reporter;
import engine.Scheme;
import engine.Workflow;

public class Scheme2 implements Scheme{

	@Override
	public void run(int numberOfTargetUser, JSONObject workFlow, Reporter reporter) {
		// TODO Auto-generated method stub
		for(int i = 0; i < numberOfTargetUser; i++){
			
			Workflow wf = new Workflow(workFlow);
			
			Scheme2Executioner scheme2Executioner = new Scheme2Executioner();
			scheme2Executioner.setWorkFlow(wf);
			scheme2Executioner.setReporter(reporter);
			scheme2Executioner.run();
		}
	}

}
