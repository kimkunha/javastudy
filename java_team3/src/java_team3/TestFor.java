package java_team3;

/**
 * 반복문에는 for문 while문, do while문이 있다 for문은 반복횟수를 알때 사용하며 do while문은 최소 한번 실행을 한다
 * 
 * @author KIM
 */
public class TestFor {

	public static void main(String[] args) {

		// 00
		// 	1011
		//   202122
		//    30313233
		for(int i=0;  i<4; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<=i; k++) {
				System.out.print(i+""+k);
			}
			System.out.println();
		}
		//*
		//**
		//***
		//****
		for(int i=0; i<4; i++) {
			System.out.print("*");
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<4; i++) {
			for(int j=1; j<=i; j++) {
					System.out.print(" ");
				}
			for(int k=0; k<=i; k++) {
				System.out.print(i+""+k);
		}
			System.out.println();
		}
	
		//향상된 for문
		int[]arr=new int[5];
		for(int tmp : arr ) {
			System.out.println(tmp);
		}
		
	}// main

}// class
