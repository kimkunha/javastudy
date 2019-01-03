package day1226;

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
//18.12.26 -1번자료- (서버 껍데기)
@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener {
private JTextArea jta;
private JTextField jtf;
private ServerSocket server;
private Socket client;
private DataInputStream readStream;
private DataOutputStream writeStream;

	public SimpleChatServer() {
		super("::::::::::채팅서버:::::::::::");
		
		jta=new JTextArea();
		jta.setBorder(new TitledBorder("대화내용"));
//		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		
		JScrollPane jsp=new JScrollPane(jta);
		
		
		jtf=new JTextField();
		jtf.setBorder(new TitledBorder("대화입력"));
		
		add("Center", jsp);
		add("South", jtf);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료!!!");
				dispose();	//dispose는 윈도우만 종료시킨다.  //화면이 종료된 후 -> windowClosed 호출
			}//windowClosing
			
			@Override
			public void windowClosed(WindowEvent e) {
			 try {
				 close(); //클라이언트와 연결하고 있는 스트림, 소켓, 서버소켓 종료
			 } catch (IOException e1) {
				 e1.printStackTrace();
			 }//end catch
			}//windowClosed
			
		});
		
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		jtf.requestFocus(); //커서를 jtf에 위치시킨다.
		
		try {
			openServer();
			revMsg();
		}catch (SocketException se) {
			System.err.println("접속자가 들어오기 전에 종료"+se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this,"서버 가동 실패! 메세지를 읽어들일수 없습니다.");
			e.printStackTrace();

		}//end catch
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
			if(writeStream !=null ) {//접속자가 존재하여 스트림이 생성된 경우에만
				sendMsg();//메세지를 보낸다.
			}else{
				JOptionPane.showMessageDialog(this, "대화 상대가 없습니다.");
				jtf.setText("");
			}//end if
		} catch (IOException ie) {
			ie.printStackTrace();
		}//end catch
	}//actionPerformed
	
	
	/**
	 * 	1. ServerSocket 생성하고(PORT 열림) 2. 접속자소켓이 들어오면(accept)
	 * 	대화를 주고 받을수 있도록 Stream 연결(DIS, DOS)
	 */
	public void openServer() throws IOException, SocketException{
		//1.
		server=new ServerSocket(65535);
		jta.setText("서버 가동 중... 접속자를 기다립니다.\n");
		//3.  (전체적인 흐름상의 번호)
		client=server.accept();
		jta.append("client 접속\n");
		//4. Stream 연결
		readStream=new DataInputStream(client.getInputStream());
		writeStream=new DataOutputStream(client.getOutputStream());
	}//openServer
	
	
	/**
	 *	접속자에게 메세지를 보내는 일 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException{
		//T.F의 값을 가져와서
		String msg=jtf.getText().trim();
		//스트림에 기록 하고
		writeStream.writeUTF( msg );
		//스트림의 내용을 목적지로 분출
		writeStream.flush();
		//내가 쓴 내용을 내 화면에 출력하고
		jta.append( "[ Server 메세지 ] : "+ msg+"\n" );
		//입력이 편하도록 jtf를 초기화
		jtf.setText("");
		
	}//sendMsg
	
	
	/**
	 *	접속자가 보내오는 메세지를 계속 읽어들어야 한다. 
	 * @throws IOException
	 */
	public void revMsg()throws IOException {
		String msg="";
		while(true) {
			//메세지를 읽어들여 
			msg=readStream.readUTF();
			//대화창에 출력
			jta.append("[ client 메세지 ] : "+ msg+"\n");
		}//end while
		
	}//revMsg
	
public static void main(String[] args) {
	new SimpleChatServer();
	/*
	  	SimpleChatServer scs=new SimpleChatServer();
	try {
		scs.openServer();
		scs.revMsg();
	}catch (SocketException se) {
		System.err.println("접속자가 들어오기 전에 종료"+se.getMessage());
	} catch (IOException e) {
		JOptionPane.showMessageDialog(scs,"서버 가동 실패! 메세지를 읽어들일수 없습니다.");
		e.printStackTrace();

	}//end catch
*/	
	}//main
}//class
