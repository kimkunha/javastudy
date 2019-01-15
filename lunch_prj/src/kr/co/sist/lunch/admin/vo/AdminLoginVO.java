package kr.co.sist.lunch.admin.vo;

public class AdminLoginVO {
	private String id, pass;

	//인자있는것만 만듬
	public AdminLoginVO(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}//생성자

	//getter
	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}
	
	
	
}//class
