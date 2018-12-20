package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//18.12.10  - 5��° - (Container Component)
/**
 *	Container Component : 
 *	�Ϲ� ������Ʈ�� Container������Ʈ�� ������ �� �ִ� Component���
 * @author owner
 */
//1. Window component ���
@SuppressWarnings("serial")
public class UsePanel extends Frame {

	public UsePanel() {
		super("Container Component ���");
		
		//2. Component ���
		Label lblName=new Label("�̸�");						//lbl �� Label�� ���� �̷������� ������ ���� �ϴ������� �̸��� �����Ͽ� ��� �ϴ����� �������� ����
		TextField tfName=new TextField(20);
		Button btnAdd=new Button("�߰�");
		Button btnClose=new Button("����");
		TextArea taDisplay=new TextArea();
		
		//�Ϲ�������Ʈ�� ��ġ�� �� �ִ� �����̳� ������Ʈ�� ����
		Panel panelNorth=new Panel();	// Panel�� �⺻ Layout�� FlowLayout�̴�.
		
		//������ �����̳� ������Ʈ�� �Ϲ� ������Ʈ ��ġ
		panelNorth.add( lblName );
		panelNorth.add( tfName );
		panelNorth.add( btnAdd );
		panelNorth.add( btnClose );
		
		
		//3. ��ġ������ ����
		setLayout(new BorderLayout());
		
		//4. ��ġ BorderLayout Ư¡ : �ϳ��� ����(����)���� �ϳ��� ������Ʈ�� ���� ����
		add("North", panelNorth);
//		add("North", lblName);
//		add("North", tfName);
//		add("North", btnAdd);
//		add("North", btnClose);
		add("Center", taDisplay);
		
		//����
		
		//5. ������ ũ�� ����
		setBounds(200, 150, 400, 250);
		//6. ����ڿ��� �����ֱ�
		setVisible(true);
		//������ ���� �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});//windowClosing
		
	}//end UsePanel
	
	public static void main(String[] args) {
		new UsePanel();
		
	}//main

}//class
