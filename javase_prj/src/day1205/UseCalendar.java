package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.jws.soap.SOAPBinding.Use;

//18.12.05 6번 자료  ( calendar 정의), 18.12.06 -1번- 자료
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
		
		//상수를 집어넣음으로써 가독성을 향상시킨다.
		int year=cal.get( Calendar.YEAR );
		//Java에서는 월의 시작이 0월  그래서 +1을 해줘야한다.
		int month=cal.get( Calendar.MONTH )+1;   
		int day=cal.get( Calendar.DAY_OF_MONTH );   
		
		
		int day_of_year=cal.get( Calendar.DAY_OF_MONTH );
		//요일 : 일-1, 월-2, 화-3, 수-4, 목-5, 금-6, 토-7
		int day_of_week=cal.get( Calendar.DAY_OF_WEEK );
		
		//18.12.06추가 된 내용 
		
//		System.out.println( year );
		System.out.printf("%d-%d-%d 오늘은 올해에 %d번째 날\n",year,month,day,day_of_year);
		String week="";
/*		switch(day_of_week){
			case Calendar.SUNDAY :			//숫자보단 이렇게 해줌으로써 가독성 향상
				week="일요일";
				break;
			case Calendar.MONDAY :
				week="월요일";
				break;
			case Calendar.TUESDAY :
				week="화요일";
				break;
			case Calendar.WEDNESDAY :
				week="수요일";
				break;
			case Calendar.THURSDAY :
				week="목요일";
				break;
			case Calendar.FRIDAY :
				week="금요일";
				break;
			case Calendar.SATURDAY :			//마지막은 dafault를 줘도 된다.
				week="토요일";
				break;
		}//end switch
*/		
		String[] weekTitle= {"일","월","화","수","목","금","토"};				//배열로해서 작성
		
		System.out.printf("%d요일 %s\n",day_of_week, weekTitle[ day_of_week-1 ]);
		
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
		System.out.printf("%d, %s\n",am_pm, am_pm==Calendar.AM?"오전":"오후");
		
		int hour=cal.get(Calendar.HOUR);
		int hour24=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		System.out.printf("%d( %d):%d:%d\n", hour, hour24, minute, second );
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("설정 전 %d-%d-%d %s요일\n", cal1.get(Calendar.YEAR),cal1.get(Calendar.MONDAY)+1,cal1.get(Calendar.DAY_OF_MONTH),"일,월,화,수,목,금,토".split(",")
				[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		
		//다른날의 날짜 얻기
	    // cal.set(field, value);                //field 에는 상수(변경할 날짜 항목)    value에는 변경할값이 들어간다.
		//년 바꾸기
		cal1.set(Calendar.YEAR, 2019); //2019-12-06
		//월 바꾸기	//자바에서는 0월부터 시작 그래서 입력값 -1을 하던지 , 초기값을 0으로 생각해서 입력하면됨
		cal1.set(Calendar.MONTH, 4); //2019-05-06	
		//일 바꾸기 : 해당월에 존재하지 않는 일자가 설정되면 다음달 1일로 설정
		cal1.set(Calendar.DAY_OF_MONTH, 15); //2019-05-15		
		
		System.out.printf("설정 후 %d-%d-%d %s요일\n", cal1.get(Calendar.YEAR),cal1.get(Calendar.MONDAY)+1,cal1.get(Calendar.DAY_OF_MONTH),"일,월,화,수,목,금,토".split(",")
				[cal1.get(Calendar.DAY_OF_WEEK)-1]);

		System.out.println("이번달의 마지막날 : "+cal.getActualMaximum(Calendar.DATE));  //이렇게하면 이번달의 마지막날 확인
	}//UseCalendar
	
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
