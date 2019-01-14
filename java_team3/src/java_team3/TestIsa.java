package java_team3;

/**
 *	is a 관계 :  부모 클래스명 객체명 = new 자식 클래스의 생성자
 *	자식이 부모를 알기에 객체화가 가능하다.
 *	부모의 자원(변수, method)를 사용할수 있다.
 *	override된 method인 경우 자식의method가 먼저 호출된다.
 * @author KIM
 */
public class TestIsa extends TestSub{
	
//	has a관계로 객체로 받아와 사용할수 있다.
	private TestHasa th;
	
	public TestIsa() {
//		th =new TestHasa();
	}
	
	@Override
	public String eat(int i) {
		String msg=i+"을 주고 라면을 먹는다.";
		
		return msg;
	}//자식 method
	
	@Override
	public String play() {
		String msg=name+"가 게임을 한다.";
		return msg;
	}//자식 method
	
	public static void main(String[] args) {
		TestSub ts= new TestIsa();
		//부모가 상속받은 변수, method도 사용할수 있다.
		ts.name="짱구";
		ts.age=4;
		
		//부모의 method를 사용한다. 맘에 안들어 Overriding로 재정의하여 사용
		ts.eat(500);
		//부모의 자원 이지만 overriding으로 자식 method가 먼저 호출된다.
		ts.play();
		
		System.out.println(ts.name);
		System.out.println(ts.age);
		System.out.println(ts.eat(6000));
		System.out.println(ts.play());
		
		
		
	}//main

}//class
