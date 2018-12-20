package day1206;

import java.util.Random;

//18.12.06 	-2번 자료-  (Random)
/**
 *	Random : 다양한 난수를 얻기위한 객체.
 * @author owner
 */
public class UseRandom {

	public UseRandom() {
		//1. 생성)
			Random r= new Random();
		//실수 난수
			double d= r.nextDouble();
			System.out.println(d);
			System.out.println(d*5);
			System.out.println((int)(d*5));
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
	
		//정수 난수
			int i=r.nextInt();					//integer의 범위인 음수나 양수가 나온다
			System.out.println(i);
			System.out.println(i%5);
			System.out.println(Math.abs(i%5)); //음수가 발생하므로 절대값을 구해야한다. 절대갑 : Math.abs
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			int j=r.nextInt(5);//음수가 발생하지 않는다.
			System.out.println(j);
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			//불린 난수
			boolean b=r.nextBoolean();
			System.out.println(b);
		
		
		
		
	}//UseRandom Constructor
	
	public static void main(String[] args) {

		new UseRandom();
	}//main

}//class
