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
			dlmTemp.addElement("���� ������");

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
				JOptionPane.showMessageDialog(sv, "ä�ü����� �̹� �������Դϴ�.");
			}//end else
		}//end if
		if(ae.getSource() == sv.getJbClose()) {
			switch (JOptionPane.showConfirmDialog(sv, "ä�ü����� �����Ͻðڽ��ϱ�?\n�����Ͻø� ��� �������� ������ �������ϴ�.")) {
			case JOptionPane.OK_OPTION:
				sv.dispose();
			}// end switch
		} // end if

	}// actionPerformed

//�������� ����� �����常��� ( 1�� â�� �켱)
}// class


