package day1203;
//18.12.03 수업 2번 자료
/**
 *
 * @author owner
 */
public class TestSub extends TestSuper{
	int i;
	
	public TestSub() {
		super();
		System.out.println("자식의 생성자");
	}//TestSub   생성자
	
	public void subMethod() {
		System.out.println("자식의 subMethod");
	}//subMethod   메소드
	
	@Override  //이것을 부르는 말을 애노케이션이라 한다
	public void printI() {
		System.out.println("자식이 Override한 method"+this.i+", 부모의 i = "+super.i);
	}//printI   메소드
	
		
		
		
		
		
		
		
		
		
		
		
		
		


}//class
