package day1212_test;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

/**
 *	Has a 관계로 클래스 만들기
 * 추가가 눌리면 이름, 나이, 주소를 List에 추가하고 TextField 초기화
 *	리스트의 아이템을 클릭하면 선택한 값이 TextField 입력
 *	변경이 눌려지면
 *	리스트의 아이템이 선택되었는지 확인후 TextField의 값으로 해당 값을 수정
 *	삭제가 눌려지면
 *	리스트의 아이템이 선택되었는지 확인 후 TextField의 값과 일치하는 아이템을 삭제
 *	닫기가 눌려지면
 *	프로그램을 종료한다/
 *	 @author owner
 */
//1.window component 상속
@SuppressWarnings("serial")
public class Design extends Frame{
	//2.사용할 컴포넌트 선언
	private Button btnAdd, btnClose, btnUpdate, btnDelete;
	private TextField tfName, tfAge, tfAddr;
	
	public Design() {
		//3. 컴포넌트 생성
		super("Information");
		
		Label lblName=new Label("이름");
		lblName.setBounds(40, 50, 25, 25);
		Label lblAge=new Label("나이");
		lblAge.setBounds(40, 85, 25, 25);
		Label lblAddr=new Label("주소");
		lblAddr.setBounds(40, 120, 25, 25);
		
		btnAdd=new Button("추가");
		btnAdd.setBounds(85, 160, 45, 35);
		btnDelete=new Button("삭제");
		btnUpdate=new Button("변경");
		btnUpdate.setBounds(x, y, width, height);
		btnClose=new Button("닫기");
		btnClose.setBounds(x, y, width, height);
		
		tfName=new TextField();
		tfName.setBounds(85, 50, 75, 25);
		tfAge=new TextField();
		tfAge.setBounds(85, 85, 75, 25);
		tfAddr=new TextField();
		tfAddr.setBounds(85, 120, 75, 25);
		
		
		
		//5.배치관리가 설정
			setLayout(null);
			
		// 값 입력
			add(lblName);
			add(lblAge);
			add(lblAddr);
			
			add(btnAdd);
			add(btnDelete);
			add(btnUpdate);
			add(btnDelete);
			
			add(tfName);
			add(tfAge);
			add(tfAddr);
			
			Event ev=new Event( this );
			
			//가시화
			setVisible(true);
			
			addWindowListener(ev);
		
	}//Design
	
	public static void main(String[] args) {
		new Design();
	}//main

}//class
