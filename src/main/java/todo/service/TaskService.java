package todo.service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import todo.dao.ITaskDAO;
import todo.dao.TaskDAO;
import todo.model.Task;

@Service
public class TaskService implements ITaskService {

	private ITaskDAO dao = new TaskDAO();

	@Override
	public void insertTask(Task task) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
		task.setRegisterDate(new Date());
		dao.insertTask(task);
	}
	
	@Override
	public void deleteTask(Long id) {
		dao.deleteTask(id);	
	}

	@Override
	public void editTask(Task task) {
		dao.editTask(task);	
	}

	@Override
	public List<Task> taskList() {
		return dao.taskList();
	}

	public void updateTaskStatus(Task task) {
		if (task.getCompletedTask()) {
			task.setCompletedTask(false);
		} else {
			task.setCompletedTask(true);
		}
		
		this.editTask(task);
		
	}

	@Override
	public Task findTask(Long id) {

		return dao.findTask(id);
	}
}