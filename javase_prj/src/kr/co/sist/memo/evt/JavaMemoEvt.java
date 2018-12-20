package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;
import kr.co.sist.memo.view.MemoHelp;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;
	private String taNoteData; // TextAera의 내용을 저장할 변수
	private String openPath; // 열었던 파일명을 저장변수

	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
		taNoteData = "";
		openPath = "";

	}// JavaMemoEvt

	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
//		miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;	//까먹을수 있으니 복사해놔서 구현해야 할 목록을 놓치지 말자
		// 라벨로 할경우 getter필요 없다.

		// 새글 메뉴아이템에서 이벤트가 발생 했을때
		if (ae.getSource() == jm.getMiNew()) {
			newMemo();
		} // end if

		// 열기 메뉴아이템에서 이벤트가 발생 했을때
		if (ae.getSource() == jm.getMiOpen()) {
			try {
				openMemo();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(jm, "선택한 파일을 읽을 수 없습니다.", "파일 열기 에러", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "선택한 파일을 읽어들이는 중 문제가 발생하였습니다.", "파일 열기 에러",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		} // end if

		// 저장 메뉴아이템에서 이벤트가 발생 했을때
		if (ae.getSource() == jm.getMiSave()) {
			saveMemo();
		} // end if

		// 다른 이름으로 저장 메뉴아이템에서 이벤트가 발생 했을 때
		if (ae.getSource() == jm.getMiNewSave()) {
			newSaveMemo();
		} // end if

		// 종료 메뉴아이템에서 이벤트가 발생 했을 때
		if (ae.getSource() == jm.getMiEnd()) {
			jm.dispose();
		} // end if

		// 서식 메뉴아이템에서 이벤트가 발생 했을 때
		if (ae.getSource() == jm.getMiFormat()) {
			formatDialog();
		} // end if

		// 도움말 메뉴아이템에서 이벤트가 발생 했을 때
		if (ae.getSource() == jm.getMiHelp()) {
			helpDialog();
		} // end if

	}// actionPerformed

	/**
	 * 새글 : TextArea를 초기화한다.
	 */
	public void newMemo() {

		TextArea tempTa = jm.getTaNote();
		boolean flagNew = false;
		// 저장할 것인지 판단
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(jm, "다른 이름으로 저장 하시겠습니까?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				newSaveMemo();
			case JOptionPane.NO_OPTION:
				flagNew = false;
				break;
			default:
				flagNew = true;
			} // end switch
		} // end if
		if (!flagNew) {

			tempTa.getText();
			tempTa.setText(""); // 이렇게 해야 되는데 버그로 인해 getText를 위에 호출한다.
			// 새글이 된 이후에는 읽기한 내용을 초기화
			taNoteData = tempTa.getText(); // 읽어들인 파일의 경로 초기화
			openPath = ""; // 초기화

			jm.setTitle("메모장 - 새글");
		} // end if
	}// newMemo

	/**
	 * txt파일 열기
	 */
	public void openMemo() throws FileNotFoundException, IOException {

		// TextArea의 내용과 읽어들였던 내용이 다르다면 저장여부를 묻고, 작업을 진행한다.
		boolean flagOpen =false;
		TextArea tempTa = jm.getTaNote();
		if (!taNoteData.equals(tempTa.getText())) {
				int flag = JOptionPane.showConfirmDialog(jm, openPath + "\n을 저장하시겠습니까?");
				switch(flag) {
				case JOptionPane.OK_OPTION :
					if (!openPath.equals("")) {
					// 기존의 이름에 저장할 것인지
					saveMemo();
			} else {
				// 다른 이름으로 저장
				newSaveMemo();
			} // end else
			case JOptionPane.NO_OPTION :
				flagOpen=false;
				break;
			default :
				flagOpen=true;
		} // end if
		}// end if
	if( !flagOpen) {
		FileDialog fdOpen = new FileDialog(jm, "문서 열기", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String filePath = fdOpen.getDirectory();
		String fileName = fdOpen.getFile();

		if (filePath != null) { // 선택한 파일이 존재
			/////////////////////////////////////// 12-20-2018 스트림으로 파일의 내용을 읽는 코드 추가
			/////////////////////////////////////// 시작/////////////////////////////////////////////////

			// 내용 : 선택한 파일로 파일객체 생성.
			File file = new File(filePath + fileName);
			// 16bit stream 사용
			BufferedReader br = null;

			try {
				br = new BufferedReader(new FileReader(file));
				String temp = "";
				tempTa.setText("");
				while ((temp = br.readLine()) != null) {
					// 파일에서 읽어들인 내용을 설정한다.
					tempTa.append(temp + "\n");
				} // end while
					// 변수에 읽어들인 내용을 저장
				taNoteData = tempTa.getText();
				// 열었던 파일명을 저장
				openPath = file.getAbsolutePath();

			} finally {
				if (br != null) {
					br.close();
				} // 연결이 되든 안되는 객체가 만들어 져있다면 한번 끊어주세요.

			} // end finally

			// 작성 :
			/////////////////////////////////////// 12-20-2018 에 코드 추가
			// 끝/////////////////////////////////////////////////

			// 파일의 경로와 이름을 Frame의 TitleBar에 설정
			jm.setTitle("메모장 - 열기 " + fileName + filePath);
		} // end if
		}//end if
	}// openMemo

	/**
	 * 작성한 메모 저장 - 기존의 파일명을 그대로 저장하는 파일명에 반영
	 */
	public void saveMemo() {
		newSaveMemo();
	}// saveMemp

	/**
	 * 파일명을 입력받아 새이름으로 저장
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "문서 저장", FileDialog.SAVE);
		fdSave.setVisible(true);

		String filePath = fdSave.getDirectory();
		String fileName = fdSave.getFile();

		if (filePath != null) { // 선택한 파일이 존재

			// 파일의 경로와 이름을 Frame의 TitleBar에 설정
			jm.setTitle("메모장 - 저장 " + fileName + filePath);
		} // end if

	}// newSaveMemo

	/**
	 * 글꼴을 설정하는 다이얼로그를 실행하는 일
	 */
	public void formatDialog() {
		new MemoFormat(jm);
	}// format

	/**
	 * 메모장 정보를 제공하는 다이얼로그를 실행
	 */
	public void helpDialog() {
		new MemoHelp(jm);
	}// helpDialog

}// class
