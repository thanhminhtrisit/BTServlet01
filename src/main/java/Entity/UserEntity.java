package entity;

public class UserEntity {
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String firstname;
	private String lastname;
	private String avatar;
	private int role_id;
	private RoleEntity role;
	private String phone;

	public UserEntity() {
		super();
	}

	public UserEntity(int id, String email, String password, String fullname, String firstname, String lastname,
			String avatar, int role_id, RoleEntity role, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.avatar = avatar;
		this.role_id = role_id;
		this.role = role;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFirstname() {
		this.setFirstname();
		return firstname;
	}

	public void setFirstname() {
		String fullname = this.fullname;
		String firstname = "";
		if (fullname != null) {
			String[] parts = fullname.trim().split("\\s+");
			firstname = parts[0];
		}
		this.firstname = firstname;
	}

	public String getLastname() {
		this.setLastname();
		return lastname;
	}

	public void setLastname() {
		String fullname = this.fullname;
		String lastname = "";
		if (fullname != null) {
			String[] parts = fullname.trim().split("\\s+");
			if (parts.length > 1) {
				lastname = String.join(" ", java.util.Arrays.copyOfRange(parts, 1, parts.length));
			}
		}
		this.lastname = lastname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
