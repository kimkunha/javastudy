package study;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *	��ư �迭�� ��Ƽ� �ڵ带 ���̴� ���
 * @author owner
 */
public class TestJbt extends JFrame{

	private JButton[] jbtName;	//��ư 
	private String[] name;
	private String[] msg;

	public TestJbt() {
		super("TestJbutton");
		jbtName = new JButton[10];
		name= new String[] {"�����", "������", "������", "������","������","������","�ڿ���","����ö","�̺���","������" };
		msg= new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		
		//��ü������ �ϱ� ���� for������ �Է�
		for(int i=0; i<jbtName.length; i++) {
			jbtName[i]=new JButton(name[i]); //for���� �ѹ� ���� jbutton�ȿ� ��Ʈ�� name �ε��� ������� 1���� jbtname ��ü ����
			add(jbtName[i]);
		}//end for
		setBounds(100, 100, 300, 300);
		setLayout(new GridLayout(5, 2));
		setVisible(true);
		
		TestJbtEvt tje=new TestJbtEvt(this);
		addWindowListener(tje);
		for(int i=0; i<jbtName.length; i++) {
			jbtName[i].addActionListener(tje);
		}
		
	}//������
	
	
	
	public JButton[] getJbtName() {
		return jbtName;
	}

	public String[] getMsg() {
		return msg;
	}

	public static void main(String[] args) {
		new TestJbt();
	}
	

}//class
