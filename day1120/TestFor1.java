package day1120;

/** 
 * ���� for : �ε����� ������ ����ؾ� �ϴ� ���.<br>
 * ���� )	for(���۰�; ����; ����.���ҽ�){<br>
 * ���� )			for(���۰�; ����; ����.���ҽ�){<br>
 * 						�ݺ����๮��;<br>
 * 					}<br>
 * 				}<br>
 * @author owner
 */
public class TestFor1 {

	public static void main(String[] args) {
		for(int i=0; i<6; i++) {
			for(int j=0; j<7; j++) {
				System.out.println("i: " + i+", j :" +j);//���� for ���
				}//end for
			System.out.println("=========================");//����for ���
		
		}//end for
	
		for(int i=2; i<10; i++) {//�� ����
		System.out.println(i+"�� ����");
		for(int j=1; j<10; j++) {//��
			System.out.println(i+" *"+j+" = "+i*j);
			}//end for
		System.out.println(i+"�� ��");
	}//end for
	

		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
			System.out.print( i+" "+j+" ");	
		}
		System.out.println();
		}

		for(int i =0; i<4; i++) {
			for(int j =i+1; j<5; j++) {
				System.out.print(i+" "+j+" ");			
		}
			System.out.println();
		}
	}//main
}//class