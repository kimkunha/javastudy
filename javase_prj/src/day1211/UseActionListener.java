package day1211;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

//18.12.11  - 8번째 - (Container Component) 
/**
 *	ActionListener를 사용한 이벤트 처리  
 * @author owner
 */
//1. Window component 상속
@SuppressWarnings("serial")
public class UseActionListener extends Frame implements ActionListener{
	private TextField tfName;
	private TextArea taDisplay;
	

	public UseActionListener() {
		super("Action Event 사용");
		
		//2. Component 사용
		Label lblName=new Label("이름");						//lbl 은 Label의 약자 이런식으로 원래의 대상과 하는형태의 이름을 조합하여 사용 하는편이 가독성이 좋다
		tfName=new TextField(20);
		//색 설정 : RGB를 사용한 생성자를 사용 -> 다양한 색을 사용할 수 있다.
		
		Button btnAdd=new Button("추가");
		
		Button btnClose=new Button("종료");
		taDisplay=new TextArea();
		
		
		//일반컴포넌트를 배치할 수 있는 컨테이너 컴포넌트를 생성
		Panel panelNorth=new Panel();	// Panel의 기본 Layout은 FlowLayout이다.
		//생성된 컨테이너 컴포넌트에 일반 컴포넌트 배치
		panelNorth.add( lblName );
		panelNorth.add( tfName );
		panelNorth.add( btnAdd );
		panelNorth.add( btnClose );
		
		//3. 배치관리자 설정
		setLayout(new BorderLayout());
		
		//4. 배치 BorderLayout 특징 : 하나의 지역(영역)에는 하나의 컴포넌트만 저장 가능
		add("North", panelNorth);
//		add("North", lblName);
//		add("North", tfName);
//		add("North", btnAdd);
//		add("North", btnClose);
		add("Center", taDisplay);
		
		//이벤트 등록
		btnAdd.addActionListener( this ); //버튼에서 이벤트가 등록
		tfName.addActionListener(this);//텍스트필드에서 이벤트가 등록
		
		//5. 윈도우 크기 설정
		setBounds(200, 150, 400, 250);
		//6. 사용자에게 보여주기
		setVisible(true);
		//윈도우 종료 이벤트 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});//windowClosing
		
	}//end UsePanel
	
	public static void main(String[] args) {
		new UseActionListener();
	}//main


	@Override
	public void actionPerformed(ActionEvent e) {
		//TextField의 값을 받아와서
		String name =tfName.getText();
		if(!name.isEmpty()) {// 입력문자열이 비어있지 않다면
			//TextArea에 추가
			taDisplay.append( name+"\n");		
			//textField의 값을 초기화
			tfName.setText("");
		}//end if
			//커서를 TextField에 재설정
			tfName.requestFocus();
			
		}//actionPerformed
			


}//class
