package kr.co.sist.chat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import kr.co.sist.chat.client.view.MultiChatClientView;

public class MultiChatClientEvt extends WindowAdapter implements ActionListener, Runnable {

	private MultiChatClientView mccv;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private Thread threadMsg;
	private String nick;
	
	public MultiChatClientEvt(MultiChatClientView mccv) {
		this.mccv=mccv;
		
	}//MultiChatClientEvt

	
	@Override
	public void run() {
		if( readStream !=null) {
			try {
				String revMsg="";
				JScrollPane jsp=mccv.getJspTalkDisplay();
			
			while(true) { //서버에서 보내오는 메세지를 읽어들여
					revMsg=readStream.readUTF();
				//채팅창에 뿌린다.
				mccv.getJtaTalkDisplay().append(revMsg+"\n");
				//스크롤바를 가장 아래로 이동
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			}//end while
				} catch (IOException e) {
					JOptionPane.showMessageDialog(mccv, "서버가 종료되었습니다");
					e.printStackTrace();
				} //end catch
		}//end if
	}//run

	@Override
	public void windowClosing(WindowEvent we) {
		mccv.dispose();
	}//windowClosing
	
	@Override
	public void windowClosed(WindowEvent we) {
		
		try {
			if( readStream !=null ) {  readStream.close();  }
			if( writeStream !=null ) { writeStream.close(); }
			if( client != null) { client.close(); }
				
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}//end finally
	}//windowClosed
	
	public void connectToServer() throws UnknownHostException, IOException {
		if ( client == null) {
			nick=mccv.getJtfNick().getText().trim();
			
			if( nick.equals("")) {
				JOptionPane.showMessageDialog(mccv, "대화명을 입력해 주세요.");
				mccv.getJtfNick().requestFocus(); //커서를 다시 jtf로 이동
				return;
			}//end if
			
			String serverIp = mccv.getJtfServerIp().getText().trim();
			client =new Socket(serverIp, 35000);
			
			//스트림 얻기
			readStream =new DataInputStream(client.getInputStream());
			writeStream =new DataOutputStream(client.getOutputStream());
			
			//대화명을 서버로 보낸다.
			writeStream.writeUTF( nick );
			
			mccv.getJtaTalkDisplay().setText("서버에 접속 하였습니다\n즐거운 채팅되세요.\n");
			//메세지 읽기
			threadMsg =new Thread(this);
			threadMsg.start();
			
		}else {
			JOptionPane.showMessageDialog(mccv, client.getInetAddress().getHostAddress()+
					"서버에 이미 접속 중 입니다.");
		}//end else
	}//end connectToServer
	
	
	public void capure() throws IOException{
		
		switch(JOptionPane.showConfirmDialog(mccv, "대화내용을 저장하시겠습니까?")) {
		case JOptionPane.OK_OPTION : 
			File saveDir=new File("c:/dev/chat");
			boolean flagDir=saveDir.mkdirs();
			File saveFile=new File(saveDir.getAbsolutePath()+"/java_chat["+System.currentTimeMillis()+"].dat");
			BufferedWriter bw=null;
	try {		
			bw=new BufferedWriter(new FileWriter(saveFile));
			bw.write( mccv.getJtaTalkDisplay().getText()); //스트림에 대화내용 기록
			bw.flush(); //스트림에 기록된 내용을 분출
			JOptionPane.showMessageDialog(mccv, saveDir+"에 대화내용이 기록 되었습니다.");
		}finally {
			if ( bw !=null ) { bw.close(); }
			}//end finally
		}//end switch
	}//capture
	
	public void senMsg() throws IOException {
		if(writeStream!=null) {
			JTextField jtf = mccv.getJtfTalk();
			//JTF에 입력한 메세지를 읽어 들인다.
			String msg= jtf.getText().trim();
			
			if( !msg.isEmpty()) {
				//스트림에 쓰고
				writeStream.writeUTF("["+nick+"]"+msg);
				//목적지 분출
				writeStream.flush();
			}//end if
			jtf.setText("");
		}//end if
	}//sendMsg
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == mccv.getJbtConnect()) {
			try {
				connectToServer();
			} catch (UnknownHostException uhe) {
				JOptionPane.showMessageDialog(mccv, "서버를 알 수 없습니다");
				uhe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "연결 실패");
				ie.printStackTrace();
			}
		}//end if

		
		
		if(ae.getSource() == mccv.getJbtClose()) {
			mccv.dispose();
		}//end if
		
		
		
		if(ae.getSource() == mccv.getJbtCapture()) {
		try {
			if( !mccv.getJtaTalkDisplay().getText().equals("")) {
					capure();
			}else {
				JOptionPane.showMessageDialog(mccv, "저장할 대화내용이 없습니다");
			}//end else
				} catch (IOException e) {
					JOptionPane.showMessageDialog(mccv, "파일로 저장하는 중 문제가 발생하였습니다.");
					e.printStackTrace();
				}//end catch
		}//end if
	
	if(ae.getSource() == mccv.getJtfTalk()) {
		try {
				senMsg();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(mccv, "서버가 종료되어 메세지를 전송할 수 없습니다.");
				e.printStackTrace();
			}//end catch
		}//end if
	
	
	}//actionPerformed
	
	
	
	
	
	
	
	
	
}//class
