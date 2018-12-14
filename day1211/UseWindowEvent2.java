package day1211;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//18.12.11  -7��° �ڷ�-  ( XxxAdapter class ),    
/**
 *	XxxAdapter class�� ���Ǿ�� �ϴ� ����
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowEvent2 extends Frame {

	public UseWindowEvent2() {
		super("Window Event ����");
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
		
		UseWindowEvent2.windowImpl wi=this.new windowImpl();
		addWindowListener( wi ); //�򰥸��� �ϱ��� �� 
	}//UseWindowEvent
	
	
	
	public static void main(String[] args) {
		new UseWindowEvent2();
	}//main


	
	//WindowAdapter class�� ��ӹ����� �ʿ��� method�� Override�ϸ� �ȴ�.
	public class windowImpl extends WindowAdapter{
		
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose();
		}//windowClosing
	}//inner class����

}//class
