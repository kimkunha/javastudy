package day1206;

import java.util.Stack;

//18.12.06 	-4�� �ڷ�-  (stack) 
/**
 *	Stack : LIFO(Last Input First Output) �� ������ Ŭ����.
 * @author owner
 */
public class UseStack {
	public UseStack() {
		
		//1.����)
			Stack<String> stk = new Stack<String>();
		//�� �Ҵ�)
//			stk.add("�θ�");	//�θ�Ŭ������ �����ϴ� ����� ������� �ʴ´�. 
			stk.push("�ϼ̽��ϴ�.");//1
			stk.push("����");//2
			stk.push("���õ�");//3
			System.out.println(stk);
			System.out.println("ũ�� : "+stk.size());//�θ�
			
//			for(int i=0; i < stk.size(); i++) {			//�θ�Ŭ������ �����ϴ� ����� ����ϸ� stack�� ��������� ����� �� ���� �ȴ�.
//				System.out.println( stk.get(i));
//			}
			
			System.out.println( stk.empty());
			while( ! stk.empty() ) {						// ! ������� �ʴٸ�
				System.out.println( stk.pop());		//���ÿ��� �����͸� ������ ���������� �� �����͸� ����� �� ����.
			}//end while
		
		
		
		
		
		
		
		
		
		
	}//UseStack Constructor
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new UseStack();
		
		
		
		
	}//main

}//class
