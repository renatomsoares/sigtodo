package todo.service;

import java.util.List;

import todo.dao.ITaskDAO;
import todo.dao.TaskDAO;
import todo.model.Task;

public class TaskService implements ITaskService {

	ITaskDAO dao = new TaskDAO();

	@Override
	public void insertTask(Task task) {
		dao.insertTask(task);
		
	}

	@Override
	public void deleteTask(Task task) {
		dao.deleteTask(task);	
	}

	@Override
	public void editTask(Task task) {
		dao.editTask(task);	
	}

	@Override
	public List<Task> taskList() {
		return dao.taskList();
	}
}
