package Study;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UseLogin extends JFrame implements ActionListener {

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JLabel jlResult;

	public UseLogin() {
		super("로그인 연습");
		jtfId = new JTextField(10);
		jpfPass = new JPasswordField();
		jlResult = new JLabel("출력창 : ");
		jlResult.setFont(new Font("SansSerif", Font.BOLD, 15));

		jtfId.setBorder(new TitledBorder("아이디"));
		jpfPass.setBorder(new TitledBorder("비밀번호"));

		jtfId.addActionListener(this);
		jpfPass.addActionListener(this);

		setLayout(new GridLayout(3, 1));
		setBounds(100, 100, 300, 200);
		add(jtfId);
		add(jpfPass);
		add(jlResult);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// 생성자

	public static void main(String[] args) {
		UseLogin ul = new UseLogin();
	}// main

	@Override
	public void actionPerformed(ActionEvent ae) {
		String id = jtfId.getText().trim();

		if (ae.getSource() == jtfId) {
			if (!id.equals("")) {
				jpfPass.requestFocus();

			} else if (id.isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요");
				return;
			} // end else
		}
		if (ae.getSource() == jpfPass) {
			if (id.equals("")) {
				jpfPass.requestFocus();
				JOptionPane.showMessageDialog(this, "아이디를 입력");
				return;
			}else {
				String pass = new String(jpfPass.getPassword());
				System.out.println("--" + pass + "--");
				if (pass.trim().equals("")) {
					JOptionPane.showMessageDialog(this, "비밀번호 입력 하세요");
					jlResult.setText("비밀번호 입력");
					return;
				}
	
				if (id.equals("root") && pass.equals("1234")) {
					JDialog jd = new JDialog(this, "파일", true);
					
					jd.setBounds(100, 100, 100, 100);
					jd.setVisible(true);
					dispose();
				}
			}
//

		} // end if
	}// actionPerformed
}// class
