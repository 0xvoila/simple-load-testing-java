package schemes;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;

import engine.Reporter;
import engine.Scheme;
import engine.Workflow;


public class Scheme1 implements Scheme{

	@Override
	public void run(int numberOfTargetUser, JSONObject workFlow, Reporter reporter) {
		// TODO Auto-generated method stub
		System.out.println("Calling from scheme 1");
		
		for(int i = 0; i < numberOfTargetUser ; i ++ ){
			Workflow wf = new Workflow(workFlow);
			
			Scheme1Executioner scheme1Executioner = new Scheme1Executioner();
			scheme1Executioner.setWorkFlow(wf);
			scheme1Executioner.setReporter(reporter);
			Thread t1 = new Thread(scheme1Executioner);
			t1.start();
		}
	}
	
}
