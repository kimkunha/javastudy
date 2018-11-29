package day1126;

/**
 * Ŭ������ ��ü�� ���� �ɶ� �⺻������ ������ �־�� �� �⺻���� �����ϰų� �⺻������ ����� �ڵ带 �����ϴ� method ����
 * 
 * @author owner
 */
public class TestConstructor {

	/**
	 * 	�⺻������ : Ŭ���� �ۼ��Ҷ� �����ڸ� �ϳ��� �������� ������
	 * �����Ϸ��� �Ű����� ���� Default Constructor�� �����Ѵ�
	 */
	public TestConstructor() {
		System.out.println("�⺻ ������");
//		TestConstructor(300);// �����ڸ� method ȣ���ϵ� ȣ���� �� ����.
	
	}// TestConstructor
	
	/**
	 * 	�����ִ� ������	(�ܺ��� ���� �Է¹޴´�)
	 * @param i	������ ��
	 */
	public TestConstructor(int i) {
		System.out.println("���� �ִ� ������"+i);
	}// TestConstructor

	public void test() {
		System.out.println("test method");
		temp();//method ȣ��
		typeA();// Ŭ�������� ������ �ٸ� �޼ҵ带 �̷������� ȣ���ؼ� ���� ��� �Ҽ� �ִ�.
	}//test			�ν��Ͻ� method�̸� �������� ��
	
	public void temp() {
		System.out.println("------temp method!!");
	}//temp
	
	public void typeA() {
		System.out.println("�ȳ��ϼ���?");
	
	}
	public static void main(String[] args) {
		//Overloading �� �����ڸ� ����Ͽ� ��üȭ�� �پ��ϰ� �� �� ����
		TestConstructor tc = new TestConstructor();	// �⺻������
		TestConstructor tc1 = new TestConstructor(26);	// �����ִ� ������
		
		System.out.println(tc);	
		System.out.println(tc1);	//��ü�� ����ϸ� �ּҰ� ���´�.
		System.out.println("==============================������=======================================");
		tc.test();
		
		
		
	}// main
}// class
