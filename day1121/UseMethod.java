package day1121;



/**
 *	method : ������ �����Ͽ� �����ϸ�, �ߺ��ڵ带 �ּ�ȭ �Ҷ� ���.
 * @author owner
 */
public class UseMethod {

		//instance method
		public void instanceMethod() {
			System.out.println("��üȭ�Ͽ� ����ϴ� method");
		}//instMethod
		
		//static method
		public static void staticMethod() {
			System.out.println("��üȭ ���� ���� ȣ���Ͽ� ����ϴ� method");
		}//static method
		
		public static void main(String[] args) {
//			instanceMethod();//��üȭ ���Ŀ� ��ü������ ȣ���Ҽ� �ִ�.

			UseMethod um=new UseMethod();
			um.instanceMethod();
//			um.staticMethod(); // staticmethod�� Ư�� ��ü�� �����ִ� method�� �ƴϹǷ� ��ü������ ȣ������ �ʴ´�.
			UseMethod.staticMethod();
			
			
			
			
			
			
	}//main

}//class
