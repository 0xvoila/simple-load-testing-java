package schemes;
import engine.Reporter;
import engine.HttpWorkFlowExecutioner;
import engine.Workflow;

public class Scheme3Executioner extends HttpWorkFlowExecutioner implements Runnable{

	private Workflow workFlow = null;
	private Reporter reporter = null;
	
	public void setWorkFlow(Workflow workFlow){
		this.workFlow = workFlow;
	}

	public void setReporter(Reporter reporter){
		this.reporter = reporter;
	}
	public void run(){
		runWorkFlow(this.workFlow, this.reporter);
	}
}
