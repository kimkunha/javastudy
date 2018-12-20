package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

//18.12.11  -2번째 자료-  ( Event 처리방법 2번째 Has a관계 )  2 ~ 3자료 연계
/**
 *	has a 관계의 이벤트 처리<br>
 *	디자인과 이벤트 처리 코드를 분리하여 코드의 복잡도를 낮출 수 있다.
 * @author owner
 */
@SuppressWarnings("serial")
//1. Window Component 상속
public class Design extends Frame{
	//2. 이벤트 처리와 관련있는 Component를 선언
	private Button btn;
	
	public Design() {
		super("디자인");
	//3. 컴포넌트 생성
		btn =new Button("클릭");
		
	//4. 배치
		Panel panel=new Panel();
		panel.add( btn );
		
		add("Center", panel);
	//4번-5번 사이에 5. Event 등록
	//이벤트 처리 객체 생성하고 has a 관계
		EventHandlingHasA ehha=new EventHandlingHasA(this);
		System.out.println("생성된 디자인 객체"+ehha);
	//컴포넌트에 Event를 등록
		btn.addActionListener(ehha);//버튼에서 이벤트가 발생하면 ehha객체의 Override된 method에서 이벤트를 처리
		
		
	//6. 윈도우 크기 설정
		setBounds(100, 100, 400, 300);
		
	//7. 사용자에게 보여주기 
		setVisible(true);
		
		
	}//end Design
	
	//Button을 받아갈 getter생성
	public Button getBtn() {
		return btn;
	}//getBtn
	
	
	
	
	
	public static void main(String[] args) {
		new Design();
		
	}//main

}//class
