package Study;

import java.util.ArrayList;
import java.util.List;

public class UseMethod {

	private List<String> names;
	
	/**
	 * 	반환형 없고 매개변수 없는 타입
	 */
	public void typeA() {
		System.out.println("반환형 과 매개변수가 없는 메소드");
		names =new ArrayList<String>();
		//값 할당 
		names.add("김건하");
		names.add("조현정");
		names.add("박영민");
		names.add("정택성");
		
		for(int i=0; i<names.size(); i++ ) {
			System.out.println(names.get(i));
		}
		
		System.out.println("---------------------------------------------");
		}//type1
		
		/**
		 * 	반환형없고 매개변수 있는 형
		 */
		public void typeB( String name) {
			names=new ArrayList<String>();
			names.add(name);
			names.add("김건하");
			System.out.println("----------------------");
			for(int i=0; i<names.size(); i++){
				System.out.println(names.get(i));
		}
	
		}
	
	
	/**
	 * 	시작은 main method에서 시작이라 인스턴스영역의 자원을 사용할수가 없다.
	 * 	사용하려면 static 으로 사용하거나 객체화를 진행하여야 한다.
	 * @param args
	 */
	public static void main(String[] args) {
		UseMethod um=new UseMethod();
		String name="조현정";
		um.typeA();
		um.typeB("안녕");
		um.typeB(name);
	}//main

}//class
