/*
2. �̸�, ������ܰ� ����� �Ÿ��� �Է¹޾� �Ʒ��� ���� ����ϼ���.
   ��������� "����,����ö,�ý�,����"�� �����Ѵ�.
   ������� 1200��, ����ö ��� 1250��, �ýÿ�� 3800�� �Դϴ�.
   ����� 10Ű�� ������ �⺻���, �� 5Ű�� �ʰ��� ���� 100���� ���� �մϴ�.

 ���   :  xxx�� ����� ��������� xx�̸� �Ÿ��� xx Ű�� �Դϴ�.
            �� �̿� ��� xx���̰�, �պ��̿� ��� xx���̸�, �Ѵ� 20�ϱ���
            ������ ��: xxxx�� �Դϴ�.  */

package day1119;

public class Homework2 {

	public static void main(String[] args) {
		String name =args[0];
		//System.out.println(name+"��");
		String trans=args[1];
		//System.out.println(trans);
		int km=Integer.parseInt(args[2]);
		int charge =0;
		int plus_charge=0;
	if (trans.equals("����")) {
		charge=1200;
	}else if (trans.equals("����ö")){
			charge=1250;
	}else if (trans.equals("�ý�")) {
			charge=3800;
	}else {
			charge=0;
	}
	if (km>10) {
		plus_charge= (int)((km-10)/5)*100;
		charge = charge+plus_charge;
	}
	System.out.println(name+" "+trans+" "+km+" "+ charge);
	}//main	

}//class
