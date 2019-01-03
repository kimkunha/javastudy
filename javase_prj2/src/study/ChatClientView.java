package study;

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

@SuppressWarnings("serial")
public class ChatClientView extends JFrame implements ActionListener{
    
    private JTextArea taChat1, taChat2;
    private JTextField tfChat;
    private JButton btnChat, btnCapture, btnClose, btnClient;
    private JLabel lblChat;
    
    private JScrollPane jsp;
    
    public ChatClientView () {
        super("ä�� Ŭ���̾�Ʈ");    
        
        lblChat =new JLabel("��ȭ��");
        taChat1=new JTextArea();
        btnChat=new JButton("����");
        btnCapture=new JButton("������");
        btnClose=new JButton("����");
        btnClient=new JButton("������");
        
        
        taChat2=new JTextArea();
        jsp=new JScrollPane(taChat2);
        
        tfChat=new JTextField();
        
        
        Panel panelNorth=new Panel();
        panelNorth.setLayout(new GridLayout(1, 6));
        panelNorth.add(lblChat);
        panelNorth.add(taChat1);
        panelNorth.add(btnChat);
        panelNorth.add(btnCapture);
        panelNorth.add(btnClose);
        panelNorth.add(btnClient);
        
        setLayout(new BorderLayout());
        add("North",panelNorth);
        add("Center", jsp);
        add("South", tfChat);
//        add(jsp);
        
        setBounds(300, 300, 500 ,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        btnClient.addActionListener(this);
        
    }//ChatClientView
    
    
    public void createJDialog() {
    	new UseJDialog(this);
    }//	
    	
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	createJDialog();
    }//actionPerformed
       
    
    public static void main(String[] args) {
    	new ChatClientView();
    	
    }//main
}//class