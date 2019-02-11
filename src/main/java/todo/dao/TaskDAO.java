package todo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import todo.infra.EntityManagerConnection;
import todo.model.Task;

@Repository
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

	public void deleteTask(Long id){
		try {
			em.getTransaction().begin();
			em.remove(em.find(Task.class, id));
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

		List<Task> taskList = (List<Task>)em.createQuery("From Task order by registerDate").getResultList();
		return taskList;
	}
	
	public Task findTask(Long id) {

		return em.find(Task.class, id);
	}
}