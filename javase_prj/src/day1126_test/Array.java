package day1126_test;

public class Array {

	/**
	 * 	�迭�̶� ? : ���� Ÿ���� ���� ������ �ϳ��� ������ �ٷ�°��� �迭(Array)��� �Ѵ�. �ϴ�����?<br>
	 * 	���� ���� �����ϱ� ���ؼ��� �� �������� ���ڸ�ŭ ������ �����Ϸ��� �ſ� ȥ��������� �迭�� ����ϸ� �������� �����͸� �� ���� �ٷ� �� �ִ�.<br>
	 * 	�߿��� ���� ���� Ÿ���̿��� �ϰ� �ٸ� Ÿ���� ������δ� ������ �� ����.
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] arr1 = new int[5];
		int tmp= arr1.length;
		System.out.println(tmp);
		
		
		
		int [] arr = new int[10];  //���� ���� ������ int�� null�� 0�� ����.
		arr[0]=0;
		arr[1]=10;
		arr[2]=20;
		arr[3]=30;
		arr[4]=40;
		arr[5]=50;
		arr[6]=60;
		arr[7]=70;
		arr[8]=80;
		arr[9]=90;
		
		for(int i =0; i<arr.length; i++) {
			System.out.println(arr[i]);
			
		}
			
		
		
		Array ar =new Array();
		System.out.println(ar);
	}//main
}//class
