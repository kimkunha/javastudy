package kr.co.sist.multichat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import kr.co.sist.multichat.client.view.ClientChatView;
import kr.co.sist.multichat.client.view.ClientSelectUserView;

public class ClientChatEvt extends WindowAdapter implements ActionListener, Runnable {

	private String nick;
	private ClientChatView ccv;
	private int portNum;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private Thread readThread;
	private boolean connectFlag;
	private DefaultListModel<String> dlmUser;
	private boolean flagGetUser;
	private String[] csvUser;
	
	public ClientChatEvt(ClientChatView ccv, int portNum) {
		this.ccv=ccv;
		this.portNum=portNum;
		dlmUser = new DefaultListModel<String>();
	}
	
	/* 
	 * 	runnable 추상메소드 쓰레드
	 */
	@Override
	public void run() {
		if (readStream != null) { //읽어오는 스트림이 널이 아니면
			try {
				String revMsg="";
				while(true) {
					revMsg=readStream.readUTF();
				}//end while
				
			}catch (IOException e) {
					e.printStackTrace();
				}//end catch
			
			
				
		
			
		}//end if
	}//run

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed
    















}//class