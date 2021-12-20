package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Model.Task;

class TaskTest {

	
	@Test
	void testTask() {
		Task task = new Task("12345", "Task Name", "Task description");
		
		assertTrue(task != null);
		assertTrue(task.getTaskID().equals("12345"));
		assertTrue(task.getTaskName().equals("Task Name"));
		assertTrue(task.getDescription().equals("Task description"));
	}
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678912345", "Task Name", "Task Description");
		});
	}
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "1234512345123451234512345", "Task Description");
		});
	}
	@Test
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task Name", "This description has to be longer than 50 characters. ");
		});
	}
	

}
