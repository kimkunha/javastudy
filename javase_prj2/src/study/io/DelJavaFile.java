package study.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

/**
 * JOptionPane.showInputDialog를 사용하여 경로를 입력 받는다.
 * 
 * 입력받은 경로에 확장자가 java인 파일이 존재한다면
 * 
 * JOptionPane.showConfirmDialog를 사용하여 삭제여부를 묻는다.
 * 
 * 출력 메세지 "java 파일이 x개 존재합니다. 삭제하시겠습니까?" "예"를 누르면 해당 파일을 삭제하고 , "아니오"나 "취소"가
 * 눌려지면 종료한다.
 * 
 * @author owner
 */
public class DelJavaFile {
	// switch문으로 사용시 가독성 좋게 상수로 선언하는편이 좋다.
	public static final int YES = 0;
	public static final int NO = 1;
	public static final int ESC = 2;

	public DelJavaFile() {

		String inputData = JOptionPane.showInputDialog("경로를 입력해주세요");
		try {
			File file = new File(inputData);
			if (file.isDirectory()) {// 만약에 폴더가 존재한다면
				delJavaFile(file); // 메소드에서 삭제를 하는 일을 작성
			} else {
				JOptionPane.showMessageDialog(null, "폴더가 존재하지 않습니다.");
			} // end else
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	}// 생성자

	private void delJavaFile(File file) {

//		 입력받은 경로에 확장자가 java인 파일이 존재한다면
//		 * 
//		 * JOptionPane.showConfirmDialog를 사용하여 삭제여부를 묻는다.
//		 * 
//		 * 출력 메세지 "java 파일이 x개 존재합니다. 삭제하시겠습니까?" "예"를 누르면 해당 파일을 삭제하고 , "아니오"나 "취소"가
//		 * 눌려지면 종료한다.

		// 매개변수로 받은 파일을 전부 배열로 담는다.
		File[] fileArr = file.listFiles();
		// 리스트로 제네렉을 파일클래스를 담아 .java 파일만 담아야함으로 가변길이형인 리스트를 사용,
		List<File> fileList = new ArrayList<File>();
		
//		for (int i = 0; i < fileArr.length; i++) {
//			File fileJava=file;
//			if (fileJava.getName().endsWith(".java")) {
//				fileList.add(fileJava);
//			} // end if
//		} // end for

		
		for (File f : fileArr) {
			if (f.getName().endsWith(".java")) {
				fileList.add(f);
			} // end if
			System.out.print(fileList.toArray());
		} // end for

		int tempData = JOptionPane.showConfirmDialog(null, "Java파일이" + fileList.size() + "이 존재합니다. 삭제 할까요?");
		switch (tempData) {
		case YES:
			for (int i = 0; i < fileList.size(); i++) {
				fileList.get(i).delete();
			} // end for
		case NO:
			break;
		case ESC:
			break;
		}// end switch

	}// delJavaFile

	public static void main(String[] args) throws IOException {
		new DelJavaFile();
	}// main

}// class
