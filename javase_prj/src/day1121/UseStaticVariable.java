package day1121;

/**
 * static (class)변수 : 클래스가 실행되면 가장 처음 메모리에(method)에 올라가고, 모든 객체가 하나의 변수를 참조하여
 * 사용하는 변수
 *
 * @author owner
 */
public class UseStaticVariable {
	public static int i;// static variable -> 바로사용
	int j;// instance variable -> 객체화하여 사용

	public void test() {
	}// test

	public static void main(String[] args) {
		// class변수 사용. 클래스명.변수명
		UseStaticVariable.i = 20;
		System.out.println(UseStaticVariable.i);

		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		usv.j = 5000; // instance변수는 생성된 객체가 각각 사용한다.
		usv1.j = 10000;
		usv.i = 20;// 객체명으로 사용하면 특정 객체에 속한(member 변수)가 아니므로 사용은 가능하지만 권장하는 문법이 아니다.

		System.out.println("usv객체 인스턴스 변수 :" + usv.j + ", 스태틱 변수:" + usv.i);
		System.out.println("usv1객체 인스턴스 변수 :" + usv1.j + ", 스태틱 변수" + usv1.i);

//	j=200;
//	System.out.println(i+" / "+j);

	}// main
}// class
