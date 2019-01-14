package java_team3;

/**
 *	Constant변수를 상수같이 사용하는것 한번 값 할당하면 변경 불가능
 *	주로 field에서 선언 한다.
 *	final 키워드를 붙여 사용
 * @author KIM
 */
public class TestConstant {
	//3. 상수는 개발자들 간의 암묵적인 룰로 대문자로 사용하는걸 추천한다.
	//4. 고정값으로 사용할 경우 상수로 사용하는것이 좋다.
	public static final int MAX_VALUE = 100;
	
	public static void main(String[] args) {

		final int i=10;
		int y=20;
		System.out.println(i);
		//1. 한번 값 할당하면 값 변경 불가능
//		int i=20;
//		y=30; //값 변경가능
		//2. 상수는 class field에서 선언해 사용하는것이 바람직하다.
		
		System.out.println(MAX_VALUE);
		
	}//main

}//class
