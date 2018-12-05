package day1205;


//18.12.05 1번 자료 (StringBuffer,StringBuilder 정의)
/**
 * 	StringBuffer, StringBuilder(JDK1.5에서 등장)		//속도 문제로 StringBuilder를 자주 사용
 *	문자열을 heap에 직접 저장하고 사용하는 클래스
 *	//질문  왜 sb를 쓰는지 객체화를 여서 하는지?
 * @author owner
 */
public class UseStringBuilder {
																							//딜리트 는 시작인덱스와 끝 인덱스를 지운다
	public void userStringBuffer() {
		//1. 클래스 생성
		StringBuffer sb=new StringBuffer();
		//2. 값( )추가 ( append)			//값은 뭐가될지 모른다(정수,실수,문자,불린,문자열..입력가능하기때문)
		sb.append("오늘은 ");//문자열
		sb.append(12);//정수
		sb.append("월 5일").append("수요일 입니다.");//문자열    method체인으로 연결
		System.out.println(sb);
		//3. 값 삽입
		//오늘은 12월 5일수요일 입니다. 
		//0 1 2 34
		sb.insert(4, "2018년");
		
		//4. 값 삭제 : delete(시작인덱스, 끝인덱스+1) //+1이유는 끝자리에 널값을 가지고 있어서 +1해줘야 한다.
		//오늘은 2018년12월 5일수요일 입니다. 
		sb.delete(0, 3);			//전체를 삭제할거면 시작0 sb.length를 사용하면 된다.
		System.out.println(sb); 	
		sb.reverse();	//거꾸로 뒤집어서 출력
		System.out.println(sb);
	}//useStringBuffer
	
	//String을 잘 안쓰는 이유 짧은문자열을 다룰때 사용
	public void userStringBuilder() {
		//1. 클래스 생성
		StringBuilder sb=new StringBuilder();
		//2. 값( )추가 ( append)			//값은 뭐가될지 모른다(정수,실수,문자,불린,문자열..입력가능하기때문)
		sb.append("오늘은 ");//문자열
		sb.append(12);//정수
		sb.append("월 5일").append("수요일 입니다.");
		System.out.println(sb);//문자열    method체인으로 연결
		//3. 값 삽입
		//오늘은 12월 5일수요일 입니다. 
		//0 1 2 34
		sb.insert(4, "2018년");
		
		//4. 값 삭제 : delete(시작인덱스, 끝인덱스+1) //+1이유는 끝자리에 널값을 가지고 있어서 +1해줘야 한다.
		//오늘은 2018년12월 5일수요일 입니다. 
		sb.delete(0, 3);			//전체를 삭제할거면 시작0 sb.length를 사용하면 된다.
		System.out.println(sb); 	
		sb.reverse();	//거꾸로 뒤집어서 출력
		System.out.println(sb);
	}//UseStringBuilder
	
	
	public static void main(String[] args) {
		//객체생성
	UseStringBuilder usb= new UseStringBuilder();
	usb.userStringBuffer();
	System.out.println("--------------------------------------------------------------------------------------");
	usb.userStringBuilder();
		
	String str= "안녕하세요?";	//짧은 문자열은 그냥 string에 저장
		System.out.println(str);
		
		//문자열에 +(더하기)가 붙어서 긴 문자열
	String str1="안";	
		System.out.println(str1+"녕"+"하"+"세"+"요");
		//new StringBuilder(String.valueOf(str1))).append(str1).append("녕").append("하").append("세").append("요").toString());
				//valueOf나온 이유는 기본형데이터를 문자열로 변경해서
		
		
	}//main

}//class
