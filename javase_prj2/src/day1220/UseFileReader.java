package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JMenu;

//18.12.20	-1번 자료-	()
/**
 * 16bit Stream만 사용하여 파일 읽기
 * 
 * @author owner
 */
public class UseFileReader {

	public void useFileReader() throws IOException { // close하기 위해 생성자에서 예외처리 한다. 코드를 간소하기위해
		BufferedReader br = null;

		File file = new File("c:/dev/temp/java_read.txt");
		// 1. 근원지 파일에 스트림 연결
//			FileReader fr=new FileReader(file);
//			//2. 줄단위 읽어들이는 기능을 가진 스트림 연결
//			br=new BufferedReader(fr);

		try {
			// 코드 간소화 하기
			br = new BufferedReader(new FileReader(file));
			String temp = "";
			// T.A를 초기화 한 후

			// 한줄씩 읽어들여 읽어들인 내용이 존재한다면
			while ((temp = br.readLine()) != null) {
				System.out.println(temp);
			} // end while

		} finally {
			// 스트림을 다 �㎢摸� 연결된 스트림을 끊는다. 중요!
			if (br != null) {
				br.close();// end if //연결이 되었있든 아니든 끊어줘
			}
		} // end finally

	}// useFileReader

	public static void main(String[] args) {
		UseFileReader ufr = new UseFileReader();

		try {
			ufr.useFileReader();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// main

}// class
