package day1203_sub;

import day1203.SuperInterface;

public class InterfaceImpl implements SuperInterface {

	@Override
	public String msg() {
		return "�ȳ��ϼ���";		
	}

	@Override
	public String msgB() {
		return "�ݰ����ϴ�";
	}

	@Override
	public void methodA() {
		System.out.println("methodA");
	}

	@Override
	public void methodB(int i) {
	}
	//���� �޼ҵ�
	public static void main(String[] args) {
		//�ڽ�Ŭ������ ��üȭ
		InterfaceImpl ic = new InterfaceImpl();
		System.out.println(ic.msg());
		ic.msgB();
		ic.methodA();
		ic.methodB(10);
		
	}

}
