package day1203_sub;

/**
 *	상속받을 클래스를 정의 
 *	상속받은 모든 추상메소드는 구현해야 한다.(구현의 의무성??)
 *	오버라이딩을 했다는 표시로 annotaion을 하는 습관을 가지자
 *	
 * @author owner
 */
public class IntetfaceImpl  implements SuperInterface{
	//먼저 SuperInterface가 상속받은 인터페이스 2가지 추상메소드를 구현해야 한다
	
	
	public String msg(){
		return "안녕하세요";
	}//interA
	
	public String msgb() {
		return "반갑습니다";
	}
		@Override
		public void methodA() {
			System.out.println("methodA");
		}
		
		public void methodB(int i) {
		}
		
		
		
		
		


	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {


	}

}
