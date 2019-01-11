package day0111;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//19.01.11 -1���ڷ�- (Jbutton Array)
public class BtnMsg extends JFrame implements ActionListener {
//������Ʈ��� �迭�� �����°� �ƴϴ�. �̹��� �迭�� ����ؼ� ����غ���. �ڵ� ����.
	private JButton[] jbtNames;  //����� ������Ʈ
	private String[] names;	//�迭�� ���� �̸�
	private String[] msg, msg2;	//�迭�� ���� �޼���
	
	public BtnMsg() {
		super("�̸��� Ŭ���� �ּ���.");
		
		names=new String[] 
				{ "������", "�ڿ���", "������", "����ö", "������", "������", "������", "������", "�����", "������" };
		msg=new String[] 
				{ "������ ���.", "�����غ�����", "����ǿ췯 ����!!", "���� ���� �ʹ�.", "�����̰� ���ƿ� *^-^*", "�����ϰ� �ʹ�.",
						"��! ���� ĳ���Ҳ���.", "�����ϰ� �ʹ�.", "���� ������ ����", "�ָ��� �����ϼ���." };
		
		jbtNames=new JButton[10];
		
		//for������ ��ü ����
		for(int i=0; i<jbtNames.length; i++) {
			jbtNames[i]=new JButton(names[i]);
			jbtNames[i].addActionListener(this); // �̺�Ʈ�� ���� for�� ������ ���
			add(jbtNames[i]);
		}//end for
		
		setLayout(new GridLayout(5, 2));
		
//		//for������ Jbutton�� �� �ֱ�
//		for(int i=0; i<jbtNames.length; i++) {
//		}//end for
		
		setBounds(200, 150, 300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//������
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		for(int i=0; i<jbtNames.length; i++) {
			if(ae.getSource() == jbtNames[i]) {
				JOptionPane.showMessageDialog(this, msg[i]); // Ŭ���ϸ� ����� ���� ���� msg[] ���ε����� ȣ���Ѵ�.
				break; //��ư Ŭ���� ����������.
			}//end if
		}//end if
	}//actionPerformed

	public static void main(String[] args) {
		BtnMsg bm=new BtnMsg();
	}

}
