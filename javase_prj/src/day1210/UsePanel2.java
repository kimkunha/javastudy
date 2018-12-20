package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

//18.12.10  - 7��° - (�� ����)  5�� �ڷ���� ���� �����̱�
/**
 *	Container Component : 
 *	�Ϲ� ������Ʈ�� Container������Ʈ�� ������ �� �ִ� Component���
 * @author owner
 */
//1. Window component ���
@SuppressWarnings("serial")
public class UsePanel2 extends Frame {

	public UsePanel2() {
		super("Container Component ���");
		
		//2. Component ���
		Label lblName=new Label("�̸�");						//lbl �� Label�� ���� �̷������� ������ ���� �ϴ������� �̸��� �����Ͽ� ��� �ϴ����� �������� ����
		//�� ���� : Field
		lblName.setBackground( Color.PINK );
		lblName.setForeground( Color.magenta );
		TextField tfName=new TextField(20);
		//�� ���� : RGB�� ����� �����ڸ� ��� -> �پ��� ���� ����� �� �ִ�.
		Color back=new Color(0x47C83E);
		Color fore=new Color(0x48FFFF);
		tfName.setBackground( back );
		tfName.setBackground( fore );
//		tfName.setBackground(new Color(0xD1B2FF));
		
		Button btnAdd=new Button("�߰�");
		btnAdd.setBackground( back );
		btnAdd.setBackground( fore );
		
		Button btnClose=new Button("����");
		TextArea taDisplay=new TextArea();
		//�۲� : Dialog��DialogInput��Monospaced��Serif��SansSerif 
		//style : PLAIN, BOLD, ITALIC, BOLD|ITALIC
		taDisplay.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC , 20));
		
		
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
		new UsePanel2();
		
	}//main

}//class
