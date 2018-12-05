package day1203_sub;

/**
 *	abstract의 부모클래스를 상속받아 사용해보자
 *	추상method는 무조건 전부 구현해야한다.
 * @author owner
 */
public class AbstractSub extends AbstractSuper {			//에러뜨는 이유는 추상method를 정의하지 않아서 이다
		//자식의 메소드, 변수 선언해보자
		int number;
		int score;
		String name;
		String grade;
	
		public String gradeMethod(int score) {
			return String.valueOf(score).concat("등급");
		}//자식 method
		
	
	//먼저 부모클래스의 추상method2가지를 정의해보자
		@Override
		public void absmethod() {
			System.out.println("abstract Overriding 된자식 메소드 안녕하세요");
		}//추상method 
		
		public String absmethod1(int i) {	//매개변수를 int로 받아서 String.ValueOf로 기본형데이터를 문자열로 변경해줘야 한다.
			
			return String.valueOf(i).concat("안녕~");
		}//end
	
	
	public static void main(String[] args) {
		//자식 테이블로 먼저 객체화 진행
		AbstractSub as= new AbstractSub();	//부모의 생성자를 가져온다.. 
		as.absmethod();
		System.out.println(as.absmethod1(10));  //자식 method 출력
		as.pMethod(5);//부모 method를 사용해봄.
		as.methodA();  // 부모의 추상클래스에서 공통된 method사용
		System.out.println("-------------------------------------------------------------");
		//is a 관계 객체화
		AbstractSuper abs= new AbstractSub();
		//부모테이블로 오버라이딩된 method 사용해보자
		abs.i=12;
		System.out.println("abs.i = "+abs.i);
		abs.absmethod();
		System.out.println(abs.absmethod1(14));
		abs.methodA();
		abs.pMethod(5);
		
		
		
		
		
		
	}//main

}//class
