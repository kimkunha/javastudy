package study.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;

/**
 *	8bit�� 16bit stream�� ����Ͽ� ���ڿ� �����͸� file�� ����غ���.
 * @author owner
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		//������ �����ϰ� �� �ȿ� ���ڿ��� �Է��ϴ� Stream ����. �׸��� ������� �ȳ�â ���
		
		//�ؽ�Ʈ ���� ���ڿ� �ۼ�
		String inputData="�ȳ��ϼ���. ������ �ݿ��Ͽ��� ��� �����ϼ���";
		//������ ������ ��ġ ��� ���� String���� ������ ������ ����
		String path="c:/dev/temp/kim/test_kim1.txt";
		//���Ͽ� �Ű������� �޴´�.
		File file=new File(path);

		//������ ��ο� ������ �����Ǿ���.
//		FileOutputStream fos=new FileOutputStream(file);
		//�� ���� �ϸ� �ƹ� ������ �����Ͽ��� ��� ���� �ڵ����� ���� ��������. �̸� �����ϱ� ���� boolean���� 
		//������ �ɾ �����ϴ� �ڵ� �ۼ�
		
		//���ڿ��� �ޱ����� 16bit�� �ӵ� ������ ����8bit�� �����Ѵ�.
		BufferedWriter bw=null;
		
		boolean flag=false;
		if(file.exists()) {// ������ �����ϴ�???
			boolean[] temp= {false, true, true};
			flag=temp[JOptionPane.showConfirmDialog(null, "������ �����մϴ�. ������ �ǰ���?")];
			
			bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			//bufferedwriter �ӵ���� ��Ű�� outputstream 8bit fileoutputstream 16bit
			bw.write(inputData);
			bw.flush();
			if( bw !=null ) {
				bw.close();
			}
		}//end if
		
	}//������
	
	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
