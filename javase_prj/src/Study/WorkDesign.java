package Study;

//���� ����   -���� �ݺ��غ���-
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
		super("��������");
		
		// ������Ʈ ����
		// Label
		Label lblName = new Label("�̸�");
		lblName.setBounds(40, 50, 25, 25);
		Label lblAge = new Label("����");
		lblAge.setBounds(40, 85, 25, 25);
		Label lblAddr = new Label("�ּ�");
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
		btnAdd = new Button("�߰�");
		btnAdd.setBounds(85, 160, 45, 35);
		btnDelete = new Button("����");
		btnDelete.setBounds(145, 160, 45, 35);
		btnUpdate = new Button("����");
		btnUpdate.setBounds(205, 160, 45, 35);
		btnClose = new Button("�ݱ�");
		btnClose.setBounds(265, 160, 45, 35);
		
		// ��ġ ������ ����
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
		
		// �̺�Ʈ ���
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
