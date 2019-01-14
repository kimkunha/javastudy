package java_team3;

public class TestOverride extends TestPolymorphsim {
	
	//부모의 자원을 사용하기 위해 상속받는다.
	//접근지정자, 반환형, method명, parameter 같게한다.
	@Override	//anotaion을 사용해 overriding 한걸로 표기해준다.
	public void override() {
		System.out.println("나는 자식입니다.");
	}//override

	public static void main(String[] args) {
		TestOverride to=new TestOverride();
		//부모의 자원 method를 내가 새로 정의하여 코드의 재 사용성을 높였다.
		to.override();
	}//main
}//class
