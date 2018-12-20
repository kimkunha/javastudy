package day1205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//18.12.05 5번 자료  ( Date정의)
/**
 *	형식이 있는 날짜 정보를 얻을 때.
 *	형식 - java.text.SimpleDateFormat
 *	날짜정보 - java.util.date
 * @author owner
 */
public class UseDate {
	
	public UseDate() {
		Date date= new Date();
		System.out.println( date );			
//		System.out.println( 1900+date.getYear() );	//비추천 method가 많다
		//Locale - 다른 나라의 날짜, 형식으로 변경하여 제공할 때
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd a EEEE HH(hh,kk):mm:ss ", Locale.JAPAN);
		String formatDate = sdf.format(date);
		System.out.println( formatDate );
		
		
	}//UseDate
	
	
	public static void main(String[] args) {
		new UseDate();
	}//main

}//class
