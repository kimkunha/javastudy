package day1217;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import day1203_sub.IntetfaceImpl;

//18.12.17 - 3번째 - ( Exception )
/**
 *	JVM이 자동으로 처리해주는 RuntimeException
 * @author owner
 */
public class UseRuntimeException {

	public static void main(String[] args) {

		//18.12.17 추가내용	
		//1. JTextArea생성 (컬럼수, 행수)
		JTextArea jta=new JTextArea(10, 40);
		jta.setEditable(false);	//수정못하게 하는 method
		jta.append("마사카");	//추가 append를 사용해서 값 입력은 가능
		//2.
		JScrollPane jsp=new JScrollPane(jta);
		//3. MessageDialog의 두번째 매개변수에 컴포넌트를 할당
		
		JOptionPane.showMessageDialog(null, jsp);
		
		
		
		
		try {
			
		int num1=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
		int result=0;
		
		result =num1/ num2;
		
		System.out.println(num1+" / "+num2+" = "+result);
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			System.err.println("배열의 인덱스가 잘못되었습니다.");	//err로 하면 의미적으로 틀린걸 알려준다.
			System.err.println("예외의 이유 : "+aioobe.getMessage());
			System.err.println("예외처리 클래스명 과 이유 : "+aioobe);
			aioobe.printStackTrace(); //자세한 예외
		}catch(NumberFormatException nfe) {
			System.err.println("입력값이 숫자 형태가 아닙니다.");
			System.err.println("예외의 이유 : "+nfe.getMessage());
			System.err.println("예외처리 클래스명 과 이유 : "+nfe);
			nfe.printStackTrace();
		}catch(ArithmeticException ae) {
			System.err.println("0으로 나눌수 없습니다.");
			ae.printStackTrace();
		}catch(Exception e) {
			System.err.println("개발자가 인지하지 못한 예외");
			e.printStackTrace();
		}finally {	//실행되어야 할 코드는 finally에 넣어야 하낟.
			System.out.println("반드시 실행되어야 할 코드");
		}
		
	}//main

}//class
