package java_team3;

import java.math.MathContext;
import java.util.Random;

/**
 * method : 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
 * 				1. 높은재사용성, 중복된 코드제거로 method를 사용.
 * 
 * 	method의 4가지형태
 * 	1. 매개변수 없고 반환형 없는 고정값 타입
 * 	2. 매개변수 있고 반환형 없는 가변값 타입
 * 	3. 반환형 있고 매개변수 없는 형	 고정값 타입
 * 	4. 매개변수 있고, 반환형 있는 값. 가변값 타입
 * @author KIM
 *
 */
public class TestMethod {
	
	private void methodA() {
		//매개변수 , 반환형 없는 고정일 하는 method
		//매개변수와 반환형이 없는 타입이라 단순히 결과만 수행하기 위한 method에 적합하다.
		System.out.println("매개변수,반환형 없는 method");
	}//methodA
	
	//반환형은 없고 매개변수를 받아 사용하는 메소드 
	private void methodB(int i) {
		if(i>70) {
			System.out.println("운동 하세요.");
		}else if(i<69){
			System.out.println("위험합니다.");
		}
		
	}//methodB
	//반환형 있고 매개변수 없는 고정값
	private int methodC( ) {
		int result=0;
		result=(int)(Math.random()*10);
		System.out.println(result);
		return result;
	}//methodc
	
	//반환형과 매개변수가 있는 가변값
	public String methodD(String name) {
		String msg="";
		if(name.contains("이재찬") && name.equals("이재찬")) {
			msg="반장입니다.";
		}
		System.out.println(msg);
		return msg;
	}
	
	
	public static void main(String[] args) {
		TestMethod tm=new TestMethod();
		tm.methodA();
		tm.methodB(80);
		tm.methodC();
		tm.methodD("이재찬");
	}//main

}//class
