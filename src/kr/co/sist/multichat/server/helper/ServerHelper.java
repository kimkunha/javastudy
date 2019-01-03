package kr.co.sist.multichat.server.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ServerHelper extends Thread {
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private DefaultListModel<String> dlm;
	private int cnt;
	private List<ServerHelper> connectList;
	private JFrame jf;
	private JScrollPane jsp;
	private String nick;
	
	public ServerHelper(Socket socket, DefaultListModel<String>dlm, int cnt, JFrame jf,
					List<ServerHelper> list/*, JScrollPane jsp*/) {
		someClient = socket;
		this.dlm = dlm;
		this.cnt = cnt;
		this.jf = jf;
		connectList =list;
		this.jsp = jsp;
		
		try {
			readStream = new DataInputStream(someClient.getInputStream());
			writeStream = new DataOutputStream(someClient.getOutputStream());
			
			nick = readStream.readUTF();
			
			dlm.addElement("[" +cnt +"] ��° �����ڰ� ["+ nick +"]���� ä�ù濡 ���� �Ͽ����ϴ�");
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
		}catch(IOException ie) {
			JOptionPane.showMessageDialog(jf, "������ ���� �� ������ �߻�...");
			ie.printStackTrace();
		}//end catch
		
	}//ServerHelper
	
	public void run() {
		
		if(readStream !=null) {
			try {
				String revMsg = "";
				while (true) {
					revMsg = readStream.readUTF();
					broadcast(revMsg);
				}//end while
			}catch (IOException ie) {
				connectList.remove(this);
				dlm.addElement(cnt + "��°" + nick+"������ ���");
				broadcast("["+nick +"]���� ����Ͽ����ϴ�.");
				
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				
				ie.printStackTrace();
			}//catch
		}//end if
	}//run
	
	public synchronized void broadcast(String msg) {
		
		ServerHelper sh = null;
		try {
			for(int i = 0; i< connectList.size(); i++) {
				sh = connectList.get(i);
				sh.writeStream.writeUTF(msg);
				sh.writeStream.flush();
				}//end for
		}catch(IOException ie) {
			JOptionPane.showMessageDialog(jf, "[" +cnt +"] �� ° �����ڿ��� �޼����� ���� �� �����ϴ�.");
			ie.printStackTrace();
		}//end catch
		
	}//broadcast
}//class
