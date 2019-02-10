package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import com.google.gson.Gson;

import todo.model.Task;
import todo.service.ITaskService;
import todo.service.TaskService;

@Controller
@RequestMapping(value = "/hello")
public class TaskBean {

	private Task task;
	private Gson gson = new Gson();

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
