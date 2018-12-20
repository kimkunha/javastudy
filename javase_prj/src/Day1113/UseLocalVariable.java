package Day1113;

//지역변수 선언 사용
class UseLocalVariable{

	public static void main(String[]args){
		//1. 지역변수 선언 : 데이터형 변수명;
		int i;//자동초기화가 되지 않는다.
		int j=11;//변수의 초기화 : 변수를 선언하면서 값할당
		long m=300000000L;
		//2. 값할당:변수명=값;
		 i=100;//초기화 하지않은 변수를 사용하면 ERROR
		
		//3. 값 사용:출력, 연산, 재할당
		System.out.println(i);
		System.out.println(j);
		System.out.println(m);
		//int i=200;//같은 이름의 변수는 작성할수 없다.

		//변수명은 한글로 가능하나 한글을 사용하지 X
		
		



	}//main
}//class


