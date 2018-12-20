package day1203_sub;

/**
 * 	부모클래스로 상속받고 사용한다. 오버라이딩 연습
 *	자식 클래스 작성
 * @author owner
 */
public class sub extends Super{

	public sub(){
		this(100);
//		super(); 안쓰여 있지만 여기에는 부모의 super가 생략되어 있다.
		System.out.println("자식의 생성자");
		}//기본 생성자
	
		public sub(int i){
		super(); //안쓰여 있지만 여기에는 부모의 super가 생략되어 있다.
			System.out.println("자식의 인자 있는생성자"+i);
		}//인자 있는 생성자
		
		
	public void methodA() {
		System.out.println("자식의 매소드");
	}//method
	
	public void printA() {
		System.out.println("이것이 먼저 나오면 오버라이딩 입니다");
	}//method
	
	
}//class
