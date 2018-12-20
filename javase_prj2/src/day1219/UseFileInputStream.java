package day1219;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//18.12.19	-5�� �ڷ�-	(FileInputStream)	
/**
 *	HDD�� �����ϴ� File�� �����Ͽ� �� ������ �о���϶� ����ϴ�
 *	FileInputStream
 * @author owner
 */
public class UseFileInputStream {
	public UseFileInputStream() {
		File file =new File("c:/dev/temp/java_read.txt");	//�ѱ��� ����� �ȵ����� ����� ����� �ȴ�. �ѱ��� ����ϱ� ���ؼ� ����
		if(file.exists()) {
			
			try {
				//��Ʈ���� �����Ͽ� JVM���� HDD�� ���ϰ� ����
				FileInputStream fis=new FileInputStream(file);
				int temp=0;
				
					while( (temp=fis.read()) !=-1 ) { //�о���� ������ �����Ѵٸ�
						System.out.print( (char)temp );
					}//end while
					
					//��Ʈ������� �Ϸ� ������ ��Ʈ���� ��� �޸� ������ ���´�.
					fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
			
		}else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���.");
		}//end else
		
		
	}//UseFileInputStream
	public static void main(String[] args) {
		new UseFileInputStream();
	}//main

}//class
