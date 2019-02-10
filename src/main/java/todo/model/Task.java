package todo.model;


import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table(name="Task", schema = "public")
public class Task{

	@Id
    @GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String description;
	
	@Column(nullable=false)
	private Boolean completedTask;
	
	@Column(nullable=false)
	private String registerDate;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getCompletedTask() {
		return completedTask;
	}
	
	public void setCompletedTask(Boolean completedTask) {
		this.completedTask = completedTask;
	}
	
	public String getRegisterDate() {
		return registerDate;
	}
	
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	
	@PrePersist
	void preInsert() {
	   if (this.completedTask == null)
	       this.completedTask = false;
	}

}