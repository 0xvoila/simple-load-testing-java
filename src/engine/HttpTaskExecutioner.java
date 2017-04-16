package engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class HttpTaskExecutioner implements TaskExecutioner{

	@Override
	public void executeTask(Task task, Reporter reporter) {
		BufferedReader br = null;
		// TODO Auto-generated method stub
		try{
			URL obj = new URL(task.getTaskTargetLocation());
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			int responseCode = conn.getResponseCode();
			
			if (200 <= responseCode && responseCode <= 299) {
			    br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			    String response =  br.lines().collect(Collectors.joining());
			    task.setTaskResponse(response);
			    task.setTaskStatus(responseCode);
			} else {
			    br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
			    String response =  br.lines().collect(Collectors.joining());
			    task.setTaskResponse(response);
			    task.setTaskStatus(responseCode);
			}
			
			reporter.appendToReport(task);	
		}
		catch(Exception e){
			reporter.appendToReport(task);
		}
			
		
	}

	
}
