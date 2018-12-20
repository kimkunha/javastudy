package day1203_sub;

import java.util.concurrent.SynchronousQueue;

/**
 *	부모 클래스 작성
 * @author owner
 */
public class Super {
	int i;
	
	public Super() {
		this(100);
		System.out.println("부모의 생성자");
	}//생성자
	
	public Super(int i) {
		System.out.println("부모의 인자 값 있는 생성자"+i);
	}//생성자
	
	public void pMethod() {
		System.out.println("부모의 메소드");
	}//부모의 클래스
	
	public void printA() {
		System.out.println("이것은 부모의 메소드 ");
	}//매소드
	
	
	
	
	
}//class
