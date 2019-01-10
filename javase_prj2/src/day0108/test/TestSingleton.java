package day0108.test;

/**
 *	싱글톤 테스트
 *	단 하나의 객체를 만들어 사용하는 pattern
 *	속도가 빠르다, 메모리를 적게 사용한다.
 *	객체가 소멸되면 해당기능을 사용할수 없지만 그 대응코드가 나옴
 *
 *
 * @author owner
 */
public class TestSingleton {
	private static TestSingleton ts;  //접근지정자 private에 static변수로 선언
	
	private TestSingleton() {
	}//생성자로 선언
	
	//가져올 method 선언
	public static TestSingleton getinstans() { //method도 static으로 선언해야 한다.
		if( ts==null) {
			ts=new TestSingleton();
		}
		return ts;
	}
	
	public static void main(String[] args) {
//		TestSingleton ts=new TestSingleton();
//		TestSingleton ts1=new TestSingleton();
//		TestSingleton ts2=new TestSingleton();
//		System.out.println(ts);
//		System.out.println(ts1);
//		System.out.println(ts2);
		//객체마다 주소값이 다르게 나온다
		
		TestSingleton ts=TestSingleton.getinstans();
		TestSingleton ts2=TestSingleton.getinstans();
		TestSingleton ts3=TestSingleton.getinstans();
		TestSingleton ts4=TestSingleton.getinstans();
		System.out.println(ts);
		System.out.println(ts2);
		System.out.println(ts3);
		System.out.println(ts4);
				
		
	}//main	

}//class
