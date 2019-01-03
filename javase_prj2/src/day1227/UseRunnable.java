package day1227;
//18.12.27	-2번자료-		(Runnable 구현)
/**
 *	Runnable interface를 구현하여 Thread를 사용
 * @author owner
 */
//1. Runnable 구현
public class UseRunnable implements Runnable {
	//2. run()의 Override
	@Override
	public void run() {
		//3. 동시에 Thread로 동작해야하는 코드
		for(int i=0; i < 1000;  i++) {
			System.out.println("run i======"+i);
		}//end for
	}//run
	
	public void test() {
		for(int i=0; i < 1000;  i++) {
			System.out.println("test****************i = "+i);
	}//end for
	}//test
	
	
	
	
	
	public static void main(String[] args) {
		long st=System.currentTimeMillis();
		//4. Runnable을 구현한 클래스를 객체화
		UseRunnable ur=new UseRunnable();
		//5. Thread 객체와 Runnable을 구현한 객체를 has a 관계로 설정
//		Thread t=new Thread();	//이러면 ur객체와 아무 관계가 없다.
		Thread t=new Thread(ur);	//ur을 넣어서 has a 관계를 만들어 준다.
		
		//6. Thread에 있는 start()호출
		t.start();//has a 관계가 설정되지 않으면 Thread의 Run() 호출된다.//아무런 관계가 없어서 출력이 아무것도 안나온다.
//		ur.run();
		ur.test();
		long et= System.currentTimeMillis();
		System.out.println((et-st)+" ms");
	}//main
}//class
