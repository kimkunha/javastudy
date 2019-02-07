package study.project;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Test_Rsume2 extends JDialog{

	private JLabel jlMsg, jlTemp;
	private JButton jbAdd, jbFile, jbCancle;
	private JTextField jtfPath;
	
	public Test_Rsume2() {
		jlMsg=new JLabel("외부 이력서 첨부");
		jlMsg.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
		add(jlMsg);
		jlMsg.setBounds(10, 32, 250, 30);
		
		jlTemp=new JLabel("외부이력서는 doc, pdf만 첨부가능 합니다.");
		jlTemp.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		add(jlTemp);
		jlTemp.setBounds(80, 60, 250, 30);
		
		jtfPath=new JTextField();
		add(jtfPath);
		jtfPath.setBounds(120, 37, 140, 20);
		
		jbFile=new JButton("파일선택");
		add(jbFile);
		jbFile.setBounds(270,37,90,20);
		
		jbAdd=new JButton("첨부하기");
		add(jbAdd);
		jbAdd.setBounds(75,95,100,25);
		
		jbCancle=new JButton("취소");
		add(jbCancle);
		jbCancle.setBounds(190,95,100,25);
		
		
		
		setLayout(null);
		setResizable(false);
		setBounds(100, 100, 380, 170);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//생성자
	
	public static void main(String[] args) {
		new Test_Rsume2();
	}//main

}//class
