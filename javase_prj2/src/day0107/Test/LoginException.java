package day0107.Test;

@SuppressWarnings("serial")
public class LoginException extends Exception {
	public LoginException() {
		this("로그인 실패");
	}//생성자
	
	public LoginException(String msg) {
		super( msg );
	}
	
}//class
