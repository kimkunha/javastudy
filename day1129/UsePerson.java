package day1129;

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
		
		
		
		
	}//main

}//class
