package day0107.login;
//19.01.07 -1���ڷ�- (�α���â �����)
import java.awt.GridLayout;
import java.time.temporal.JulianFields;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class StatementLogin extends JFrame{

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton jbtLogin, jbtCancel;
	
	public StatementLogin() {
		super("Statement ��ü�� ����� Login");
			jtfId=new JTextField();
			jpfPass=new JPasswordField();
			jbtLogin=new JButton("�α���");
			jbtCancel=new JButton("���");
				
		//�׸��� ���̾ƿ� �ڽ� �־ �ϴ� ������Ʈ	
		setLayout(new GridLayout(3, 1));	
		//�г� �����
		JPanel panel=new JPanel();
				panel.add(jbtLogin);
				panel.add(jbtCancel);
		jtfId.setBorder(new TitledBorder("���̵�"));		
		jpfPass.setBorder(new TitledBorder("��й�ȣ"));
		
		add(jtfId);
		add(jpfPass);
		add(panel);
		
		//has a �����  evtŬ�����������ͼ� ��üȭ this ���
		StatementLoginEvt sle=new StatementLoginEvt(this);
		//�̺�Ʈ ó���� ���
		jtfId.addActionListener(sle);
		jpfPass.addActionListener(sle);
		jbtLogin.addActionListener(sle);
		jbtCancel.addActionListener(sle);
		
		addWindowListener(sle);
		setBounds(100, 100, 300, 180);
		setVisible(true);
		setResizable(false);
		
	
	}//StatementLogin
	
	//getter ���
	public JTextField getJtfId() {
		return jtfId;
	}

	public JPasswordField getJpfPass() {
		return jpfPass;
	}

	public JButton getJbtLogin() {
		return jbtLogin;
	}

	public JButton getJbtCancel() {
		return jbtCancel;
	}

	
	
	
	public static void main(String[] args) {
		StatementLogin sl=new StatementLogin();
	}//main
}//class
