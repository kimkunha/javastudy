package day1219;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//18.12.19	-5번 자료-	(FileInputStream)	
/**
 *	HDD에 존재하는 File과 연결하여 그 내용을 읽어들일때 사용하는
 *	FileInputStream
 * @author owner
 */
public class UseFileInputStream {
	public UseFileInputStream() {
		File file =new File("c:/dev/temp/java_read.txt");	//한글은 출력이 안되지만 영어는 출력이 된다. 한글을 출력하기 위해서 다음
		if(file.exists()) {
			
			try {
				//스트림을 생성하여 JVM에서 HDD의 파일과 연결
				FileInputStream fis=new FileInputStream(file);
				int temp=0;
				
					while( (temp=fis.read()) !=-1 ) { //읽어들인 내용이 존재한다면
						System.out.print( (char)temp );
					}//end while
					
					//스트림사용을 완료 했으면 스트림을 끊어서 메모리 누수를 막는다.
					fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
			
		}else {
			System.out.println("경로나 파일명을 확인하세요.");
		}//end else
		
		
	}//UseFileInputStream
	public static void main(String[] args) {
		new UseFileInputStream();
	}//main

}//class
