package day1203;
//18.12.03 수업 17번 자료
public class UseDefaultMethod implements UseDefault {

	@Override // annotation에서 Override가 에러가 나면 그냥 지우면 된다 이클립스 버그
	public void test() {
		System.out.println("Override method");
	}//test

	public static void main(String[] args) {
		//자식 클래스 객체화
		UseDefaultMethod udm=new UseDefaultMethod();
		udm.test();
		udm.temp(); //default method
		
		
		//is a 관계의 객체화
		UseDefault ud=new UseDefaultMethod();
		ud.test();	// Override한 method가 호출
		ud.temp(); //default method
	
	}//main

}//class
