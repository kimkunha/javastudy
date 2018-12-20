package day1205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//18.12.05 5�� �ڷ�  ( Date����)
/**
 *	������ �ִ� ��¥ ������ ���� ��.
 *	���� - java.text.SimpleDateFormat
 *	��¥���� - java.util.date
 * @author owner
 */
public class UseDate {
	
	public UseDate() {
		Date date= new Date();
		System.out.println( date );			
//		System.out.println( 1900+date.getYear() );	//����õ method�� ����
		//Locale - �ٸ� ������ ��¥, �������� �����Ͽ� ������ ��
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd a EEEE HH(hh,kk):mm:ss ", Locale.JAPAN);
		String formatDate = sdf.format(date);
		System.out.println( formatDate );
		
		
	}//UseDate
	
	
	public static void main(String[] args) {
		new UseDate();
	}//main

}//class
