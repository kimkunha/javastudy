package Study;

//숙제 영민   -따라서 반복해볼것-
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

@SuppressWarnings("serial")
public class WorkDesign extends Frame {
	private TextField tfName, tfAge, tfAddr;
	private Button btnAdd, btnDelete, btnUpdate, btnClose;
	private List lstBoard;
	
	public WorkDesign() {
		super("개인정보");
		
		// 컴포넌트 생성
		// Label
		Label lblName = new Label("이름");
		lblName.setBounds(40, 50, 25, 25);
		Label lblAge = new Label("나이");
		lblAge.setBounds(40, 85, 25, 25);
		Label lblAddr = new Label("주소");
		lblAddr.setBounds(40, 120, 25, 25);
		
		// TextField
		tfName = new TextField();
		tfName.setBounds(85, 50, 75, 25);
		tfAge = new TextField();
		tfAge.setBounds(85, 85, 75, 25);
		tfAddr = new TextField();
		tfAddr.setBounds(85, 120, 75, 25);
		
		// List
		lstBoard = new List();
		lstBoard.setBounds(185, 50, 180, 95);
		
		// Button
		btnAdd = new Button("추가");
		btnAdd.setBounds(85, 160, 45, 35);
		btnDelete = new Button("삭제");
		btnDelete.setBounds(145, 160, 45, 35);
		btnUpdate = new Button("변경");
		btnUpdate.setBounds(205, 160, 45, 35);
		btnClose = new Button("닫기");
		btnClose.setBounds(265, 160, 45, 35);
		
		// 배치 관리자 해제
		setLayout(null);
		
		add(lblName);
		add(lblAge);
		add(lblAddr);

		add(tfName);
		add(tfAge);
		add(tfAddr);
		
		add(lstBoard);
		
		add(btnAdd);
		add(btnDelete);
		add(btnUpdate);
		add(btnClose);
		
		// 이벤트 등록
		WorkEvent we = new WorkEvent(this);
		
		btnAdd.addActionListener(we);
		btnDelete.addActionListener(we);
		btnUpdate.addActionListener(we);
		btnClose.addActionListener(we);
		
		lstBoard.addItemListener(we);
		
		setBounds(200, 200, 400, 225);
		setVisible(true);
		
		addWindowListener(we);
		
	} // WorkDesign
	
	public TextField getTfName() {
		return tfName;
	} // getTfName

	public TextField getTfAge() {
		return tfAge;
	} // getTfAge

	public TextField getTfAddr() {
		return tfAddr;
	} // getTfAddr

	public Button getBtnAdd() {
		return btnAdd;
	} // getBtnAdd

	public Button getBtnDelete() {
		return btnDelete;
	} // getBtnDelete

	public Button getBtnUpdate() {
		return btnUpdate;
	} // getBtnUpdate

	public Button getBtnClose() {
		return btnClose;
	} // getBtnClose

	public List getLstBoard() {
		return lstBoard;
	} // getLstBoard

	public static void main(String[] args) {
		new WorkDesign();
		
	} // main
	
} // class
