package day1220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

//18.12.20	-2�� �ڷ�-	()
/**
 * �ڹ�JVM���� �߻��� �����Ͱ� ����, byte[] �� ��쿡 File�� �����ϴ� FileOutputStream ���.
 * 
 * @author owner
 */
public class UseFileOutputStream {

	public void useFileOutputStream() throws IOException { // Close �ϱ����ؼ� ����ó�� �Ѵ�.
		int i = 65;
		// 1. File class����
		File file = new File("c:/dev/temp/java_write22.txt");
		// 2. FileOutputStream ���� -> �Էµ� ��ο� ������ �����ȴ�.
//		FileOutputStream fos = new FileOutputStream(file); // ->���ϻ����� �ȴ�. ������
		// ������ ���ٸ� �����ϰ�, ������ �ִٸ� ���� ����. (�ƹ� �޼����� ���� �׳� ����� ������)

		FileOutputStream fos = null;

		try {
			boolean flag = false;
			if (file.exists()) {
				boolean [] temp= {false,true,true};
				int select=JOptionPane.showConfirmDialog(null, "����ðڽ��ϱ�?"); 
					flag=temp[select];
				}//end if
			
					// 2. FileOutputStream ���� -> �Էµ� ��ο� ������ �����ȴ�.
//				FileOutputStream fos = new FileOutputStream(file); // ->���ϻ����� �ȴ�. ������
//				// ������ ���ٸ� �����ϰ�, ������ �ִٸ� ���� ����. (�ƹ� �޼����� ���� �׳� ����� ������)
			if(!flag) {
			fos = new FileOutputStream(file);
			fos.write(i);// ���� ��Ʈ���� ���( ���� ���� ���ڰ� ���)
			fos.flush();
				}//end if
			
			System.out.println("���� ��� �Ϸ�");
		} finally {
			// fos.close(); : ��Ʈ���� ��ϵ� ������ �ִٸ�, �����ϰ� ���� ���´�.
			if (fos != null) {
				fos.close();
			} // end if

		}//end finally

	}// useFileOutputStream

	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();
		try {
			ufos.useFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// main

}// class
