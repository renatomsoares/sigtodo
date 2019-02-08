package todo.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import todo.dao.ITaskDAO;
import todo.dao.TaskDAO;
import todo.model.Task;

public class TaskService implements ITaskService {

	ITaskDAO dao = new TaskDAO();

	@Override
	public void insertTask(Task task) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
		task.setRegisterDate(new SimpleDateFormat().format(new Date()));
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

	public void updateTaskStatus(Task task) {
		if (task.getCompletedTask()) {
			task.setCompletedTask(false);
		} else {
			task.setCompletedTask(true);
		}
		
		this.editTask(task);
		
	}
}
