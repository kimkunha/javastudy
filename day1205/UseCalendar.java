package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.jws.soap.SOAPBinding.Use;

//18.12.05 6�� �ڷ�  ( calendar ����)
/**
 *	Calendar : ���� ��¥ ������ ������.
 * @author owner
 */
public class UseCalendar {

	public UseCalendar() {
		//Calendar Ŭ������ �ν��Ͻ� ���
		//1. getInstance���
//		Calendar cal = new Calendar(); // �ν��Ͻ�ȭ �Ҽ� ����. �߻�Ŭ��������
		Calendar cal = Calendar.getInstance();
		//2. is a ����
		Calendar cal1=new GregorianCalendar();   //GregorianCalendar�� �ڽ�Ŭ������ ��üȭ�� �����ϴ�.
		//3. �ڽĸ����� ��ü
		GregorianCalendar gc=new GregorianCalendar();
		System.out.println( cal );
		System.out.println( cal1 );
		System.out.println( gc );
		
		int year=cal.get( Calendar.YEAR );  //����� ����������ν� �������� ����Ų��. 
		
		System.out.println( year );
		
	}//UseCalendar
	
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
