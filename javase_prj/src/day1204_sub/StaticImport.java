package day1204_sub;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
/**
 *	static import를 사용해보자
 *	static import는 변수/상수 static method를 내 클래스에 있는것처럼 사용하는것
 *	사용법 : import static 패키지명.클래스명.static 변수///  import static 패키지명.클래스명.static method
 * @author owner
 */
public class StaticImport {

	public static void main(String[] args) {

		int i =Integer.MAX_VALUE;
				System.out.println(i);
			System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(MIN_VALUE);
		System.out.println(MAX_VALUE);
		
		
		String year="1111";
		int intYear = Integer.parseInt(year);
		System.out.println(intYear);
		
		
	}//main

}//class
