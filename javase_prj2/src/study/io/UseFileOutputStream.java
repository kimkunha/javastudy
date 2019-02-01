package study.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 *	자바 JVM에서 발생한 데이터가 정수, byte[] 인 경우에 File로 저장하는 File로 저장하는 FileOutputStream 사용
 * @author owner
 */
public class UseFileOutputStream {

	private void useFileOutputStream() throws IOException {
		int i=65;
		
//		String[] strArr= {"안녕","안녕"};
		//1. File class 생성
		File file =  new File("c:/dev/temp/Test_java_io.txt");
		//2. FileOutputStream 생성 ->입력된 경로에 파일이 생성된다.
//		FileOutputStream fos=new FileOutputStream(file);
		
		FileOutputStream fos=null;
		
		
		boolean flag=false;
		if(file.exists()) { //파일이 존재하는지? 파일 있음?
			boolean [] temp= {false,true,true};
			int select=JOptionPane.showConfirmDialog(null, "덮어씌움?");
			flag=temp[select];
		}//end if
		
		//2. FileOutputStream 생성 -> 입력된 경로에 파일이 생성된다.
//		FileOutputStream fos =new FileOutputStream(file) 이렇게 하면 입력된 경로에 파일이 생성된다.
//		하지만 파일이 없다면 생성하고, 파일이 있다면 덮어 쓴다.( 아무 메세지도 없이 덮어 씌워 버린다)
		
		if(!flag) { //flag가 true라면 fileoutputstream을 생성한다. 매개변수로 file 파일 생성할곳 경로
			fos=new FileOutputStream(file);
		fos.write(i); //값을 스트림에 기록 (수에 대한 문자가 출력)
			fos.flush();
		
		}//end if
		
		System.out.println("파일 기록 완료!!!!!");
		
		
		
		
	}//usefileoutputstream
	
	
	
	
	
	public static void main(String[] args) {
		try {
			new UseFileOutputStream().useFileOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main

}//class
