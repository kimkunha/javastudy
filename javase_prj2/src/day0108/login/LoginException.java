package day0108.login;
//19.01.07 -3���ڷ�- (����ó�� â �����)
/**
 *	����� ���� ����ó�� Ŭ���� <br>
 *	Exception (��Ȳ������, ���ݿ� ���� RuntimeException) ��ӹ޴´�.
 * @author owner
 */
@SuppressWarnings("serial")
public class LoginException extends Exception{
	public LoginException() {
		this("�α��� ����");
	}//LoginException
	
	public LoginException(String msg) {
		super( msg ); //����ó�� ��ü�� ����Ͽ� ���� �޼����� ����� �� �ִ�.
	}//LoginException
	
}//class

