package Study;

import java.util.ArrayList;
import java.util.List;

public class UseMethod {

	private List<String> names;
	
	/**
	 * 	��ȯ�� ���� �Ű����� ���� Ÿ��
	 */
	public void typeA() {
		System.out.println("��ȯ�� �� �Ű������� ���� �޼ҵ�");
		names =new ArrayList<String>();
		//�� �Ҵ� 
		names.add("�����");
		names.add("������");
		names.add("�ڿ���");
		names.add("���ü�");
		
		for(int i=0; i<names.size(); i++ ) {
			System.out.println(names.get(i));
		}
		
		System.out.println("---------------------------------------------");
		}//type1
		
		/**
		 * 	��ȯ������ �Ű����� �ִ� ��
		 */
		public void typeB( String name) {
			names=new ArrayList<String>();
			names.add(name);
			names.add("�����");
			System.out.println("----------------------");
			for(int i=0; i<names.size(); i++){
				System.out.println(names.get(i));
		}
	
		}
	
	
	/**
	 * 	������ main method���� �����̶� �ν��Ͻ������� �ڿ��� ����Ҽ��� ����.
	 * 	����Ϸ��� static ���� ����ϰų� ��üȭ�� �����Ͽ��� �Ѵ�.
	 * @param args
	 */
	public static void main(String[] args) {
		UseMethod um=new UseMethod();
		String name="������";
		um.typeA();
		um.typeB("�ȳ�");
		um.typeB(name);
	}//main

}//class
