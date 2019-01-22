package teamlogin.vo;

public class UserInfoVO {

	private String id, password, tel, email;

	public UserInfoVO(String id, String password, String tel, String email) {
		super();
		this.id = id;
		this.password = password;
		this.tel = tel;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "UserInfoVO [id=" + id + ", password=" + password + ", tel=" + tel + ", email=" + email + "]";
	}
	
	
	
	
}//class
