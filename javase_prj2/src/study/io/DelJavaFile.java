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
 * JOptionPane.showInputDialog�� ����Ͽ� ��θ� �Է� �޴´�.
 * 
 * �Է¹��� ��ο� Ȯ���ڰ� java�� ������ �����Ѵٸ�
 * 
 * JOptionPane.showConfirmDialog�� ����Ͽ� �������θ� ���´�.
 * 
 * ��� �޼��� "java ������ x�� �����մϴ�. �����Ͻðڽ��ϱ�?" "��"�� ������ �ش� ������ �����ϰ� , "�ƴϿ�"�� "���"��
 * �������� �����Ѵ�.
 * 
 * @author owner
 */
public class DelJavaFile {
	// switch������ ���� ������ ���� ����� �����ϴ����� ����.
	public static final int YES = 0;
	public static final int NO = 1;
	public static final int ESC = 2;

	public DelJavaFile() {

		String inputData = JOptionPane.showInputDialog("��θ� �Է����ּ���");
		try {
			File file = new File(inputData);
			if (file.isDirectory()) {// ���࿡ ������ �����Ѵٸ�
				delJavaFile(file); // �޼ҵ忡�� ������ �ϴ� ���� �ۼ�
			} else {
				JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�.");
			} // end else
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	}// ������

	private void delJavaFile(File file) {

//		 �Է¹��� ��ο� Ȯ���ڰ� java�� ������ �����Ѵٸ�
//		 * 
//		 * JOptionPane.showConfirmDialog�� ����Ͽ� �������θ� ���´�.
//		 * 
//		 * ��� �޼��� "java ������ x�� �����մϴ�. �����Ͻðڽ��ϱ�?" "��"�� ������ �ش� ������ �����ϰ� , "�ƴϿ�"�� "���"��
//		 * �������� �����Ѵ�.

		// �Ű������� ���� ������ ���� �迭�� ��´�.
		File[] fileArr = file.listFiles();
		// ����Ʈ�� ���׷��� ����Ŭ������ ��� .java ���ϸ� ��ƾ������� ������������ ����Ʈ�� ���,
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

		int tempData = JOptionPane.showConfirmDialog(null, "Java������" + fileList.size() + "�� �����մϴ�. ���� �ұ��?");
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
