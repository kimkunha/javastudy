package kr.co.sist.chat.server.helper;

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
 * 서버에서 생성하며 접속자소켓에 스트림을 얻어와서 관리하는 클래스.<br>
 * 접속자가 존재하면 접속자 소켓에 얻어낸 스트림에서 메세지를 무한루프로 읽어들이고 모든 접속자에게 메세지를 출력
 * 
 * @author owner
 */
public class MultiChatServerHelper extends Thread { // 다이어그램은 runnable이지만 thread로 해도 괜찮을거 같아 변경
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private DefaultListModel<String> dlm;
	private int cnt;
	private List<MultiChatServerHelper> connectList;
	private JFrame jf;
	private JScrollPane jsp;
	private String nick;

	/**
	 * 접속자 소켓을 받아서 스트림을 얻어 메세지를 읽거나 보낼수 있는 상태로 만든다.
	 * 
	 * @param socket 접속자 소켓
	 * @param dlm    접속자 관리창을 사용하기 위한 Model객체
	 * @param cnt    접속 순서
	 */
	public MultiChatServerHelper(Socket socket, DefaultListModel<String> dlm, int cnt, JFrame jf,
			List<MultiChatServerHelper> list, JScrollPane jsp ) {
		someClient = socket;
		this.dlm = dlm;
		this.cnt = cnt;
		this.jf=jf;
		connectList=list;
		this.jsp=jsp;
		
		// 스트림 얻기
		try {
			readStream = new DataInputStream(someClient.getInputStream());
			writeStream = new DataOutputStream(someClient.getOutputStream());
			
			//접속자가 보내오는 nick을 받는다.
			nick=readStream.readUTF();
			//서버창에 접속메세지를 출력
			dlm.addElement("["+someClient.getInetAddress()+" / "+nick+"] 님이 접속하셨습니다." );
			
			//서버에 접속한 모든 접속자에게 메세지를 출력
			broadcast("[ "+cnt+" ] 번째 접속자가 ["+nick+"]채팅방에 접속 하였습니다.");
			//접속자가 들어와 스크롤창이 자동적으로 내려가게 설정 
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf, "접속자 연결 중 문제 발생...");
			ie.printStackTrace();
		} // end catch

	}// MultiChatServerHelper

//	public void setConnectList(List<MultiChatServerHelper> list) {
//		connectList = list;
//	}// setConnectList

	@Override
	public void run() {
		
		if(readStream !=null) {
			try {
				String revMsg = "";
				while(true) {//서버어서 보내오는 모든 메세지를 읽어서, 모든 접속자에게 뿌린다.
					revMsg=readStream.readUTF();
					broadcast( revMsg );
				}//end while
			} catch (IOException ie) {
				//접속자가 퇴실하면 해당 접속자를 리스트에서 삭제한다.
				connectList.remove( this );
				//메세지를 읽어들이지 못하는 상태라면 접속자가 연결을 종료한 상태
				dlm.addElement(cnt+"번째/"+nick+" 접속자 퇴실");
				broadcast("[ "+nick+" ]님이 퇴실하였습니다.");
				
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				
				ie.printStackTrace();
			}//end catch
		}//end if
		
	}// run

	/**
	 *  모든 접속자에게 메세지를 뿌려주는 일
	 * 	synchronized : MutiThread에서 동시호출 막기(동기화 처리)
	 * @param msg
	 */
	public synchronized void broadcast(String msg) {
		
		MultiChatServerHelper mcsh=null;
		try {
			for( int i=0; i< connectList.size(); i++) {
					mcsh=connectList.get(i); 	//list에서 Helper 객체를 얻고
					mcsh.writeStream.writeUTF(msg);	//출력 스트림에 출력
					mcsh.writeStream.flush();	//목적지로 분출
				}//end for
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(jf, "[ "+cnt+" ] 번째 접속자에게 메세지를 보낼 수 없습니다.");
				ie.printStackTrace();
			}//end catch
		
	}// broadcast

}// class
