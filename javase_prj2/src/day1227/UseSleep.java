package day1227;

import java.util.Random;

//18.12.27	-3���ڷ�-		(�����ֱ�)
/**
 *	running ���¿��� block���·� ���� ����(�����ֱ�)
 *	�ַ� �����޾Ƽ� ����Ѵ� 
 * @author owner
 */
public class UseSleep implements Runnable {


	@Override
	public void run() {
		System.out.println("loading");
		Random r=new Random();
		for(int i=0; i< 15; i++) {
			System.out.print(" . ");
			try {
				Thread.sleep(100*r.nextInt(10)+1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//end for
		System.out.println("finish");
//		for(int i=0; i<10; i++) {
//			System.out.println("2 * "+i+" = "+(2*i)); //running����
//			try {
//				Thread.sleep(500);//block����		//sleep method�� ���� ������ �ð����� �Ͻ����� ������ ������Ų��.
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}//end for
	}//run

	
	
	
	
	public static void main(String[] args) {
		//Ŭ���� ��üȭ
		UseSleep us=new UseSleep();
		//Thread�� has a
		Thread t=new Thread(us);
		//Start
		t.start();
	
	}//main
	
}//class
