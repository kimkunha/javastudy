package day1203_sub;

import day1203.SuperInterface;

public class InterfaceImpl implements SuperInterface {

	@Override
	public String msg() {
		return "안녕하세요";		
	}

	@Override
	public String msgB() {
		return "반갑습니다";
	}

	@Override
	public void methodA() {
		System.out.println("methodA");
	}

	@Override
	public void methodB(int i) {
	}
	//메인 메소드
	public static void main(String[] args) {
		//자식클래스로 객체화
		InterfaceImpl ic = new InterfaceImpl();
		System.out.println(ic.msg());
		ic.msgB();
		ic.methodA();
		ic.methodB(10);
		
	}

}
