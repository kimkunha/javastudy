package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//18.12.19	-2�� �ڷ�-	(8bit Stream�� 16bit Stream�� ����)	�Է��� �ٿ� 1. Ű���� �Է�
/**
 *	����ڰ� �Է��� Ű������ ���� ó���ϴ� System.in
 * @author owner
 */
public class UseKeyboardInput2 {

	public UseKeyboardInput2() {
		
		System.out.println("�ƹ�Ű�� ������ ����");
	
		//8bit Stream�� 16bit Stream�� ����
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in ));
			try {
			
		//�Է� �� �� ���� �Է� ���� �ϳ� �ޱ�.
//			int input=System.in.read();	//read�� ��� method
			
		//while�� ����� �Է� ���� ��ŭ ���� �ޱ� , �Էµ� ��� ���ڿ� �ޱ� : �ѱ��� ���� �� ����.
//			int input=0;
//			while(true) {
//				input=System.in.read();
//				System.out.print( (char)input);		//char�� casting�ϸ� �״�� �Է¹����� �ִ�. �ѱ�X
//				
//				if(input==13) {		//���Ͱ� 13�̴ѱ� ����ġ�� ������
//					break;
//				}
//			}//end while
			
//			System.out.println("�Է°� : "+input);
			
			//16bit stream�� ����Ͽ� �Էµ����͸� �ٴ����� �о� ���δ�.
			String str=br.readLine();
			
			System.out.println( str );
			
			//��Ʈ�� ����� �� ������ ��Ʈ���� ������ ���´�.
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}//UseKeyboardInput
	
	
	
	public static void main(String[] args) {
		new UseKeyboardInput2();
	}//main

}//class
