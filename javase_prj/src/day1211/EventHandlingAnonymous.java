package day1211;
//18.12.11  -5번째 자료-  ( Event 처리방법 4번째 Anonymous inner class ),    
/**
 *	anonymous inner class로 이벤트 처리
 * @author owner
 */

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//1.Window Component 상속
@SuppressWarnings("serial")
public class EventHandlingAnonymous extends Frame {
	//2. 이벤트 처리에 사용할 Component 선언
		private Button btn;
	
		public EventHandlingAnonymous() {
			super();
		//3. 컴포넌트 생성
			btn=new Button("클릭");
			//4. 배치
			Panel panel=new Panel();
			panel.add(btn);
			
			add("Center",btn);
		//5. 이벤트 등록 : anonymous inner class
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("버튼 클릭");
				}//actionPerformed
			});
		
		//6. 윈도우 크기 설정
			setBounds(200,100,400,200);
		//7. 사용자에게 보여주기
			setVisible(true);
		}//EventHandlingAnonymous
	
		public Button getBtn() {
			return getBtn();
		}//end getBtn
		
		
		public static void main(String[] args) {
		new EventHandlingAnonymous();
	}//main

}//class
