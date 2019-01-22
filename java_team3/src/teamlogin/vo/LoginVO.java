package teamlogin.vo;

public class LoginVO {

	private String id, password;

	public LoginVO(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", password=" + password + "]";
	}
	
	
}//class
