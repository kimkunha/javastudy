package day1219;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//18.12.19	-3�� �ڷ�-	(File)	
/**
 *	FileŬ����
 *	-������ �������
 *	-���丮 ����
 *	-���ϻ���
 * @author owner
 */
public class UseFile {

	public UseFile() {
		String path="c:/dev/temp/java_read.txt";
		//1. ����
		File file=new File( path );	//path�� ��η� ��
		System.out.println( file );
//		System.out.println( file.exists());	//������ �����ϴ�? 
		if( file.exists()) {	//������ �����ϴ°�쿡 
			System.out.println("���� ��� : "+file.getAbsolutePath());	//������
			try {
				System.out.println("�Թ� ��� : "+file.getCanonicalPath());
			} catch (IOException ie) {
				ie.printStackTrace();
			}//end catch 	//������
			System.out.println("��� : "+file.getPath());
			System.out.println("������ : "+file.getParent());	//c:/dev/temp
			System.out.println("���ϸ� : "+file.getName());	//java_read.txt
			
			System.out.println(file.isFile()?"����":"���丮");
			System.out.println(file.isDirectory()?"���丮":"����");
			
			System.out.println("���� ���� : "+file.length()+"byte");
			System.out.println("����"+(file.canExecute()?"����":"�Ұ���"));
			System.out.println("�б�"+(file.canRead()?"����":"�Ұ���"));
			System.out.println("����"+(file.canWrite()?"����":"�Ұ���"));
			System.out.println(file.isHidden()?"��������":"�Ϲ�����");
			Date d=new Date(file.lastModified());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
			System.out.println("������ ������ : "+sdf.format(d));
			
			
		}else {
			System.out.println("��θ� Ȯ���� �ּ���.");	//������ �������� ����
		}//end if
		
	}//UseFile
	
	public static void main(String[] args) {
		new	UseFile();
	}//main

}//class
