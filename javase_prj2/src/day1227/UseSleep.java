package day1227;

import java.util.Random;

//18.12.27	-3번자료-		(생명주기)
/**
 *	running 상태에서 block상태로 상태 이전(생명주기)
 *	주로 구현받아서 사용한다 
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
//			System.out.println("2 * "+i+" = "+(2*i)); //running상태
//			try {
//				Thread.sleep(500);//block상태		//sleep method로 인해 지정된 시간동안 일시적인 실행을 정지시킨다.
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}//end for
	}//run

	
	
	
	
	public static void main(String[] args) {
		//클래스 객체화
		UseSleep us=new UseSleep();
		//Thread와 has a
		Thread t=new Thread(us);
		//Start
		t.start();
	
	}//main
	
}//class
