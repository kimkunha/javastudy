package java_team3;

/**
 * 	call by value는 매개변수로 기본형으로 받으면 매개변수에 값을 변경하더라도 값은 변경되지 않는다.
 * @author KIM
 */
public class TestCallByValue {

	public void  swap( int a, int b ) {
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println(" a 의 값 : "+a+",  b의 값 : "+b);
	}
	
	public static void main(String[] args) {
		int i=10;
		int y=20;
		System.out.println("swap 전 i : = "+i+"swap 전 y : = "+y);
		TestCallByValue tcbv=new TestCallByValue();
		tcbv.swap(i, y);
		System.out.println("swap 후 i : = "+i+"swap 후 y : = "+y);
		// 값이 바뀌지 않은 이유
		// 매개변수로 보낸 i, y는 메소드의 a,b하고 서로 다르기 떄문이다
		// main 메소드에서 선언된 i,y는 메모리의 값이 할당되지만
		//메서드 호출 시에 사용한 인자 a와 b는 할당 된 메모리 주소가 아닌 메모리에 담겨져 있던 값만이 복사되어
		// swap() 메서드 내부의 매개변수 i와 y의 메모리 주소에 담겨지게 됩니다
		
	}//class

}//main
