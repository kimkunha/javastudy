package day0103;
//19.01.03 -5�� �ڷ�- (Thread ���)
public class UseLambda3 {

	public static void main(String[] args) {

		Thread t=new Thread( () -> {
			for (int i=0; i< 1000; i++) {
				System.out.println(i);
				}
			});
		t.start();
		
		for (int i=0; i< 1000; i++) {
			System.out.println("mani----i"+i);
		}//end for
		
	}//main

}//class
