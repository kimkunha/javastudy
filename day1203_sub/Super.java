package day1203_sub;

import java.util.concurrent.SynchronousQueue;

/**
 *	�θ� Ŭ���� �ۼ�
 * @author owner
 */
public class Super {
	int i;
	
	public Super() {
		this(100);
		System.out.println("�θ��� ������");
	}//������
	
	public Super(int i) {
		System.out.println("�θ��� ���� �� �ִ� ������"+i);
	}//������
	
	public void pMethod() {
		System.out.println("�θ��� �޼ҵ�");
	}//�θ��� Ŭ����
	
	public void printA() {
		System.out.println("�̰��� �θ��� �޼ҵ� ");
	}//�żҵ�
	
	
	
	
	
}//class
