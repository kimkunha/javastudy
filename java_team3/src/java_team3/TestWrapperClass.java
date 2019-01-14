package java_team3;

/**
 *	기본형데이터를 참조형데이터로 사용할수 있게 객체로 사용
 *	기본형데이터들이 객체형으로 사용되어야 할 경우 
 * @author KIM
 */
public class TestWrapperClass {
	
	public static Integer integer1=100;
	public static Integer integer2;
	public TestWrapperClass() {
		System.out.println(integer1);
		System.out.println(integer2); //객체의 초기값 null
	}
	
	public static void main(String[] args) {
		new TestWrapperClass();
	}//main

}//class
