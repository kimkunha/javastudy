package day1203_sub;

/**
 * 	�θ�Ŭ������ ��ӹް� ����Ѵ�. �������̵� ����
 *	�ڽ� Ŭ���� �ۼ�
 * @author owner
 */
public class sub extends Super{

	public sub(){
		this(100);
//		super(); �Ⱦ��� ������ ���⿡�� �θ��� super�� �����Ǿ� �ִ�.
		System.out.println("�ڽ��� ������");
		}//�⺻ ������
	
		public sub(int i){
		super(); //�Ⱦ��� ������ ���⿡�� �θ��� super�� �����Ǿ� �ִ�.
			System.out.println("�ڽ��� ���� �ִ»�����"+i);
		}//���� �ִ� ������
		
		
	public void methodA() {
		System.out.println("�ڽ��� �żҵ�");
	}//method
	
	public void printA() {
		System.out.println("�̰��� ���� ������ �������̵� �Դϴ�");
	}//method
	
	
}//class
