/*
���� 
�Ʒ��� ������ ó���ϴ� method�� type�� �˸°� �ۼ��ϰ� API�ּ���
 ������ �� ȣ���Ͽ� ����� �� �� Java Doc�� �����غ�����.
- API�ּ��� � ������ method������ �ּ����� ����Ұ�.

1. �ڽ��� �̸��� ��ȯ�ϴ� method�ۼ�.
2. ���̸� �Է¹޾� �¾ �ظ� ��ȯ�ϴ�  method �ۼ�.
3. ���ڸ� �Է¹޾� �ش� ������ Unicode ���� ��ȯ�ϴ� method �ۼ�.
4. ���ڸ� �Է¹޾� ���ڰ�  ������, ������ ������ ���� �� �ش� ������
    ���ڸ�  ����ϴ� ���� �ϴ� method  �ۼ�
5. ȣ���ϸ� �ڽ��� �ּҸ� ����ϴ�  method �ۼ�.
6. ģ���� �̸��� �Է¹޾� ����ϴ�  method �ۼ�(ģ���� n�� �Դϴ�.)
*/
package day1122;

public class HomeWork1 {

	/**
	 * @return �����
	 */
	public String name() {
		return "�����";
	}// �̸���ȯ method

	/**
	 * age�� �Է� ���� ������ �����ڵ带 reyear����� ��ȯ�Ѵ�.
	 * @param ���̸� �Է¹���
	 * @return ���� �������
	 */
	public int year(int age) {
		int reyear = 2018 - age + 1;

		return reyear;
	}
//3. ���ڸ� �Է¹޾� �ش� ������ Unicode ���� ��ȯ�ϴ� method �ۼ�.

	/**
	 * 	���ڸ� �Է¹������� unicode�� �ٲٷ��� int������ casting�� �ʿ��ϹǷ�
	 * 	 casting �� ��ȯ�ϸ� ��¹��� int������ ���´�
	 * @param ch ������ ch�� �����ڵ�� �������ҷ��� int�� casting �ʿ�
	 * @return int�� ĳ������ ���� ����ϸ� int������ ����
	 */
	public int message(char ch) {

		int i = (int) ch;
		return i;
	}
/*	
	4. ���ڸ� �Է¹޾� ���ڰ�  ������, ������ ������ ���� �� �ش� ������
    ���ڸ�  ����ϴ� ���� �ϴ� method  �ۼ� 65~90
*/
	
//	5. ȣ���ϸ� �ڽ��� �ּҸ� ����ϴ�  method �ۼ�.
	
	 
	
	public void add(){
		System.out.println("������");
		
	}
	
	
	 public void number (int range) {
		 
		 if(range>65 && range<90) {
		char	aaaaa=(char)range;
			 System.out.println(aaaaa
					 );
		 }//end if
	
	 }
	 
	 
/*	 
	 6. ģ���� �̸��� �Է¹޾� ����ϴ� 
	 method �ۼ�(ģ���� n�� �Դϴ�.) 
 */
	 /**
	 * @param friend ģ���� ���� �Է¹������� �Ű����� friend�� ����
	 */
	public void name1(String ... friend) {
		for(int i=1; i<friend.length; i++ ) {
			 System.out.println(friend[i]);
		}//end for
	 }
	 
	 
	public static void main(String[] args) {
		HomeWork1 hw = new HomeWork1();

		System.out.println(hw.name());

		System.out.println(hw.year(29));

		System.out.println(hw.message('A'));

		hw.number(66);
		
		hw.name1("���Ͽ�","���ϴ�","�Ѿ���","������");
		
		hw.add();
		
	}// main
}// class
