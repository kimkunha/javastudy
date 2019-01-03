package study;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseJDialogisa extends JFrame{

	private JButton jbConnect, jbCapture, jbClose, jbUser;
	private JTextArea jtaChatDisplay;
	private JList<String> jlNick;
	private DefaultListModel<String> dlmNick;
	private JTextField jtfNick, jtfTalk;
//	private JScrollPane
	
	
	
	public UseJDialogisa() {
		super("채팅클라이언트");
		
		dlmNick=new DefaultListModel<String>();
		jlNick=new JList<String>(dlmNick);
		jtfNick=new JTextField(20);
		jbConnect=new JButton("접속");
		jbCapture=new JButton("갈무리");
		jbClose=new JButton("종료");
		jbUser=new JButton("접속자");
		
				
		JPanel jpanel=new JPanel();
		jpanel.add(jlNick);
		jpanel.add(jtfNick);
		jpanel.add(jbConnect);
		jpanel.add(jbCapture);
		jpanel.add(jbUser);
		
		add("Center", jpanel);
		
		setLayout(null);
		setBounds(300, 300, 300, 300);
		setVisible(true);
		
		
		
		
		
	}//UseJDialogisa
	
	
	
	
	public static void main(String[] args) {
		new UseDIalogIsA();
	}//main

}//class
