package java_team3;

/**
 *	casting 서로다른 변수의 타입형을 일시적으로 변환하여 사용
 * @author KIM
 */
public class TestCasting {

	public static void main(String[] args) {
		byte b=10;
		int i=20;
		long l=30;
		System.out.println("바이트 b 의값 : "+b+" + 인트 i 의 값 "+i+" = "+(i+b));
		//데이터형 크기가 다른데 연산이 되는이유는 byte의 값이 int의 크기로 형변환이 되어서 연산이 된것이다.
		//int 크기 4by라  byte, short보다 크기가 커서 자바가상머신에서 자동으로 형변환을 해주어 따로 수식없이 사용가능
		//연산시 두 데이터형의 크기가 큰것으로 되서 연산가능, 기본형데이터 끼리만 가능하다.
		System.out.println("인트 i 의값 : "+i+" + 롱 l 의 값 "+l+" = "+(i+l)); //long 타입으로 연산됨
		
		//형변환 방법
		//int의 값을 byte형으로 넣어줄때는 변수명 앞에 넣을 변수의 타입에 맞춰줘야 한다 
		//boolean을 제외한 나머지 타입들은 형변환이 가능하다  
//		b=i; X못들어간다
		b=(byte)i;    
		i=(int)l;
		//실수형을 정수형으로 casting할경우 int는 정수형이라 소수값은 날라간다
		double d=114.1231;
		i=(int)d;
		System.out.println(i);
		
	}//main
	
}
