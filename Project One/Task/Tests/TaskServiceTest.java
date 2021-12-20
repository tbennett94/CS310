package Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import Model.Task;
import Model.TaskService;

import static org.junit.jupiter.api.Assertions.*;




class TaskServiceTest {

	private static TaskService tasks;
	
	@BeforeAll
	
	static void setup() {
		tasks = TaskService.getService();
	}
	
	@Test
	void testAddTaskSuccess() {
		Task task = new Task("123", "Task Name", "Task Description");
		assertTrue(tasks.addTask(task));
		
		Task cachedTask = tasks.getTask(task.getTaskID());
		
		assertTrue(cachedTask != null);
		assertTrue(cachedTask.getTaskID().equals("123"));
		assertTrue(cachedTask.getTaskName().equals("Task Name"));
		assertTrue(cachedTask.getDescription().equals("Task Description"));
	}
	
	@Test
	void testTaskDeletionSuccess() {
		Task task = new Task("55", "Task Name", "Task Description");
		
		assertTrue(tasks.addTask(task));
		assertTrue(task != null);
		
		assertTrue(tasks.deleteTask(task.getTaskID()));
		assertTrue(tasks.getTask(task.getTaskID()) == null);
		
	}
	
	@Test
	void testTaskDeletionFailure() {
		String invalidTaskID = "1";
		
		assertFalse(tasks.deleteTask(invalidTaskID));
	}
	
	@Test
	void testTaskUpdate() {
		Task task = new Task("12345", "Test", "Description");
		
		assertTrue(tasks.addTask(task));
		Task updateTask = tasks.getTask(task.getTaskID());
		
		updateTask.setTaskName("Update");
		updateTask = tasks.getTask(updateTask.getTaskID());
		assertTrue(updateTask.getTaskName().equals("Update"));
}
	
}
