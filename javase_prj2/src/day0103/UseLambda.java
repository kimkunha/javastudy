package day0103;

import java.text.SimpleDateFormat;
import java.util.Date;

//19.01.03 -2번 자료- ( 1번 람다식 연계)
public class UseLambda {

	public static void main(String[] args) {
//		TestLambda tl=()->new Date().toString(); // return 생략가능
//		TestLambda tl=()-> { return new Date().toString() ; } ; // return 사용가능하나 사용시 중괄호로 묶고 뒤에 새미콜론으로 끝나야 한다.
//		//abstract method 내의 코드가 복잡(여러줄)한 경우에는 { } 를 반드시 기술
		TestLambda tl=()->{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			for(int i=0; i< 10; i++) {
				System.out.println("i = "+i);
			}//end for
			
			return sdf.format(new Date());
			};//return 기술. { }필요
	
		System.out.println( tl.toDay());
	}//main

}//class
