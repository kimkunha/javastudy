package day1219;

import java.io.File;

//18.12.19	-4�� �ڷ�-	(File2)	
/**
 *	���� ����, ���� ����
 * @author owner
 */
public class UseFile2 {
	public void createDirectory() {
	File file=new File("c:/kunha/kim");
	if(file.mkdir()) {		//dir, dirs �Ѵ� ����
		
	System.out.println("�������� ����");
	}else {
		System.out.println("���� �̸��� ���� ����");
	}//end if
	
	
	}//createDirectory
	public void removeFile() {
		File file=new File("c:/dev/temp/a.txt");
				boolean flag=file.delete();
				if( flag ) {
					System.out.println("���� ���� ����");
				}else {
					System.out.println("���� ���� ����");
				}//end if
	}//removeFile
	
		
	public static void main(String[] args) {
		UseFile2 uf2=new UseFile2();
		uf2.createDirectory();
		System.out.println("-------------------------------------------");
		uf2.removeFile();
		
		
		
		
	}//main

}//class
