package java_team3;

/**
 *	인터페이스를 구현해야 하는  클래스
 *	키워드가 implements
 *	구현해야하는 인터페이스가 부모를 상속받고 있다면 그 부모까지 전부 추상method를 구현해야하는 의무가 있다.
 * @author KIM
 */
public class TestInterfacesub implements TestInterface {

	//구현해야 하는 추상method를 Overriding해야하는 의무가 있음.
	@Override
	public void eat() {
		System.out.println("배고픕니다.");
	}
	
	public static void main(String[] args) {
		TestInterfacesub tf=new TestInterfacesub();
		tf.eat();
	}//main

}//class
