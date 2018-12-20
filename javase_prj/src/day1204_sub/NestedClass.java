package day1204_sub;

/**
 * Nested class의 안쪽클래스는 static변수를 사용한다 따라서 객체화를 하지 않는다 바깥쪽 클래스에서 안쪽 클래스를 사용할 경우
 * static문법을 사용한다 : 클래스명.staic변수 or method
 *
 * @author owner
 */
public class NestedClass {
	int i;
	static int j;

	public NestedClass() {
		System.out.println("기본 생성자");
	}// Nestedclass constructor

	public void NestedClassMethod() {
		System.out.println("바깥쪽 method");
	}// method

	/////////////////////////////////////////////////// 안쪽 클래스 시작
	/////////////////////////////////////////////////// ///////////////////////////////////////////////////////
	static class StaticNested {
		int a; // static클래스여도 안쪽영역 기본이 인스턴스변수라서 만들수는 있다
		static int z=10;
		

//				public  StaticNested(){		//생성자를 만들수 있지만 객체화를 하지 않기떄문에 만들 필요는 없다.
//				}//생성자

		public static void StaticNestedMethod() {
			System.out.println("안쪽 클래스의 method method 입니다"+StaticNested.z);
		}

	}// staticNested

	/////////////////////////////////////////////////// 안쪽 클래스 끝
	/////////////////////////////////////////////////// ///////////////////////////////////////////////////////

	public static void main(String[] args) {

		//객체화를 할 필요가 없다
		//바깥클래스 객체화
		NestedClass ns =new NestedClass();
		ns.i=10000;
		ns.NestedClassMethod();
		
		//스태틱클래스의 자원을 사용하고싶을떄는 스태틱클래스명. 변수나 메소드를 붙이면 된다
		
		StaticNested.z=100;
		StaticNested.StaticNestedMethod();
		
		
		
		
	}// main

}// class
