package day1219;

import java.io.IOException;


//18.12.19	-1번 자료-	(System.in)
/**
 *	사용자가 입력한 키보드의 값을 처리하는 System.in
 * @author owner
 */
public class UseKeyboardInput {

	public UseKeyboardInput() {
		try {
		//입력 값 중 최초 입력 문자 하나 받기.
		System.out.println("아무키나 누르고 엔터");
//			int input=System.in.read();	//read를 블록 method
			
		//while을 사용해 입력 넣은 만큼 문자 받기, 입력된 모든 문자열 받기 : 한글은 받을 수 없다.
			int input=0;
			while(true) {
				input=System.in.read();
				System.out.print( (char)input);		//char로 casting하면 그대로 입력받을수 있다. 한글X
				
				if(input==13) {		//엔터가 13이닌까 엔터치면 나가라
					break;
				}
			}//end while
//			System.out.println("입력값 : "+input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}//UseKeyboardInput
	
	
	
	public static void main(String[] args) {
		new UseKeyboardInput();
	}//main

}//class
