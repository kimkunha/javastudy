package day1121;

/**
 * static (class)���� : Ŭ������ ����Ǹ� ���� ó�� �޸𸮿�(method)�� �ö󰡰�, ��� ��ü�� �ϳ��� ������ �����Ͽ�
 * ����ϴ� ����
 *
 * @author owner
 */
public class UseStaticVariable {
	public static int i;// static variable -> �ٷλ��
	int j;// instance variable -> ��üȭ�Ͽ� ���

	public void test() {
	}// test

	public static void main(String[] args) {
		// class���� ���. Ŭ������.������
		UseStaticVariable.i = 20;
		System.out.println(UseStaticVariable.i);

		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		usv.j = 5000; // instance������ ������ ��ü�� ���� ����Ѵ�.
		usv1.j = 10000;
		usv.i = 20;// ��ü������ ����ϸ� Ư�� ��ü�� ����(member ����)�� �ƴϹǷ� ����� ���������� �����ϴ� ������ �ƴϴ�.

		System.out.println("usv��ü �ν��Ͻ� ���� :" + usv.j + ", ����ƽ ����:" + usv.i);
		System.out.println("usv1��ü �ν��Ͻ� ���� :" + usv1.j + ", ����ƽ ����" + usv1.i);

//	j=200;
//	System.out.println(i+" / "+j);

	}// main
}// class
