package day1219;

import java.io.IOException;


//18.12.19	-1�� �ڷ�-	(System.in)
/**
 *	����ڰ� �Է��� Ű������ ���� ó���ϴ� System.in
 * @author owner
 */
public class UseKeyboardInput {

	public UseKeyboardInput() {
		try {
		//�Է� �� �� ���� �Է� ���� �ϳ� �ޱ�.
		System.out.println("�ƹ�Ű�� ������ ����");
//			int input=System.in.read();	//read�� ��� method
			
		//while�� ����� �Է� ���� ��ŭ ���� �ޱ�, �Էµ� ��� ���ڿ� �ޱ� : �ѱ��� ���� �� ����.
			int input=0;
			while(true) {
				input=System.in.read();
				System.out.print( (char)input);		//char�� casting�ϸ� �״�� �Է¹����� �ִ�. �ѱ�X
				
				if(input==13) {		//���Ͱ� 13�̴ѱ� ����ġ�� ������
					break;
				}
			}//end while
//			System.out.println("�Է°� : "+input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}//UseKeyboardInput
	
	
	
	public static void main(String[] args) {
		new UseKeyboardInput();
	}//main

}//class
