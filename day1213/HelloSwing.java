package day1213;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

//18.12.13  - 4번 자료 -  Swing 앞부분
/**
 *	Swing을 사용한 Window Application
 * @author owner
 */
//1. JFrame 상속
@SuppressWarnings("serial")
public class HelloSwing extends JFrame implements ActionListener{

	public HelloSwing() {
		super("스윙연습");
		//컴포넌트 생성
		JButton jb=new JButton("안녕! 난 스윙이라고 해");
		Button btn=new Button("AWT버튼");
		//배치관리자 전환
		setLayout(new GridLayout(1, 2));
		//배치
		add( jb );
		add( btn );
		//이벤트 등록
		jb.addActionListener( this );
		btn.addActionListener(this);
		//크기 설정
		setBounds(100, 100, 300, 200);
		//사용자에게 보여주기(가시화)
		setVisible(true);
		//윈도우 종료처리
		/*	//Swing도 이렇게 사용종료 할수 있으나 아래 방법이 더 효율적이다.
		 * addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		*/   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//HelloSwing
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}//actionPerformed
	
	public static void main(String[] args) {
		new HelloSwing();
	}//main

}//class
