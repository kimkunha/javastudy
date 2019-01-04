package kr.co.sist.multichat.client.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.multichat.client.evt.ClientChatEvt;

public class ClientChatView extends JFrame {
    
    private JTextArea jtaNick, jtaChatDisplay;
    private JTextField jtfTalk, jtfNick;
    private JButton jbConnect, jbCapture, jbClose, jbUser;
//    private JLabel jlNick;
    
    private JScrollPane jspTalkDisplay;
    
    public ClientChatView () {
        super("채팅 클라이언트");    
        
        jtfNick =new JTextField(10);
        jtaNick=new JTextArea();
        jbConnect=new JButton("접속");
        jbCapture=new JButton("갈무리");
        jbClose=new JButton("종료");
        jbUser=new JButton("접속자");
        
        
        jtaChatDisplay=new JTextArea();
        jspTalkDisplay=new JScrollPane(jtaChatDisplay);
        
        jspTalkDisplay.setBorder(new TitledBorder("대화내용"));
        jspTalkDisplay.getVerticalScrollBar().setValue(jspTalkDisplay.getVerticalScrollBar().getMaximum());
        
        jtaChatDisplay.setEditable(false);
        
        
        
        jtfTalk=new JTextField();
        jtfTalk.setBorder(new TitledBorder("대화"));
        
        
        Panel panelNorth=new Panel();
        panelNorth.setLayout(new GridLayout(1, 6));
        panelNorth.add(new JLabel("대화명",JLabel.CENTER));
        panelNorth.add(jtfNick);
        panelNorth.add(jbConnect);
        panelNorth.add(jbCapture);
        panelNorth.add(jbClose);
        panelNorth.add(jbUser);
        
        setLayout(new BorderLayout());
        add("North",panelNorth);
        add("Center", jspTalkDisplay);
        add("South", jtfTalk);
        
        ClientChatEvt cce=new ClientChatEvt(this);
        jbUser.addActionListener(cce);
        jbClose.addActionListener(cce);
        
        setBounds(300, 300, 600 ,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JButton getJbConnect() {
        return jbConnect;
    }
    public JButton getJbCapture() {
        return jbCapture;
    }
    public JButton getJbClose() {
        return jbClose;
    }
    public JButton getJbUser() {
        return jbUser;
    }
    public JScrollPane getJspTalkDisplay() {
    	return jspTalkDisplay;
    }
    public void setJspTalkDisplay(JScrollPane jspTalkDisplay) {
    	this.jspTalkDisplay = jspTalkDisplay;
    }
    
    
    public JTextField getJtfNick() {
		return jtfNick;
	}
	public JTextArea getJtaChatDisplay() {
		return jtaChatDisplay;
	}
	public static void main(String[] args) {
        new ClientChatView();
        
    
    }//main


}