package day1204;
//18.12.04 9번 자료 (Static Import 정의)
import static java.lang.Integer.MAX_VALUE  ;
//같은 이름의 상수는 하나만 static import 받는다
//import static java.lang.byte.MAX_VALUE;	

//method는 method명만 기술한다.
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;
/**
 * 	static import
 *	다른 클래스의 static 변수/(Constant)나 method를 현재 클래스의 있다는 것 처럼 사용할 때<br>
 *	import static 패키지명.클래스명.변수명  또는  import static 패키지명.클래스명.method명
 * @author owner
 */
public class TestStaticImport {

	public static void main(String[] args) {
		// 인트(인티져) 의 최고값 
		int i =Integer.MAX_VALUE;					
				System.out.println(i);
				System.out.println(Integer.MAX_VALUE );
				System.out.println( MAX_VALUE );
				
		String	year="2018";	
		String	month="12";	
		String	day="4";
		
		//문자열을 정수형으로 
		//static import로 integer.parselnt를 선언하여 간단하게 정의할수 있다. 
		int intYear=parseInt(year);
		int intMonth=parseInt(month);
		int intDay=parseInt(day);
				
		System.out.println(intYear+" / "+intMonth+" / "+intDay);
		System.out.println(toBinaryString(intYear)+" / "+toBinaryString(intMonth)+" / "+toBinaryString(intDay));
				
				
				
				
				
				
				
				
				
	}//main

}//class
