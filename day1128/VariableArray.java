package day1128;

/**
 *	�ึ�� ���� ������ �ٸ� ���� �迭
 * @author owner
 */
public class VariableArray {
	
	public VariableArray() {
		//1. ����) ��������[][] �迭�� =null;
		int[][] arr=null;
		//2. ����) ���� ������ ����.  �迭�� =new ��������[���� ��][];
		arr=new int[4][];
		System.out.println("���Ǽ�"+arr.length);
		//3. �ึ�� ���� ����) �迭��[���ǹ�ȣ]=new ��������[���ǰ���];
		arr[0]=new int[3];
		arr[1]=new int[4];
		arr[2]=new int[1];
		//�ʱ�ȭ�� �ҷ��� ���� ������ �������� �ʴ´�.
		arr[3]=new int[] {1,2,3,4,5,6};				
		//4. ���Ҵ�
		arr[0][2]=10;
		arr[1][3]=20;
		arr[2][0]=30;
		
		//5. �� ���
		System.out.println(arr[0][0]+" / "+arr[0][1]+" / "+arr[0][2]);
		
		for(int i=0; i < arr.length; i++) {//��
			for(int j=0; j < arr[i].length; j++) {//��
				System.out.printf("arr[%d][%d]=%-5d",i,j, arr[i][j]);
			}//end for
			System.out.println();
		}//end for
		
	}//VariableArray
	
	
	/**
	 * 	���� �迭�� �⺻�� ���Ļ��
	 */
	public void priType() {
		System.out.println("--------------------------------------------------------------");
		//����) ��������[ ][ ]�迭�� ={ {��}{��,,,},{��,,,,,,,,},{��,,} }
		//�౸�� ��ȣ�� �������� ���� ������ �ٸ��� ����
		String[][] arr= {{"����"},{"����","����","����","������"},{"���","��","��"},{"��"}};
		String[] title= {"��","����","����","�ܿ�"};
		for(int i=0; i < arr.length; i++) {
			System.out.print(title[i]+":");
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j]+"\t");
			}//end for
			System.out.println();	
}//end for
	}//priType
	
	public static void main(String[] args) {
		new VariableArray().priType();				//1������ �����ڰ� �ҷ����� 2������ method�� �Ҹ���.
		
		
		
		
		
		
		
	}//main

}//class
