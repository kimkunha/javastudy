package day1211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//18.12.11  -3번째 자료-  ( Event 처리방법 2번째 Has a관계 )    2-3번 연계 has a관계가 가중 자주사용
/**
 *	Has a 관계로 이벤트 처리
 * @author owner
 */
//1. 이벤트 처리 객체를 구현
public class EventHandlingHasA implements ActionListener {		//Overriding을 해야 에러 삭제
	//EventHandlingHasA 는 Design을 가지고 있다.
//2. has a 관계 저장하고 사용할 객체 선언
	private Design design;

	public  EventHandlingHasA( Design design) {
		this.design=design;
	}//EventHandlingHasA
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생했을때 처리할 코드
		System.out.println("전달받은 Design객체"+ design);
		design.dispose();
	}//actionPerformed
	
	
	
}//class
