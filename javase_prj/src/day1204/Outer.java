package day1204;
//18.12.04 1�� �ڷ� (Innerclass ����)
/**
 * 
 * @author owner
 */
public class Outer {
	int i;
	 
	public Outer() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//OuterConstructor
	
	public void outMethod() {
		System.out.println("�ٱ� Ŭ������ method i ="+i);
//		System.out.println("���� Ŭ������ j = "+j); //���Ұ�
		
//		//����Ŭ������ ��üȭ
//		Outer.Inner in = this.new Inner();		//this�� �ؼ� ����Ҽ� �ִ�.
//		in.j=100;
//		in.inMethod();
	}//outMEthod
		
	
	/////////////////////////////////////////����Ŭ���� ����///////////////////////////////////////////////////
	public class Inner{
		int j;
		public Inner() {
			System.out.println("���� Ŭ������ ������");
		}//Inner constructor
		
		public void inMethod() {
			System.out.println("���� Ŭ������ method j = "+j+", �ٱ� Ŭ������ �ڿ� i = "+i);
			outMethod();//�ٱ� Ŭ������ method    //���ʿ����� �ٱ�Ŭ������ �ڿ� ������� ��밡��
		}//inMethod
		
	}//class
	/////////////////////////////////////////����Ŭ����  ��/////////////////////////////////////////////////////
	public static void main(String[] args) {
		//1. �ٱ� Ŭ������ ��üȭ
		Outer out = new Outer();
		out.i=10;
		out.outMethod();
//		out.j=100;	//���Ұ�  (����Ŭ������ �ڿ��� ���� �����Ͽ� ����Ҽ� ����.)		����ϰ� ������� Ư���� ��üȭ�� �Ͽ��� �Ѵ�.
//		out.inmethod();//���Ұ�  (����Ŭ������ �ڿ��� ���� �����Ͽ� ����Ҽ� ����.)
		//2. ����Ŭ������ ��üȭ :  --�ٱ� Ŭ�������� ���� Ŭ������ �ڿ��� ����� �� �ִ�.
		//	 �ٱ�Ŭ������.����Ŭ������  ��ü��  =  �ٱ�Ŭ������ ��ü��.new  ���ʻ�����( );
//				Outer.Inner in = out.new Inner();				//�������� ��üȭ ���
				Inner in = out.new Inner();						//�ٱ�Ŭ�������� ������ �� �ִ�.
				in.j=12;						//����Ŭ������ �ڿ��� ���
				in.inMethod();				//����Ŭ������ �ڿ��� ���
			
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}//class
