package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.MySQLConfig;
import entity.RoleEntity;

public class RoleRepository {
	public List<RoleEntity> findAll() {
		List<RoleEntity> list = new ArrayList<RoleEntity>();
		String query = "SELECT r.id, r.name, r.description FROM roles r";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				RoleEntity entity = new RoleEntity();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				entity.setDescription(resultSet.getString("description"));
				list.add(entity);
			}
		} catch (Exception e) {
			System.out.println("findAll: " + e.getLocalizedMessage());
		}

		return list;
	}

	public int insertRole(String roleName, String description) {
		int count = 0;
		String queryString = "INSERT INTO roles (name, description) VALUES (?,?)";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(queryString);
			statement.setString(1, roleName);
			statement.setString(2, description);
			count = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertRole: " + e.getLocalizedMessage());
		}
		return count;
	}

	public int deleteRole(int id) {
		int count = 0;
		String query = "DELETE FROM roles WHERE id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			count = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteRole: " + e.getLocalizedMessage());
		}
		return count;
	}

	public int updateRole(int id, String roleName, String description) {
		int count = 0;
		String query = "UPDATE roles SET name = ?, description = ? WHERE id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, roleName);
			statement.setString(2, description);
			statement.setInt(3, id);
			count = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateRole: " + e.getLocalizedMessage());
		}
		return count;
	}

	public RoleEntity findById(int id) {
		RoleEntity role = null;
		String query = "SELECT id, name, description FROM roles WHERE id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				role = new RoleEntity();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));
			}
		} catch (Exception e) {
			System.out.println("findById: " + e.getLocalizedMessage());
		}
		return role;
	}

}
