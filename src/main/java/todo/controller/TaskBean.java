package todo.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import todo.model.Task;
import todo.service.ITaskService;
import todo.service.TaskService;

@Named
@Scope("session")
public class TaskBean {

	private Task task;

	@Inject
	private ITaskService service;

	public TaskBean() {
		this.task = new Task();
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public ArrayList<Task> getTaskList() {
		return (ArrayList<Task>) service.taskList();
	}

	public String addTask() {
		task.setId(null);
		service.insertTask(task);
		task = new Task();
		return "taskList";
	}

	public String fillTask(Task task) {

		Task objEdited = null;

		/* Setting The Particular Teste Details In Session */
		Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		for (Task t : this.getTaskList()) {
			if (t.getId() == task.getId()) {
				objEdited = t;
			}
		}

		sessionMapObj.put("objEdited", objEdited);

		return "editTask";
	}

	public String editTask(Task task) {
		service.editTask(task);
		return "taskList";
	}

	public String deleteTask(Task task) {
		service.deleteTask(task);
		return "taskList";
	}

	public String updateTaskStatus(Task task) {
		service.updateTaskStatus(task);
		return "taskList";
	}
}
