package java_team3;

/**
 *	Call by Refernce
 *	매개변수를 참조형데이터(class, array, String)로 주면 하나의 주소값이 그대로 넘어간다.
 * @author KIM
 */
public class TestCallByReference {
	
	private int num;
	private int num2;
	
	public TestCallByReference(int num, int num2) {
		this.num=num;
		this.num2=num2;
	}
	
	public void swap(TestCallByReference cbr) {
		int temp;
		temp=num;
		num=num2;
		num2=temp;
		System.out.println("method 내부에서 값 num : ="+num+", num2 의 값 : "+num2);
	}
	
	public static void main(String[] args) {
		TestCallByReference tcbr=new TestCallByReference(10, 30);
		
		System.out.println("swap 전 값 num = "+tcbr.num+", num2 = "+tcbr.num2);
		tcbr.swap(tcbr);
		System.out.println("swap 후 값 num = "+tcbr.num+", num2 = "+tcbr.num2);
		//값이 변경 된 이유?
		//호출시 값이 아닌 주소를 넘겨줌으로써 주소를 참조하여 값 변경이 가능
		
		
	}//main

}//class
