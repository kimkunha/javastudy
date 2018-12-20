package day1204;
//18.12.04 2번 자료 (Nested class 정의)
/**
 *	내부클래스를  static 변수처럼 사용할 수 있는 중첩클래스.
 * @author owner
 */
public class NestedOuter {

	int i;
	static int j;			// 스태틱 변수란 : 객체화 하지 않고 공용으로 사용할수 있다.
	 
	public NestedOuter() {
		System.out.println("바깥 클래스의 생성자");
	}//Nested Constructor
	
	public void outInstMethod() {			//인스턴스 변수 생성
		System.out.println("바깥 클래스의 인스턴스 method");
	}//outInstMEthod
	
	public static void outStatMethod() {		//스태틱 변수 생성 
		System.out.println("바깥 클래스의 static method");
	}//outInstMEthod
	
	////////////////////////////////////////////////Nested class 시작 /////////////////////////////////////////////////////
	static class NestedInner{
//		int in_i;	//instance 변수(만들수 있지만 권장하지 않음)		static클래스를 만들어도 안쪽영역은 기본이 instance변수
		// ( 안쪽(static class)에서 인스턴스변수를 만들어 사용할 수 는 있지만 
		//바깥쪽(nestedouter Class)에서 생성된 인스턴스 변수, method는 사용할수 없다. )
		static int in_j; //static 변수
		
//		public NestedInner() {		생성자를 만들수있지만 잘 만들지 않음
//		} 								static변수는 객체화를 하지 않기 때문에 생성자를 만들어 혼란을 가져올 필요가 없다.
		public void inMethod() {
			System.out.println("안쪽 클래스의 인스턴스 method");
		}//inMethod
		
		public static void inStatMethod() {
			System.out.println("안쪽 클래스의 static method");
			System.out.println("바깥 클래스의 자원 사용 i = 사용불가 , j = "+j +NestedOuter.j );   //바깥클래스명.j 라고도 사용가능
//			outInstMethod();// instance영역의 method이므로 사용할 수 없다.  
			NestedOuter.outStatMethod();//스태틱변수나 스태틱메소드 사용시 클래스명(출처)를 밝혀서 쓰는편이 좋다
		}//inStatMethod
	}//class
	///////////////////////////////////////////////////Nested class 끝 ///////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		//static 영역을 사용할 때에는 객체화 없이 클래스명.변수명, 클래스명.method명으로 사용한다.  (static 방식)
//		inStatmethod();		//static이라고 영역이 같다고 해서 사용할수는 없다. 클래스명을 써줘야한다.
		NestedInner.inStatMethod();		//클래스명.method명으로 사용한다.
		
		NestedOuter no=new NestedOuter();
		no.i=10;
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}//class
