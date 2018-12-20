package day1211;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//18.12.11  -6��° �ڷ�-  ( XxxAdapter class ),    6 ~ 7 ����
/**
 *	XxxAdapter class�� ���Ǿ�� �ϴ� ����
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowEvent extends Frame {

	public UseWindowEvent() {
		super("Window Event ����");
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
		
		UseWindowEvent.windowImpl wi=this.new windowImpl();
		addWindowListener( wi ); //�򰥸��� �ϱ��� �� 
	}//UseWindowEvent
	
	
	
	public static void main(String[] args) {
		new UseWindowEvent();
	}//main


	
	//WindowListener interface�� ������ class�� ��������ʴ� method������ ��� Override �ؾ� �Ѵ�.
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
		//windowClosing���� dispose() �� ȣ�� �Ǹ� �׶� windowClosed�� ȣ��
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
	}//inner class����

}//class
