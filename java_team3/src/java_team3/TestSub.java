package java_team3;

/**
 *	TestInheritance의 상속을받은 자식 클래스
 *	자식은 부모의자원(변수, method)를 사용할수 있다.
 *	 @author KIM
 */
public class TestSub extends TestInheritance {
	
	public String eat(int i) {
		String msg =i+"원 을주고 밥을 먹는다.";
		
		return msg;
	}//eat

	public static void main(String[] args) {

		TestSub ts =new TestSub();
		//부모의 인스턴스 변수
		ts.name="철수";	
		ts.age=5;	
		
		//부모의 method
		ts.play();
		
		System.out.println(ts.name);
		System.out.println(ts.age);
		
		System.out.println(ts.play());
		System.out.println(ts.play("빵"));
	}//main

}//class
