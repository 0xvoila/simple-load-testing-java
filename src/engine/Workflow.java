package engine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Workflow {
	
	private boolean isWorkFlowDynamic = false;
	private ArrayList<Task> taskList = null;
	private CSVRecordsHandler csvRecordsHandler = null;
	
	public Workflow(JSONObject workFlow){
		
		JSONArray targetLocations = (JSONArray)workFlow.get("targetLocations");
		this.csvRecordsHandler = CSVRecordsHandler.csvRecordHandler;
		
		this.taskList = new ArrayList<Task>();
		for(int i=0; i < targetLocations.size(); i++){
			JSONObject jsonObj = (JSONObject)targetLocations.get(i);
			for (Object taskName : jsonObj.keySet()) {
		        
				Task newTask = new Task();
		        String taskNameStr = (String)taskName;
		        newTask.setTaskName(taskNameStr);
		        String taskTargetLocation = (String)jsonObj.get(taskNameStr);
		        newTask.setTaskTargetLoation(taskTargetLocation);
		        this.taskList.add(newTask);
		    }
		}
		
	}
	
	public Task getNextTaskInWorkFlow(Task task){
		
		Task nextTask = null;
		
		if(task == null){
			nextTask = taskList.get(0);
			Task serializedTask = serializeTask(nextTask);
			nextTask = serializedTask;
		}
		else{
			for(int i=0; i<taskList.size();  i++){
				if((task.getTaskId() == taskList.get(i).getTaskId()) && (i<taskList.size()-1)){
					nextTask = taskList.get(i + 1);
					Task serializedTask = serializeTask(task, nextTask);
					nextTask = serializedTask;
				}
			}	
		}	
		
		return nextTask;
	}
	
	public Task serializeTask(Task thisTask){
		String targetLocation = thisTask.getTaskTargetLocation();
		if(this.csvRecordsHandler != null){
			TargetLocationParser targetLocationParser = new TargetLocationParser();
			ArrayList<String> keywordsToReplace = targetLocationParser.getPlaceHoldersInTargetLocation(targetLocation);
			if(keywordsToReplace.isEmpty()){
				thisTask.setTaskTargetLoation(targetLocation);
			}
			else{
				// Fetch the values for keywordsToReplace from CSV File 
				HashMap<String,String> replacableValues = this.csvRecordsHandler.getReplacedValuesForCSVFields(keywordsToReplace);
				targetLocation = targetLocationParser.setKeywordsValues(replacableValues, thisTask.getTaskTargetLocation());
				thisTask.setTaskTargetLoation(targetLocation);
			}
		}
			 
		return thisTask;
	}
	
	public Task serializeTask(Task previousTask, Task thisTask){
		return thisTask;
	}
	
	public boolean hasWorkFlowNextTask(Task task){
		
		boolean hasNextTask = false;
		if(task == null && taskList.size()  > 0){
			hasNextTask = true;
		}
		
		else {
			for(int i=0; i<taskList.size();  i++){
				if((task.getTaskId() == taskList.get(i).getTaskId()) && (i<taskList.size()-1)){
					hasNextTask = true;
				}
			}	
		}
	
		return hasNextTask;
	
	}
}
