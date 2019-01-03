package kr.co.sist.chat.server.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import kr.co.sist.chat.server.helper.MultiChatServerHelper;
import kr.co.sist.chat.server.view.MultiChatServerView;

public class MultiChatServerEvt extends WindowAdapter implements ActionListener, Runnable {

	private MultiChatServerView mcsv;
	private Thread threadServer; //접속자의 대한 처리를 하기 위한 Thread
	private ServerSocket server; //PORT 열기
	private List<MultiChatServerHelper> listClient; //모든 접속자를 관리할 List

	public MultiChatServerEvt(MultiChatServerView mcsv) {	//has a관계로 이벤트 처리
		this.mcsv=mcsv;
		listClient=new ArrayList<MultiChatServerHelper>();
	}//MultiChatServerEvt
	
	
@Override
public void run() {
	//서버소켓을 열고 접속자 소켓을 받는다.
	try {
		server=new ServerSocket(35000);//PORT는 0 ~ 65545개의 PORT을 열수있다.
		DefaultListModel<String>dlmTemp=mcsv.getDlmChatList();
		dlmTemp.addElement("서버가 35000 PORT를 열고 가동 중..");
	
		Socket someClient=null; //객체 초기값 null,//접속자 소켓을 저장할 객체
		InetAddress ia=null; //접속자의 ip address를 얻기위한 객체
		
		MultiChatServerHelper mcsh=null;//접속자 소켓을 받아 스트림을 연결하고,
		//대화를 읽거나 모든 접속자에게 전송하는 일.
		for( int cnt=0; ; cnt++) { //반복문에서 변수 선언하지 않을걸 추천
			someClient=server.accept();
			ia=someClient.getInetAddress();
			 
			//소켓, 서버의 화면, 접속순서를 할당하여 Helper class생성
			mcsh=new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient, mcsv.getJspList());
			//생성된 같은 이름의 소켓객체를 여러개 관리하기 위해 LIst 에 추가
			listClient.add( mcsh);
			//접속자의 메세지를 읽어들이기 위한 thread를 시작
			mcsh.start();
	
		}//end for
	
	} catch (IOException ie) {
		ie.printStackTrace();
	}//end catch
	
}//run

	@Override
	public void windowClosing(WindowEvent e) {
		mcsv.dispose();
	}//windowClosing


	@Override
	public void windowClosed(WindowEvent we) {
		try {
			if( server !=null) { server.close();} //end if
		}catch (IOException e) {
			e.printStackTrace();
		} //end catch
	}// windowClosed

@Override
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource() == mcsv.getJbtOpenServer()) {
		if( threadServer== null) {
			threadServer=new Thread(this);
			threadServer.start(); //start ( ) -> run( ) 이 가동된다.
		}else {
			JOptionPane.showMessageDialog(mcsv, "채팅서버가 이미 가동 중 입니다");
		}//end else
	}// end if
	
	if(ae.getSource() == mcsv.getJbtCloseServer()) {
		switch (JOptionPane.showConfirmDialog(mcsv, "채팅서버를 종료하시겠습니까?")){
		case JOptionPane.OK_OPTION : mcsv.dispose(); // 종료
		
	}//end switch
	
	}//end if
	
}//actionPerformed

}//class
