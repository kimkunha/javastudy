package day1218;
//18.12.18	-1번 자료- (Compile Exception)
/**
 *	Compile Exception : byte code를 정상적으로 생성하기 위한것.
 *	개발자가 반드시 예외상황을 처리해야 하는 예외.
 * @author owner
 */
public class UseCompileException {


	public static void main(String[] args) {
		//new를 하지 않고도 객체를 얻어서 쓸수있는 방법
		
		try {
//			Object obj=Class.forName("java.lang.String");		//워닝이 뜨면 2번째 try로 처리 할수 있다.
			Object obj=Class.forName("day1217.UseRuntimeException");		//워닝이 뜨면 2번째 try로 처리 할수 있다.
			System.out.println("로딩한 클래스"+obj);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("죄송합니다.");
			System.err.println("예외 메세지 출력 : "+cnfe.getMessage() );	//getMessage를 부르면 예외메세지를 출력할수 있다.
			System.err.println("예외처리 객체와 메세지 : "+cnfe);
			cnfe.printStackTrace();
//			System.out.println("--------");		//println은 printStackTrace보다 먼저 출력된다.
			
			//예외 발생하면 다른것 보다도 내가만든 클래스를 본다. 무조건 볼것..
			// 모르면 구글링해서 찾아볼것.
			
		}finally {
			System.out.println("사용해주셔서 감사합니다.");
		}//end finally
			
		
		
		
	}//main

}//class
