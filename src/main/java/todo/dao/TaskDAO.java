package todo.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import todo.infra.EntityManagerConnection;
import todo.model.Task;

public class TaskDAO implements ITaskDAO {

	EntityManager em = EntityManagerConnection.getInstance();

	public TaskDAO() {
	}

	public void insertTask(Task task){

		try {
			em.getTransaction().begin();
			em.persist(task);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}


	public void deleteTask(Task task){
		try {
			em.getTransaction().begin();
			em.remove(task);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}



	public void editTask(Task task){
		try {
			em.getTransaction().begin();
			em.merge(task);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public List<Task> taskList() {

		List<Task> taskList = (List<Task>)em.createQuery("From Task").getResultList();
		return taskList;
	}
}
