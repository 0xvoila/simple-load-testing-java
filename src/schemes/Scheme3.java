package schemes;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;

import engine.Reporter;
import engine.Scheme;
import engine.Workflow;

public class Scheme3 implements Scheme{

	@Override
	public void run(int numberOfTargetUser, JSONObject workFlow, Reporter reporter) {
		// TODO Auto-generated method stub
		int loopCount = 0;
		while(loopCount < 4){
			for(int i =0; i < numberOfTargetUser; i++){
				Workflow wf = new Workflow(workFlow);
				
				Scheme3Executioner scheme3Executioner = new Scheme3Executioner();
				scheme3Executioner.setWorkFlow(wf);
				scheme3Executioner.setReporter(reporter);
				Thread t1 = new Thread(scheme3Executioner);
				t1.start();
			}
			loopCount = loopCount + 1;
			// Sleep for two minutes
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
