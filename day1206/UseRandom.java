package day1206;

import java.util.Random;

//18.12.06 	-2�� �ڷ�-  (Random)
/**
 *	Random : �پ��� ������ ������� ��ü.
 * @author owner
 */
public class UseRandom {

	public UseRandom() {
		//1. ����)
			Random r= new Random();
		//�Ǽ� ����
			double d= r.nextDouble();
			System.out.println(d);
			System.out.println(d*5);
			System.out.println((int)(d*5));
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
	
		//���� ����
			int i=r.nextInt();					//integer�� ������ ������ ����� ���´�
			System.out.println(i);
			System.out.println(i%5);
			System.out.println(Math.abs(i%5)); //������ �߻��ϹǷ� ���밪�� ���ؾ��Ѵ�. ���방 : Math.abs
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			int j=r.nextInt(5);//������ �߻����� �ʴ´�.
			System.out.println(j);
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			//�Ҹ� ����
			boolean b=r.nextBoolean();
			System.out.println(b);
		
		
		
		
	}//UseRandom Constructor
	
	public static void main(String[] args) {

		new UseRandom();
	}//main

}//class
