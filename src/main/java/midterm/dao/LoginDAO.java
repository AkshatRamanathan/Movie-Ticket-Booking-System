package midterm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import midterm.model.UserRegistration;
import midterm.model.UserSession;

public class LoginDAO {

	private Connection connection;

	public LoginDAO() {

	}

	public UserSession updateDetails(UserSession user, String username, String email) {
		PreparedStatement pst = null;
		try {
			connection = DatabaseConnector.getInstance().getConnection();
			pst = connection.prepareStatement("UPDATE users SET username=?, email=? WHERE username=?");
			pst.setString(1, username);
			pst.setString(2, email);
			pst.setString(3, user.getUsername());
			pst.executeUpdate();
			user.setUsername(username);
			user.setEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;

	}

	public void updatePassword(String oldPassword, String newPassword) {
		PreparedStatement pst = null;
		try {
			connection = DatabaseConnector.getInstance().getConnection();
			pst = connection.prepareStatement("UPDATE users SET password=MD5(?) WHERE password=MD5(?)");
			pst.setString(1, newPassword);
			pst.setString(2, oldPassword);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public UserSession validateLogin(String username, String password) {
		PreparedStatement pst = null;
		UserSession userSession = null;

		try {
			connection = DatabaseConnector.getInstance().getConnection();
			pst = connection.prepareStatement("SELECT * FROM users WHERE username=? and password=MD5(?)");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String usernameFromDB = rs.getString("username");
				String emailFromDB = rs.getString("email");
				String roleFromDB = rs.getString("role");
				userSession = new UserSession(usernameFromDB, emailFromDB, roleFromDB);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userSession;
	}

	public boolean registerUser(UserRegistration user) {
		boolean flag = false;
		PreparedStatement pst = null;
		try {
			connection = DatabaseConnector.getInstance().getConnection();
			pst = connection.prepareStatement(
					"INSERT INTO users(username,firstname,lastname,password,email,role) value(?,?,?,MD5(?),?,?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getFirstname());
			pst.setString(3, user.getLastname());
			pst.setString(4, user.getPassword());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getRole().toString());
			int row = pst.executeUpdate();
			if (row > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;

	}

}
