package engine;

import java.util.Random;

public class Task {

	private int taskId;
	private String taskName = null;
	private String taskTargetLocation = null;
	private int taskStatusCode;
	private Object taskResponse = null;
	
	public Task(){
		Random rand = new Random(); 
		int value = rand.nextInt(50);
		this.taskId = value;
	}
	
	public void setTaskTargetLoation(String targetLocation){
		this.taskTargetLocation = targetLocation;
	}
	
	public void setTaskName(String taskName){
		this.taskName = taskName;	
	}
	
	public void setTaskStatus(int taskStatusCode){
		this.taskStatusCode = taskStatusCode;
	}
	
	public void setTaskResponse(Object response){
		this.taskResponse = response;
	}
	
	public int getTaskId(){
		return this.taskId;
	}
	
	public String getTaskName(){
		return this.taskName;
	}
	public int getTaskStatus(){
		return this.taskStatusCode;
	}
	public String getTaskTargetLocation(){
		return this.taskTargetLocation;
	}
	
	public Object getTaskResponse(){
		return this.taskResponse;
	}
}
