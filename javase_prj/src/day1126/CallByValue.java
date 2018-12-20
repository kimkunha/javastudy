package day1126;

public class CallByValue {

	/**
	 * method �� �Ű������� �⺻������ ���� �ȴٸ� �Ű������� �Ҵ�Ǵ� ���� ����Ǿ� ���޵ȴ�. �Ű������� ���� �����ϴ��� ������ ����
	 * ������� �ʴ´�.(Call by Value)
	 * @param args
	 */
	public void swap(int i, int j) {
		int temp = 0;
		// �ԷµǴ� ������ ���� ���� ����
		temp = i;
		i = j;
		j = temp;
		System.out.println("swap method������ i=" + i + ", j=" + j);
	}// swap ������ �ϴ� method

	public static void main(String[] args) {
		int i=11, j=26;
		
		System.out.println("swap��  i="+i+", j="+j);
		
		CallByValue cbv=new CallByValue();
		cbv.swap(i, j);// ���� ����Ǿ� ����.
		System.out.println("swap�� i="+i+", j="+j);
	
		int s=i;
		
		System.out.println(s*100);
	
	
	}// main

}// class
