package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JMenu;

//18.12.20	-1�� �ڷ�-	()
/**
 * 16bit Stream�� ����Ͽ� ���� �б�
 * 
 * @author owner
 */
public class UseFileReader {

	public void useFileReader() throws IOException { // close�ϱ� ���� �����ڿ��� ����ó�� �Ѵ�. �ڵ带 �����ϱ�����
		BufferedReader br = null;

		File file = new File("c:/dev/temp/java_read.txt");
		// 1. �ٿ��� ���Ͽ� ��Ʈ�� ����
//			FileReader fr=new FileReader(file);
//			//2. �ٴ��� �о���̴� ����� ���� ��Ʈ�� ����
//			br=new BufferedReader(fr);

		try {
			// �ڵ� ����ȭ �ϱ�
			br = new BufferedReader(new FileReader(file));
			String temp = "";
			// T.A�� �ʱ�ȭ �� ��

			// ���پ� �о�鿩 �о���� ������ �����Ѵٸ�
			while ((temp = br.readLine()) != null) {

			} // end while

		} finally {
			// ��Ʈ���� �� ���ٸ� ����� ��Ʈ���� ���´�. �߿�!
			if (br != null) {
				br.close();// end if //������ �Ǿ��ֵ� �ƴϵ� ������
			}
		} // end finally

	}// useFileReader

	public static void main(String[] args) {
		UseFileReader ufr = new UseFileReader();

		try {
			ufr.useFileReader();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// main

}// class
