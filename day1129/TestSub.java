package day1129;

/**
 *	TestSuper의 자식클래스
 * @author owner
 */
public class TestSub extends TestSuper {														//extends TsetSuper 부모클래스
	int i;
	
	public TestSub() {
		System.out.println("자식의 생성자");
	}//TestSub
	
	public void subMethod() {
		System.out.println("자식 method");
	}//subMethod
	
	public static void main(String[] args) {
		// 객체화는 자식클래스를 사용한다.
		TestSub ts=new TestSub();		//객체화
		// 자식과 부모가 같은 패키지 존재하면 부모가 가진									//자식과 부모는 같은 패키지에 없을 가능성이 높다.
		// 변수나 method의 접근지정자가 public, protected, default인 자원만 사용할 수 있다.				//private는 불가능
		ts.pub_i=10;	// public
		ts.pro_i=20;	//protected
		ts.def_i=30;	//default
		ts.i=100;
		//부모의 코드를 내것처럼 쓴다. (코드의 재사용성)
		
		System.out.println("부모의 자원 "+ts.pro_i+" / "+ts.pub_i+" / "+ts.pro_i+" / "+ts.def_i);
		ts.superMethod();
		System.out.println("자식의 자원"+ts.i);
		
		
	}//main

}//class
