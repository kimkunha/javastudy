/*2.  do~while�� ����Ͽ� �Ʒ��� ������  *�� ����ϴ�  static method��
    �ۼ��Ͽ� ȣ���ϼ���.
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
		 HomeWork2.staticStar();    //Ŭ�������� �ٿ� �������� ����
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
