package study.filecopy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 *	���� �����غ���.
 * @author owner
 */
public class TestCopy {
	
	public TestCopy() throws IOException {
		//������ �����ϴ°Ŵ� ���Ͻ�Ʈ���� ����ؾ� �ȴ�.
		//��ǲ ��Ʈ������ ������ ������ ����
		BufferedReader br=null;
		//�ƿ�ǲ ��Ʈ������ �����Ѱ��� ��� 
		BufferedWriter bw=null;
		try {
//		File file=new File("c:/dev/temp/kim/kim.txt");
			
//			File file =new File("c:/dev/temp/kim/kim.txt");
			
//		br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		br=new BufferedReader(new InputStreamReader(new FileInputStream( new File("c:/dev/temp/kim/kim.txt"))));
		bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("c:/dev/temp/kim/kims.txt"))));	
			
			int temp=0;
					
			while( (temp=br.read()) != -1) {
				bw.write(temp);
				bw.flush();
			}
			
			JOptionPane.showMessageDialog(null, "���缺����!");
		
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if( br!=null) { br.close();}
			if( bw!=null) { bw.close();}
		}
		
		
	}//������
	
	public static void main(String[] args) {
		try {
			new TestCopy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main
	
}//class
