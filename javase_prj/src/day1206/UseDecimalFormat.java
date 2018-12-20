package day1206;

import java.text.DecimalFormat;

//18.12.06 	-1번 자료-
/**
 * 	DecimalFormat
 *	숫자를 지정한 문자열로 변경.
 * @author owner
 */
public class UseDecimalFormat {

	public UseDecimalFormat() {
		int temp=20181206;
		System.out.println(temp);
		
//		DecimalFormat df= new DecimalFormat("0,000");				//변수값이 입력된 자릿수보다 많을경우 자동적으로 3자리마다 , 를 입력해준다.
//		DecimalFormat df1= new DecimalFormat("#,###");
		
		DecimalFormat df= new DecimalFormat("0,000,000,000");				
		DecimalFormat df1= new DecimalFormat("#,###,###,###");
		
		System.out.println("0사용 : "+df.format(temp));
		System.out.println("#사용 : "+df1.format(temp));
		
		DecimalFormat df2= new DecimalFormat("#,###.##");		// 뒤에 .(점)임
		//실수자릿수를 사용하면 마지막뒷자리의 값이 반올림 대상이라면 반올림한 결과를 보여준다.
		System.out.println("소수자리수 포현 : "+df2.format(201812.066));
		System.out.println("소수자리수 포현 : "+df2.format(201812.066));
	}//UseDecimalFormat Constructor
	
	public static void main(String[] args) {
		new UseDecimalFormat();
		
		
		
	}//main

}//class
