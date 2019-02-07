package study.project;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Test_Resume extends JDialog{

	private JLabel jlMsg;
	private JButton jbYes, jbNo, jbCancle;
	
	public Test_Resume() {
		jlMsg=new JLabel("첨부할 외부이력서가 있습니까?");
		jlMsg.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		
		add(jlMsg);
		jlMsg.setBounds(80, 30, 250, 30);
		
		jbYes=new JButton("네");
		add(jbYes);
		jbYes.setBounds(60,80,80,30);
		jbNo=new JButton("아니요");
		add(jbNo);
		jbNo.setBounds(145,80,80,30);
		
		jbCancle=new JButton("취소");
		add(jbCancle);
		jbCancle.setBounds(230,80,80,30);
		
		
		
		setLayout(null);
		setResizable(false);
		setBounds(100, 100, 380, 180);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//생성자
	
	public static void main(String[] args) {
		new Test_Resume();
	}//main

}//class
