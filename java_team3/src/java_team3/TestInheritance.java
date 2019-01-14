package java_team3;

/**
 *	상속 : 부모클래스의 자원(변수, method) 을 자식클래스에서 자신의 것처럼 사용하는것. (코드의 재사용성)
 *			주의점 : private는 쓸수 없다. public사용, 단일상속만 할수 있다. 다중상속 불가능
 *					   생성자는 사용할수 없다.
 *			부모는 자식을 알수 없다. 
 *
 *	super : 부모클래스의 자원을 자식
 * @author KIM
 */
public class TestInheritance {

	public String name;
	public int age;
	
	public String play() {
		String msg=name+"가 공부를 한다.";
		return msg;
	}
	
	//Overload
	public String play(String str) {
		String msg="";
		return msg=name+"가"+str+"을 먹으면서 공부한다.";
	}
	
	public static void main(String[] args) {

		
	}//main

}//class
