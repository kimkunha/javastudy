package day0107_Test;

@SuppressWarnings("serial")
public class LoginException extends Exception {
	public LoginException() {
		this("�α��� ����");
	}//������
	
	public LoginException(String msg) {
		super( msg );
	}
	
}//class
