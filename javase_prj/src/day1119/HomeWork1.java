/*���� 
1. ����� �ð��� �Է¹޾� �Ʒ��� �������� ����ϼ���.
  ��� :  ����� �ð��� �ִ� 2�ð��� ������ ������ 60���� �Ѵ� �ٸ� "��Ÿ�"
 	 60�� ���϶�� "�ܰŸ�"�� ����ϼ���.*/
package day1119;

public class HomeWork1 {

	public static void main(String[] args) {
		int input_time=Integer.parseInt(args[0]);
				if (input_time < 60) {
					System.out.println("�ܰŸ�");
				}else if(input_time >120) {
					System.out.println("�ִ� 2�ð��� �����Դϴ�");
//				}else if(input_time <120) {
//					System.out.println("�ִ� 2�ð� �����Դϴ�");
				}else {
				System.out.println("��Ÿ�");		
				}//endif
	}//main

}//class
