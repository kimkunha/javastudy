package day1227;
//18.12.27	-1번자료-		(Thread)
/**
 *	Thread Class를 상속받아서 Thread 사용.
 * @author owner
 */
//1. Thread 상속
public class UseThread extends Thread{
	//2. run method Override
	@Override
	public void run() {
		//3. Thread로 동작되어야할 코드(동시에 실행되어야할 코드)
		for(int i=0; i<1000; i++) {
			System.out.println("run i------------->"+i);
		}//end for
	}//run
	
	public void test() {
		for(int i=0; i < 1000; i++) {
			System.out.println("main ================== i = "+i);
		}//end for
	}//end for
	
	
	public static void main(String[] args) {
		//4. 객체 생성
		UseThread ut=new UseThread();
		//5. 부모 클래스인 Thread 가 가지고 있는 start( ) 메소드 호출
		ut.start();// start()호출하면 start()안에서 -> run()호출	//동시에 실행이된다.
		ut.test();
		
		//동시에 실행이된다. Thread 매번 달라진다.
		//1.상속받아서 thread사용, 2. 구현을해서 thread 사용
	}//main

}//class
