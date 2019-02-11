package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import todo.model.Task;
import todo.service.ITaskService;
import todo.service.TaskService;

@Named
@WebServlet("/api/task")
@MultipartConfig
public class TaskAPI extends HttpServlet {

	private Gson gson;
	private ITaskService taskService;

	public TaskAPI() {
		this.taskService = new TaskService();
		this.gson = new Gson();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		setAccessControlHeaders(response);

		System.out.println(this.taskService.taskList());
		String stringJsonTasks = this.gson.toJson(this.taskService.taskList());
		try {
			PrintWriter out = response.getWriter();	
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(stringJsonTasks);
			out.flush(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);  
		Task newTask = new Task();
		newTask.setDescription(request.getParameter("task_description"));
		this.taskService.insertTask(newTask);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		request.getHeaderNames();
		this.taskService.deleteTask(Long.valueOf(request.getParameter("task_id")).longValue());
	}
	
	@Override
	  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task editedTask = this.taskService.findTask(Long.valueOf(request.getParameter("task_id")).longValue());
		editedTask.setDescription(request.getParameter("task_description"));
		this.taskService.editTask(editedTask);
	  }


	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		resp.setHeader("Access-Control-Max-Age", "3600");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Origin, Cache-Control, X-Requested-With");
		resp.setHeader("Access-Control-Allow-Credentials", "true");
	}
}