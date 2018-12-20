package day1205;

//18.12.05 3번 자료 (Math 정의)			//생성자를 만들수없다 전부static이다 클래스명.method를 써야한다.
/**
 * Math : 객체를 생성하지 않고 사용하는 클래스.(생성자가 없다) //나중에 몇개 더 있다
 * 
 * @author owner
 */
public class UseMath {
	public UseMath() {
//		Math m= new Math(); //불가능
		int i = -12;
		System.out.println(i + "의 절대갑 : " + Math.abs(i)); // math.abs(정수) : 절대값
		System.out.println(Math.ceil(10.0)); // 0은 안한다 .1부터 올린다 //Math.ceil
		System.out.println(Math.round(10.5));// 반올림 0.5부터 올린다 //Math.round
		System.out.println(Math.floor(10.9));// 소수점 이하 첫 자리에서 내린다 //Math.round

		double d = Math.random();
		System.out.println("발생한 난수 : " + d);
		System.out.println("범위를 설정한 난수 : " + d * 5);
		System.out.println("범위를 설정한 난수에서  정수: " + (int) (d * 10)); // 캐스팅이 먼저 계산되기때문에 괄호로 먼저 연산해준다.

		// A(65)-Z(90)중 하나의 문자를 반환하는 일
		System.out.println((char) ((int) (d * 26) + 65));

	}// UseMath

	public char[] createPassword() {
		char[] tempPass = new char[8];
		// 영문자대문자, 소문자, 숫자로 이루어진 임의의 비밀번호 8자리를 생성하여 반환하는 일
		String flag="ABCDEFGHIJKLMNOPQRSTUVXXYZabcdefghijklmnopqrstuvwxyz0123456789";
			for(int i=0; i<tempPass.length; i++) {
				tempPass[i]=flag.charAt((int)(Math.random()*flag.length()));
				System.out.print( tempPass[i]);
			}//end for
		return tempPass;
	}// createPassword

	
	
	
	public static void main(String[] args) {
		new UseMath().createPassword();

	}// main

	
	
	
}// class
