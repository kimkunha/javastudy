package java_team3;

/**
 * 	객체가 생성될때 기본으로 가지고 있어야 할 초기값
 * 	반환형이 없으며 클래스명 과 동일하게 만든다
 * 	오버로딩을 지원한다.
 *	생성자는 compiler가 기본으로 정의 해준다
 *	인자있는 생성자로 사용이 가능
 * @author KIM
 */
public class TestConstructor {

	public String name;
	public int age;
	
	//기본 생성자
	public TestConstructor(  ) {
	}
	
	//인자있는 생성자
	public TestConstructor( String s, int i ) {
		//1.
				name = s;
				age = i;
		
	//3.		this를 사용하는것이 가장 좋다.
		//		this.name=name;
		//		this.age=age;
	}
	public static void main(String[] args) {
		TestConstructor tc1=new TestConstructor("짱구",5);//1. 생성자에서 바로 값을 넣어서 가능
				//this를 사용하여 간단하게 값 입력 
				System.out.println(tc1.name+" / "+tc1.age);
		
				TestConstructor tc2=new TestConstructor();//2.코드가 길어지는 단점.
				tc2.name="짱구";
				tc2.age=5;
				System.out.println(tc2.name+" / "+tc2.age);
	}//main

}//class
