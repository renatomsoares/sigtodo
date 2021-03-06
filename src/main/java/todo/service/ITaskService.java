package todo.service;

import java.util.List;

import todo.model.Task;

public interface ITaskService {
	
	public void insertTask(Task task);
	public void deleteTask(Long id);
	public void editTask(Task task);
	public List<Task> taskList();
	public void updateTaskStatus(Task task);
	public Task findTask(Long id);
}

