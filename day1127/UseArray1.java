package day1127;

/**
 * 1���� �迭 : �� �ϳ��� ���θ� ������ �迭<br>
 * �迭 - �޸𸮿� ���ϵ����������� ������ ��������<br>
 * ������ ���������̸�, �������� ��<br>
 * �ϰ�ó���� ��� <br>
 * ���� ���� ���(�迭��.length)
 * 
 * @author owner
 */
public class UseArray1 {

	public UseArray1() {
		// 1. �迭 ����) ��������[]�迭��=null;
		int[] arr = null;
		arr = new int[6];
		// 2. ����� ����)�������� [] �迭�� = new ��������[���ǰ���];
		// �迭�� �����ϸ� ��� ���� ���� �ʱ�ȭ �ȴ�.
		int[] arr1 = new int[8];
		System.out.println(arr + " / " + arr1);

		System.out.println("arr�迭 ���� ���� = " + arr.length + " arr1 �迭 ���� ���� = " + arr1.length);

		// 3. �� �Ҵ�) �迭��[���� �ε���]=��;
		arr[0] = 11;
		arr[1] = 27;
		arr[2] = 14;
		arr[3] = 46;
		// 4. �� ���)
		System.out.printf("arr[0]=%d arr[1]=%d arr[2]=%d\n", arr[0], arr[1], arr[2]);
		// �迭�� ���� �ε����� ����ϸ� Error
//		arr[6]=10;
		System.out.println("arr[5]=" + arr[5]);
		System.out.println("=============================================================================");
		// �ϰ�ó��
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("=============================================================================");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}

	}// UseaaArray1 ������

	/**
	 * 1���� �迭�� �⺻�� ������ ���. new ���X
	 */
	public void arrayPrimitive() {
		System.out.println("-----------------------------�⺻�� ������ ���--------------------------------------------");
		// 1.���� : �������� �迭�� [] ={��........};
		int[] arr = { 2018, 11, 27, 15, 20 };
		System.out.println("���� �� :"+arr.length);
		int[] arr1 = new int[] {1,2,3,4,5,6,7};//���� ������ �����ϸ� Error
		System.out.println("arr1�� ���� ���� :"+arr1.length);
		
		arr[0]=2019;
		System.out.println(arr[0]+"/"+arr[1]);
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"]="+arr[i]);
		}//end for
		
		//���� for : �迭�̳� collection(List,set)�� ó�� ����� �������
		//������ ���� ���������� �ս��� ��� �� ��
		/*
		 * for(�迭���� ���� ������ ���� : �迭)
		 * ������
		 *}
		 */
		for(int value :arr1) {
			System.out.println(value);
		}//end for
		
		System.out.println("-------------------------------------------------------------------------------");
		// arr1�迭�� ������ ����� ó�� �� ���� ���
		for(int i=arr1.length-1; i>=0; i--) {
			System.out.println(arr1[i]);
		}
		
	}// arrayPrimitive

	public void method() {
		System.out.println("method");
	}// method

	public static void main(String[] args) {
		new UseArray1().arrayPrimitive();

		System.out.println("======================================================");
		int[] arr4 = new int[10];
		System.out.println("arr4�� ���� ����" + arr4.length);

	}// main

}// class
