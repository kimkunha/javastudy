package day1212;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//1. Window Comonent ���
@SuppressWarnings("serial")
public class KeyTest extends Frame implements KeyListener {
 
	public Label lbl1;
	public Label lbl2;
	
	public KeyTest() {
		super("����");
	//2. �̺�Ʈ�� �����ִ� ������Ʈ ����
		lbl1 = new Label();
		lbl2 = new Label();
		
		
	//3. ������Ʈ ����
		setLayout(null);
		add("Center",lbl1);
		add("Center",lbl2);
		
		lbl2.addKeyListener(this);
		
		setBounds(100,100,400,150);
		
		//����ȭ
		setVisible(true);
		
		//8. �̺�Ʈ ���� ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}//KeyTest
	
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	public static void main(String[] args) {
		new KeyTest();
	}//main
	
}//class
