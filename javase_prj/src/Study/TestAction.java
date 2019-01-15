package Study;


import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *	actionlistener 복습
 * @author owner
 */
@SuppressWarnings("serial")
public class TestAction extends JFrame {
//1. jframe 상속
	private JLabel jlbl;
	private JTextField jtf;
	private JButton jbt1, jbt2;
	private JTextArea jta;
	private DefaultListModel<String> dlm;
	private JList<String> jlist;
	
	public TestAction() {
		super("연습");
		//생성자에서 컴포넌트 생성
		jlbl=new JLabel("입력란");
		jtf=new JTextField(10);
		jbt1=new JButton("입력");
		jbt2=new JButton("취소");
		jta =new JTextArea();
		
		dlm=new DefaultListModel<String>();
		jlist=new JList<String>(dlm);
		
		
		JScrollPane jsp=new JScrollPane(jlist);
		jsp.setBorder(new TitledBorder("연습창"));
//		jsp.getVerticalScrollBar().
		
		
		JPanel jp=new JPanel();
		jp.add(jlbl);
		jp.add(jtf);
		jp.add(jbt1);
		jp.add(jbt2);
		
		add("North",jp);
		add("Center", jsp);
		
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 400, 300);
		
		
		//이벤트 처리
		TestUseAction tua=new TestUseAction(this);
		addWindowListener(tua);
		jbt1.addActionListener(tua);
		jbt2.addActionListener(tua);
		
		
	}//생성자
	
	
	
	
	public JLabel getJlbl() {
		return jlbl;
	}




	public JTextField getJtf() {
		return jtf;
	}




	public JButton getJbt1() {
		return jbt1;
	}




	public JButton getJbt2() {
		return jbt2;
	}




	public JTextArea getJta() {
		return jta;
	}




	public DefaultListModel<String> getDlm() {
		return dlm;
	}




	public JList<String> getJlist() {
		return jlist;
	}




	public static void main(String[] args) {
		new TestAction();
	}//main

}//class
