package java_team3;

/**
 *	자바에서는 클래스 간의 다중상속이 불가능한것을 인터페이스로 다중상속을 가능하게 함
 *	인터페이스는 상수와, 추상method만 가진다.
 *	인터페이스는 부모를 여러개 둘수 있다. 인터페이스간의 상속관계는추상method를 구현 하지 않는다.
 *	단 상속받는 클래스는 모든 부모의 추상method를 구현해야하는 의무가 있다.
 *
 *	
 * @author KIM
 */
public interface TestInterface {

	//상수와 추상method를 가질수있다.
	public static int i=100;

	//추상method
	public abstract void eat();
	
	
}
