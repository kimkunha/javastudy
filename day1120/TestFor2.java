package day1120;

/**
 * 다양한 for 형태
 * 
 * @author owner
 */
public class TestFor2 {

	public static void main(String[] args) {
/*//		무한loop
		for () {
			System.out.println("아아");
		} // end for
		System.out.println("");*/

		// 증가하는 수를 세는 무한loop
		for (int i = 0;; i++) {
			System.out.println("무한loop" + i);
			if (i == 50) {
				break;// 가장 인근에 존재하는 반복문을 빠져 나간
			} // end if
		} // end loop
		System.out.println("");

		// 여러개의 초기값을 사용하는 for
		for (int i = 0, j = 10, k = 30; i < 10; i++, j++, k--) {
			System.out.println(i + " " + j + " " + k);
		} // end for

		// 조건식을 잘못 설정하면 무한loop에 들어간다
		for (int i = 0; i < 10; i--) {
			System.out.println(i);
		} // end for

		int i = 0;
		for (i = 0; i < 10; i++)
			;
		{ // 세미콜론때문에 한번만 수행한다.
			System.out.println("반복문" + i);
		}

	}// main

}// class
