package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *	
 * @author owner
 */
//1. Window Component 상속
@SuppressWarnings("serial")
public class Homework1 extends Frame {

	public Homework1() {
		super("homework1");
		//2.사용할 일반 컴포넌트를 생성
		//north
		Label lblStudents=new Label("학생관리");
		
		
		
		//Center
		Label lblName=new Label("이름");
		TextField rfName1=new TextField(20);
		Label lblAge=new Label("나이");
		TextField rfName2=new TextField(20);
		Label lblTel=new Label("전화번호");
		TextField rfName3=new TextField(20);
		Label lblSex=new Label("성별");
		CheckboxGroup cg=new CheckboxGroup();
		Checkbox cbGender1=new Checkbox("남",false,cg);
		Checkbox cbGender2=new Checkbox("여",false,cg);

		TextArea nfEast =new TextArea();

		
		
		//south
		Button btnAdd=new Button("추가");
		Button btnUpdate=new Button("변경");
		Button btnDelete=new Button("삭제");
		Button btnClose=new Button("종료");
		
		//일반 컴포넌트를 배치할 수 있는 컨테이너 컴포넌트를 생성
		Panel panelNorth=new Panel();
		Panel panelSouth=new Panel();
		Panel panelWest=new Panel();
		Panel panelEast=new Panel();
		Panel gender = new Panel();
		
		
		//생성된 컨테이너 컴포넌트에 일반 컴포넌트 배치
		
		//North
		panelNorth.add(lblStudents);
		
		
		//West
		panelWest.setLayout(new GridLayout(4,2 ));
		panelWest.add( lblName );
		panelWest.add( rfName1 );
		panelWest.add( lblAge );
		panelWest.add( rfName2 );
		panelWest.add(lblTel);
		panelWest.add( rfName3 );
		panelWest.add(lblSex);
		panelWest.add(gender);
		
		//South
		panelSouth.add(btnAdd);
		panelSouth.add(btnUpdate);
		panelSouth.add(btnDelete);
		panelSouth.add(btnClose);
		
		//Gender
		gender.add(cbGender1);
		gender.add(cbGender2);
		
		//East
		panelEast.add(nfEast);
		
		//3. 배치관리자 설정
		setLayout(new BorderLayout());
//		setLayout(new GridLayout(1, 2));
		
		//4. 배치 borderLayout 
		add("North", panelNorth);
		add("South",panelSouth);
		add("West",panelWest);
		add("East",panelEast);
			
		
		
		
		
		
		
		
		
		//5. 윈도우 크기 설정
				setSize(400, 400);
				
				//6. 사용자에게 보여주기
				setVisible(true);
				//윈도우 종료 이벤트 처리
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent we) {
						dispose();
					}//windowClosing
				});//windowClosing
		
		
		
		
		
		
		
		
		
	}//end Homework1
	
	public static void main(String[] args) {
		new Homework1();
		
		
		
	}//main

}//class
