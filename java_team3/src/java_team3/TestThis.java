package java_team3;

/**
 *	method형식 this
 *	생성자의 이름으로 클래스명 대신 this사용
 *	내 클래스의 오버로딩 된 생성자를 호출할때 사용 this()
 *	한 생성자에서 다른 생성자를 호출할때 반드시 첫줄에서만 호출이 가능하다.this
 *
 * @author KIM
 */
public class TestThis {
	
	public String color;
	public String gearType;
	public int door;

	public TestThis(String color, String gearType, int door) {
		//this를 사용하여 this.color는 인스턴스변수  /  color는 매개변수로 정의된 지역변수로 구별이 가능하다.
		//this를 static영역 에서는 사용이 불가.
		//this , this()는 다르다
		//this는 참조변수로 자신을 가르킨다.
		this.color=color;
		this.gearType=gearType;
		this.door=door;
	}
	
	public TestThis() {									//3.인자 없는 생성자로 와서 일을하고 } <- 로 호출된곳으로 돌아간다.
		this("안녕",10);
		System.out.println("인자 없는 생성자");
	}
	
	public TestThis(int i) {								//2. 매개변수 있는 생성자로 호출되었으나
		this();												//		this(); 인자 없는 생성자로 호출 하라는 명령어
		System.out.println("인자 하나 있는 생성자");//4. 돌아와서 일을 진행 
	}															
															
	public TestThis(String str, int i) {
//		this();											//호출된곳으로 다시 부르면 무한루프로 error
		System.out.println("인자 두개 있는 생성자");
	}
	

	public static void main(String[] args) {
//		TestThis tt = new TestThis("white","auto",4);	//this를 사용
		new TestThis(20); //1. 매개변수 있는 생성자 호출 this();는 생성자의 첫번째 줄에서만 정의 가능
		
	}//main

}
