package day1219_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *	���� �ϳ� �Է��ϱ�
 * @author owner
 */
public class UseKeyboard {

	public static void main(String[] args) {
//		try {
//			int input=System.in.read();			//����ó���Ұ�
//			System.out.println(input);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
		
		System.out.println("�ƹ�Ű�� ����������");
		//while�� ������ �� ����, ���ڿ� �̾ƺ���
		String str;
		try {
			
		while(true) {	//while�� true�ؼ� ������.
			InputStream is = System.in;
//			InputStreamReader isr= new InputStreamReader(is);
//			BufferedReader br=new BufferedReader(isr);
//			String str=br.readLine();
		BufferedReader br=new BufferedReader(new InputStreamReader( System.in));
			str= br.readLine();
			
			
				if(str.equals("�ȳ�")) {
					break;
				}
				br.close();
		}//end while
		//��Ʈ�� �����ϸ� �ݵ�� �ݾ��ֱ�
		
			}catch (IOException e) {
				e.printStackTrace();
		}//end catch
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}//class
