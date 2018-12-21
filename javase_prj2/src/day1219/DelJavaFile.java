package day1219;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *	JOptionPane.showInputDialog를 사용하여 경로를 입력 받는다.

	입력받은 경로에  확장자가 java인 파일이 존재한다면 

 	JOptionPane.showConfirmDialog를 사용하여  삭제여부를 묻는다.

 	출력 메세지  "java 파일이 x개 존재합니다. 삭제하시겠습니까?"
 	"예"를 누르면 해당 파일을 삭제하고 , "아니오"나 "취소"가  눌려지면 
	종료한다. 
 * @author owner
 */
public class DelJavaFile {
	private static final int YES = 0;
	private static final int NO = 1;
	private static final int ESC = 2;
	
	public DelJavaFile() {
		questionPath();
	} // DelJavaFile
	
	public void questionPath() {
		String path = JOptionPane.showInputDialog("경로 입력");
		
		try {
			File file = new File(path);
			
			if (file.isDirectory()) {
				deleteJavaFile(file);
			} else {
				System.out.println("경로를 다시 확인해주세요.");
			} // end else
		} catch (NullPointerException npe) {
			return;
		} // end catch
	} // deleteJavaFile
	
	public void deleteJavaFile(File file) {
		File[] fileArr = file.listFiles();
		
		List<File> javaFile = new ArrayList<File>();
		
		for (File f : fileArr) {
			if (f.getName().endsWith(".java")) {
				javaFile.add(f);
			} // end if
		} // end for
		
		int delFlag = JOptionPane.showConfirmDialog(null, 
				"java 파일이 " + javaFile.size() + "개 존재합니다. 삭제하시겠습니까?");
		
		switch (delFlag) {
		case YES:
			for (int i = 0; i < javaFile.size(); i++) {
				javaFile.get(i).delete();
			} // end for
			break;
		case NO:
			return;
		case ESC:
			return;
		} // end switch
	} // deleteJavaFile
	
	public static void main(String[] args) {
		new DelJavaFile();
		
	} // main

} // class
