package java_team3;

/**
 *	인스턴스변수, 스태틱변수, 지역변수 정의 
 *	변수를 결정짓는 중요한 요소는 "변수으 선언된 위치"
 *	
 * @author KIM
 */
public class TestInstanceVariable {
	//인스턴스 변수
	private String name="김건하";
	//스태틱 변수
	private static int i =10;
	
	public static void main(String[] args) {
		//인스턴스 변수는 객체화 없이  main method에서 사용할수 없다.
		//각 인스턴스 변수는 독립적인 저장 공간을 가진다
		//생성 시기 : 인스턴스가 생성 될때
		TestInstanceVariable tiv=new TestInstanceVariable();
		System.out.println(tiv.name);
	
		//스태틱 변수
		//인스턴스 변수앞에 static을 붙여주면 스태틱 변수로 같은 저장공간을 공유하는 형태이다.
		//객체화 없이 메인메소드에서 바로 사용할수 있다.
		//변수명만 아닌 클래스이름.스태틱변수명으로 사용해주는것이 가독성이 좋다.
		//생성시기 : 클래스가 메모리에 올라갈 때 
		System.out.println(i);
		
		//지역변수
		//클래스 영역이 아닌 mainmethod이나 블럭{ ( ) } 에서 생성된 변수를 가르킨다.
		//지역변수가 선언된 블록을 벗어나면 지역변수는 사라진다
		//생성시기 : 변수 선언문이 수행했을시
		int i=100;
		
		//참고로 스태택변수, 로컬변수는 같은 변수명을 사용할수 있으므로  아래 와같이 출력할경우
		//같은 지역에 지역변수가 있으면 지역변수가 먼저 호출된다.
		System.out.println(i);
		
		
	}//main
	
}//class
