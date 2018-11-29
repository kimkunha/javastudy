package day1127;

import java.util.concurrent.SynchronousQueue;

/**
 * 문자열 저장소의 주소를 저장하고, 문자열을 다루는 기능을 제공하는 String class의 사용<br>
 * java에서 제공하는 클래스의 이름과 내가 만든 클래스의 이름이 같다면 내가만든 클래스를 먼저 사용하게 된다. java에서 제공하는
 * 클래스를 사용할 때마다 "full path : 패키지명을 모두 기술하여 클래스를 사용하는 것"로 사용해야 한다. 패키지명.클래스명
 * 
 * @author owner
 */
public class UseString {

	public static void main(String[] args) {
		// 기본형 형식 사용. String s="문자열";
		String str = "Abcdefg";
		// 참조형 형식 사용. String s=new String("문자열");
		String mail = new String("kimkh8455@gmail.com");
		System.out.println(str);
		System.out.println(mail);

		
		// length길이
		System.out.println(str + "의 길이 " + str.length());
		System.out.println(mail + "의 길이 " + mail.length());

		// toUpperCase
		System.out.println(str + "을 모두 대문자 " + str.toUpperCase());
		System.out.println(mail + "을 모두 대문자 " + mail.toUpperCase());

		// toLowerCase
		System.out.println(str + "을 모두 소문자 " + str.toLowerCase());
		System.out.println(mail + "을 모두 소문자 " + mail.toLowerCase());

		
		// "AbcdEfg"
		// 0 123456
		// indexOf는 왼쪽 ->오른쪽 진행하면 가장 처음 찾아지는 문자열의 인덱스를 얻는다.
		System.out.println(str + "에서 'd'의 인덱스 : " + str.indexOf("d"));
		System.out.println(str + "에서 'd'의 인덱스 : " + str.indexOf("z"));

		
		// @인덱스 찾기
		System.out.println(mail + "에서 \"@\"의 인덱스 : " + mail.indexOf("@"));
		
		
		//lastIndexOf는 오른쪽에서 왼쪽으로 진행하면서 가장 처음 찾아지는 문자열의 인덱스를 얻는다.
		str = "AbcdEfAg";
		System.out.println(str + "문자열 에서 뒤로부터 'A'의 인덱스 :" + str.lastIndexOf("A"));
		
		
		//특정인덱스의 문자얻기
		char temp=str.charAt(2);
		System.out.println(str+"에서 2번째 인덱스에 해당하는 문자"+temp);
		
		
		//자식문자열 자르기
		//str = "AbcdEfAg";			2~5번째라고 해서 그리하면안됨 +1 해줘야함
		//		   01234567
		System.out.println(str+"에서 인덱스가 2~5번째 해당하는 문자열 "+ str.substring(2,6)); // 마지막 인덱스는 null값으로 처리되기 때문에 null값 한자리를 생각해서 +1로 해줘야 한다.		
		
		
		//kimkh8455   (메일주소)  @gmail.com  (도메인주소)   메일주소가 0~8까지지만 끝자리 null값 생각해서 +1해준다.
		//0123456789 <- String index    
		System.out.println(mail+"에서 메일 주소만 얻기"+mail.substring(0,9));
		System.out.println(mail+"에서 메일 주소만 얻기"+mail.substring(0,mail.indexOf("@")));
		
		System.out.println(mail+"에서 메일 주소만 얻기"+mail.substring(9,19));
		System.out.println(mail+"에서 도메인 주소만 얻기"+mail.substring(mail.indexOf("@")+1, mail.length()));
		//Substring은 시작 인덱스만 넣으면 끝까지 잘라 낸다.
		System.out.println(mail+"에서 도메인 주소만 얻기"+mail.substring(mail.indexOf("@")+1));
		
		
		//앞뒤공백자르기
		str="   A BC   ";
		System.out.println("["+str+"]에서 앞뒤공백제거 ["+str.trim()+"]");  // 앞뒤공백만 제거 가능 사이는 불가능
		
		
		//문자열붙이기
		str="Abcd";
		String str1=str.concat("Efg");
		System.out.println(str1);		
		String str2=str+"Efg";
		System.out.println(str2);
		
		
		//문자열이 완벽하게 같은지 비교
		str="이재찬";
		str1="김건하";
		System.out.println(str+"은(는)"+(str.equals("이재찬")?"반장":"평민"));
		
		//문자열이 이 문자열로 시작하는지
		str="피씨방";
		if(str.startsWith("씨방")) {
			System.out.println("욕은 사용하실수 없습니다.");
		}else {
			System.out.println(str);
		}//end else
		
		str="서울시 강남구";
		str1="수원시 팔달구";
		
		System.out.println(str+"은(는)"+(str.startsWith("서울")?"서울시 입니다":"서울이 아닙니다."));
		System.out.println(str1+"은(는)"+(str1.startsWith("서울")?"서울시 입니다":"서울이 아닙니다."));
		
		//특정 문자열로 끝났는지
		str="서울시 강남구 역삼동";
		str1="경기도 김포시 김포리";
		System.out.println(str+"은(는)"+(str.endsWith("동")?"도시":"시골"));
		System.out.println(str1+"은(는)"+(str1.endsWith("동")?"도시":"시골"));
		
		//치환
		str="나 지금 피씨방인데 넌 어디니 씨방새야!";
		System.out.println(str.replaceAll("씨방","**"));
		
		//method를 연결해서 호출하는 것을 method chain
		str="나 지금 피씨방인데 넌 어디니 씨 방새야!";
		System.out.println(str.replaceAll("씨","*").replaceAll("방","*") );
		
		str="   a bc   ";    //""붙은것을 empty라고한다
		System.out.println(str.replaceAll(" ", "") );
		
		int i=27;
//		str=i; 	int는 String으로 할당 될 수 없다.
		//기본형 데이터형을 문자열로 변환
		str=String.valueOf( i );
		System.out.println( str );
		
		double d=11.27;
		str=d+"";  //이렇게도 가능하지만 권장하지는 않음
		System.out.println(str);
		
		str="";
		System.out.println(str.isEmpty());		//True

		str="11";
		System.out.println(str.isEmpty());		//False
		
		//객체 생성을 하지 않았을 때 그 클래스가 제공하는 method를 사용할수 없다. Error
//		str=null;
//		System.out.println(str.isEmpty());
		
		///////////////////////////////////////////////11- 28- 2018 split 사용 코드 추가///////////////////////////////////////////////
		String data=
				"이재찬,이재현,정택성~공선의~김건하.최지우,노진경,김정운.김정윤";
		//split은 한번에 하나의 문자로 구분하여 자른다.
		String []arr=data.split("");	//.은 구분되지 않는다.  []묶어서 쓴다.
		System.out.println("구분된 배열 방의 갯수"+arr.length);
		for(String name : arr) {
			System.out.println( name );
		}//end for
		
		
		
		
		
		
		
		
		
		
	}// main;

}// class
