package day1120;

public class Homework1 {

	public static void main(String[] args) {
		int sum=0;
		
		
		System.out.println("=========구구단 시작=================");
		for(int i=2; i<10; i++) {
		System.out.println(i+"단 시작");
			for(int j=1; j<10; j++) {
		
				System.out.println(i+" * "+j+" = "+(i*j) );
			}//안쪽 end for
			
				System.out.println(i+"단 끝=============");
		}//end for
	System.out.println("==============구구단 끝============");
		
		
		
	
		
		
		
		
		
		
	}//main
}//class
