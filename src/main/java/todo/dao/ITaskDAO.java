package todo.dao;

import java.util.List;

import todo.model.Task;

public interface ITaskDAO {
	
	public void insertTask(Task task);
	public void deleteTask(Task task);
	public void editTask(Task task);
	public List<Task> taskList();
}
