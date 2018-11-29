package Day1114;
/*
기본형 데이터형												자주사용
	정수형 : byte, short, int, long								int,long 
	문자형 : char												char,boolean
	실수형 : float, double
	블린형 : boolean
*/

class  PrimitiveDataType {
	public static void main(String[] args) {
		//정수형
		byte a=10;
		short b=20;
		int c=30;
		long d=40; // 할당되는 값이 4byte내 이므로 literal 을 변환할 필요가 없다.
		long e=2147483648L;
		//literal에 저장이 되지 않으므로 literal의 크기를 변경  -형명시- 라고 함

		System.out.println("byte : " +a+", short : " +b+
				", int : " + c +",long : " +d+","+e);

		//문자형 : unioncode 값 : \u0000
		//char f='A';// 할당 unicode
		char f=66;//unicode값을 10진수로 할당가능.
		char g='0';
		char h='가';
		//출력 : unicode에 대한 문자 출력
		System.out.println("char :" +f+","+g+","+h);

		//실수
		float i=3.14F;
		//float는 4바이트인데 리터럴 3.14은 8바이트라 같은 형으로 맞춰야 한다. 그것이 형명시
		//형명시 - 실수 literal은 8byte이고 float 데이터형은 4byte이므로 값할당이 되지 않는다.
		//그래서 그래서 뒤에 F를붙여 줄이고 키우는건 L이다.
		double j=3.14;// 리터럴과 데이터형이 같으므로 형명시를 생략 할수있다.
		double k=3.14D;

		System.out.println("float : "+i+", double : "+j+","+k);

		//불린형
		boolean l=true;
		boolean m=false;
		System.out.println("boolean : "+l+","+m);

		byte b1=10, b2=20;
		int result=0;       //byte형으로 하면 안되지만 int로 하면 가능하다 
		result = b1 + b2;
			System.out.println(result);
	




	}//main
}//class
