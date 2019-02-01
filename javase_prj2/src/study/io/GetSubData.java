package study.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
		CheckDirectory();
		
		
	}//������

	private void CheckDirectory() throws IOException {
		System.out.println("�Է����ּ���.");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String fileDir=br.readLine();
			File file=new File(fileDir);
			if(file.isDirectory()) {//������ �����ϴ�?
				selectFile(file);
			}else {
				System.out.println("������ ������� �ʽ��ϴ�.");
			}//end else
			
		}finally {
			if(br !=null ) { br.close(); }
		}//end chatch
		
		
	}//checkDirectory
	
	private void selectFile(File file) {
		JTextArea jta=new JTextArea(10,80);
		jta.setEditable(false);
		jta.append("�̸�\t\t����\t\tũ��\t\t���������� ������ ��¥\n");
//		* test.java	����		17byte	yyyy-MM-dd hh:mm<br>
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		Date d=null;
		File[] fileArr=file.listFiles();
		for( File f : fileArr) {
			d=new Date(f.lastModified());
			jta.append(f.getName()+"\t\t"+(f.isFile()?"����":"����")+"\t\t"+f.length()+"byte\t\t"+sdf.format(d)+"\n");
			
		}//end for
		JScrollPane jsp=new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
		
		
		
	}//selectFile
	
	public static void main(String[] args) {
		try {
			new GetSubData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
