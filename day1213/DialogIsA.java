package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//18.12.13  - 3번 자료 - Dialog is a 관계로 작성. 복습할것. 2 ~ 3연계
@SuppressWarnings("serial")
//1. Dialog 상속
public class DialogIsA extends Dialog implements ActionListener {
//2. 이벤트와 관련있는 컴포넌트를 선언
	private Button btn;

	//현재 다이얼로그의 부모가 될 객체와 has a
	public DialogIsA( UseDIalogIsA uda ) {
		super( uda, "다이얼로그", true );
		
		//컴포넌트 생성
		Label	lbl=new Label("오늘은 목요일 입니다.");			//이벤트와 관련없으면 생성자 안에서 지역변수로 생성하는것도 괜찮다.
		
		btn=new Button("종료");
		
		add("Center", lbl);
		add("South", btn);
		
		btn.addActionListener( this );
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});
		//다이얼로그의 위치를 부모프레임 안쪽에서 띄우기
		System.out.println("부모 X"+uda.getX()+", 부모 y "+uda.getY());
		setBounds(uda.getX()+100, uda.getY()+100,300,300);
		setVisible(true);
		
	}//DialogIsA
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();

	}//actionPerformed

}//class
