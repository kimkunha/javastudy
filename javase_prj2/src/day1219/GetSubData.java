package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ���α׷��� ����Ǹ� "���͸��� �Է� : " �޽����� ��µǰ�, 
 * ����ڰ� ���͸� "��) c:/dev"�� �Է����� ��, 
 * ���͸���� �ش� ���͸� �� ���� ������ JOptionPane.showMessageDialog�� ����ϴ� ���α׷�<br>
 * ���͸��� �ƴ϶�� "������ ������� �ʽ��ϴ�." console�� ���<br>
 * 
 * ���)
 * �̸�			����		ũ��		���������� ������ ��¥<br>
 * apis			����<br>
 * test.java	����		17byte	yyyy-MM-dd hh:mm<br>
 * 
 * - ������ ��� ũ�⸦ ������� �ʴ´�.<br>
 * @author owner
 */
@SuppressWarnings("serial")
public class GetSubData extends JFrame {
	public GetSubData() throws IOException {
		checkDirectory();
	} // GetSubData
	
	public void checkDirectory() throws IOException {
		System.out.print("���͸��� �Է� : ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String dirName = br.readLine();
		
		File fileName = new File(dirName);
		
		if (fileName.isDirectory()) {
			getFileData(fileName);
		} else {
			System.err.println("������ ������� �ʽ��ϴ�.");
		} // end else
		
		br.close();
	} // checkDirectory
	
	public void getFileData(File file) {
		JTextArea jta = new JTextArea(10, 70);
		jta.setEditable(false);
		jta.append("�̸�\t\t����\t\tũ��\t\t���������� ������ ��¥\n");
		
		SimpleDateFormat sdf =
				new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		Date d=null;
		
		// �ش� ���͸��� ���� ���͸�, ������ ������ �޾ƿ��� �ȴ�.
		// �̰� �����ϴ� method��? listFiles()
		File[] fileArr = file.listFiles();
		
		for (File f : fileArr) {
			d = new Date(f.lastModified());
			
			jta.append(f.getName() + 
					"\t\t" + (f.isFile()? "����" : "����") + 
					"\t\t" + f.length() + 
					"byte\t\t" + sdf.format(d) + "\n");
		} // end for
		
		JScrollPane jsp = new JScrollPane(jta);
		
		JOptionPane.showMessageDialog(null, jsp);
	} // getFileData
	
	public static void main(String[] args) throws IOException {
		new GetSubData();
		
	} // main

} // class
