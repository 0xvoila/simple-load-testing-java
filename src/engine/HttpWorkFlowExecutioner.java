package engine;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpWorkFlowExecutioner implements WorkFlowExecutioner{

	private String targetLocation = null;
	private Task previousTaskDone = null;
	private Workflow workFlow = null;
	private Reporter reporter = null;
	private HttpTaskExecutioner httpTaskExecutioner = null; 
	
	public void runWorkFlow(Workflow workFlow, Reporter reporter){

		this.workFlow = workFlow;
		this.reporter = reporter;
		this.httpTaskExecutioner = new HttpTaskExecutioner();
		
		while(hasWorkFlowNextTask(previousTaskDone)){
			previousTaskDone = getNextTaskInWork(previousTaskDone);
			try{
				 httpTaskExecutioner.executeTask(previousTaskDone, reporter);	
			}
			catch(Exception e){
			
			}
		}		
	}
	
	public Task getNextTaskInWork(Task previousTaskDone){
		Task task = this.workFlow.getNextTaskInWorkFlow(previousTaskDone);
		//System.out.println(task);
		return task;
	}
	
	public boolean hasWorkFlowNextTask(Task previousTaskDone){
		return this.workFlow.hasWorkFlowNextTask(previousTaskDone);
	}
	
}
