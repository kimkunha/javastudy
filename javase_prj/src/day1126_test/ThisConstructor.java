package day1126_test;

/**
 *	this method���� ����
 *	this( ); �ƹ��͵� ������ �⺻������ ( )�ȿ� ���� ��������� �����ִ� ������
 * @author owner
 */
public class ThisConstructor {

	public ThisConstructor() {
//		this(10);  // �̷����ϸ� ���ѷ����� �߻��ȴ�
		System.out.println("�⺻ ������");
	}//�⺻ ������
	
	public ThisConstructor(int i) {
		this();
		System.out.println("���� �� �ִ� ������");
	}//���ڰ��� �ִ� ������
	
	public ThisConstructor(int i, int j) {
		this(10);
		System.out.println("���� �� �ִ� ������2222");
	}//���ڰ��� �ִ� ������
	
	//this method������ �����ڸ� ȣ���ϴ°��̱� ������ this�� ��������� �� ���� �ؼ� �������.
	
	
	
	
	public static void main(String[] args) {
		new ThisConstructor(10,15);
		
	}//main

}//class
