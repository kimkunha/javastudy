package day1207;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.SynchronousQueue;

//18.12.07  -3번자료-   ( Window Application )
/**
 *	Window Application 작성
 * @author owner
 */
//1. Window Component 상속
@SuppressWarnings("serial")
public class HelloAWT  extends Frame{
	public HelloAWT() {				
		super("AWT 연습");		//부모 클래스의 생성자를 불러준다.
		//2. 사용할 일반 컴포넌트 생성.
			Label lblTitle =new Label("오늘 베스트 사자성어");
			TextArea ta = new TextArea("정택성씨\n구로 1동의 자랑!!! ");
		
		//3. 배치관리자를 사용하여 컴포넌트를 배치.
			add("North", lblTitle);
			add("Center", ta);
										//add, setSize, setVisible은 전부 부모메소드를 사용중이다.
		//4. 윈도우 크기 설정
			setSize(400, 270);
			
		//5. 사용자에게 보여주기
			setVisible(true);
			
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent we) {
					//현재 윈도우인스턴스만 종료
//					dsipose();
					System.exit(0);;
				}//windowClosing
			});
			
			
	}//HeeloAWT
	public static void main(String[] args) {
		new HelloAWT();
		
		
		
		
	}//main

}//class
