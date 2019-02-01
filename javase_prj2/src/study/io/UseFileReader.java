package study.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UseFileReader {

	/**
	 * 	스트림으로 파일을 읽어와 출력
	 * @throws IOException
	 */
	public UseFileReader() throws IOException {
		File file=new File("c:/dev/temp/java_read.txt");
		
		BufferedReader br=null;
		br=new BufferedReader(new FileReader(file));
		String temp="";
		while( (temp=br.readLine( )) !=null ) {
			System.out.println(temp);
		}
		
		br.close();
		
	}//생성자
	
	public static void main(String[] args) {
		try {
			new UseFileReader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main

}//class
