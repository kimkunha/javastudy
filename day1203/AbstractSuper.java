package day1203;
//18.12.03 수업 5번 자료 (5번~6번 자료 연계)
/**
 *	상속을 목적으로 만드는 부모 클래스.<br>
 *	객체화가 되지 않는다.<br>
 *	자식클래스가 반드시 구현해야 할 abstract method를 가지는 클래스.
 * @author owner
 */
public abstract class AbstractSuper {

	int i;
	
	public AbstractSuper() {
		//자식클래스가 생성될때만 호출 된다.
		System.out.println("AbstractSuper 부모 생성자");
	}//AbstractSuper Constructor
		
	public void method() {
		System.out.println("부모 일을 하는 일반 method");
	}//method
	
	//abstract method는 자식이 반드시 구현해야 할 일의 목록정의
	public abstract void absMethod(); //추상method                      // 바디가 없어서 일을못함 반드시 자식에서 Overriding을 해야한다
	public abstract String absMethod1(int i); //추상method          //반환형 매개변수 가질수 있다.        
	
	
//	public static void main(String[] args) {
//		new AbstractSuper();   //abstract 키워드를 사용하면 객체화가 불가능해 진다.
//			}//main
		
		
		
		
		
		



}//class