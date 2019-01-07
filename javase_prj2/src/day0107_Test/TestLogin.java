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
		super("로그인 창");
	jtfId=new JTextField();
	jpfPass=new JPasswordField();
	jbtLogin=new JButton("로그인");
	jbtCancel=new JButton("취소");
	
	
	//위,중간,아래 3등분을 나누기 위해 그리드 레이아웃 사용.
	setLayout(new GridLayout(3, 1));
	//마지막칸 사용위해 jpanel 사용
	JPanel jp=new JPanel();
		jp.add(jbtLogin);
		jp.add(jbtCancel);
	jtfId.setBorder(new TitledBorder("아이디"));
	jpfPass.setBorder(new TitledBorder("비밀번호"));
	
		add(jtfId);
		add(jpfPass);
		add(jp);
		
		setBounds(100, 100, 300, 200);
		
		setVisible(true);
		setResizable(false);
		
	}//생성자
	
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