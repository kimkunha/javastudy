package study.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;

/**
 *	8bit와 16bit stream을 사용하여 문자열 데이터를 file에 기록해보자.
 * @author owner
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		//파일을 생성하고 그 안에 문자열을 입력하는 Stream 공부. 그리고 덮어쓸건지 안내창 출력
		
		//텍스트 넣을 문자열 작성
		String inputData="안녕하세요. 오늘은 금요일에요 모두 수고하세요";
		//파일을 저장할 위치 경로 지정 String으로 설정해 파일을 생성
		String path="c:/dev/temp/kim/test_kim1.txt";
		//파일에 매개변수로 받는다.
		File file=new File(path);

		//지정한 경로에 파일이 생성되었다.
//		FileOutputStream fos=new FileOutputStream(file);
		//위 같이 하면 아무 파일이 존재하여도 경고 없이 자동으로 덮어 씌워진다. 이를 방지하기 위해 boolean으로 
		//조건을 걸어서 수행하는 코딩 작성
		
		//문자열을 받기위한 16bit와 속도 개선을 위해8bit를 연결한다.
		BufferedWriter bw=null;
		
		boolean flag=false;
		if(file.exists()) {// 파일이 존재하니???
			boolean[] temp= {false, true, true};
			flag=temp[JOptionPane.showConfirmDialog(null, "파일이 존재합니다. 덮어씌우실 건가요?")];
			
			bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			//bufferedwriter 속도향상 시키는 outputstream 8bit fileoutputstream 16bit
			bw.write(inputData);
			bw.flush();
			if( bw !=null ) {
				bw.close();
			}
		}//end if
		
	}//생성자
	
	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
