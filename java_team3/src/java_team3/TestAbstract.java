package java_team3;

/**
 *	상속을 위해 만드는 클래스 이다.
 *	추상클래스는 객체화를 할수 없다. 하지만 is a관계로 객체화는 가능하다
 *	추상method를 생성해 자신 클래스는 반드시 오버라이딩으로 구현하여야 한다
 *	키워드는 abstract
 *	접근지정자 abstract 클래스명
 *	접근지정자 abstract 반환형, method명 ( ) ; 반환형과 매개변수를 가질수 있다.
 *	추상method : 바디가 없다. 일을 할수없다. 그러므로 자식클래스는 반드시 이것을 구현해야하는 의무가 있다.
 *
 * @author KIM
 */
public abstract class TestAbstract  {
	
	//부모의 자원(변수, method 사용할수 있다)
	public String ssn="서울";
	public int age=5;
	
	public String play(int eat) {
		String msg;
		return msg=eat+"주고 밥을 먹는다";
	}//method
	
	//생성자도 가질수 있다.
	public TestAbstract() {
		System.out.println("부모의 생성자 입니다.");
	};
	
	public abstract void study() ;
	public abstract String  study(int i) ; //오버로딩 가능
	
	public static void main(String[] args) {

	}

}
