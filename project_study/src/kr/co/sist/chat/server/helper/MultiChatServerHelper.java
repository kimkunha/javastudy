package kr.co.sist.chat.server.helper;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *	�������� �����ϸ� �����ڼ��Ͽ� ��Ʈ���� ���ͼ� �����ϴ� Ŭ����<br>
 *	�����ڰ� �����ϸ� ������ ���Ͽ� �� ��Ʈ������ �޼����� ���ѷ����� �о� ���̰� ��� �����ڿ��� �޼����� ���
 *
 * @author owner
 */
public class MultiChatServerHelper extends Thread { 
	
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private DefaultListModel<String> dlm;
	private int cnt;
	private List<MultiChatServerHelper> connectList;
	private JFrame jf;
	private JScrollPane jsp;
	private String nick;
	
	public MultiChatServerHelper(Socket socket, DefaultListModel<String> dlm, int cnt, JFrame jf,
			List<MultiChatServerHelper>list, JScrollPane jsp) {
		someClient = socket;
		this.dlm=dlm;
		this.cnt=cnt;
		this.jf=jf;
		connectList=list;
		this.jsp=jsp;
		
		// ��Ʈ�����
		//intput��Ʈ����  ���Ͽ��� 
		try {
			readStream=new DataInputStream(someClient.getInputStream());
			writeStream=new DataOutputStream(someClient.getOutputStream());
		
			//�����ڰ� �������� nick�� �޴´�.
			nick=readStream.readUTF();
			//����â�� ���Ӹ޼����� ���
			dlm.addElement("["+someClient.getInetAddress()+" / "+nick+"]���� ���� �ϼ̽��ϴ�.");
			//������ ������ ��� �����ڿ��� �޼����� ���
			broadcast(" [ "+cnt+" ] ��° �����ڰ� ["+nick+"] ä�ù濡 ���� �Ͽ����ϴ�.");
			//�����ڰ� ���� ��ũ��â�� �ڵ������� �������� ����
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf, "������ ���� �� ���� �߻�..");
			ie.printStackTrace();
		}//end catch
		
	}//MultiChatServerHelper

	@Override
	public void run() {
		
		if(readStream !=null) {
			try {
			String revMsg="";
			while(true) {//�������� �������� ��� �޼����� �о, ��� �����ڿ��� �Ѹ���
					revMsg=readStream.readUTF();
					broadcast( revMsg);
			}//end while
			} catch (IOException ie) {
				//�����ڰ� ����ϸ� �ش� �����ڸ� ����Ʈ���� �����Ѵ�.
				connectList.remove( this);
				//�޼����� �о������ ���ϴ� ���¶�� �����ڰ� ������ ������ ����
				dlm.addElement(cnt+"��°/"+nick+"������ ���");
				broadcast( "[ "+nick+"] ���� ����Ͽ����ϴ�.");
				
				//��ũ���� �ڵ������� �Ʒ��� �������� ���ش�.
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				
				ie.printStackTrace();
			}//end catch
		}//end if
		
	}//run
	
	
	/**
	 * 	��� �����ڿ��� �޼����� �ѷ��ִ� ��
	 * 	Synchronized : MultiThread���� ����ȣ�� ����(����ȭ ó��)
	 * @param msg
	 */
	public synchronized void broadcast(String msg) {
		
		MultiChatServerHelper mcsh=null;
		try {
		for( int i=0; i< connectList.size(); i++) {
			mcsh=connectList.get(i); //list���� helper ��ü�� ���
			mcsh.writeStream.writeUTF(msg); //��� ��Ʈ���� ���
			mcsh.writeStream.flush(); //�������� ����
		}//end for
		}catch( IOException ie) { 
			JOptionPane.showMessageDialog(jf, "[ "+cnt+" ] ��° �����ڿ��� �޼����� ���� �� �����ϴ�.");
			ie.printStackTrace();
		}//end catch
		
	}//broadcast
	
	
	
}//class
