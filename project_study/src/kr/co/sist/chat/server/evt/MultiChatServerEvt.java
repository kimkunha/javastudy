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
	private Thread threadServer; //�������� ���� ó���� �ϱ� ���� Thread
	private ServerSocket server; //PORT ����
	private List<MultiChatServerHelper> listClient; //��� �����ڸ� ������ List

	public MultiChatServerEvt(MultiChatServerView mcsv) {	//has a����� �̺�Ʈ ó��
		this.mcsv=mcsv;
		listClient=new ArrayList<MultiChatServerHelper>();
	}//MultiChatServerEvt
	
	
@Override
public void run() {
	//���������� ���� ������ ������ �޴´�.
	try {
		server=new ServerSocket(35000);//PORT�� 0 ~ 65545���� PORT�� �����ִ�.
		DefaultListModel<String>dlmTemp=mcsv.getDlmChatList();
		dlmTemp.addElement("������ 35000 PORT�� ���� ���� ��..");
	
		Socket someClient=null; //��ü �ʱⰪ null,//������ ������ ������ ��ü
		InetAddress ia=null; //�������� ip address�� ������� ��ü
		
		MultiChatServerHelper mcsh=null;//������ ������ �޾� ��Ʈ���� �����ϰ�,
		//��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��.
		for( int cnt=0; ; cnt++) { //�ݺ������� ���� �������� ������ ��õ
			someClient=server.accept();
			ia=someClient.getInetAddress();
			 
			//����, ������ ȭ��, ���Ӽ����� �Ҵ��Ͽ� Helper class����
			mcsh=new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient, mcsv.getJspList());
			//������ ���� �̸��� ���ϰ�ü�� ������ �����ϱ� ���� LIst �� �߰�
			listClient.add( mcsh);
			//�������� �޼����� �о���̱� ���� thread�� ����
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
			threadServer.start(); //start ( ) -> run( ) �� �����ȴ�.
		}else {
			JOptionPane.showMessageDialog(mcsv, "ä�ü����� �̹� ���� �� �Դϴ�");
		}//end else
	}// end if
	
	if(ae.getSource() == mcsv.getJbtCloseServer()) {
		switch (JOptionPane.showConfirmDialog(mcsv, "ä�ü����� �����Ͻðڽ��ϱ�?")){
		case JOptionPane.OK_OPTION : mcsv.dispose(); // ����
		
	}//end switch
	
	}//end if
	
}//actionPerformed

}//class
