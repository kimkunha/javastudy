package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.jws.soap.SOAPBinding.Use;

//18.12.05 6번 자료  ( calendar 정의)
/**
 *	Calendar : 단일 날짜 정보를 얻을때.
 * @author owner
 */
public class UseCalendar {

	public UseCalendar() {
		//Calendar 클래스의 인스턴스 얻기
		//1. getInstance사용
//		Calendar cal = new Calendar(); // 인스턴스화 할수 없다. 추상클래스여서
		Calendar cal = Calendar.getInstance();
		//2. is a 관계
		Calendar cal1=new GregorianCalendar();   //GregorianCalendar가 자식클래여서 객체화가 가능하다.
		//3. 자식만으로 객체
		GregorianCalendar gc=new GregorianCalendar();
		System.out.println( cal );
		System.out.println( cal1 );
		System.out.println( gc );
		
		int year=cal.get( Calendar.YEAR );  //상수를 집어넣음으로써 가독성을 향상시킨다. 
		
		System.out.println( year );
		
	}//UseCalendar
	
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
