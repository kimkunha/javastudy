package study.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *	���� �о��
 * @author owner
 */
public class UseFileInputStream {

	public UseFileInputStream() throws IOException {
		//�о� ���� ������ ��θ� ��Ʈ�� path �� ����
		String path="c:/dev/temp/java_read.txt";
		//���� ��ü�� �����Ͽ� �Ű������� ����
		File file=new File(path);
		
		if(file.exists()) {//������ �����ϴ��� �����ϸ� beffered ��Ʈ�� ����
			BufferedReader br=null;
			
			try {
				br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
				String temp="";
				while( (temp=br.readLine()) !=null ) { //���۵� ����������� ���پ� �о� ���δ�. ���� �ƴҶ� ����
					System.out.println(temp);
				}//end while
				
			}finally {
			if(br !=null) { br.close(); }
			}//end finally
			
			
		}//end if
		
	}//������
	
	public static void main(String[] args) throws IOException {
		new UseFileInputStream();
	}//main

}//class
