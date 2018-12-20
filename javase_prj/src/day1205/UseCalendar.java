package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.jws.soap.SOAPBinding.Use;

//18.12.05 6�� �ڷ�  ( calendar ����), 18.12.06 -1��- �ڷ�
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
		
		//����� ����������ν� �������� ����Ų��.
		int year=cal.get( Calendar.YEAR );
		//Java������ ���� ������ 0��  �׷��� +1�� ������Ѵ�.
		int month=cal.get( Calendar.MONTH )+1;   
		int day=cal.get( Calendar.DAY_OF_MONTH );   
		
		
		int day_of_year=cal.get( Calendar.DAY_OF_MONTH );
		//���� : ��-1, ��-2, ȭ-3, ��-4, ��-5, ��-6, ��-7
		int day_of_week=cal.get( Calendar.DAY_OF_WEEK );
		
		//18.12.06�߰� �� ���� 
		
//		System.out.println( year );
		System.out.printf("%d-%d-%d ������ ���ؿ� %d��° ��\n",year,month,day,day_of_year);
		String week="";
/*		switch(day_of_week){
			case Calendar.SUNDAY :			//���ں��� �̷��� �������ν� ������ ���
				week="�Ͽ���";
				break;
			case Calendar.MONDAY :
				week="������";
				break;
			case Calendar.TUESDAY :
				week="ȭ����";
				break;
			case Calendar.WEDNESDAY :
				week="������";
				break;
			case Calendar.THURSDAY :
				week="�����";
				break;
			case Calendar.FRIDAY :
				week="�ݿ���";
				break;
			case Calendar.SATURDAY :			//�������� dafault�� �൵ �ȴ�.
				week="�����";
				break;
		}//end switch
*/		
		String[] weekTitle= {"��","��","ȭ","��","��","��","��"};				//�迭���ؼ� �ۼ�
		
		System.out.printf("%d���� %s\n",day_of_week, weekTitle[ day_of_week-1 ]);
		
		int am_pm=cal.get(Calendar.AM_PM);
//		switch (am_pm) {
//		case Calendar.AM:
//			
//			break;
//
//		case Calendar.PM:
//			
//			break;
//		}
//		System.out.printf("%d",am_pm);
		System.out.printf("%d, %s\n",am_pm, am_pm==Calendar.AM?"����":"����");
		
		int hour=cal.get(Calendar.HOUR);
		int hour24=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		System.out.printf("%d( %d):%d:%d\n", hour, hour24, minute, second );
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("���� �� %d-%d-%d %s����\n", cal1.get(Calendar.YEAR),cal1.get(Calendar.MONDAY)+1,cal1.get(Calendar.DAY_OF_MONTH),"��,��,ȭ,��,��,��,��".split(",")
				[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		
		//�ٸ����� ��¥ ���
	    // cal.set(field, value);                //field ���� ���(������ ��¥ �׸�)    value���� �����Ұ��� ����.
		//�� �ٲٱ�
		cal1.set(Calendar.YEAR, 2019); //2019-12-06
		//�� �ٲٱ�	//�ڹٿ����� 0������ ���� �׷��� �Է°� -1�� �ϴ��� , �ʱⰪ�� 0���� �����ؼ� �Է��ϸ��
		cal1.set(Calendar.MONTH, 4); //2019-05-06	
		//�� �ٲٱ� : �ش���� �������� �ʴ� ���ڰ� �����Ǹ� ������ 1�Ϸ� ����
		cal1.set(Calendar.DAY_OF_MONTH, 15); //2019-05-15		
		
		System.out.printf("���� �� %d-%d-%d %s����\n", cal1.get(Calendar.YEAR),cal1.get(Calendar.MONDAY)+1,cal1.get(Calendar.DAY_OF_MONTH),"��,��,ȭ,��,��,��,��".split(",")
				[cal1.get(Calendar.DAY_OF_WEEK)-1]);

		System.out.println("�̹����� �������� : "+cal.getActualMaximum(Calendar.DATE));  //�̷����ϸ� �̹����� �������� Ȯ��
	}//UseCalendar
	
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
