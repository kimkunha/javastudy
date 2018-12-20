package day1211;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//18.12.11  -7번째 자료-  ( XxxAdapter class ),    
/**
 *	XxxAdapter class가 사용되어야 하는 이유
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowEvent2 extends Frame {

	public UseWindowEvent2() {
		super("Window Event 연습");
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
		
		UseWindowEvent2.windowImpl wi=this.new windowImpl();
		addWindowListener( wi ); //헷갈리니 암기할 것 
	}//UseWindowEvent
	
	
	
	public static void main(String[] args) {
		new UseWindowEvent2();
	}//main


	
	//WindowAdapter class를 상속받으면 필요한 method만 Override하면 된다.
	public class windowImpl extends WindowAdapter{
		
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose();
		}//windowClosing
	}//inner class종료

}//class
