package day1203_sub;

/**
 *	��Ӱ��� ���� 
 *	is a ���� ��üȭ
 * @author owner
 */
public class UsePlay {
	public Super test1() {
		Super s= new sub();
		return s;
	}// 
		
	
	

	public static void main(String[] args) {
		//���� �ڽ�Ŭ������ ��üȭ�Ͽ� �θ� Ŭ���� ����غ���
		sub s1= new sub();
		UsePlay us=new UsePlay();
		
		s1.i=100;
		System.out.println("�θ��� �ڿ��� ���"+s1.i);
		s1.pMethod(); // �θ��� �޼ҵ帣�� ����� (�ڵ��� ���뼺)
		s1.printA(); //
		System.out.println("-----------------------------------------------------------------");
		
		Super s=us.test1();
		
	}//main

}//class
