package engine;

public interface WorkFlowExecutioner {

	public void runWorkFlow(Workflow workflow, Reporter reporter);
	public Task getNextTaskInWork(Task previousTaskDone);
	public boolean hasWorkFlowNextTask(Task previousTaskDone);
	
}
