package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//18.12.19	-2번 자료-	(8bit Stream과 16bit Stream을 연결)	입력의 근원 1. 키보드 입력
/**
 *	사용자가 입력한 키보드의 값을 처리하는 System.in
 * @author owner
 */
public class UseKeyboardInput2 {

	public UseKeyboardInput2() {
		
		System.out.println("아무키나 누르고 엔터");
	
		//8bit Stream과 16bit Stream을 연결
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in ));
			try {
			
		//입력 값 중 최초 입력 문자 하나 받기.
//			int input=System.in.read();	//read를 블록 method
			
		//while을 사용해 입력 넣은 만큼 문자 받기 , 입력된 모든 문자열 받기 : 한글은 받을 수 없다.
//			int input=0;
//			while(true) {
//				input=System.in.read();
//				System.out.print( (char)input);		//char로 casting하면 그대로 입력받을수 있다. 한글X
//				
//				if(input==13) {		//엔터가 13이닌까 엔터치면 나가라
//					break;
//				}
//			}//end while
			
//			System.out.println("입력값 : "+input);
			
			//16bit stream을 사용하여 입력데이터를 줄단위로 읽어 들인다.
			String str=br.readLine();
			
			System.out.println( str );
			
			//스트림 사용이 끝 났으면 스트림의 연결을 끊는다.
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}//UseKeyboardInput
	
	
	
	public static void main(String[] args) {
		new UseKeyboardInput2();
	}//main

}//class
