package todo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import todo.dao.TaskDAO;
import todo.model.Task;

public class TaskDAOTest {

	private TaskDAO dao;
	private Task task;
	
	private Task newTask(String description) {
		Task task = new Task(description);
		task.setRegisterDate(new Date());
		return task;
	}
	
	@Before
	public void beforeTaskServiceTest() {
		this.dao = new TaskDAO();
		this.task = newTask("Primeira tarefa.");
		dao.insertTask(task);
	}
	
	@Test
	public void insertTaskTest() {
		Task newTask = newTask("Nova tarefa.");
		this.dao.insertTask(newTask);
		assertNotNull(this.dao.findTask(newTask.getId()));
	}
	
	@Test
	public void updateTaskTest() {
		String newDescription = "Nova descrição.";
		this.task.setDescription(newDescription);
		dao.editTask(task);
		assertEquals(newDescription, this.dao.findTask(task.getId()).getDescription());
	}
	
	@Test
	public void findTaskTest() {
		assertNotNull(dao.findTask(task.getId()));
	}

	@Test
	public void deleteTaskTest() {
		dao.deleteTask(task.getId());
		assertNull(dao.findTask(task.getId()));
	}
}