package entity;

import java.util.Date;

public class TaskEntity {
	private int id;
	private String name;
	private Date date;
	private Date end_date;
	private JobEntity job_id;
	private UserEntity user_id;
	private StatusEntity status_id;

	public TaskEntity() {
		super();
	}

	public TaskEntity(int id, String name, Date date, Date end_date, JobEntity job_id, UserEntity user_id,
			StatusEntity status_id) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.end_date = end_date;
		this.job_id = job_id;
		this.user_id = user_id;
		this.status_id = status_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public JobEntity getJob_id() {
		return job_id;
	}

	public void setJob_id(JobEntity job_id) {
		this.job_id = job_id;
	}

	public UserEntity getUser_id() {
		return user_id;
	}

	public void setUser_id(UserEntity user_id) {
		this.user_id = user_id;
	}

	public StatusEntity getStatus_id() {
		return status_id;
	}

	public void setStatus_id(StatusEntity status_id) {
		this.status_id = status_id;
	}

}
