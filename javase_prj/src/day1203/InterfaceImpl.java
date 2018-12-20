package day1203;
//18.12.03 수업 14번 자료   ( 11 ~ 14번자료 셋트)
/**
 *	interface를 구현하는 class (자식 클래스이고 interface내 모든 추상method를 Override하는 클래스)           -맨 마지막 자식 클래스-
 *	구현 interface가 부모 interface를 가진다면 최종적인 자식클래스에서는 모든 추상method를 구현해야 한다.
 * @author owner
 */
public class InterfaceImpl implements SuperInterface{
	
	@Override
	public String msg() {	//InterA
		return "내일은 화요일";
	}//msg
	
	@Override
	public String msgB() {	 //InterB
		return "오늘은 월요일";
	}//msgB

	@Override
	public void methodA() { //SuperInterface
		System.out.println("methodA");
	}//methodA

	@Override
	public void methodB(int i) { //SuperInterface
		System.out.println("methodB");
	}//methodB
	public void test() {
		
	}
	
	public static void main(String[] args) {
		//자식 클래스로 객체화 : 모든 method를 호출할수 있다.
		//ii.msg(), ii.msgb(), ii.methodA(), ii.methodb(), ii.test() 전부 부를수 있다.   -자식이라서-
		InterfaceImpl ii=new InterfaceImpl();
		ii.methodB(12);
		
		//is a 관계의 객체화   (부모를 앞으로 자식의 생성자를 뒤로)
		//SuperInterface로 객체화를 하면 Override된 method만 호출
		//부모의 method도 모두 호출 가능
		//si.msg(), si.msgB(), si.methodA(), si.methodB()
		SuperInterface si=new InterfaceImpl();
		System.out.println(si.msg());
		
		//InterA로 is a 관계의 객체화 하면 : ia.msg()만 호출 가능.
		InterA ia= new InterfaceImpl();
		System.out.println(ia.msg());
		
		//InterB로 is a 관계의 객체화 하면 : ib.msg()만 호출 가능.
		InterB ib= new InterfaceImpl();
		System.out.println(ib.msgB());
		
		//object o=new interfaceImpl 도 가능하다 object은 모든 자식자식을 저장할수 있다.  //object에 달려있는 method만 사용가능
		//interface는 객체화 되지 않는다. 스스로는 객체화가 되지 않고 자식을 통해서만 객체를 만들수 있다.
//		InterA ia1=new InterA();
//		SuperInterface si1=new SuperInterface(); 
		
		
	}//main
}//class
