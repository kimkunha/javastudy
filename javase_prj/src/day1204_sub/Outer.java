package day1204_sub;
//1�� innerŬ����
/**
 *	inner class�� �ۼ��غ���
 *	����Ŭ������ ���� �����ڴ� public
 *	����Ŭ���������� �ٱ��� Ŭ������ �ڿ��� ����Ҽ� �ִ�
 *	�ٱ��� Ŭ���������� ���� Ŭ������ �ڿ��� ����Ҽ� ���� ����Ϸ��� ��Ư�� ��üȭ�� ����� �Ѵ�
 *	��üȭ : ����Ŭ������ ��ü�� = �ٱ�Ŭ���� ��ü��.new ����Ŭ���� ������ ( );
 * @author owner
 */
public class Outer {
	int i;
	public Outer() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//OuterConstructor
	public void outerMethod() {
		System.out.println("�ٱ� Ŭ������ method");
		Inner in =this.new Inner();	//this�� ����ؾ� �ٱ���Ŭ���������� ����Ŭ������ ����Ҽ� �ִ�.
		in.j=100;
		in.innerMethod();
	}//method

	///////////////////////////////////////////////////////////////////���� Ŭ���� ���� ///////////////////////////////////////////////////////////////
	
	//����Ŭ������ ������ public���� �޾��ش�
	public class Inner{
		int j;
		public Inner() {
			System.out.println("inner ������ �ۼ�");
		}//������ �ۼ�
		
		public void innerMethod() {
			System.out.println("inner method = ��"+i);
		}//method
	}//inner class
		
	///////////////////////////////////////////////////////////////////���� Ŭ����  ��///////////////////////////////////////////////////////////////

	
	
	public static void main(String[] args) {
			//1. �ٱ��� Ŭ������ ��üȭ�� �켱�Ѵ�.
		Outer out = new Outer();
		out.i=15;
//		out.j=12;		//�ٱ���Ŭ������ ����Ŭ������ �ڿ� ���Ұ�
		System.out.println(out.i);
		out.outerMethod();
		
		
		
//		//���� Ŭ������ ��üȭ ����Ŭ������ ����Ŭ���� ��ü�� = �ٱ�Ŭ���� ��ü��.new ����Ŭ���� ������ ( );
		Inner in =out.new Inner();
//		//����Ŭ������ �ٱ��U Ŭ������ �ڿ��� ������ ��� ����
		in.j=150;
		in.innerMethod();
//		
//	
		
		
		
		
		
		
		
		
	}//main

}//class
