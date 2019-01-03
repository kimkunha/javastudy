package study;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

//18.12.13  - 2번 자료 - Dialog is a 관계로 작성. 복습할것. 2 ~ 3 연계
/**
 * Frame클래스에서 is a 로 생성된 Dialog클래스를 사용
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseDIalogIsA extends JFrame implements ActionListener {

	private Button btn1/* Frame에 배치 */, btn2/* Dialog */;

	public UseDIalogIsA() {
		super("다이얼로그 사용");

		btn1 = new Button("다이얼로그 사용");
		JPanel jpanel = new JPanel();
		jpanel.add(btn1);

		add("Center", jpanel);

		btn1.addActionListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}// end windowClosing
		});

	}// UseDialogHasA

	@Override
	public void actionPerformed(ActionEvent ae) {
		createDialog();
	}// actionPerformed

	public void createDialog() {
//		new UseJDialog( this );
	}// createDialog

	public static void main(String[] args) {
		new UseDIalogIsA();
	}// main

}// class
