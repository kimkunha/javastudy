package java_team3;

/**
 *	 is a 관계는 부모를 상속받아서 객체화를 하는것이지만
 *	 has a 관계는 객체로 받아서 그 클래스의 자원을 사용하수 있다.
 *	has a관계는 상속받는것이 아니라 클래스 필드에서 인스턴스를 따로 생성하여 사용하여야 한다.
 *	주로 생성자 안에 넣는듯.
 *
 * @author KIM
 */
public class TestHasa {

	private TestIsa ti;
	public String gun;
	
	public TestHasa() {
		ti=new TestIsa();
	}
	
	public String play() {
		return ti.eat(5000); 
			//has a 관계로 testisa의 자원을 사용	
			//반환형을 같이 맞춰줘야 한다.
	}
	
	
	public static void main(String[] args) {
		TestHasa th=new TestHasa();		
		System.out.println(th.play());
		
	}//main

}//class
