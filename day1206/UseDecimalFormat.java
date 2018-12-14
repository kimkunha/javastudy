package day1206;

import java.text.DecimalFormat;

//18.12.06 	-1�� �ڷ�-
/**
 * 	DecimalFormat
 *	���ڸ� ������ ���ڿ��� ����.
 * @author owner
 */
public class UseDecimalFormat {

	public UseDecimalFormat() {
		int temp=20181206;
		System.out.println(temp);
		
//		DecimalFormat df= new DecimalFormat("0,000");				//�������� �Էµ� �ڸ������� ������� �ڵ������� 3�ڸ����� , �� �Է����ش�.
//		DecimalFormat df1= new DecimalFormat("#,###");
		
		DecimalFormat df= new DecimalFormat("0,000,000,000");				
		DecimalFormat df1= new DecimalFormat("#,###,###,###");
		
		System.out.println("0��� : "+df.format(temp));
		System.out.println("#��� : "+df1.format(temp));
		
		DecimalFormat df2= new DecimalFormat("#,###.##");		// �ڿ� .(��)��
		//�Ǽ��ڸ����� ����ϸ� ���������ڸ��� ���� �ݿø� ����̶�� �ݿø��� ����� �����ش�.
		System.out.println("�Ҽ��ڸ��� ���� : "+df2.format(201812.066));
		System.out.println("�Ҽ��ڸ��� ���� : "+df2.format(201812.066));
	}//UseDecimalFormat Constructor
	
	public static void main(String[] args) {
		new UseDecimalFormat();
		
		
		
	}//main

}//class
