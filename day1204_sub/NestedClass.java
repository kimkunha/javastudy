package day1204_sub;

/**
 * Nested class�� ����Ŭ������ static������ ����Ѵ� ���� ��üȭ�� ���� �ʴ´� �ٱ��� Ŭ�������� ���� Ŭ������ ����� ���
 * static������ ����Ѵ� : Ŭ������.staic���� or method
 *
 * @author owner
 */
public class NestedClass {
	int i;
	static int j;

	public NestedClass() {
		System.out.println("�⺻ ������");
	}// Nestedclass constructor

	public void NestedClassMethod() {
		System.out.println("�ٱ��� method");
	}// method

	/////////////////////////////////////////////////// ���� Ŭ���� ����
	/////////////////////////////////////////////////// ///////////////////////////////////////////////////////
	static class StaticNested {
		int a; // staticŬ�������� ���ʿ��� �⺻�� �ν��Ͻ������� ������� �ִ�
		static int z=10;
		

//				public  StaticNested(){		//�����ڸ� ����� ������ ��üȭ�� ���� �ʱ⋚���� ���� �ʿ�� ����.
//				}//������

		public static void StaticNestedMethod() {
			System.out.println("���� Ŭ������ method method �Դϴ�"+StaticNested.z);
		}

	}// staticNested

	/////////////////////////////////////////////////// ���� Ŭ���� ��
	/////////////////////////////////////////////////// ///////////////////////////////////////////////////////

	public static void main(String[] args) {

		//��üȭ�� �� �ʿ䰡 ����
		//�ٱ�Ŭ���� ��üȭ
		NestedClass ns =new NestedClass();
		ns.i=10000;
		ns.NestedClassMethod();
		
		//����ƽŬ������ �ڿ��� ����ϰ�������� ����ƽŬ������. ������ �޼ҵ带 ���̸� �ȴ�
		
		StaticNested.z=100;
		StaticNested.StaticNestedMethod();
		
		
		
		
	}// main

}// class
