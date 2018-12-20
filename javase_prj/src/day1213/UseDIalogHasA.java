package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//18.12.13  - 1번 자료 - Dialog has a 관계로 작성. 복습할것.
/**
 *	Frame클래스에서 Dialog클래스를 Has a로 사용
 * @author owner
 */
@SuppressWarnings("serial")
public class UseDIalogHasA extends Frame implements ActionListener{

	private Button btn1/*Frame에 배치 */, btn2/* Dialog*/;
	private Dialog d;
	
	public UseDIalogHasA() {
		super("다이얼로그 사용");
		
		btn1=new Button("다이얼로그 사용");
		Panel panel=new Panel();
		panel.add(btn1);
		
		add("Center", panel);
		
		btn1.addActionListener( this );
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//end windowClosing
		});
		
		
	}//UseDialogHasA
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn1) {
			createDialog();
		}//end if
		
		if(ae.getSource()==btn2) {
			d.dispose();
		}//end if
		
		
	}//actionPerformed

	public void createDialog() {
		//1. 생성
		d=new Dialog(this,"다이얼로그",true); //true - modal,  false - 비 modal
		
		//2. Dialog에 배치될 컴포넌트 생성
		Label lbl=new Label("오늘은 눈오는 목요일 입니다. (^. ~)");
		btn2=new Button("닫기");
		
		d.add("Center", lbl);
		d.add("South", btn2);
		
		btn2.addActionListener( this );
		
		//크기 설정
		d.setBounds(200,200,300,300);
		
		//종료					//Dialog는 무조건 setVisible위에 올려야 한다.    
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				d.dispose();
			}
		});
		
		//가시화
		d.setVisible(true);
		
	}//createDialog

	
	
	
	
	
	public static void main(String[] args) {
		new UseDIalogHasA();
	}//main
	
}//class
