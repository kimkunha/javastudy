package day1227;
//18.12.27	-1���ڷ�-		(Thread)
/**
 *	Thread Class�� ��ӹ޾Ƽ� Thread ���.
 * @author owner
 */
//1. Thread ���
public class UseThread extends Thread{
	//2. run method Override
	@Override
	public void run() {
		//3. Thread�� ���۵Ǿ���� �ڵ�(���ÿ� ����Ǿ���� �ڵ�)
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
		//4. ��ü ����
		UseThread ut=new UseThread();
		//5. �θ� Ŭ������ Thread �� ������ �ִ� start( ) �޼ҵ� ȣ��
		ut.start();// start()ȣ���ϸ� start()�ȿ��� -> run()ȣ��	//���ÿ� �����̵ȴ�.
		ut.test();
		
		//���ÿ� �����̵ȴ�. Thread �Ź� �޶�����.
		//1.��ӹ޾Ƽ� thread���, 2. �������ؼ� thread ���
	}//main

}//class
