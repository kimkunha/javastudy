package java_team3;

/**
 *	변수는 기본형 데이터형과 참조형 데이터형으로 나누어 진다.
 *	기본형 데이터형은 8가지, 참조형 데이터형은 객체의 주소를 저장한다.
 *	기본형 데이터 8가지를 제외한 모두가 참조형 데이터형
 * @author KIM
 */
public class TestVariableTypes {

	public static void main(String[] args) {

		//기본형 데이터형 
		//논리형 boolean true - false 값을 가지며 조건식과 논리적 계산에 사용된다. 기본형과 연산이 불가능
		boolean flag= true;

		//문자형 char 문자를 저장하는데 사용 변수아에 하나의 문자만 저장할수 있다.
		char a='가';
		
		//정수형 byte, short, int, long으로 나누어진다. 각 타입마다 저장할수 있는 값의 범위가 다르다
		byte b=10; //byte범위 : -128 ~ 127까지 크기 1 byte
		short s=20; //shote범위 : -32,768 ~ 32,767까지 크기 2byte
		int i=30;	//int 범위 : -2147483648 ~ 2147483647 까지 크기 4byte 
		long l=40; //long 범위 : -9223372036854775 878 ~9223372036854775 878 크기 8byte
		
		//실수형 float, double 있다
		float f =0.1f; //실수는 8바이트라서 그것을 맞춰주기 위해 형명시로 f를 붙임
		double d=12.123; 
		
		
		
		
	}//main

}
