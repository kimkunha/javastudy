package day0114;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * 선택한 파일을 서버로 전송하는 파일 클라이언트
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class FileClient extends JFrame implements ActionListener {

	private JButton btnSelectFile;
	private DefaultListModel<String> dlmFileList;

	public FileClient() {
		super("파일전송");
		btnSelectFile = new JButton("파일선택");

		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<String>(dlmFileList);
		JScrollPane jspFileList = new JScrollPane(listFile);

		jspFileList.setBorder(new TitledBorder("전송한 파일"));
//		jspFileList.getVerticalScrollBar().

		JPanel panel = new JPanel();
		panel.add(btnSelectFile);

		add("Center", jspFileList);
		add("South", panel);

		// 이벤트 등록
		btnSelectFile.addActionListener(this);

		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// FileClient

	private void selectFile() {
		FileDialog fdOpen = new FileDialog(this, "파일선택", FileDialog.LOAD);
		fdOpen.setVisible(true);
		// 이미지 파일만 전송
		String fPath = fdOpen.getDirectory();
		String fName = fdOpen.getFile();

		// 이미지 파일(jpg, jpeg, gif, png, bmp)만 전송
		/// 선택한 파일이 위의 파일이 아닌 경우 경고창 출력
		if (fName != null) {

			String ext = fName.substring(fName.lastIndexOf(".") + 1).toLowerCase();
			String[] arrCompare = { "jpg", "jpeg", "gif", "png", "bmp" };

			boolean extFlag = false;

			for (String tempExt : arrCompare) {
				if (tempExt.equals(ext)) {
					extFlag = true;
				} // end if
			} // end for

			if (!extFlag) {
				JOptionPane.showMessageDialog(this, fName + "은 전송가능한 파일이 아닙니다.\n이미지만 전송 가능합니다.");
				return;
			} // end if
		} // end if

//		if(!fName.endsWith(".jpg") && !fName.endsWith("jpeg")) {	//내가 만든것.. 가능은 함 초라함
//			JOptionPane.showMessageDialog(this, "아닙니다.", "아님", JOptionPane.WARNING_MESSAGE);
//		}

		// 파일전송!!!!! (중요)
		try {
			sendFile(new File(fPath + "/" + fName));
			dlmFileList.addElement(fName);
			JOptionPane.showMessageDialog(this, fName + "파일을 전송하였습니다.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// selectFile

	public void sendFile(File file) throws UnknownHostException, IOException {
		// 서버에 접속
		Socket socketClient = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;

		try {
			String ip=JOptionPane.showInputDialog("서버ip ");
			socketClient = new Socket("211.63.89.135", 10000);

			String fName = file.getName();
			// 1. 파일명을 전송
			dos = new DataOutputStream(socketClient.getOutputStream());
			dos.writeUTF(fName);
			dos.flush();

			// 3. 전송할 파일의 byte[] 갯수 서버 전송 //중요함
			int dataCnt = 0;
			byte[] tempData = new byte[512];
			int dataLen = 0;

			fis = new FileInputStream(file);
			while ((dataLen = fis.read(tempData)) != -1) {
				dataCnt++;
			} // end while
//			System.out.println("전송할 배열의 갯수" + dataCnt);
			fis.close();
			
			dos.writeInt(dataCnt); // 서버가 읽어들일 배열의 횟수(갯수)를 전송한다.
			dos.flush();
			
			//5. 파일에서 읽어들인 내용을 전송한다.
			dataLen=0;
			fis=new FileInputStream(file);  //전송한크기를 구한후 연결을 끊었기 때문에 재 연결한다.
			while( (dataLen = fis.read(tempData)) != -1) {
				dos.write(tempData,0,dataLen);
				dos.flush();
				dataCnt--;
			}//end while
			System.out.println("전송 횟수"+dataCnt);
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (dos != null) {
				dos.close();
			}
			if (socketClient != null) {
				socketClient.close();
			}

		} // end finally

	}// sendFile

	@Override
	public void actionPerformed(ActionEvent ae) {
		selectFile();
	}// actionPerformed

	public static void main(String[] args) {
		new FileClient();
	}// main
}// class
