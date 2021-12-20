package Model;

public class Task {
	String taskID;
	String taskName;
	String description;
	
	
	public Task(String taskID, String taskName, String description) {

		//validate inputs against requirements
		boolean isValid = validateInput(taskID, 10);
		
		if(isValid) {
			this.taskID = taskID;
		}
		
		isValid = isValid && setTaskName(taskName);
		isValid = isValid && setDescription(description);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
		}
		
	}
	
	public boolean setTaskName(String taskName) {
		boolean isValid = validateInput(taskName, 20);
		
		if(isValid) {
			this.taskName = taskName;
		}
		
		return isValid;
	}
	
	public boolean setDescription(String description) {
		boolean isValid = validateInput(description, 50);
		
		if(isValid) {
			this.description = description;
		}
		return isValid;
	}
	
	private boolean validateInput(String item, int length) {
		return(item != null && item.length() <= length);
	}
	
	public String getTaskID() {
		return taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getDescription() {
		return description;
	}
}