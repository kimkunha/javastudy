package day0108.login;
//19.01.07 -3번자료- (예외처리 창 만들기)
/**
 *	사용자 정의 예외처리 클래스 <br>
 *	Exception (상황에따라, 성격에 따라 RuntimeException) 상속받는다.
 * @author owner
 */
@SuppressWarnings("serial")
public class LoginException extends Exception{
	public LoginException() {
		this("로그인 실패");
	}//LoginException
	
	public LoginException(String msg) {
		super( msg ); //예외처리 객체를 사용하여 예외 메세지를 출력할 수 있다.
	}//LoginException
	
}//class

