package day1227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
//18.12.26 -1���ڷ�- (���� ������)
//18.12.27 Thread �߰�
/**
 *	Thread�� �����Ͽ� �޼����� �д� �ڵ带 ȭ��, �޼����� ������ �ڵ�� ���ÿ� ó���Ѵ�.
 * @author owner
 */
@SuppressWarnings("serial")
public class SimpleThreadChatServer extends JFrame implements ActionListener, Runnable {
private JTextArea jta;
private JTextField jtf;
private JScrollPane jsp;

private ServerSocket server;
private Socket client;
private DataInputStream readStream;
private DataOutputStream writeStream;

private String serverNick;
private String clientNick;

	public SimpleThreadChatServer() {
		super("::::::::::ä�ü���:::::::::::");
		
		jta=new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ����"));
//		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		
		jsp=new JScrollPane(jta);
		
		
		jtf=new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ�Է�"));
		
		add("Center", jsp);
		add("South", jtf);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("����!!!");
				dispose();	//dispose�� �����츸 �����Ų��.  //ȭ���� ����� �� -> windowClosed ȣ��
			}//windowClosing
			
			@Override
			public void windowClosed(WindowEvent e) {
			 try {
				 close(); //Ŭ���̾�Ʈ�� �����ϰ� �ִ� ��Ʈ��, ����, �������� ����
			 } catch (IOException e1) {
				 e1.printStackTrace();
			 }//end catch
			}//windowClosed
			
		});
		
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		jtf.requestFocus(); //Ŀ���� jtf�� ��ġ��Ų��.
		
/*		
  		try {
			openServer();
		//has a : �޼����� �д� �ڵ带 Thread�� ó���ϸ� ��� �ֵ� �� �ڵ�� ������ �ϰ� �ȴ�.
			Thread t=new Thread(this);
			t.start();// start�� ���� run ȣ��
		}catch (SocketException se) {
			System.err.println("�����ڰ� ������ ���� ����"+se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this,"���� ���� ����! �޼����� �о���ϼ� �����ϴ�.");
			e.printStackTrace();
		}//end catch
*/		
		jtf.addActionListener(this);
		
	}//SimpleChatServer

	public void close() throws IOException {
		try {
		if( readStream !=null ) { readStream.close(); }//end if
		if( writeStream !=null ) { writeStream.close(); }//end if
		if( client !=null ) { client.close();}//end if
		}finally {
			if( server !=null ) { server.close(); }//end if
		}//end finally
	}//close
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			if(writeStream !=null ) {//�����ڰ� �����Ͽ� ��Ʈ���� ������ ��쿡��
				sendMsg();//�޼����� ������.
			}else{
				JOptionPane.showMessageDialog(this, "��ȭ ��밡 �����ϴ�.");
				jtf.setText("");
			}//end if
		} catch (IOException ie) {
			ie.printStackTrace();
		}//end catch
	}//actionPerformed
	
	
	/**
	 * 	1. ServerSocket �����ϰ�(PORT ����) 2. �����ڼ����� ������(accept)
	 * 	��ȭ�� �ְ� ������ �ֵ��� Stream ����(DIS, DOS)
	 */
	public void openServer() throws IOException, SocketException{
		serverNick=JOptionPane.showInputDialog("��ȭ�� �Է�");
		//1.
		server=new ServerSocket(65535);
		jta.setText("���� ���� ��... �����ڸ� ��ٸ��ϴ�.\n");
		//3.  (��ü���� �帧���� ��ȣ)
		client=server.accept();
		jta.append("client ����\n");
		//4. Stream ����
		readStream=new DataInputStream(client.getInputStream());
		writeStream=new DataOutputStream(client.getOutputStream());
		//�������� �г����� �޴´�.
		clientNick=readStream.readUTF();
		//�� ���� �����ش�.
		writeStream.writeUTF(serverNick);
		
	}//openServer
	
	
	/**
	 *	�����ڿ��� �޼����� ������ �� 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException{
		//T.F�� ���� �����ͼ�
		String msg=jtf.getText().trim();
		//��Ʈ���� ��� �ϰ�
		writeStream.writeUTF( msg );
		//��Ʈ���� ������ �������� ����
		writeStream.flush();
		//���� �� ������ �� ȭ�鿡 ����ϰ�
		jta.append( "[ "+serverNick+" ] : "+ msg+"\n" );
		//�Է��� ���ϵ��� jtf�� �ʱ�ȭ
		jtf.setText("");
		//��ũ�ѹٸ� ����
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
		
	}//sendMsg
	
	
	/**
	 *	�����ڰ� �������� �޼����� ��� �о���� �Ѵ�. 
	 * @throws IOException
	 */
	public void run() {
		String msg="";
		if( readStream != null) {
			try {
		while(true) {
			//�޼����� �о�鿩 
			msg=readStream.readUTF();
			//��ȭâ�� ���
			jta.append("[ "+clientNick+" ] : "+ msg+"\n");
			//�޼����� T.A�� �߰��Ǹ� JScrollpane�� ��ũ�ѹ��� ����
			//J.S.P�� �ְ����� �������ش�.
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
		}//end while
			}catch(IOException ie) {
				JOptionPane.showMessageDialog(this, clientNick+" �����ڰ� ����Ͽ����ϴ�.");
				ie.printStackTrace();
			}//end catch
		}//end if
	}//revMsg
	
public static void main(String[] args) {
//	new SimpleThreadChatServer();

	  	SimpleThreadChatServer stcs=new SimpleThreadChatServer();
	try {
		stcs.openServer();
		//Thread�� stcs��ü�� has a ����� ����
		Thread t=new Thread(stcs);
		//�޼����� �д� �ڵ带 Thread�� ó��
		t.start();
	}catch (SocketException se) {
		System.err.println("�����ڰ� ������ ���� ����"+se.getMessage());
	} catch (IOException e) {
		JOptionPane.showMessageDialog(stcs,"���� ���� ����! �޼����� �о���ϼ� �����ϴ�.");
		e.printStackTrace();

	}//end catch
	
	}//main
}//class
