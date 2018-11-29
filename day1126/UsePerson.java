package day1126;

/**
 *	사람을 추상화 하여 만든Person 클래스를 사용하는 클래스
 * @author owner
 */
public class UsePerson {

	public static void main(String[] args) {
		//객체화 하여 객체생성 : heap에 생성되고 instance변수는 자동 초기화
		Person teacksung=new Person();
		//참조형 데이터형인 Person은 heap의 주소를 가지고 있다.
		System.out.println("객체를 출력하면 주소가 출력"+ teacksung);
		teacksung.setName("정택성");
//		teacksung.setEye(2);
//		teacksung.setNose(2);
//		teacksung.setMouth(1);
		
		System.out.format
		("생성된 사람 객체정보 눈[%d],코[%d],입[%d],이름[%s]\n",
		teacksung.getEye(),teacksung.getNose(),teacksung.getMouth(),teacksung.getName());
		//생성된 객체에서 정의된 일을 사용.
		System.out.println(teacksung.eat());
		System.out.println(teacksung.eat("육회 비빔밥",8000));
		System.out.printf("눈 %d개, 코 %d개, 입 %d개\n",teacksung.getEye(),teacksung.getNose(),teacksung.getMouth());
		
		System.out.println("==============================================");
		
		Person jinban=new Person(3,1,1);
		jinban.setName("천진반");
//		jinban.setEye(3);
//		jinban.setNose(1);
//		jinban.setMouth(1);
		
		System.out.format
		("생성된 사람 객체정보 눈[%d],코[%d],입[%d],이름[%s]\n",
		jinban.getEye(),jinban.getNose(),jinban.getMouth(),jinban.getName());
		
		
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("선두",1));
	}//main

}//class
