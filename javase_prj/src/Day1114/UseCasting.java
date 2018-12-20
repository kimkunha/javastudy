package Day1114;
/*
	강제형변환 : 변수의 데이터형을 일시적으로 변환하여 사용하는 것
*/

class UseCasting{
	public static void main(String[] args) 	{
		byte b1=10,b2=20; //int로 자동형변환
		byte result = (byte)(b1+b2);// byte끼리의 연산의 결과가 int로 자동형변환됨  주의점 result가 Byte로 받으면 안되니 int로 바꿔줘야 한다.
								//연산의 결과가 int로 자동형변환 되는것을 byte로 강제형변환
								//괄호가 + 보다 먼저연산이 되므로 괄호를 해줘서 연산을 해야함  -굳이 추천안함-
		System.out.println( b1+" + "+b2+" = " +result);

		double d=11.14;
		float f=(float)d;
		System.out.println("double : "+d+", float : "+f);

		float f1=(float)2018.11;
		System.out.println("double : " +f1);

		//long l=(long)2147483648;// 상수값이 literal 보다 크다면 casting을 실행하기전에 ERROR발생.

		int i=(int)f1;   // byte수는 같지만 값 종류가 틀려서 ERROR발생, 강제형변환으로 실행할수 있지만 실수부의 값이 모두 사라져 할당)  -값손실 발생-
		System.out.println("int : "+i+", float : "+f1);

		char c='A';
		System.out.println(c+"의 unicode(ASCII code)값" +
						(int)c);

		//형(기본형, <-> 참조형)이 다르면 강제형변환이 되지 않는다.
//		String s="11";//참조형
//		int i=(int)s;//기본형
				

		//boolean 형은 boolean형 끼리만 변환 가능
		boolean b=true;
		//i=(int)b;  //ERROR
		boolean bc=(boolean)b; //되기 하지만 아무 의미없다.
		System.out.println(bc);

	}//main
}//class
