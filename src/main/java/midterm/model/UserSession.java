package midterm.model;

import midterm.model.UserRegistration.Role;

public class UserSession {

	private String username;
	private String email;
	private UserRegistration.Role role;
	private String currentPage;

	public UserSession(String username, String email, String role) {
		super();
		this.username = username;
		this.email = email;
//		this.role = role;
		if("ADMIN".equals(role)) {
			this.role = Role.ADMIN;
			this.currentPage="adminDashboard";
		}else if("CUSTOMER".equals(role)) {
			this.role = Role.CUSTOMER;
			this.currentPage = "userDashboard";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRegistration.Role getRole() {
		return role;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

}
