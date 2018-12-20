/*2.  do~while을 사용하여 아래의 형태의  *을 출력하는  static method를
    작성하여 호출하세요.
    *
    **
    ***
    ****
    **/
    package day1121;

public class HomeWork2 {
	 public static void staticStar() {
	 
		int i=0;
		do {
			int j=0;
			while(j<i) {
				System.out.print("*");
				j++;
			}
			System.out.println("*");
			i++;
		}while(i <4);
	 }//end method

	public static void main(String[] args) {
		 HomeWork2.staticStar();    //클래스명을 붙여 가독성을 높음
//		int i=1;
//		do {
//			int j=0;
//			while(j<i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}while(i <5);	
		
	/*	
		int k=0;
		do {
			System.out.println("*");
			k++;
		}while(k<5);
			*/
		
	
		
			
		
	}//main

}//class
