package day1204;
//18.12.04 9�� �ڷ� (Static Import ����)
import static java.lang.Integer.MAX_VALUE  ;
//���� �̸��� ����� �ϳ��� static import �޴´�
//import static java.lang.byte.MAX_VALUE;	

//method�� method�� ����Ѵ�.
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;
/**
 * 	static import
 *	�ٸ� Ŭ������ static ����/(Constant)�� method�� ���� Ŭ������ �ִٴ� �� ó�� ����� ��<br>
 *	import static ��Ű����.Ŭ������.������  �Ǵ�  import static ��Ű����.Ŭ������.method��
 * @author owner
 */
public class TestStaticImport {

	public static void main(String[] args) {
		// ��Ʈ(��Ƽ��) �� �ְ� 
		int i =Integer.MAX_VALUE;					
				System.out.println(i);
				System.out.println(Integer.MAX_VALUE );
				System.out.println( MAX_VALUE );
				
		String	year="2018";	
		String	month="12";	
		String	day="4";
		
		//���ڿ��� ���������� 
		//static import�� integer.parselnt�� �����Ͽ� �����ϰ� �����Ҽ� �ִ�. 
		int intYear=parseInt(year);
		int intMonth=parseInt(month);
		int intDay=parseInt(day);
				
		System.out.println(intYear+" / "+intMonth+" / "+intDay);
		System.out.println(toBinaryString(intYear)+" / "+toBinaryString(intMonth)+" / "+toBinaryString(intDay));
				
				
				
				
				
				
				
				
				
	}//main

}//class
