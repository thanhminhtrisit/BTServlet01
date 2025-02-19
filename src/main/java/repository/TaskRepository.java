package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import config.MySQLConfig;
import entity.JobEntity;
import entity.StatusEntity;
import entity.TaskEntity;
import entity.UserEntity;

public class TaskRepository {

	public List<TaskEntity> findAllTasks() {
		List<TaskEntity> tasks = new ArrayList<>();
		// This query joins tasks with jobs, users, and status to retrieve the names.
		String query = "SELECT t.id, t.name, t.start_date, t.end_date, " + "j.id as job_id, j.name as job_name, "
				+ "u.id as user_id, u.fullname as user_fullname, " + "s.id as status_id, s.name as status_name "
				+ "FROM tasks t " + "JOIN jobs j ON t.job_id = j.id " + "JOIN users u ON t.user_id = u.id "
				+ "JOIN status s ON t.status_id = s.id";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TaskEntity task = new TaskEntity();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setDate(rs.getDate("start_date"));
				task.setEnd_date(rs.getDate("end_date"));

				// Create and set JobEntity
				JobEntity job = new JobEntity();
				job.setId(rs.getInt("job_id"));
				job.setName(rs.getString("job_name"));
				task.setJob_id(job);

				// Create and set UserEntity (assuming your UserEntity has setId and
				// setFullname)
				UserEntity user = new UserEntity();
				user.setId(rs.getInt("user_id"));
				user.setFullname(rs.getString("user_fullname"));
				task.setUser_id(user);

				// Create and set StatusEntity
				StatusEntity status = new StatusEntity();
				status.setId(rs.getInt("status_id"));
				status.setName(rs.getString("status_name"));
				task.setStatus_id(status);

				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	public int insertTask(String name, Date start_date, Date end_date, int user_id, int job_id, int status_id) {
		int count = 0;
		String query = "INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id) VALUES(?,?,?,?,?,?)";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setDate(2, new java.sql.Date(start_date.getTime()));
			statement.setDate(3, new java.sql.Date(end_date.getTime()));
			statement.setInt(4, user_id);
			statement.setInt(5, job_id);
			statement.setInt(6, status_id);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateTask(int id, String name, Date start_date, Date end_date, int user_id, int job_id, int status_id) {
		int count = 0;
		String query = "UPDATE tasks SET name = ?, start_date = ?, end_date = ?, user_id = ?, job_id = ?, status_id = ? WHERE id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setDate(2, new java.sql.Date(start_date.getTime()));
			statement.setDate(3, new java.sql.Date(end_date.getTime()));
			statement.setInt(4, user_id);
			statement.setInt(5, job_id);
			statement.setInt(6, status_id);
			statement.setInt(7, id);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteTask(int id) {
		int count = 0;
		String query = "DELETE FROM tasks WHERE id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public TaskEntity findTaskById(int id) {
		TaskEntity task = null;
		String query = "SELECT t.id, t.name, t.start_date, t.end_date, " + "j.id AS jobId, j.name AS jobName, "
				+ "u.id AS userId, u.fullname AS userFullname, " + "s.id AS statusId, s.name AS statusName "
				+ "FROM tasks t " + "JOIN jobs j ON t.job_id = j.id " + "JOIN users u ON t.user_id = u.id "
				+ "JOIN status s ON t.status_id = s.id " + "WHERE t.id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				task = new TaskEntity();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setDate(rs.getDate("start_date"));
				task.setEnd_date(rs.getDate("end_date"));

				// Create and set JobEntity
				JobEntity job = new JobEntity();
				job.setId(rs.getInt("jobId"));
				job.setName(rs.getString("jobName"));
				task.setJob_id(job);

				// Create and set UserEntity
				UserEntity user = new UserEntity();
				user.setId(rs.getInt("userId"));
				user.setFullname(rs.getString("userFullname"));
				task.setUser_id(user);

				// Create and set StatusEntity
				StatusEntity status = new StatusEntity();
				status.setId(rs.getInt("statusId"));
				status.setName(rs.getString("statusName"));
				task.setStatus_id(status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}

}
