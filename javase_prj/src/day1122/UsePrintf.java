package day1122;

/**
 *	��� method
 * @author owner
 */
public class UsePrintf {

	public static void main(String[] args) {
//		System.out.format("���� %d\n",11);
//		System.out.printf("���� %d",11);
		
		System.out.printf("����[%d][%5d][%-5d]\n",11,22,38);
		System.out.printf("����[%c][%5c][%-5c]\n", 'A', 'B' ,'C');
		System.out.printf("���ڿ�[%s][%10s][%-10s]\n", "�ڹ�", "�ڹ�" ,"�ڹ�");
		System.out.printf("�Ǽ�[%.2f][%5.2f][%-5.2f]\n", 3.141592,
					3.141592, 3.141592);
		
		System.out.printf("������ %d��%d��%d�� %s���� �÷��� %.2f�Դϴ�", 2018, 11, 22, "��", 1.5 );
		
	}//main

}//class