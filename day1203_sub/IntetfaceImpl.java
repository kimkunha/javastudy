package day1203_sub;

/**
 *	��ӹ��� Ŭ������ ���� 
 *	��ӹ��� ��� �߻�޼ҵ�� �����ؾ� �Ѵ�.(������ �ǹ���??)
 *	�������̵��� �ߴٴ� ǥ�÷� annotaion�� �ϴ� ������ ������
 *	
 * @author owner
 */
public class IntetfaceImpl  implements SuperInterface{
	//���� SuperInterface�� ��ӹ��� �������̽� 2���� �߻�޼ҵ带 �����ؾ� �Ѵ�
	
	
	public String msg(){
		return "�ȳ��ϼ���";
	}//interA
	
	public String msgb() {
		return "�ݰ����ϴ�";
	}
		@Override
		public void methodA() {
			System.out.println("methodA");
		}
		
		public void methodB(int i) {
		}
		
		
		
		
		


	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {


	}

}
