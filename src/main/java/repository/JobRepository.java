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

public class JobRepository {

	public List<JobEntity> findAllJobs() {
		List<JobEntity> jobs = new ArrayList<>();
		String query = "SELECT * FROM jobs";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				JobEntity job = new JobEntity();
				job.setId(rs.getInt("id"));
				job.setName(rs.getString("name"));
				job.setDatestart_date(rs.getDate("start_date"));
				job.setEnd_date(rs.getDate("end_date"));
				jobs.add(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public int insertJob(String name, Date start_date, Date end_date) {
		int count = 0;
		String query = "INSERT INTO jobs (name, start_date, end_date) VALUES (?, ?, ?)";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setDate(2, new java.sql.Date(start_date.getTime()));
			statement.setDate(3, new java.sql.Date(end_date.getTime()));
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateJob(int id, String name, Date start_date, Date end_date) {
		int count = 0;
		String query = "UPDATE jobs SET name = ?, start_date = ?, end_date = ? WHERE id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setDate(2, new java.sql.Date(start_date.getTime()));
			statement.setDate(3, new java.sql.Date(end_date.getTime()));
			statement.setInt(4, id);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteJob(int id) {
		int count = 0;
		String query = "DELETE FROM jobs WHERE id = ?";
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

	public JobEntity findJobById(int id) {
		JobEntity job = null;
		String query = "SELECT * FROM jobs WHERE id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				job = new JobEntity();
				job.setId(rs.getInt("id"));
				job.setName(rs.getString("name"));
				job.setDatestart_date(rs.getDate("start_date"));
				job.setEnd_date(rs.getDate("end_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return job;
	}

}
