package study.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 *	�ڹ� JVM���� �߻��� �����Ͱ� ����, byte[] �� ��쿡 File�� �����ϴ� File�� �����ϴ� FileOutputStream ���
 * @author owner
 */
public class UseFileOutputStream {

	private void useFileOutputStream() throws IOException {
		int i=65;
		
//		String[] strArr= {"�ȳ�","�ȳ�"};
		//1. File class ����
		File file =  new File("c:/dev/temp/Test_java_io.txt");
		//2. FileOutputStream ���� ->�Էµ� ��ο� ������ �����ȴ�.
//		FileOutputStream fos=new FileOutputStream(file);
		
		FileOutputStream fos=null;
		
		
		boolean flag=false;
		if(file.exists()) { //������ �����ϴ���? ���� ����?
			boolean [] temp= {false,true,true};
			int select=JOptionPane.showConfirmDialog(null, "�����?");
			flag=temp[select];
		}//end if
		
		//2. FileOutputStream ���� -> �Էµ� ��ο� ������ �����ȴ�.
//		FileOutputStream fos =new FileOutputStream(file) �̷��� �ϸ� �Էµ� ��ο� ������ �����ȴ�.
//		������ ������ ���ٸ� �����ϰ�, ������ �ִٸ� ���� ����.( �ƹ� �޼����� ���� ���� ���� ������)
		
		if(!flag) { //flag�� true��� fileoutputstream�� �����Ѵ�. �Ű������� file ���� �����Ұ� ���
			fos=new FileOutputStream(file);
		fos.write(i); //���� ��Ʈ���� ��� (���� ���� ���ڰ� ���)
			fos.flush();
		
		}//end if
		
		System.out.println("���� ��� �Ϸ�!!!!!");
		
		
		
		
	}//usefileoutputstream
	
	
	
	
	
	public static void main(String[] args) {
		try {
			new UseFileOutputStream().useFileOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main

}//class
