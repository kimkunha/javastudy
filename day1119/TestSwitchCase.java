package day1119;

/**
 * switch~case : 정수를 비교할때.(JDK1.7에서 부터는 문자열도 비교 가능)<br>
 * 문법)<br>
 * switch(변수명){<br>
 * case 상수 : 수행문장;<br>
 * case 상수 : 수행문장;<br>
 * case 상수 : 수행문장;<br>
 * case 상수 : 수행문장;<br>
 * default : 일치하는상수가없을때 수행문장; <br>
 * }
 * 
 * @author owner
 */
public class TestSwitchCase {

	public static void main(String[] args) {
//		String i = "1"; //jdk1.7+에서 부터 가능
		int i=0;
		switch (i) {// switch에 입력되는 변수의 데이터형은 byte, short, int, char, String long(x)
		// case는 입력되는 변수에 따라 다른 범위를 가진다.
		case 0:
			System.out.println("새벽");
		case 1:
			System.out.println("아침"); // break;
		case 2:
			System.out.println("점심");
		default:
			System.out.println("저녁");
		}// end switch
	}// main

}// class
