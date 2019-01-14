package java_team3;

/**
 *	다형성 : 같은대상을 다르게 사용하는 것
 * 				method 다형성, 객체 다형성, 
 * 	method 다형성 : 같은 이름의 method를 다르게 사용하는것 overload, override 지원
 * 		
 * overload : 접근 지정자 반환형,  method명 같이 만들고 parameter만 다르게 작성
 * 				편의성을 향상시켜 준다.
 * 
 * override :	 접근 지정자(광의의 접근지정자), 반환형, method명 parameter 같아야 한다.
 * 				 상위 클래스의 자원이 나한테 맞지 않을때 재정의 하여 사용할때.
 * 
 * 
 * @author KIM
 */
public class TestPolymorphsim {

	
	public void overload() {
		System.out.println("오늘은 일요일");
	}//overload
	
	//접근 지정자, 반환형, method명 parameter 다르게 
	public void overload(int i) {
		System.out.println("오늘은"+i+"일"+ "일요일");
	}//overload
	
	public void override() {
		System.out.println("부모의 자원 override");
	}//override
	
	
	public static void main(String[] args) {
			TestPolymorphsim tp=new TestPolymorphsim();
			tp.overload();
			//오버로딩 으로 코드의 재사용성과 편의성이 높아진다.
			//같은 method명을 사용하지만 method마다 용도가 다르게 사용되며 결과물도 다르게 나타낼수 있다.
			tp.overload(13);
	}//main
}//class
