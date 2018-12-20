package day1203_sub;

/**
 *	abstract부모 클래스 
 *	객체화를 할수 없다. (자식이 객체화하면 사용가능)
 * 	추상method를 생성하면 자식 클래스는 무조선 수행해야 한다.(구현의 강제성???)
 * @author owner
 */
public abstract class AbstractSuper {
	
	int i=130;
	
	public AbstractSuper() {
		System.out.println("부모의 기본 생성자!!!!!!!!!!!!!!!");
	}//생성자
	
	public  void pMethod(int i) {
		if(i>10) {
			i=100;
			System.out.println("당첨~~~");
		}else{ System.out.println("다음 기회에~~");
			
		}//end if
	}//부모 method
	
	//공통으로 사용될 method작성
	public void methodA() {
		System.out.println("부모 method!!");
	}//method
	
	//그리고 추상method작성 해보자
	public  abstract void absmethod();	//자식 클래스는 무조건 구현해야한다.
	public abstract String absmethod1(int i) ;// 반환형 매개변수 있는 추상 메소드
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
