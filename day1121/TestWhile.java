package day1121;

/**
 *	while : ���۰� ���� �𸦶� ����ϴ� �ݺ��� <br>
 *			 �ּ� 0������ �ִ� ���Ǳ��� ����<br>
 *	���� )
 *			while(���ǽ�){<br>
 *				�ݺ����๮��<br>
 *			   }
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {

			int i =1; //�ʱⰪ;    
//			int i =100;			//���ǿ� �����ʰ� �ʱⰪ�� ũ�Գ����� �ѹ��� ���� ���Ҽ� �ִ�. (while�� Ư¡)
			while(i <10) {//���ǽ�
				System.out.println("i="+i);
				i++;//������
			}//end while
	
			System.out.println("================================================================'");
			
			//���� �Է¹޾� 2��~9�ܻ��̶�� ������ ���
			int j =2;
			int k=2;
			while(j<10) {
				System.out.println(j+"�ܽ���");
			
				while(k<10) {
					System.out.println(j+" * "+k+" ="+(j*k));
				j++;
					k++;
				}
			}//end while
			
			//����loop
			i=0;
			while(true) {
				System.out.println("���� loop");
				if(i==5) {
					break;
				}//end if
				i++;
			}//end while
		
		
		
		
		
	}//main

}//class
