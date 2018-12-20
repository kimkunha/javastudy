package day1212;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.xml.soap.Text;

/**
 *	추가가 눌리면 이름, 나이, 주소를 List에 추가하고 TextField 초기화
 *	리스트의 아이템을 클릭하면 선택한 값이 TextField 입력
 *	변경이 눌려지면
 *	리스트의 아이템이 선택되었는지 확인후 TextField의 값으로 해당 값을 수정
 *	삭제가 눌려지면
 *	리스트의 아이템이 선택되었는지 확인 후 TextField의 값과 일치하는 아이템을 삭제
 *	닫기가 눌려지면
 *	프로그램을 종료한다/
 * @author owner
 */
//1. Window Component 상속
@SuppressWarnings("serial")
public class InfoProcessor extends Frame implements ActionListener, ItemListener {
//2. 사용할 컴포넌트 선언	
	public Label lblName;
	public Label lblAge;
	public Label lblSsn;
	public Label lblList;
	public TextField tfName;
	public TextField tfAge;
	public TextField tfSsn;
	public TextArea taArea;
	public Button btnAdd;
	public Button btndelete;
	public Button btnupdate;
	public Button btnClose;
	
	public InfoProcessor() {
		super("Infomation Processor");
	//3. 컴포넌트 생성하기
		lblName =new Label("이름");
		lblAge =new Label("나이");
		lblSsn =new Label(" 주소");
		lblList =new Label("List");
		tfName =new TextField(20);
		tfAge =new TextField(20);
		tfSsn =new TextField(20);
		taArea =new TextArea();
		btnAdd =new Button("추가");
		btndelete =new Button("삭제");
		btnupdate =new Button("변경");
		btnClose =new Button("닫기");
			
		//이벤트 등록
		btnClose.addActionListener(this);
		btnAdd.addActionListener(this);
		
		
	//4.패널생성
		Panel panelEast=new Panel();
		Panel panelWest=new Panel();
		Panel panelSouth=new Panel();
		
		panelWest.setLayout(new GridLayout(3, 2));
		panelWest.add(lblName);
		panelWest.add(tfName);
		panelWest.add(lblAge);
		panelWest.add(tfAge);
		panelWest.add(lblSsn);
		panelWest.add(tfSsn);
		
		panelEast.add(lblList);
		panelEast.add(taArea);
		
		panelSouth.add(btnAdd);
		panelSouth.add(btndelete);
		panelSouth.add(btnupdate);
		panelSouth.add(btnClose);
		
	//5. 배치 관리자 설정
		setLayout(new BorderLayout());
		add("East",panelEast);
		add("Center",panelWest);
		add("South", panelSouth);
		
	//6. 윈도우 크기설정
		setSize(800, 400);
		
	//7. 사용자에게 보여주기(가시화)
		setVisible(true);
		
	//8.종료처리	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});
		
		
		
		
		
		
	}//InfoProcessor
	

	@Override
	public void itemStateChanged(ItemEvent ie) {
		{
			
		}
	}//itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("사용을 종료 합니다.");
		dispose();
	}//actionPerformed

	

	
	public static void main(String[] args) {
		new InfoProcessor();
	}//main
}//class
