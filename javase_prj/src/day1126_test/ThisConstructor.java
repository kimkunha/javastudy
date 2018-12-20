package day1126_test;

/**
 *	this method형식 연습
 *	this( ); 아무것도 없으면 기본생성자 ( )안에 값이 들어있으면 인자있는 생성자
 * @author owner
 */
public class ThisConstructor {

	public ThisConstructor() {
//		this(10);  // 이렇게하면 무한루프가 발생된다
		System.out.println("기본 생성자");
	}//기본 생성자
	
	public ThisConstructor(int i) {
		this();
		System.out.println("인자 값 있는 생성자");
	}//인자값이 있는 생성자
	
	public ThisConstructor(int i, int j) {
		this(10);
		System.out.println("인자 값 있는 생성자2222");
	}//인자값이 있는 생성자
	
	//this method형식은 생성자를 호출하는것이기 때문에 this의 진행방향을 잘 이해 해서 사용하자.
	
	
	
	
	public static void main(String[] args) {
		new ThisConstructor(10,15);
		
	}//main

}//class
