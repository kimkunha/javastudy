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
 *	�߰��� ������ �̸�, ����, �ּҸ� List�� �߰��ϰ� TextField �ʱ�ȭ
 *	����Ʈ�� �������� Ŭ���ϸ� ������ ���� TextField �Է�
 *	������ ��������
 *	����Ʈ�� �������� ���õǾ����� Ȯ���� TextField�� ������ �ش� ���� ����
 *	������ ��������
 *	����Ʈ�� �������� ���õǾ����� Ȯ�� �� TextField�� ���� ��ġ�ϴ� �������� ����
 *	�ݱⰡ ��������
 *	���α׷��� �����Ѵ�/
 * @author owner
 */
//1. Window Component ���
@SuppressWarnings("serial")
public class InfoProcessor extends Frame implements ActionListener, ItemListener {
//2. ����� ������Ʈ ����	
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
	//3. ������Ʈ �����ϱ�
		lblName =new Label("�̸�");
		lblAge =new Label("����");
		lblSsn =new Label(" �ּ�");
		lblList =new Label("List");
		tfName =new TextField(20);
		tfAge =new TextField(20);
		tfSsn =new TextField(20);
		taArea =new TextArea();
		btnAdd =new Button("�߰�");
		btndelete =new Button("����");
		btnupdate =new Button("����");
		btnClose =new Button("�ݱ�");
			
		//�̺�Ʈ ���
		btnClose.addActionListener(this);
		btnAdd.addActionListener(this);
		
		
	//4.�гλ���
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
		
	//5. ��ġ ������ ����
		setLayout(new BorderLayout());
		add("East",panelEast);
		add("Center",panelWest);
		add("South", panelSouth);
		
	//6. ������ ũ�⼳��
		setSize(800, 400);
		
	//7. ����ڿ��� �����ֱ�(����ȭ)
		setVisible(true);
		
	//8.����ó��	
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
		System.out.println("����� ���� �մϴ�.");
		dispose();
	}//actionPerformed

	

	
	public static void main(String[] args) {
		new InfoProcessor();
	}//main
}//class
