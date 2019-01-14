package java_team3;

/**
 *	추상클래스를 상속받은 자식 클래스
 *	자식은 부모클래스의 추상method를 구현해야 할 의무가 있다.
 * @author KIM
 */
public class TestabstractSub extends TestAbstract {

	
	public TestabstractSub() {
		super();
	}//생성자
	
	

	@Override
	public void study() {
		System.out.println("자식은 반드시 부모의 추상 method를 구현하여아 한다.");
	}

	@Override
	public String study(int i) {
		String msg;
		return msg=i+"원 을 주고 택성이는 공부중이다.";
	}
	
	
	public static void main(String[] args) {
		TestabstractSub tbs=new TestabstractSub();// 
		//부모의 생성자와 자원(변수, 메소드 사용가능)
		System.out.println(tbs.age);
		System.out.println(tbs.ssn);
		System.out.println(tbs.play(5000));
		
		tbs.study();
		System.out.println(tbs.study(300));
		
		
//		TestAbstract tb=new TestAbstract() is a 관계의 객체화 가능하다.
			
			
		
	}//main

}//end 