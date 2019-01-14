package java_team3;

/**
 *	모든 생성자의 첫번째 줄에는 부모 클래스의 기본 생성자를 호출하는 super를 가지고 있다.
 *	super는 method형식과 keyword 형식 두가지로 사용이 가능하다
 *	method형식 :
 *	부모클래스의 생성자를 호출할수 있다 생성자의 첫번째 줄에 정의할수있다. this()하고 같이 사용못함.
 *	super와 this는 근복적으로 같다.
 *
 * @author KIM
 */
public class TestSuper {

	public String name;
	public int number;

	public void superMethod() {
		System.out.println("부모의 생성자");
	}
	
	
	public TestSuper() {
		this(10);
		System.out.println("인자 없는 생성자");
	}
	
	public TestSuper( int i) {
		System.out.println("인자 있는 부모 생성자 200");
	}
	
	
//	public static void main(String[] args) {
//		TestSuper ts=new TestSuper();
		
//	}//main

}//class
