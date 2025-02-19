package service;

import java.util.Date;
import java.util.List;

import entity.TaskEntity;
import repository.TaskRepository;

public class TaskServices {
	private TaskRepository taskRepository = new TaskRepository();

	public List<TaskEntity> getAllTasks() {
		return taskRepository.findAllTasks();
	}

	public boolean insertTask(String name, Date start_date, Date end_date, int user_id, int job_id, int status_id) {
		return taskRepository.insertTask(name, start_date, end_date, user_id, job_id, status_id) > 0;
	}

	public boolean updateTask(int id, String name, Date start_date, Date end_date, int user_id, int job_id,
			int status_id) {
		return taskRepository.updateTask(id, name, start_date, end_date, user_id, job_id, status_id) > 0;
	}

	public boolean deleteTask(int id) {
		return taskRepository.deleteTask(id) > 0;
	}

	public TaskEntity getTaskById(int id) {
		return taskRepository.findTaskById(id);
	}
}
