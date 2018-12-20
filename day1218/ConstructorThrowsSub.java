package day1218;
//18.12.18	-4번 자료- ( 자식 생성자 Throws)
public class ConstructorThrowsSub extends ConstructorThrows{
	//부모클래스의 생성자가 컴파일 예외를 날리면 자식클래스의 생성자에서도 예외를 날려야 한다.
	public ConstructorThrowsSub() throws ClassNotFoundException {
		
//		try {
//		super();	//Super는 무조건 생성자의 첫번째 줄에서만 정의할수 있다. 그러므로 부모클래스의 생성자가
//					// Compile Exception을 throws로 날리면 생성자를 호출하는 자식 클래스에서는 반드시 예외를 처리해야하는 
//					//문법상 에러가 발생하게 된다.
//		}catch(ClassNotFoundException cnfe) {
//			
//		}//end catch
		
	}//end ConstructorThrowsSub
	
	
	
	
	
	
	public static void main(String[] args) {

		
		
	}//main

}//class
