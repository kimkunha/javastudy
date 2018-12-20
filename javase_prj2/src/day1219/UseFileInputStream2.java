package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//18.12.19	-5�� �ڷ�-	(FileInputStream)/	8bit+16bit �����Ͽ� �ѱ۷� ����Ҽ� �ְ� ���ִ� ��.	
/**
 *	HDD�� �����ϴ� File�� �����Ͽ� �� ������ �о���϶� ����ϴ�
 *	FileInputStream
 * @author owner
 */
public class UseFileInputStream2 {
	
	public UseFileInputStream2() throws IOException{
		File file =new File("c:/dev/temp/java_read.txt");
		if(file.exists()) {
			BufferedReader br=null;
			
			try {
//				//��Ʈ���� �����Ͽ� JVM���� HDD�� ���ϰ� ����
//				FileInputStream fis=new FileInputStream(file);
//				int temp=0;
//				
//					while( (temp=fis.read()) !=-1 ) { //�о���� ������ �����Ѵٸ�
//						System.out.print( (char)temp );
//					}//end while
//					
//					//��Ʈ������� �Ϸ� ������ ��Ʈ���� ��� �޸� ������ ���´�.
//					fis.close();
			
			////////////12-20-2018 �ڵ� �߰�///////////////      (�����̷��̶�� �Ѵ�)
				//8bitStream �� 16bitStream ���� : �ѱ��� ������ �����ذ�.
				
//				FileInputStream fis=new FileInputStream(file);	//���ϰ������ϴ� Stream
//				InputStreamReader isr=new InputStreamReader(fis);	//8bit�� 16bit ���� ���ִ� method
//				 br=new BufferedReader(isr);		//�ӵ�����, �ٴ��� �б� (buffer�� ����� �ӵ����� ���ִ� method)
				//�� �ڵ� 3�ٵ� ��� 1�ٷ� ����ȭ �� ���ڴ�.
				br=new BufferedReader(new InputStreamReader( new FileInputStream(file)));
				
				String temp="";
				while( (temp=br.readLine()) !=null) { // �ٴ���(\n������)�� �о �о���� ������ �ִٸ�  ����ض�
					System.out.println( temp );	//���
				}//end while
//				br.close();	//�ݵ�� ������ �������־�� �Ѵ�.		
				
				
//			} catch (FileNotFoundException e) {		//throws �� ��������
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
			}finally {
				if(br !=null) {
					br.close();
				}
				
//				try {
//					br.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}	//�ݵ�� ������ �������־�� �Ѵ�.		//1.�������� ���� BufferedReader�� ���������� ���� �ν��Ͻ������� �����Ѵ�
																	//�� �������� ���� ����ó�� ����� �Ѵ�.. �ڵ尡 ��� �������� �������� ����ȭ ���ش�
			}//end catch											// throws �� ��������
			
		}else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���.");
		}//end else
		
		
	}//UseFileInputStream
	public static void main(String[] args) {
		try {
			new UseFileInputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
