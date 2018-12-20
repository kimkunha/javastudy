package day1203;
//18.12.03 ���� 14�� �ڷ�   ( 11 ~ 14���ڷ� ��Ʈ)
/**
 *	interface�� �����ϴ� class (�ڽ� Ŭ�����̰� interface�� ��� �߻�method�� Override�ϴ� Ŭ����)           -�� ������ �ڽ� Ŭ����-
 *	���� interface�� �θ� interface�� �����ٸ� �������� �ڽ�Ŭ���������� ��� �߻�method�� �����ؾ� �Ѵ�.
 * @author owner
 */
public class InterfaceImpl implements SuperInterface{
	
	@Override
	public String msg() {	//InterA
		return "������ ȭ����";
	}//msg
	
	@Override
	public String msgB() {	 //InterB
		return "������ ������";
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
		//�ڽ� Ŭ������ ��üȭ : ��� method�� ȣ���Ҽ� �ִ�.
		//ii.msg(), ii.msgb(), ii.methodA(), ii.methodb(), ii.test() ���� �θ��� �ִ�.   -�ڽ��̶�-
		InterfaceImpl ii=new InterfaceImpl();
		ii.methodB(12);
		
		//is a ������ ��üȭ   (�θ� ������ �ڽ��� �����ڸ� �ڷ�)
		//SuperInterface�� ��üȭ�� �ϸ� Override�� method�� ȣ��
		//�θ��� method�� ��� ȣ�� ����
		//si.msg(), si.msgB(), si.methodA(), si.methodB()
		SuperInterface si=new InterfaceImpl();
		System.out.println(si.msg());
		
		//InterA�� is a ������ ��üȭ �ϸ� : ia.msg()�� ȣ�� ����.
		InterA ia= new InterfaceImpl();
		System.out.println(ia.msg());
		
		//InterB�� is a ������ ��üȭ �ϸ� : ib.msg()�� ȣ�� ����.
		InterB ib= new InterfaceImpl();
		System.out.println(ib.msgB());
		
		//object o=new interfaceImpl �� �����ϴ� object�� ��� �ڽ��ڽ��� �����Ҽ� �ִ�.  //object�� �޷��ִ� method�� ��밡��
		//interface�� ��üȭ ���� �ʴ´�. �����δ� ��üȭ�� ���� �ʰ� �ڽ��� ���ؼ��� ��ü�� ����� �ִ�.
//		InterA ia1=new InterA();
//		SuperInterface si1=new SuperInterface(); 
		
		
	}//main
}//class
