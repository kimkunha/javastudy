package day1219;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *	JOptionPane.showInputDialog�� ����Ͽ� ��θ� �Է� �޴´�.

	�Է¹��� ��ο�  Ȯ���ڰ� java�� ������ �����Ѵٸ� 

 	JOptionPane.showConfirmDialog�� ����Ͽ�  �������θ� ���´�.

 	��� �޼���  "java ������ x�� �����մϴ�. �����Ͻðڽ��ϱ�?"
 	"��"�� ������ �ش� ������ �����ϰ� , "�ƴϿ�"�� "���"��  �������� 
	�����Ѵ�. 
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
		String path = JOptionPane.showInputDialog("��� �Է�");
		
		try {
			File file = new File(path);
			
			if (file.isDirectory()) {
				deleteJavaFile(file);
			} else {
				System.out.println("��θ� �ٽ� Ȯ�����ּ���.");
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
				"java ������ " + javaFile.size() + "�� �����մϴ�. �����Ͻðڽ��ϱ�?");
		
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
