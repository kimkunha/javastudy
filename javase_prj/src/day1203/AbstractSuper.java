package day1203;
//18.12.03 ���� 5�� �ڷ� (5��~6�� �ڷ� ����)
/**
 *	����� �������� ����� �θ� Ŭ����.<br>
 *	��üȭ�� ���� �ʴ´�.<br>
 *	�ڽ�Ŭ������ �ݵ�� �����ؾ� �� abstract method�� ������ Ŭ����.
 * @author owner
 */
public abstract class AbstractSuper {

	int i;
	
	public AbstractSuper() {
		//�ڽ�Ŭ������ �����ɶ��� ȣ�� �ȴ�.
		System.out.println("AbstractSuper �θ� ������");
	}//AbstractSuper Constructor
		
	public void method() {
		System.out.println("�θ� ���� �ϴ� �Ϲ� method");
	}//method
	
	//abstract method�� �ڽ��� �ݵ�� �����ؾ� �� ���� �������
	public abstract void absMethod(); //�߻�method                      // �ٵ� ��� �������� �ݵ�� �ڽĿ��� Overriding�� �ؾ��Ѵ�
	public abstract String absMethod1(int i); //�߻�method          //��ȯ�� �Ű����� ������ �ִ�.        
	
	
//	public static void main(String[] args) {
//		new AbstractSuper();   //abstract Ű���带 ����ϸ� ��üȭ�� �Ұ����� ����.
//			}//main
		
		
		
		
		
		



}//class