package day1203;
import java.util.Arrays;
//18.12.03 수업 10번 자료
import java.util.Date;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd=new HongGilDong();
		gd.setName("홍길동");		// 부모의 method 사용 (코드의 재사용성)
		System.out.println("눈 : "+gd.getEye()+", 코 : "+gd.getNose()+", 입 : "+gd.getMouth());
		System.out.println(gd.eat());
		System.out.println(gd.eat("국밥",1));
		//자신만의 특징 
		System.out.println( gd.fight(6)); // 레벨 7>8 됨
		System.out.println( gd.fight(7)); // 레벨 8>9 됨
		System.out.println( gd.fight(9)); // 레벨  비김
		System.out.println( gd.fight(10)); // 진다 9>8
		System.out.println( gd.fight(9)); // 진다 8>7
		
		System.out.println("------------------------------------------------------------------------------------------------");
		Clark superman=new Clark();// 자식이 생성되면 부모클래스가 먼저 생성된후 자식이 생선된다.
		// 자식의 객체로 부모클래스의 자원 (변수,method)를 자식의 것처럼 사용할수 있다. (코드의 재사용성)
		
		superman.setName("클락");
		
		System.out.println(superman.getEye()+" / "+superman.getNose()+" / "+superman.getMouth()
		+superman.getName());
		System.out.println(superman.eat());
		System.out.println(superman.eat("스테이크",10));
		
		//(자신)자식의 자원 (변수, method)
		String stone="짱돌";

		System.out.println(stone+"은 맞은 결과"+superman.power(stone)+", 힘의 변화 : "+
		superman.power);
		
		stone="클립토나이트";
	
		System.out.println(stone+"은 맞은 결과"+superman.power(stone)+", 힘의 변화 : "+
				superman.power);
		
		stone="다이아몬드";
		
		System.out.println(stone+"은 맞은 결과"+superman.power(stone)+", 힘의 변화 : "+
				superman.power);
		
		
		System.out.println(gd);				//객체를 출력하면 주소가 출력된다 : 이유는 object에서 제공하는 toString()method를
		System.out.println(superman);	// 호출하여 반환하는 값을출력하기 때문이다
		
		String s=new String("오늘은 금요일 입니다");
		System.out.println(s.toString());
		
		Date d=new Date();
		System.out.println(d.getYear());
		
		@SuppressWarnings("unused")
		int i;
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		String[] clarkLang=superman.language("외계어");
		clarkLang=superman.language("영어");
		
		System.out.println(Arrays.deepToString(clarkLang));
		
		String[] hongLang=gd.language("한국어");
		hongLang=gd.language("중국어");
		hongLang=gd.language("수화");
		
		System.out.println(Arrays.toString(hongLang));
		System.out.println("----------------------------------------------------------------------------------------------------------");
		
		//Clark은 interface를 구현하였으므로 비행가능
		System.out.println(superman.speed("빠른"));
		System.out.println(superman.height("높"));
		
		
		
	}//main

}//class
