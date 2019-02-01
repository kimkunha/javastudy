package study.filecopy;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TestFileCopy extends JFrame implements ActionListener {

	private JButton jb;
	private JProgressBar jpb;
	private long fileLen;
	private int cnt;
	File file;

	public TestFileCopy() {
		super("파일 복사");
		jb = new JButton("파일선택");
		jpb = new JProgressBar(0, 100);
		jpb.setString("진행도");

		JPanel jp = new JPanel();
		jp.add(jb);

		add("Center", jp);
		add("South", jpb);

		jb.addActionListener(this);
		setBounds(100, 100, 500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// 생성자

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// 파일 다이얼로그 설정
		FileDialog fdOpen = new FileDialog(this, "파일 열기", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String path = fdOpen.getDirectory(); // 지정된 파일의 폴더(저장위치?)명 를 얻는다 반환String
		String name = fdOpen.getFile(); // 지정된 파일명을 얻는다.

		if (path != null) { // 폴더가 없다면. 는 그럴리가 무조건 있음
			file = new File(path + name);

			copy(file);

		} // end if

	}// actionPerformed

	public void copy( File file) {
		
		int selectValue=JOptionPane.showConfirmDialog(this, "파일을 복사하시겠습니까?");
	
		switch(selectValue) {
		case JOptionPane.OK_OPTION :
			
			// 스트링 빌더로 사용하여 매개변수에 절대경로 입력
			StringBuilder copyFileName = new StringBuilder(file.getAbsolutePath());
			copyFileName.insert(copyFileName.lastIndexOf("."), "_bak");
			// insert method는 데이터를 추가하는 method
			// 인트로 인덱스 자리 설정, 뒤에 문자열 삽입
			FileInputStream fis = null; // 파일 읽어오는 스트림
			FileOutputStream fos = null;// 파일 출력하는 스트림
			try {

				// 원본파일에 스트림 연결
				fis = new FileInputStream(file);
				fos = new FileOutputStream(copyFileName.toString()); // bak이 들어간 복사된 파일

				// 파일과 연결된 스트림에서 값을 얻는다.
				int temp = 0;
				fileLen = file.length();
				cnt = 0;
				int i = 0;
				try {
					while ((temp = fis.read()) != -1) { //읽어들이는게 없을떄 까지
						fos.write(temp);
						fos.flush();
//						jpb.setValue(  (int)(( i/(double)fileLen)*100)  );
//						if(jpb.getValue()==100) {
//							break;
//						}
						//읽어 들인 내용을 _bak가 붙은 파일을 생성하여 출력 ( 복사 )
						i++;
					}//end while
					
					JOptionPane.showMessageDialog(this, file+"복사성공");
				} catch (IOException e) {
				}finally {
					if(fis != null ) { 
						try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					} }//end if
					if(fos != null ) { 
						try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					} }
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} // end catch
//			HDD가 읽어 들이는 크기를
			
		}//end switch
	
	}// copy

	public static void main(String[] args) {
		new TestFileCopy();
	}// main

}// class
