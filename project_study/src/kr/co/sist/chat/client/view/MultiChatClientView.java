package kr.co.sist.chat.client.view;

import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.chat.client.evt.MultiChatClientEvt;

@SuppressWarnings("serial")
//1. 껍데기 만들기 위해 jframe 상속
public class MultiChatClientView extends JFrame {
//2. 사용할 인스턴스 변수 선언
	private JTextArea jtaTalkDisplay;
	private JTextField jtfServerIp, jtfNick, jtfTalk;
	private JButton jbtConnect, jbtCapture, jbtClose;
	private JScrollPane jspTalkDisplay;
	
	public MultiChatClientView() {
		super("채팅 클라이언트");
//3. 생성자에서 사용할 인스턴스 변수 생성
		jtaTalkDisplay=new JTextArea();
		
		jtfServerIp=new JTextField("211.63.89",10);
		jtfNick=new JTextField(10);
		jtfTalk=new JTextField();
		//타이틀이 있는 테두리 생성
		jtfTalk.setBorder(new TitledBorder("대화"));
		
		jbtConnect=new JButton("접속");
		jbtCapture=new JButton("저장");
		jbtClose=new JButton("종료");
		
		//스크롤바 생성할 textarea를 넣어 준다.
		jspTalkDisplay=new JScrollPane(jtaTalkDisplay);
		jspTalkDisplay.setBorder(new TitledBorder("대화내용"));
		
		//대화창 수정 못하게 false
		jtaTalkDisplay.setEditable(false);
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(new JLabel("서버주소",JLabel.CENTER));
		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("대화명",JLabel.CENTER));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtConnect);
		jpNorth.add(jbtCapture);
		jpNorth.add(jbtClose);
		
		add("North", jpNorth);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);
		
		//이벤트 처리
		MultiChatClientEvt mcce=new MultiChatClientEvt(this);
		jbtCapture.addActionListener(mcce);
		jbtConnect.addActionListener(mcce);
		jbtClose.addActionListener(mcce);
		jtfTalk.addActionListener(mcce);
		
		setBounds(100, 100, 600, 350);
		setVisible(true);
		
		
		
	}//MultiChatClientView

	
	//이벤트 처리를 위해 private처리한 변수들 getter로 넘기기
	public JTextArea getJtaTalkDisplay() {
		return jtaTalkDisplay;
	}

	public JTextField getJtfServerIp() {
		return jtfServerIp;
	}

	public JTextField getJtfNick() {
		return jtfNick;
	}

	public JTextField getJtfTalk() {
		return jtfTalk;
	}

	public JButton getJbtConnect() {
		return jbtConnect;
	}

	public JButton getJbtCapture() {
		return jbtCapture;
	}

	public JButton getJbtClose() {
		return jbtClose;
	}

	public JScrollPane getJspTalkDisplay() {
		return jspTalkDisplay;
	}
	
	
}//class
