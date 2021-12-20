package Model;

import java.util.HashMap;
import java.util.Map;



public class TaskService {
	
	private static TaskService reference = new TaskService();
	private final Map<String, Task> tasks;
	
	TaskService() {
		this.tasks = new HashMap<String, Task>();
	}
	
	public static TaskService getService() {
		return reference;
	}
	
	public boolean addTask(Task task) {
		boolean isSuccess = false;
		
		if(!tasks.containsKey(task.getTaskID())) {
			tasks.put(task.getTaskID(), task);
			isSuccess = true;
		}
		
		return isSuccess;
	}
	
	public boolean deleteTask(String taskID) {
		return tasks.remove(taskID) != null;
	}
	
	public boolean updateTask(Task task) {
		boolean isSuccess = false;
		
		if(tasks.containsKey(task.getTaskID())) {
			tasks.replace(task.getTaskName(), task);
			tasks.replace(task.getDescription(), task);
			isSuccess = true;
		}
		
		return isSuccess;
	}
	
	public Task getTask(String taskID) {
		return tasks.get(taskID);
	}
}

