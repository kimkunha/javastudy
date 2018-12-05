package day1203;
//18.12.03 수업 13번 자료
/**
 *	구현클래스(자식클래스)에서 반드시 구현해야하는 일의 목록만
 *	정의하는 interface의사용법.(구현의 강제성)
 * @author owner
 */
//interface는 부모를 여러개 가질 수 있다.   
//자식은 부모 interface의 추상method를 구현하지 않는다.
public interface SuperInterface extends InterA, InterB{											
	//Constant : 변수를 상수처럼 사용
//	int i; //변수는 작성할 수 없다.
	public static final int FLAG_VALUE=12;			//상수명은 대문자로 해주는것이 좋다
	
	//추상method 구성							//추상method는 body가 없는게 특징
	//일반 method 는 가질 수 없다. Error
//	public void test() {	 }
	
//인터페이스간 상속에는 추상method를 Override하지 않는다.
//		@Override
//		public String msg();
	
		//abstract을 사용하지 않아도 된다.  (대신 body가 있으면 안된다.)
		public void methodA();				
		//abstract을 사용해도 된다.
		public abstract void methodB(int i);

	
}//interface
