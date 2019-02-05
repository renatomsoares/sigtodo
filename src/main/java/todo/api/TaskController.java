/*

package todo.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todo.dao.TaskDAO;
import todo.model.Task;

@RestController
@RequestMapping("/api")	
public class TaskController {

	@Autowired
	private TaskDAO dao = new TaskDAO();


	@RequestMapping(value = "/task/", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> task() {
		List<Task> tasks = dao.taskList();
		if (tasks.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}
}

*/