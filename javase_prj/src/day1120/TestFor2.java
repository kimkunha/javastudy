package day1120;

/**
 * �پ��� for ����
 * 
 * @author owner
 */
public class TestFor2 {

	public static void main(String[] args) {
/*//		����loop
		for () {
			System.out.println("�ƾ�");
		} // end for
		System.out.println("");*/

		// �����ϴ� ���� ���� ����loop
		for (int i = 0;; i++) {
			System.out.println("����loop" + i);
			if (i == 50) {
				break;// ���� �αٿ� �����ϴ� �ݺ����� ���� ����
			} // end if
		} // end loop
		System.out.println("");

		// �������� �ʱⰪ�� ����ϴ� for
		for (int i = 0, j = 10, k = 30; i < 10; i++, j++, k--) {
			System.out.println(i + " " + j + " " + k);
		} // end for

		// ���ǽ��� �߸� �����ϸ� ����loop�� ����
		for (int i = 0; i < 10; i--) {
			System.out.println(i);
		} // end for

		int i = 0;
		for (i = 0; i < 10; i++)
			;
		{ // �����ݷж����� �ѹ��� �����Ѵ�.
			System.out.println("�ݺ���" + i);
		}

	}// main

}// class
