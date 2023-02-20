package midterm.model;

public class UserRegistration {
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	private Role role;

	public enum Role {

		ADMIN("admin"), CUSTOMER("customer");

		private final String roleName;

		// private enum constructor
		private Role(String roleName) {
			this.roleName = roleName;
		}
		
		public String getRoleName() {
			return roleName;
		}

	}

	public UserRegistration(String firstname, String lastname, String username, String password, String email,
			Role customer) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = customer;
		this.firstname=firstname;
		this.lastname=lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

}
