package day0107.Test;

@SuppressWarnings("serial")
public class LoginException extends Exception {
	public LoginException() {
		this("�α��� ����");
	}//������
	
	public LoginException(String msg) {
		super( msg );
	}
	
}//class
