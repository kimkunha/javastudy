package day1126;

/**
 * 클래스가 객체로 생성 될때 기본적으로 가지고 있어야 할 기본값을 설정하거나 기본적으로 수행될 코드를 정의하는 method 일종
 * 
 * @author owner
 */
public class TestConstructor {

	/**
	 * 	기본생성자 : 클래스 작성할때 생성자를 하나도 정의하지 않으면
	 * 컴파일러가 매개변수 없는 Default Constructor를 생성한다
	 */
	public TestConstructor() {
		System.out.println("기본 생성자");
//		TestConstructor(300);// 생성자를 method 호출하듯 호출할 수 없다.
	
	}// TestConstructor
	
	/**
	 * 	인자있는 생성자	(외부의 값을 입력받는다)
	 * @param i	임의의 값
	 */
	public TestConstructor(int i) {
		System.out.println("인자 있는 생성자"+i);
	}// TestConstructor

	public void test() {
		System.out.println("test method");
		temp();//method 호출
		typeA();// 클래스내의 생성된 다른 메소드를 이런식으로 호출해서 같이 출력 할수 있다.
	}//test			인스턴스 method이며 고정적인 값
	
	public void temp() {
		System.out.println("------temp method!!");
	}//temp
	
	public void typeA() {
		System.out.println("안녕하세요?");
	
	}
	public static void main(String[] args) {
		//Overloading 된 생성자를 사용하여 객체화를 다양하게 할 수 있음
		TestConstructor tc = new TestConstructor();	// 기본생성자
		TestConstructor tc1 = new TestConstructor(26);	// 인자있는 생성자
		
		System.out.println(tc);	
		System.out.println(tc1);	//객체를 출력하면 주소가 나온다.
		System.out.println("==============================구분점=======================================");
		tc.test();
		
		
		
	}// main
}// class
