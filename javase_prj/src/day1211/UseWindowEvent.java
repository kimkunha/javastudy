package day1211;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//18.12.11  -6번째 자료-  ( XxxAdapter class ),    6 ~ 7 연계
/**
 *	XxxAdapter class가 사용되어야 하는 이유
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowEvent extends Frame {

	public UseWindowEvent() {
		super("Window Event 연습");
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
		
		UseWindowEvent.windowImpl wi=this.new windowImpl();
		addWindowListener( wi ); //헷갈리니 암기할 것 
	}//UseWindowEvent
	
	
	
	public static void main(String[] args) {
		new UseWindowEvent();
	}//main


	
	//WindowListener interface를 구현한 class는 사용하지않는 method일지라도 모두 Override 해야 한다.
	public class windowImpl implements WindowListener{
		
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}



	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose();
	}



	@Override
	public void windowClosed(WindowEvent e) {
		//windowClosing에서 dispose() 가 호출 되면 그때 windowClosed가 호출
		System.out.println("windowClosed");
	}



	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconfield");
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}
	}//inner class종료

}//class
