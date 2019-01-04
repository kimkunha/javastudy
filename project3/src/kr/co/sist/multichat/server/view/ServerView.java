package kr.co.sist.multichat.server.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import kr.co.sist.multichat.server.evt.ServerEvt;

@SuppressWarnings("serial")
public class ServerView extends JFrame {
	
	private JList<String> jlChatDisplay1,jlChatDisplay2,jlChatDisplay3,jlChatDisplay4;
	private JScrollPane jspChatDisplay1,jspChatDisplay2,jspChatDisplay3,jspChatDisplay4;
	private JButton jbStart, jbClose;
	private Panel Center, soso;
	private DefaultListModel<String> dlmChatList;
	
	public ServerView() {
		super("채팅 서버");
		
		 Center = new Panel();
		 soso = new Panel();
		
		 dlmChatList = new DefaultListModel<String>();
		 
		 
		 jlChatDisplay1 = new JList<String>(dlmChatList);
		 jlChatDisplay2 = new JList<String>();
		 jlChatDisplay3 = new JList<String>();
		 jlChatDisplay4 = new JList<String>();
		
		 jspChatDisplay1 = new JScrollPane(jlChatDisplay1);
		 jspChatDisplay2 = new JScrollPane(jlChatDisplay2);
		 jspChatDisplay3 = new JScrollPane(jlChatDisplay3);
		 jspChatDisplay4 = new JScrollPane(jlChatDisplay4);
		
		 jbStart = new JButton("시작");
		 jbClose= new JButton("종료");
		
		jspChatDisplay1.setBorder(new TitledBorder("1조"));
		jspChatDisplay2.setBorder(new TitledBorder("2조"));
		jspChatDisplay3.setBorder(new TitledBorder("3조"));
		jspChatDisplay4.setBorder(new TitledBorder("4조"));

		Center.setLayout(new GridLayout(2, 2));
		Center.add(jspChatDisplay1);
		Center.add(jspChatDisplay2);
		Center.add(jspChatDisplay3);
		Center.add(jspChatDisplay4);
		
		setLayout(new BorderLayout());
		
		
		soso.add(jbStart);
		soso.add(jbClose);
		
		add("Center", Center);
		add("South", soso);
		setBounds(100,100, 500,500);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ServerEvt se = new ServerEvt( this);
		jbStart.addActionListener(se);
		jbClose.addActionListener(se);
		
		addWindowListener(se);
		
		
		
	}//hwServer
	public JButton getJbStart() {
		return jbStart;
	}
	public JButton getJbClose() {
		return jbClose;
	}
	
	public DefaultListModel<String> getDlmChatList() {
		return dlmChatList;
	}
	public static void main(String[] args) {
		new ServerView();
	}

}
