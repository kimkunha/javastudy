package day1203_sub;

/**
 * InterA, InterB의 상속을 받는다 다중상속
 * 	인터페이스간의 오버라이딩은 하지 않아도 된다.	
 *	상수는 대문자로 해주는 것이 좋다
 *	인터페이스는 일반 메소드를 가질수 없다.
 * @author owner
 */
public interface SuperInterface extends InterA,InterB {
	
	public void methodA(); //추상method 바디를 가지지 않는다
	public abstract void methodB(int i); 
	
	
	
	
}//interface
