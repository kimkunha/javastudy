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
//1. ������ ����� ���� jframe ���
public class MultiChatClientView extends JFrame {
//2. ����� �ν��Ͻ� ���� ����
	private JTextArea jtaTalkDisplay;
	private JTextField jtfServerIp, jtfNick, jtfTalk;
	private JButton jbtConnect, jbtCapture, jbtClose;
	private JScrollPane jspTalkDisplay;
	
	public MultiChatClientView() {
		super("ä�� Ŭ���̾�Ʈ");
//3. �����ڿ��� ����� �ν��Ͻ� ���� ����
		jtaTalkDisplay=new JTextArea();
		
		jtfServerIp=new JTextField("211.63.89",10);
		jtfNick=new JTextField(10);
		jtfTalk=new JTextField();
		//Ÿ��Ʋ�� �ִ� �׵θ� ����
		jtfTalk.setBorder(new TitledBorder("��ȭ"));
		
		jbtConnect=new JButton("����");
		jbtCapture=new JButton("����");
		jbtClose=new JButton("����");
		
		//��ũ�ѹ� ������ textarea�� �־� �ش�.
		jspTalkDisplay=new JScrollPane(jtaTalkDisplay);
		jspTalkDisplay.setBorder(new TitledBorder("��ȭ����"));
		
		//��ȭâ ���� ���ϰ� false
		jtaTalkDisplay.setEditable(false);
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(new JLabel("�����ּ�",JLabel.CENTER));
		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("��ȭ��",JLabel.CENTER));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtConnect);
		jpNorth.add(jbtCapture);
		jpNorth.add(jbtClose);
		
		add("North", jpNorth);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);
		
		//�̺�Ʈ ó��
		MultiChatClientEvt mcce=new MultiChatClientEvt(this);
		jbtCapture.addActionListener(mcce);
		jbtConnect.addActionListener(mcce);
		jbtClose.addActionListener(mcce);
		jtfTalk.addActionListener(mcce);
		
		setBounds(100, 100, 600, 350);
		setVisible(true);
		
		
		
	}//MultiChatClientView

	
	//�̺�Ʈ ó���� ���� privateó���� ������ getter�� �ѱ��
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
