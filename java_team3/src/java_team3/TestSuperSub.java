package java_team3;

/**
 *	부모클래스의 자원과 자식 클래스의 자원이 같은 이름을 가질때 
 *	중복정의 되어 서로 구별해야 할떄 사용 (부모클래스의 자원을 사용하기 위한 예약어)
 *	클래스의 인스턴스 영역에서만 사용할수 있다 static영역 사용 불가.
 *
 * @author KIM
 */
public class TestSuperSub extends TestSuper{

	public String name;
	public int number;
	
	public void superMethod( int number) {
		super.number = 100;//부모와 자식의 자원이 이름이 같을 경우 super예약어를 사용해 구별한다.
		this.number=number;
		System.out.println("부모 자원 : "+super.number+" / "+"자식 자원 : "+this.number);//인스턴스 number에 값 입력
		super.superMethod();
	}
	
	
	public TestSuperSub() {
		super();
		System.out.println("인자 없는 자식 생성자");
	}//자식 생성자
	
	public TestSuperSub(int i) {
		this();
		System.out.println("인자 있는 자식 생성자   200");
	}//자식 생성자
	
	
	public static void main(String[] args) {
		
		//부모와 자식의 생성자 흐름 연습    //거꾸로 시작하면 이해 하기 쉽다.
		TestSuperSub tss=new TestSuperSub(30);
		
		System.out.println("-------------------------------------------");
		tss.superMethod(30);
		
		
	}//main

}//class
