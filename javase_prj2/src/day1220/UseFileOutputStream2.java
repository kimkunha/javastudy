package day1220;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

//18.12.20	-3번 자료-	()
/**
 *	8bit Stream과 16bit Stream을 사용하여 문자열 데이터를 File에 기록
 * 
 * @author owner
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		String data="오늘은 목요일 입니다 내일음 금요일. 모래는 토요일입니다hi,hello.123124123努力しなきゃ";
		//1. File객체 생성 : 파일이 존재한다면 덮어 쓸것인지를 판단하기 위해서 만든다.
		File file =new File("c:/dev/temp/java_write2.txt");
		
		boolean flag=false;	//파일이 없을때 														//불린형 쓰는거 연습해보기
		if(file.exists()) { //파일이 존재할때
			boolean[] temp= {false,true,true};	//예, 아니오, 취소
			flag=temp[JOptionPane.showConfirmDialog(null, "덮어쓰는 부분? 린졍?")];
		}//end if
		
		//2. stream 생성
		if( !flag ) {
			BufferedWriter bw=null;
			try {
				
				//8bit Stream과 16bit Stream 연결사용
//				//2-1. 파일을 생성하는 스트림 : FileNoutFoundException 발생 -> 폴더가 없을때
//				FileOutputStream fos=new FileOutputStream( file );
//				//2-3. 문자열을 쓰기위한 스트림을 연결 / 문제점 : 속도가 느리다
//				OutputStreamWriter osw=new OutputStreamWriter( fos );
//				//2-4. 느린속도를 개선하기 위한 스트림을 연결
//				BufferedWriter bw=new BufferedWriter( osw );
				
				//길어진 코드를 간소화 시킴
//				bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream( file )));
				
				///////////////////////////16bit만 사용//////////////////////////////////////
				//단순하게 문자열만 사용할때는 16bit가 쉽다.
				bw=new BufferedWriter(new FileWriter( file ));
				
				
				bw.write( data );// 스트림에 데이터를 기록
				bw.flush();//목적지 파일로 분출			//출력Stream의 flush는 기본동작
				System.out.println("파일에기록 완료!!");
			
				
			}finally {
				//스트림 객체가 생서되어 있다면 연결 끊기
//				if( bw!=null) {bw.close(); }//end if
			}//end finally
			
		}//end if
		
		
		
	}// UseFileOutputStream2

	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}// main

}// class
