package study.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *	파일 읽어보자
 * @author owner
 */
public class UseFileInputStream {

	public UseFileInputStream() throws IOException {
		//읽어 들일 파일의 경로를 스트링 path 에 담음
		String path="c:/dev/temp/java_read.txt";
		//파일 객체를 생성하여 매개변수에 담음
		File file=new File(path);
		
		if(file.exists()) {//파일이 존재하는지 존재하면 beffered 스트림 생성
			BufferedReader br=null;
			
			try {
				br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
				String temp="";
				while( (temp=br.readLine()) !=null ) { //버퍼드 리드라인으로 한줄씩 읽어 들인다. 널이 아닐때 까지
					System.out.println(temp);
				}//end while
				
			}finally {
			if(br !=null) { br.close(); }
			}//end finally
			
			
		}//end if
		
	}//생성자
	
	public static void main(String[] args) throws IOException {
		new UseFileInputStream();
	}//main

}//class
