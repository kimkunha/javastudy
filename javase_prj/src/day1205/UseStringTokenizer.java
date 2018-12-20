package day1205;
//18.12.05 2번 자료 (StringTokenizer 정의)
import java.util.StringTokenizer;

/**
 *	문자열을 짧은 마디로 구분하는 StringTokenizer의 사용
 * @author owner
 */
public class UseStringTokenizer {
	public UseStringTokenizer() {
		String msg="오늘은 수요일 입니다. 날씨는 -5입니다. 쉬었다가 합시다";
		
		//공백으로 구분 : 매개변수 하나인 생성자를 사용.
		StringTokenizer stk=new StringTokenizer(msg);
		
		System.out.println(stk.countTokens()+"개");
		
		while(stk.hasMoreTokens()) {	//토큰이 존재하는 지?
			//토큰을 얻고 포인터를 다음으로 이동
			System.out.println(stk.nextToken());
		}//end while
		
		String names="이재현,이재찬~정택성,김희철.김정운~김정윤,공선의";
		
		//특정문자로 토큰 구분 : 매개변수 두개인 생성자(String," " )
		StringTokenizer stk1= new StringTokenizer(names, ",~.");    //" "안에 해당하는 문자열을 다잘라서 출력이 가능하다. 한글도 가능 해당문자는 잘려져서 출력
				System.out.println("-----------------------------------------");
		System.out.println("토큰의 수 : "+stk1.countTokens());
		
		while(stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}//end while
	
		//특정문자로 토큰 구분, 구분된 문자열도 토큰으로 취급(처리) :
		//매개변수 세개인 생성자를 사용하면 된다.
		System.out.println("---------------------------------------------------------------------------------------------------");
		StringTokenizer stk2=new StringTokenizer(names,",.~",false);		//true : 토큰으로 취급
		System.out.println("토큰의 수 : "+stk2.countTokens());
	
		while(stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}//end while
		
		System.out.println(stk);
		
	}//UseStringTokenizer
	
	
	public static void main(String[] args) {
		new UseStringTokenizer();
		
		
	}//main

}//class
