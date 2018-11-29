package day1122;

/**
 * ������ : method Overload<br>
 * �ϳ��� Ŭ�������� ���� �̸��� method�� ������ �ۼ��ϴ� ��.<br>
 * ��Ģ : ���������� ��ȯ�� method���� ���� �����. �Ű������� �ٸ��� �ۼ�.
 * 
 * @author owner
 */
public class TestOverload {

	/**
	 * ���� �ϳ� ����ϴ� ��
	 */
	public void printsStar() {
		System.out.println("��");
	}// printstar

	/**
	 * �ԷµǴ� ���� ������� ������ ����ϴ� ��
	 * @param count ����� ���� ����
	 */
	public void printsStar(int count) {
		for (int i = 0; i < count; i++) {
			System.out.println("��");
		} // end for
	}// printstar

	
	
	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		//���� 1�� ���
		to.printsStar();
		//���� ������ ���
		to.printsStar(10);
		



	
	
		
		
		
	}// main

}// class
