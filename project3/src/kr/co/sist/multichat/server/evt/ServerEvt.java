package kr.co.sist.multichat.server.evt;

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

import kr.co.sist.multichat.server.helper.ServerHelper;
import kr.co.sist.multichat.server.view.ServerView;

public class ServerEvt extends WindowAdapter implements ActionListener, Runnable {

	private ServerView sv;
	private Thread threadServer;
	private ServerSocket server;
	private List<ServerHelper> listClient;

	public ServerEvt(ServerView sv) {
		this.sv = sv;
		listClient = new ArrayList<ServerHelper>();
	}// ServerEvt

	@Override
	public void run() {
		try {
			server = new ServerSocket(36000);
			DefaultListModel<String> dlmTemp = sv.getDlmChatList();
			dlmTemp.addElement("서버 가동중");

			Socket someClient = null;
			InetAddress ia = null;

			ServerHelper sh = null;
			for (int cnt = 0; ; cnt++) {
				someClient = server.accept();
				ia = someClient.getInetAddress();

				sh = new ServerHelper(someClient, dlmTemp, cnt, sv, listClient/*, sv.getJspList()*/);
				listClient.add(sh);

				sh.start();
			} // end for

		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// run

	@Override
	public void windowClosing(WindowEvent we) {
		sv.dispose();
	}// windowClosing

	@Override
		public void windowClosed(WindowEvent we) {
			try {	
				if(server != null) {server.close();}//end if
			}catch(IOException e){
				e.printStackTrace();
			}// end catch
	}// windowClosed

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == sv.getJbStart()) {
			if(threadServer == null) {
				threadServer=new Thread(this);
				threadServer.start();
			}else {
				JOptionPane.showMessageDialog(sv, "채팅서버가 이미 가동중입니다.");
			}//end else
		}//end if
		if(ae.getSource() == sv.getJbClose()) {
			switch (JOptionPane.showConfirmDialog(sv, "채팅서버를 종료하시겠습니까?\n종료하시면 모든 접속자의 연결이 끊어집니다.")) {
			case JOptionPane.OK_OPTION:
				sv.dispose();
			}// end switch
		} // end if

	}// actionPerformed

//서버소켓 만들고 스레드만들기 ( 1조 창만 우선)
}// class


