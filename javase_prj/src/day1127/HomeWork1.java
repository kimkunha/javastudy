package day1127;


/**
 * 	����
 * 	�ֹι�ȣ �Է¹޾� ó���ϴ� ���α׷� �ۼ�
 * 	�� �۾��� method �����ϰ� ȣ���Ͽ� ����� �޾Ƽ� ó��
 * 	1-1. �����ڴ� �ֹι�ȣ�� �޾� instance ������ �Ҵ��Ѵ�.
 * 		-�ν��Ͻ������� �� ���
 * 	1-2. �ֹι�ȣ�� ����üũ�Ͽ� 14�ڰ� �ƴϸ� false��ȯ
 * 	1-3. �ֹι�ȣ�� 6��° �ڸ��� '-'�� �ƴϸ� 	false ��ȯ
 * 	1-4. �ֹι�ȣ�� ��ȿ�� �����Ͽ� ��ȿ�ϸ� true/false ��ȯ
 * 		  �ֹι�ȣ�� �� �ڸ��� 2 3 4 5 6 7 8 9 2 3 4 5 �� ���� ����
 * 		  ���Ͽ� 11�� ���� ������ ���� ��� 11���� �� ���� ����
 * 			10���� ���� �������� �ֹι�ȣ�� ���ڸ��� ���ٸ� true/false
 * 	1-5. ������� ��ȯ�ϴ� �� "1988-11-11"
 * 	1-6. ���̸� ��ȯ�ϴ��� 31
 * 	1-7 ������ ��ȯ ��.��
 * 	1-8 ������/�ܱ��� ��ȯ	 1,2,3,4 ������ 5,6,7,8�ܱ���
 * 	1-9 �츦 ��ȯ "���"
 * 
 * 
 * 
 * @author owner
 */
public class HomeWork1 {
	String ssn=new String();
	
	public HomeWork1(String ssn){
		this.ssn=ssn;
	}//1-1
	
	public boolean ssn1(String ssn) {
		boolean flag=true;
		
			if(ssn.length() !=14) {
				flag=false;
			}//end if
		return flag;
	}//1-2
	
	public boolean ssn2(String ssn) {
		boolean flag=false;
		
			if(ssn.substring(6, 7)!="-") {
				flag=true;
				
			}
		return flag;
	}//1-3
	
	public int year(int i) {
		int s =2018-i+1;
		
		return s;
	}//1-6
	
//	public int gender(int gender) {
//  }
	
	
	
	
	public static void main(String[] args) {
		HomeWork1 hw =new HomeWork1("901217-1074411"); 
		System.out.println(hw.ssn);
		
	System.out.println();
		
		
		System.out.println(hw.year(30));
		
		
		
		
		
		
		
		
		
	}//main

}//class
