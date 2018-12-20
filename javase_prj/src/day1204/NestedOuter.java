package day1204;
//18.12.04 2�� �ڷ� (Nested class ����)
/**
 *	����Ŭ������  static ����ó�� ����� �� �ִ� ��øŬ����.
 * @author owner
 */
public class NestedOuter {

	int i;
	static int j;			// ����ƽ ������ : ��üȭ ���� �ʰ� �������� ����Ҽ� �ִ�.
	 
	public NestedOuter() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//Nested Constructor
	
	public void outInstMethod() {			//�ν��Ͻ� ���� ����
		System.out.println("�ٱ� Ŭ������ �ν��Ͻ� method");
	}//outInstMEthod
	
	public static void outStatMethod() {		//����ƽ ���� ���� 
		System.out.println("�ٱ� Ŭ������ static method");
	}//outInstMEthod
	
	////////////////////////////////////////////////Nested class ���� /////////////////////////////////////////////////////
	static class NestedInner{
//		int in_i;	//instance ����(����� ������ �������� ����)		staticŬ������ ���� ���ʿ����� �⺻�� instance����
		// ( ����(static class)���� �ν��Ͻ������� ����� ����� �� �� ������ 
		//�ٱ���(nestedouter Class)���� ������ �ν��Ͻ� ����, method�� ����Ҽ� ����. )
		static int in_j; //static ����
		
//		public NestedInner() {		�����ڸ� ����������� �� ������ ����
//		} 								static������ ��üȭ�� ���� �ʱ� ������ �����ڸ� ����� ȥ���� ������ �ʿ䰡 ����.
		public void inMethod() {
			System.out.println("���� Ŭ������ �ν��Ͻ� method");
		}//inMethod
		
		public static void inStatMethod() {
			System.out.println("���� Ŭ������ static method");
			System.out.println("�ٱ� Ŭ������ �ڿ� ��� i = ���Ұ� , j = "+j +NestedOuter.j );   //�ٱ�Ŭ������.j ��� ��밡��
//			outInstMethod();// instance������ method�̹Ƿ� ����� �� ����.  
			NestedOuter.outStatMethod();//����ƽ������ ����ƽ�޼ҵ� ���� Ŭ������(��ó)�� ������ �������� ����
		}//inStatMethod
	}//class
	///////////////////////////////////////////////////Nested class �� ///////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		//static ������ ����� ������ ��üȭ ���� Ŭ������.������, Ŭ������.method������ ����Ѵ�.  (static ���)
//		inStatmethod();		//static�̶�� ������ ���ٰ� �ؼ� ����Ҽ��� ����. Ŭ�������� ������Ѵ�.
		NestedInner.inStatMethod();		//Ŭ������.method������ ����Ѵ�.
		
		NestedOuter no=new NestedOuter();
		no.i=10;
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}//class
