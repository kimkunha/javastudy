package day0107.login;
//19.01.07 -1번자료- (로그인창 만들기)
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
		super("Statement 객체를 사용한 Login");
			jtfId=new JTextField();
			jpfPass=new JPasswordField();
			jbtLogin=new JButton("로그인");
			jbtCancel=new JButton("취소");
				
		//그리드 레이아웃 박스 넣어서 하는 컴포넌트	
		setLayout(new GridLayout(3, 1));	
		//패널 만들기
		JPanel panel=new JPanel();
				panel.add(jbtLogin);
				panel.add(jbtCancel);
		jtfId.setBorder(new TitledBorder("아이디"));		
		jpfPass.setBorder(new TitledBorder("비밀번호"));
		
		add(jtfId);
		add(jpfPass);
		add(panel);
		
		//has a 관계로  evt클래스를가져와서 객체화 this 사용
		StatementLoginEvt sle=new StatementLoginEvt(this);
		//이벤트 처리할 목록
		jtfId.addActionListener(sle);
		jpfPass.addActionListener(sle);
		jbtLogin.addActionListener(sle);
		jbtCancel.addActionListener(sle);
		
		addWindowListener(sle);
		setBounds(100, 100, 300, 180);
		setVisible(true);
		setResizable(false);
		
	
	}//StatementLogin
	
	//getter 목록
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
