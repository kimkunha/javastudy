package day1203;
//18.12.03 ���� 17�� �ڷ�
public class UseDefaultMethod implements UseDefault {

	@Override // annotation���� Override�� ������ ���� �׳� ����� �ȴ� ��Ŭ���� ����
	public void test() {
		System.out.println("Override method");
	}//test

	public static void main(String[] args) {
		//�ڽ� Ŭ���� ��üȭ
		UseDefaultMethod udm=new UseDefaultMethod();
		udm.test();
		udm.temp(); //default method
		
		
		//is a ������ ��üȭ
		UseDefault ud=new UseDefaultMethod();
		ud.test();	// Override�� method�� ȣ��
		ud.temp(); //default method
	
	}//main

}//class
