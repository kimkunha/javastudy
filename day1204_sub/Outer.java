package day1204_sub;
//1번 inner클래스
/**
 *	inner class를 작성해보자
 *	안쪽클래스의 접근 지정자는 public
 *	안쪽클래스에서는 바깥쪽 클래스의 자원을 사용할수 있다
 *	바깥쪽 클래스에서는 안쪽 클래스의 자원을 사용할수 없다 사용하려면 독특한 객체화를 해줘야 한다
 *	객체화 : 안쪽클래스명 객체명 = 바깥클래스 객체명.new 안쪽클래스 생성자 ( );
 * @author owner
 */
public class Outer {
	int i;
	public Outer() {
		System.out.println("바깥 클래스의 생성자");
	}//OuterConstructor
	public void outerMethod() {
		System.out.println("바깥 클래스의 method");
		Inner in =this.new Inner();	//this를 사용해야 바깥쪽클래스에서도 안쪽클래스를 사용할수 있다.
		in.j=100;
		in.innerMethod();
	}//method

	///////////////////////////////////////////////////////////////////안쪽 클래스 시작 ///////////////////////////////////////////////////////////////
	
	//안쪽클래스는 무조건 public으로 받아준다
	public class Inner{
		int j;
		public Inner() {
			System.out.println("inner 생성자 작성");
		}//생성자 작성
		
		public void innerMethod() {
			System.out.println("inner method = 값"+i);
		}//method
	}//inner class
		
	///////////////////////////////////////////////////////////////////안쪽 클래스  끝///////////////////////////////////////////////////////////////

	
	
	public static void main(String[] args) {
			//1. 바깥쪽 클래스의 객체화를 우선한다.
		Outer out = new Outer();
		out.i=15;
//		out.j=12;		//바깥쪽클래스가 안쪽클래스의 자원 사용불가
		System.out.println(out.i);
		out.outerMethod();
		
		
		
//		//안쪽 클래스의 객체화 안쪽클래스명 안쪽클래스 객체명 = 바깥클래스 객체명.new 안쪽클래스 생성자 ( );
		Inner in =out.new Inner();
//		//안쪽클래스는 바깥쪾 클래스의 자원을 마음껏 사용 가능
		in.j=150;
		in.innerMethod();
//		
//	
		
		
		
		
		
		
		
		
	}//main

}//class
