package day1129;

/**
 *	TestSuper�� �ڽ�Ŭ����
 * @author owner
 */
public class TestSub extends TestSuper {														//extends TsetSuper �θ�Ŭ����
	int i;
	
	public TestSub() {
		System.out.println("�ڽ��� ������");
	}//TestSub
	
	public void subMethod() {
		System.out.println("�ڽ� method");
	}//subMethod
	
	public static void main(String[] args) {
		// ��üȭ�� �ڽ�Ŭ������ ����Ѵ�.
		TestSub ts=new TestSub();		//��üȭ
		// �ڽİ� �θ� ���� ��Ű�� �����ϸ� �θ� ����									//�ڽİ� �θ�� ���� ��Ű���� ���� ���ɼ��� ����.
		// ������ method�� ���������ڰ� public, protected, default�� �ڿ��� ����� �� �ִ�.				//private�� �Ұ���
		ts.pub_i=10;	// public
		ts.pro_i=20;	//protected
		ts.def_i=30;	//default
		ts.i=100;
		//�θ��� �ڵ带 ����ó�� ����. (�ڵ��� ���뼺)
		
		System.out.println("�θ��� �ڿ� "+ts.pro_i+" / "+ts.pub_i+" / "+ts.pro_i+" / "+ts.def_i);
		ts.superMethod();
		System.out.println("�ڽ��� �ڿ�"+ts.i);
		
		
	}//main

}//class
