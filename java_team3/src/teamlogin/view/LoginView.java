package teamlogin.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import teamlogin.controller.LoginController;

public class LoginView extends JFrame{

	private JTextField jtfId;
	private JPasswordField jpfPw;
	private JButton jbLogin, jbsingUp;
	private JLabel jlForgotPass;
	
	public LoginView() {
		super("Simple Login");
		
		JLabel jlText =new JLabel("SImple Login");
		jlText.setFont(new Font("SansSerif", Font.BOLD, 20));
		jlText.setVerticalAlignment(SwingConstants.CENTER);//�� ��� ���� 
		jlText.setHorizontalAlignment(SwingConstants.CENTER); 
	
		JLabel jlLogin =new JLabel("�α���");
		jlLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel jlPass =new JLabel("��й�ȣ");
		jlPass.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		jtfId=new JTextField(10);
		jpfPw=new JPasswordField(10);
		
		jbLogin=new JButton("�α���");
		jbsingUp=new JButton("ȸ������");
				
		setLayout(new GridLayout(6, 1));
		
		JPanel jpLogin=new JPanel();
		jpLogin.add(jlLogin);
		jpLogin.add(jtfId);
		
		JPanel jpPass=new JPanel();
		jpPass.add(jlPass);
		jpPass.add(jpfPw);
		
		JPanel jpButton=new JPanel();
		jpButton.add(jbLogin);
		
		JPanel jpButton2=new JPanel();
		jpButton2.add(jbsingUp);
		
		add(jlText);
		add(jpLogin);
		add(jpPass);
		add(jpButton);
		add(jpButton2);
		
		//�̺�Ʈ ó��
		LoginController lc=new LoginController(this);
		addWindowListener(lc);
		jbsingUp.addActionListener(lc);
		jbLogin.addActionListener(lc);
		
		
		setBounds(100, 100, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//������

	public JTextField getJtfId() {
		return jtfId;
	}

	public JPasswordField getJpfPw() {
		return jpfPw;
	}

	public JButton getJbLogin() {
		return jbLogin;
	}

	public JButton getJbsingUp() {
		return jbsingUp;
	}

	public JLabel getJlForgotPass() {
		return jlForgotPass;
	}
	
	
	
}//class
