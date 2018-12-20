package day1207;

import java.util.HashMap;
import java.util.Map;

/**
 *숙제 1.
main method의 arguments로 날짜를 여러개 입력 받아 입력받은 날짜의
 요일을 저장하고 출력하는 method 를 작성하세요.

예) java Test 4 12 30 32 35 15 4   

출력) 4 화
        12 수
        15 토
        30 일
 * @author owner
 */
public class Homework1 {
	public Homework1() {
		
		
	}//Homework1
	public void weather1() {
		Map<Integer,String> weather = new HashMap<Integer,String>();
			weather.put(4, "화");
			weather.put(12, "수");
			weather.put(15, "토");
			weather.put(30, "일");
	}//weather1
	
	public static void main(String[] args) {
		new Homework1();
		
		
		
		
		
	}//main

}//class
