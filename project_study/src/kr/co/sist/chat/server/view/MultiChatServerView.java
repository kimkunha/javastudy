package kr.co.sist.chat.server.view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.co.sist.chat.server.evt.MultiChatServerEvt;

/**
 *	view만들거니 jframe 상속
 * @author owner
 */
@SuppressWarnings("serial")
public class MultiChatServerView extends JFrame{
	//사용할 인스턴스 변수들 선언
	private JList<String> jlChatList;
	private JScrollPane jspList;
	private JButton jbtOpenServer, jbtCloseServer;
	private DefaultListModel<String>dlmChatList;
	
	public MultiChatServerView() {
		super(":::::::::채팅방관리자:::::::::");
		//사용할 인스턴스 변수 생성
		
		dlmChatList=new DefaultListModel<String>();	// 1. MVC패턴 모델 생성
		jlChatList=new JList<String>(dlmChatList);	// 2. has a 관계로 jlist로 받아옴
		jspList=new JScrollPane(jlChatList);	// 3. 스크롤페인에 담아 스크롤바 생성
		
		jbtOpenServer=new JButton("서버시작");
		jbtCloseServer=new JButton("서버중지");
		
		JPanel btnPanel =new JPanel();
		btnPanel.add(jbtOpenServer);
		btnPanel.add(jbtCloseServer);
		
		jspList.setBorder(new TitledBorder("접속자 정보"));
		
		add("Center", jspList);
		add("South", btnPanel);
		
		
		//이벤트 처리
		MultiChatServerEvt mcse=new MultiChatServerEvt(this);
		
		jbtOpenServer.addActionListener(mcse);
		jbtCloseServer.addActionListener(mcse);
			
		setBounds(100, 100, 400, 650);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//MultiChatServerView

	//getter로 이제 넘겨주자
	public JList<String> getJlChatList() {
		return jlChatList;
	}

	public JScrollPane getJspList() {
		return jspList;
	}

	public JButton getJbtOpenServer() {
		return jbtOpenServer;
	}

	public JButton getJbtCloseServer() {
		return jbtCloseServer;
	}

	public DefaultListModel<String> getDlmChatList() {
		return dlmChatList;
	}
	
	
	
	
	
	
	
	
}//class
