package day1122;


/**
 * method �� 4���� ����
 *
 * @author owner
 */
public class MethodType {

	/**
	 * ��ȯ�� ���� �Ű����� ���� �� - ���� ���� �����Ѵ�
	 */
	public void typeA() {
		System.out.println("�ȳ��ϼ���?");
	}// typeA

	/**
	 * ��ȯ�� ����, �Ű����� �ִ� �� - ������
	 * 
	 * @param i �� ��¶�� ���� ��
	 */
	public void typeB(int i) {
		System.out.println(i + "�� �ȳ�?");
	}// typeb

	/**
	 * ��ȯ�� �ְ�, �Ű����� ���� �� - ���� �� 
	 * 	���� �޾� ����ϴ� �ڵ尡 �ʿ�.
	 * @return ��.�� �� �Ǽ������� ��ȯ
	 */
	public double typeC() {
//		int i = 11;
		return 2018.11;					//���������� ���� ��� �Ѵ�.   casting , ������ؼ� ��ȯ���� �����ָ� ����Ҽ� �ִ�.
		// System.out.println("|||||"); //return ���� �Ʒ��� �ڵ尡 ���� �ɼ� ����.
	}// typeC

	/**
	 * 	��ȯ���� �ְ�, �Ű����� �ִ� �� - ���� ��
	 * @param d ������ ����� ���� �Ǽ� ��
	 * @return ������ ��ȯ�� ��
	 */
	public int typeD(double d) {
		
		 int i=(int)d;
		 
		 return i;
	}//typeD
	
		 
	public static void main(String[] args) {

		MethodType mt = new MethodType();
		// 1. ���� �� �� �ϴ� method ȣ��
		mt.typeA(); // ��ü��.method��(); �� ����̵ȴ�.      ������ �����Ұ� = ������ ��

		// 2. ���� �� method ȣ�� // �ԷµǴ� ���� ���� �ٸ� ���� �Ѵ�.
		mt.typeB(22);
		mt.typeB(21);
		mt.typeB(202);
		
		//3. ���� �� method ȣ�� - ��ȯ���� ��ġ�ϴ� ������ ���� ���� �����ؾ� �Ѵ�.
			double i=mt.typeC()+1;
			System.out.println("������"+i);

		//4. ���� �� method ȣ�� - ��Ȳ���� ��ġ�ϴ� ������ ���� �� ����
			int j=mt.typeD(300.003);
			System.out.println("������"+j);
		
		
		
	}// main

}// class
