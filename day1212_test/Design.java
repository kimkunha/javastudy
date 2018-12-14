package day1212_test;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

/**
 *	Has a ����� Ŭ���� �����
 * �߰��� ������ �̸�, ����, �ּҸ� List�� �߰��ϰ� TextField �ʱ�ȭ
 *	����Ʈ�� �������� Ŭ���ϸ� ������ ���� TextField �Է�
 *	������ ��������
 *	����Ʈ�� �������� ���õǾ����� Ȯ���� TextField�� ������ �ش� ���� ����
 *	������ ��������
 *	����Ʈ�� �������� ���õǾ����� Ȯ�� �� TextField�� ���� ��ġ�ϴ� �������� ����
 *	�ݱⰡ ��������
 *	���α׷��� �����Ѵ�/
 *	 @author owner
 */
//1.window component ���
@SuppressWarnings("serial")
public class Design extends Frame{
	//2.����� ������Ʈ ����
	private Button btnAdd, btnClose, btnUpdate, btnDelete;
	private TextField tfName, tfAge, tfAddr;
	
	public Design() {
		//3. ������Ʈ ����
		super("Information");
		
		Label lblName=new Label("�̸�");
		lblName.setBounds(40, 50, 25, 25);
		Label lblAge=new Label("����");
		lblAge.setBounds(40, 85, 25, 25);
		Label lblAddr=new Label("�ּ�");
		lblAddr.setBounds(40, 120, 25, 25);
		
		btnAdd=new Button("�߰�");
		btnAdd.setBounds(85, 160, 45, 35);
		btnDelete=new Button("����");
		btnUpdate=new Button("����");
		btnUpdate.setBounds(x, y, width, height);
		btnClose=new Button("�ݱ�");
		btnClose.setBounds(x, y, width, height);
		
		tfName=new TextField();
		tfName.setBounds(85, 50, 75, 25);
		tfAge=new TextField();
		tfAge.setBounds(85, 85, 75, 25);
		tfAddr=new TextField();
		tfAddr.setBounds(85, 120, 75, 25);
		
		
		
		//5.��ġ������ ����
			setLayout(null);
			
		// �� �Է�
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
			
			//����ȭ
			setVisible(true);
			
			addWindowListener(ev);
		
	}//Design
	
	public static void main(String[] args) {
		new Design();
	}//main

}//class
