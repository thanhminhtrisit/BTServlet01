package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.MySQLConfig;
import entity.RoleEntity;
import entity.UserEntity;

public class UserRepository {
	public int insertUser(String fullname, String password, String email, String phone, int roleId) {
		String query = "INSERT INTO users(fullname,email,password, phone,role_id) VALUES(?,?,?,?,?)";
		int count = 0;
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, fullname);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setString(4, phone);
			statement.setInt(5, roleId);

			count = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("findAll: " + e.getLocalizedMessage());
		}

		return count;
	}

	public List<UserEntity> findAllUser() {
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		String query = "SELECT u.id, u.fullname, u.email, r.description FROM users u JOIN roles r ON u.role_id = r.id";

		Connection connection = MySQLConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				UserEntity entity = new UserEntity();
				entity.setId(result.getInt("id"));
				entity.setEmail(result.getString("email"));
				entity.setFullname(result.getString("fullname"));

				RoleEntity roleEntity = new RoleEntity();
				roleEntity.setDescription(result.getString("description"));

				entity.setRole(roleEntity);

				userEntities.add(entity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userEntities;
	}

	public int deleteUser(int id) {
		int count = 0;
		String query = "DELETE FROM users WHERE id = ?";
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

	public int updateUser(int id, String fullname, String email, String phone, int roleId) {
		int count = 0;
		String query = "UPDATE users SET fullname = ?, email = ?, phone = ?, role_id = ? WHERE id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, fullname);
			statement.setString(2, email);
			statement.setString(3, phone);
			statement.setInt(4, roleId);
			statement.setInt(5, id);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public UserEntity findUserById(int id) {
		UserEntity user = null;
		String query = "SELECT id, fullname, email, phone, role_id FROM users WHERE id = ?";
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				user = new UserEntity();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRole_id(rs.getInt("role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
