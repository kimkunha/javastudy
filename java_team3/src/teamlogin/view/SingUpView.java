package teamlogin.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import teamlogin.controller.SingUpController;

@SuppressWarnings("serial")
public class SingUpView extends JDialog {

	private JTextField jtfId, jtfTel1, jtfTel2, jtfTel3, jtfEmail1, jtfEmail2;
	private JPasswordField jpfPw1, jpfPw2;
	private JButton jbSinnUp, jbCancel;
	private JComboBox<String> jcbEmail;
	private String[] emailArr;
	private LoginView lv;
	
	public SingUpView(LoginView lv) {
		super(lv, "회원가입", true);
		
		
		JLabel jlText =new JLabel("회원가입");
		jlText.setFont(new Font("SansSerif", Font.BOLD, 25));
		jlText.setVerticalAlignment(SwingConstants.CENTER);//라벨 가운데 설정 
		jlText.setHorizontalAlignment(SwingConstants.CENTER); 
		
		JLabel jlId=new JLabel("아이디");
		jlId.setFont(new Font("SansSerif", Font.BOLD, 15));
		jtfId=new JTextField(10);
		JPanel jp1=new JPanel();
		jp1.add(jlId);
		jp1.add(jtfId);
		
		JLabel jlPass=new JLabel("비밀번호");
		jlId.setFont(new Font("SansSerif", Font.BOLD, 15));
		jpfPw1=new JPasswordField(10);
		JPanel jp2=new JPanel();
		jp2.add(jlPass);
		jp2.add(jpfPw1);
		
		
		JLabel jlPass2=new JLabel("비밀번호 확인");
		jlId.setFont(new Font("SansSerif", Font.BOLD, 15));
		jpfPw2=new JPasswordField(10);
		JPanel jp3=new JPanel();
		jp3.add(jlPass2);
		jp3.add(jpfPw2);
		
		JLabel jlTel=new JLabel("핸드폰");
		jlId.setFont(new Font("SansSerif", Font.BOLD, 15));
		jtfTel1=new JTextField(5);
		JLabel jlhp=new JLabel("-");
		jtfTel2=new JTextField(5);
		JLabel jlhp2=new JLabel("-");
		jtfTel3=new JTextField(5);
		JPanel jp4=new JPanel();
		jp4.add(jlTel);
		jp4.add(jtfTel1);
		jp4.add(jlhp);
		jp4.add(jtfTel2);
		jp4.add(jlhp2);
		jp4.add(jtfTel3);
		
		JLabel jlEmail=new JLabel("이메일");
		jlEmail.setFont(new Font("SansSerif", Font.BOLD, 15));
		jtfEmail1=new JTextField(5);
		JLabel jlhp3=new JLabel("@");
		jtfEmail2=new JTextField(5);
		emailArr=new String[] {"Daum.net", "gmail.net", "Naver.com"};
		jcbEmail=new JComboBox<>(emailArr);
		JPanel jp5=new JPanel();
		jp5.add(jlEmail);
		jp5.add(jtfEmail1);
		jp5.add(jlhp3);
		jp5.add(jtfEmail2);
		jp5.add(jcbEmail);
		
		jbSinnUp = new JButton("회원가입");
		jbCancel = new JButton("취소");
		JPanel jp6=new JPanel();
		jp6.add(jbSinnUp);
		jp6.add(jbCancel);
		
 		
		add(jlText);
		add(jp1);
		add(jp2);
		add(jp3);
		add(jp4);
		add(jp5);
		add(jp6);
		
		//이벤트
		SingUpController suc=new SingUpController(this);
		addWindowListener(suc);
		jbSinnUp.addActionListener(suc);
		jcbEmail.addActionListener(suc);
		setLayout(new GridLayout(7, 1));
		setBounds(100, 100, 400, 400);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
//		JLabel jlEmail=new JLabel("이메일");
//		jlId.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		
	}//생성자

	public JTextField getJtfId() {
		return jtfId;
	}

	public JTextField getJtfTel1() {
		return jtfTel1;
	}

	public JTextField getJtfTel2() {
		return jtfTel2;
	}

	public JTextField getJtfTel3() {
		return jtfTel3;
	}

	public JTextField getJtfEmail1() {
		return jtfEmail1;
	}

	public JTextField getJtfEmail2() {
		return jtfEmail2;
	}

	public JPasswordField getJpfPw1() {
		return jpfPw1;
	}

	public JPasswordField getJpfPw2() {
		return jpfPw2;
	}

	public JButton getJbSinnUp() {
		return jbSinnUp;
	}

	public JButton getJbCancel() {
		return jbCancel;
	}

	public JComboBox<String> getJcbEmail() {
		return jcbEmail;
	}

	public LoginView getLv() {
		return lv;
	}

	public String[] getEmailArr() {
		return emailArr;
	}
	
	
}//class
