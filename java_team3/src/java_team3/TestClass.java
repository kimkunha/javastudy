package java_team3;

/**
 *	클래스는 참조형데이터, 사용자정의 자료형 2가지로 나뉘는게 보편적
 *	참조형 데이터형 : 객체를 생성하여 사용
 *	클래스를 사용하기 위해서는 heap 메모리에 객체를 올리는걸 말함
 *	객체를 사용하려면 객체화를 해야 한다
 *	
 * 
 * @author KIM
 */
public class TestClass {

	public TestClass() {
	}

	public void classMethod() {
		
	}
	public static void main(String[] args) {
		//객체화의 5가지 방법
		//1. 클래명 객체명 = new 생성자 객체명으로 여러 기능 사용가능
			TestClass tc=new TestClass();
		//2. new 생성자
			new TestClass();	//객체화로 사용이 끝나는경우 method호출X
		//3. new 생성자.method명
			new TestClass().classMethod(); //객체화 후 method하나만 호출하여 종료하는경우
		//4. is a 관계의 객체화
			//부모테이블명 객체명 =new 자식테이블명 자식 생성자
		//5.innerclass 객체화	
			//바깥클래스명.안쪽클래스명 객체명 =바깥클래스의객체명.new 안쪽클래스의 생성자
			//outer.inner in =out.new inner( );
			
			
			
	}//main

}
