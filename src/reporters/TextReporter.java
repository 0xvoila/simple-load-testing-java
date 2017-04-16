package reporters;

import java.util.ArrayList;

import engine.Reporter;
import engine.Task;

public class TextReporter implements Reporter{
	
	int x = 0;
	
	public void appendToReport(Task task){
		// Check the status of task 
		System.out.println(task.getTaskId() + ", " +task.getTaskName() + ", " + task.getTaskStatus() + ", " + task.getTaskTargetLocation());
		System.out.println("\r\n");
		//System.out.println(task.getTaskTargetLocation());
	}
}
