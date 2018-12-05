package day1204;
//18.12.04 1번 자료 (Innerclass 정의)
/**
 * 
 * @author owner
 */
public class Outer {
	int i;
	 
	public Outer() {
		System.out.println("바깥 클래스의 생성자");
	}//OuterConstructor
	
	public void outMethod() {
		System.out.println("바깥 클래스의 method i ="+i);
//		System.out.println("안쪽 클래스의 j = "+j); //사용불가
		
//		//안쪽클래스를 객체화
//		Outer.Inner in = this.new Inner();		//this로 해서 사용할수 있다.
//		in.j=100;
//		in.inMethod();
	}//outMEthod
		
	
	/////////////////////////////////////////안쪽클래스 시작///////////////////////////////////////////////////
	public class Inner{
		int j;
		public Inner() {
			System.out.println("안쪽 클래스의 생성자");
		}//Inner constructor
		
		public void inMethod() {
			System.out.println("안쪽 클래스의 method j = "+j+", 바깥 클래스의 자원 i = "+i);
			outMethod();//바깥 클래스의 method    //안쪽에서는 바깥클래스의 자원 마음대로 사용가능
		}//inMethod
		
	}//class
	/////////////////////////////////////////안쪽클래스  끝/////////////////////////////////////////////////////
	public static void main(String[] args) {
		//1. 바깥 클래스의 객체화
		Outer out = new Outer();
		out.i=10;
		out.outMethod();
//		out.j=100;	//사용불가  (안쪽클래스의 자원을 직접 접근하여 사용할수 없다.)		사용하고 싶은경우 특별한 객체화를 하여야 한다.
//		out.inmethod();//사용불가  (안쪽클래스의 자원을 직접 접근하여 사용할수 없다.)
		//2. 안쪽클래스의 객체화 :  --바깥 클래스에서 안쪽 클래스의 자원을 사용할 수 있다.
		//	 바깥클래스명.안쪽클래스명  객체명  =  바깥클래스의 객체명.new  안쪽생성자( );
//				Outer.Inner in = out.new Inner();				//정석적인 객체화 방법
				Inner in = out.new Inner();						//바깥클래스명은 생략할 수 있다.
				in.j=12;						//안쪽클래스의 자원들 사용
				in.inMethod();				//안쪽클래스의 자원들 사용
			
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}//class
