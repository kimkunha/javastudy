package day1203_sub;

/**
 * 	부모클래스로 상속받고 사용한다. 오버라이딩 연습
 *	자식 클래스 작성
 * @author owner
 */
public class sub2 extends Super{

	public sub2(){
		System.out.println("자식의 생성자");
	}//기본 생성자
	public void methodB() {
		
	}//method
	
	public void printA() {
		System.out.println("이것이 먼저 나오면 오버라이딩 입니다");
	}//method
	
	
}//class
