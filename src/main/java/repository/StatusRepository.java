package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.MySQLConfig;
import entity.StatusEntity;

public class StatusRepository {
	public List<StatusEntity> findAll() {
		List<StatusEntity> statuses = new ArrayList<>();
		String query = "SELECT id, name FROM status";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				StatusEntity status = new StatusEntity();
				status.setId(rs.getInt("id"));
				status.setName(rs.getString("name"));
				statuses.add(status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statuses;
	}
}
