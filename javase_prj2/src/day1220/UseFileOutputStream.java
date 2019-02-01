package day1220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

//18.12.20	-2번 자료-	()
/**
 * 자바JVM에서 발생한 데이터가 정수, byte[] 인 경우에 File로 저장하는 FileOutputStream 사용.
 * 
 * @author owner
 */
public class UseFileOutputStream {

	public void useFileOutputStream() throws IOException { // Close 하기위해서 예외처리 한다.
		int i = 65;
		// 1. File class생성
		File file = new File("c:/dev/temp/java_write22.txt");
		// 2. FileOutputStream 생성 -> 입력된 경로에 파일이 생성된다.
//		FileOutputStream fos = new FileOutputStream(file); // ->파일생성이 된다. 하지만
		// 파일이 없다면 생성하고, 파일이 있다면 덮어 쓴다. (아무 메세지도 없이 그냥 덮어씌워 버린다)

		FileOutputStream fos = null;

		try {
			boolean flag = false;
			if (file.exists()) {
				boolean [] temp= {false,true,true};
				int select=JOptionPane.showConfirmDialog(null, "덮어쓰시겠습니까?"); 
					flag=temp[select];
				}//end if
			
					// 2. FileOutputStream 생성 -> 입력된 경로에 파일이 생성된다.
//				FileOutputStream fos = new FileOutputStream(file); // ->파일생성이 된다. 하지만
//				// 파일이 없다면 생성하고, 파일이 있다면 덮어 쓴다. (아무 메세지도 없이 그냥 덮어씌워 버린다)
			if(!flag) {
			fos = new FileOutputStream(file);
			fos.write(i);// 값을 스트림에 기록( 수에 대한 문자가 출력)
			fos.flush();
				}//end if
			
			System.out.println("파일 기록 완료");
		} finally {
			// fos.close(); : 스트림에 기록된 내용이 있다면, 분출하고 연결 끊는다.
			if (fos != null) {
				fos.close();
			} // end if

		}//end finally

	}// useFileOutputStream

	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();
		try {
			ufos.useFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// main

}// class
