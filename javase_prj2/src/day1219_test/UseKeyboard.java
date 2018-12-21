package day1219_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *	값을 하나 입력하기
 * @author owner
 */
public class UseKeyboard {

	public static void main(String[] args) {
//		try {
//			int input=System.in.read();			//예외처리할것
//			System.out.println(input);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
		
		System.out.println("아무키나 눌러보세요");
		//while을 돌려서 긴 정수, 문자열 뽑아보기
		String str;
		try {
			
		while(true) {	//while이 true해서 돌린다.
			InputStream is = System.in;
//			InputStreamReader isr= new InputStreamReader(is);
//			BufferedReader br=new BufferedReader(isr);
//			String str=br.readLine();
		BufferedReader br=new BufferedReader(new InputStreamReader( System.in));
			str= br.readLine();
			
			
				if(str.equals("안녕")) {
					break;
				}
				br.close();
		}//end while
		//스트림 종료하면 반드시 닫아주기
		
			}catch (IOException e) {
				e.printStackTrace();
		}//end catch
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}//class
