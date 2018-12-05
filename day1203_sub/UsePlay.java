package day1203_sub;

/**
 *	상속관계 정리 
 *	is a 관계 객체화
 * @author owner
 */
public class UsePlay {
	public Super test1() {
		Super s= new sub();
		return s;
	}// 
		
	
	

	public static void main(String[] args) {
		//먼저 자식클래스로 객체화하여 부모 클래스 사용해본다
		sub s1= new sub();
		UsePlay us=new UsePlay();
		
		s1.i=100;
		System.out.println("부모의 자원을 사용"+s1.i);
		s1.pMethod(); // 부모의 메소드르를 사용함 (코드의 재사용성)
		s1.printA(); //
		System.out.println("-----------------------------------------------------------------");
		
		Super s=us.test1();
		
	}//main

}//class
