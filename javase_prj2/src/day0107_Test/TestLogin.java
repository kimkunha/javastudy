package day0107_Test;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class TestLogin extends JFrame {

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton jbtLogin, jbtCancel;
	
	public TestLogin() {
		super("�α��� â");
	jtfId=new JTextField();
	jpfPass=new JPasswordField();
	jbtLogin=new JButton("�α���");
	jbtCancel=new JButton("���");
	
	
	//��,�߰�,�Ʒ� 3����� ������ ���� �׸��� ���̾ƿ� ���.
	setLayout(new GridLayout(3, 1));
	//������ĭ ������� jpanel ���
	JPanel jp=new JPanel();
		jp.add(jbtLogin);
		jp.add(jbtCancel);
	jtfId.setBorder(new TitledBorder("���̵�"));
	jpfPass.setBorder(new TitledBorder("��й�ȣ"));
	
		add(jtfId);
		add(jpfPass);
		add(jp);
		
		setBounds(100, 100, 300, 200);
		
		setVisible(true);
		setResizable(false);
		
	}//������
	
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
		new TestLogin();
	}//main
}//class