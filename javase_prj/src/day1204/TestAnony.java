package day1204;
//18.12.04 5번 자료 (Anony class 정의   4번 ~ 6번 연계)
/**
 *	인터페이스가 method의 매개변수일때 간단하게 사용하는 방법.<br>
 *		Anony는 한번 불을때는 좋지만 여러번 부를때는 좋지않다.
 * 
 * @author owner
 */
public class TestAnony {
	
	public void useAnonInter(AnonyInter ai) {
		System.out.println( ai.getMsg()+" "+ai.getName());
	}//useAnonyInter
	
	public static void main(String[] args) {
//		AnonyInter ai= new AnonyInter();  //인터페이스는 객체화가 되지 않는다 
		//인터페이스가 매개변수 였을 때는
		//1. 인터페이스를 구현한 클래스를 생성.
		//2. 구현클래스로 객체를 생성
		AnonyImpl ai=new AnonyImpl();
		//3. 매개변수를 가진 method를 호출하기 위해 객체생성
		TestAnony ta =new TestAnony();
		//4. method 호출
		ta.useAnonInter(ai);
		System.out.println("----------------anonymous innerclass-----------------------------------");
		// anonymous inner class를 사용하면 클래스를 따로 만들필요가 없음
		
		ta.useAnonInter(new AnonyInter() {	//자식method "test"만은 출력이 안되서 같이 override에 붙여줘서 출력
			@Override
			public String getName() {
				return "공선의"+test();	
			}//getName
			@Override
			public String getMsg() {
				return "온뇨쇼";
			}//getMsg
			public String test() {
				return " 자식 method";
			}
			});
			
	
		
		
		
		
		
		
	}//main

}//class
