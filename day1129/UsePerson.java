package day1129;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd=new HongGilDong();
		gd.setName("ȫ�浿");		// �θ��� method ��� (�ڵ��� ���뼺)
		System.out.println("�� : "+gd.getEye()+", �� : "+gd.getNose()+", �� : "+gd.getMouth());
		System.out.println(gd.eat());
		System.out.println(gd.eat("����",1));
		//�ڽŸ��� Ư¡ 
		System.out.println( gd.fight(6)); // ���� 7>8 ��
		System.out.println( gd.fight(7)); // ���� 8>9 ��
		System.out.println( gd.fight(9)); // ����  ���
		System.out.println( gd.fight(10)); // ���� 9>8
		System.out.println( gd.fight(9)); // ���� 8>7
		
		
		
		
	}//main

}//class
