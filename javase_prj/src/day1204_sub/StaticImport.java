package day1204_sub;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
/**
 *	static import�� ����غ���
 *	static import�� ����/��� static method�� �� Ŭ������ �ִ°�ó�� ����ϴ°�
 *	���� : import static ��Ű����.Ŭ������.static ����///  import static ��Ű����.Ŭ������.static method
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
