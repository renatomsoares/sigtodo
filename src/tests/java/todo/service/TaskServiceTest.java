package todo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import todo.dao.TaskDAO;
import todo.model.Task;

public class TaskServiceTest {

	private TaskService service;
	private Task task;
	
	@Before
	public void beforeTaskServiceTest() {
		this.service = new TaskService();
		this.task = new Task();
		task.setDescription("Primeira tarefa.");
		service.insertTask(task);
	}
	
	@Test
	public void insertTaskTest(){
		Task newTask = new Task("Tarefa recém inserida.");
		service.insertTask(newTask);
		assertNotNull(this.service.findTask(newTask.getId()));
	}
	
	@Test
	public void createdTaskWithPendingStatusTest(){
		assertEquals(false, this.service.findTask(task.getId()).getCompletedTask());
	}
	
	@Test
	public void updateToTrueTaskStatusTest(){
		
		this.service.updateTaskStatus(task);
		assertEquals(true, this.service.findTask(task.getId()).getCompletedTask());
	}
	
	@Test
	public void createdTaskWithGeneratedRegisterDateTest() {
		assertNotNull(this.service.findTask(task.getId()).getCompletedTask());
	}
	
	@Test
	public void createdTaskWithIdIncrementTest() {
		Task newTask = new Task();
		newTask.setDescription("Segunda tarefa.");
		this.service.insertTask(newTask);
		assertEquals(task.getId().longValue()+1, newTask.getId().longValue());
	}
	
	@Test
	public void editTaskTest() {
		String newDescription = "Primeira tarefa atualizada.";
		task.setDescription(newDescription);
		this.service.editTask(task);
		assertEquals(newDescription, this.task.getDescription());
	}
	
	@Test
	public void deleteTaskTest() {
		this.service.deleteTask(this.task.getId());
		assertNull(this.service.findTask(task.getId()));
	}	
}