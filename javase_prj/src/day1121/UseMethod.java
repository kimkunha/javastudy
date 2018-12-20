package day1121;



/**
 *	method : 업무를 구분하여 정의하며, 중복코드를 최소화 할때 사용.
 * @author owner
 */
public class UseMethod {

		//instance method
		public void instanceMethod() {
			System.out.println("객체화하여 사용하는 method");
		}//instMethod
		
		//static method
		public static void staticMethod() {
			System.out.println("객체화 없이 직접 호출하여 사용하는 method");
		}//static method
		
		public static void main(String[] args) {
//			instanceMethod();//객체화 이후에 객체명으로 호출할수 있다.

			UseMethod um=new UseMethod();
			um.instanceMethod();
//			um.staticMethod(); // staticmethod는 특정 객체에 속해있는 method가 아니므로 객체명으로 호출하지 않는다.
			UseMethod.staticMethod();
			
			
			
			
			
			
	}//main

}//class
