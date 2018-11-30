package day1130;

/**
 *  Override(Overriding)
 *	부모클래스가 제공하는 기능이 자식클래스에 맞지 않는다면
 *	자식클래스에서 부모 클래스의 method와 동일한 method를 정의하여
 *	사용하는 것.
 * @author owner
 */
public class OverrideToString {
	
	@Override				//자주사용할것
	public String toString() {
//		toString();
		return"OverrideToString 클래스"+super.toString();
	}//toString



}//class
