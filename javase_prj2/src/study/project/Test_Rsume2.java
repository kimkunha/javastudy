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
		jlMsg=new JLabel("�ܺ� �̷¼� ÷��");
		jlMsg.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
		add(jlMsg);
		jlMsg.setBounds(10, 32, 250, 30);
		
		jlTemp=new JLabel("�ܺ��̷¼��� doc, pdf�� ÷�ΰ��� �մϴ�.");
		jlTemp.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		add(jlTemp);
		jlTemp.setBounds(80, 60, 250, 30);
		
		jtfPath=new JTextField();
		add(jtfPath);
		jtfPath.setBounds(120, 37, 140, 20);
		
		jbFile=new JButton("���ϼ���");
		add(jbFile);
		jbFile.setBounds(270,37,90,20);
		
		jbAdd=new JButton("÷���ϱ�");
		add(jbAdd);
		jbAdd.setBounds(75,95,100,25);
		
		jbCancle=new JButton("���");
		add(jbCancle);
		jbCancle.setBounds(190,95,100,25);
		
		
		
		setLayout(null);
		setResizable(false);
		setBounds(100, 100, 380, 170);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//������
	
	public static void main(String[] args) {
		new Test_Rsume2();
	}//main

}//class
