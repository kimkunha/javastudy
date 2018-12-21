package day1219_test;

import java.io.File;
import java.lang.reflect.Field;

/**
 *	파일에 대해서 공부하자
 *
 * @author owner
 */
public class UseFile {

	public static void main(String[] args) {
		//1. 파일생성하기
		File file=new File("c:/dev/temp");		//안에는 경로가 들어온다
				System.out.println(file);
			if(file.exists()) {// 파일,폴더가 있으면 하위 디렉토리에 .text로 끝나는 파일을 검색하여 제일 처음 검색되는 파일을 읽어와서 콘솔창에 출력
				File[] arr=file.listFiles();
				
			}
			
		
		
		
		
		
		
		
		
		
		
	}//main

}//class
