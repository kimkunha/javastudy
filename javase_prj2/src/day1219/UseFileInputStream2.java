package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//18.12.19	-5번 자료-	(FileInputStream)/	8bit+16bit 연결하여 한글로 출력할수 있게 해주는 법.	
/**
 *	HDD에 존재하는 File과 연결하여 그 내용을 읽어들일때 사용하는
 *	FileInputStream
 * @author owner
 */
public class UseFileInputStream2 {
	
	public UseFileInputStream2() throws IOException{
		File file =new File("c:/dev/temp/java_read.txt");
		if(file.exists()) {
			BufferedReader br=null;
			
			try {
//				//스트림을 생성하여 JVM에서 HDD의 파일과 연결
//				FileInputStream fis=new FileInputStream(file);
//				int temp=0;
//				
//					while( (temp=fis.read()) !=-1 ) { //읽어들인 내용이 존재한다면
//						System.out.print( (char)temp );
//					}//end while
//					
//					//스트림사용을 완료 했으면 스트림을 끊어서 메모리 누수를 막는다.
//					fis.close();
			
			////////////12-20-2018 코드 추가///////////////      (계정이력이라고 한다)
				//8bitStream 과 16bitStream 연결 : 한글이 깨지는 문제해결.
				
//				FileInputStream fis=new FileInputStream(file);	//파일과연결하는 Stream
//				InputStreamReader isr=new InputStreamReader(fis);	//8bit와 16bit 연결 해주는 method
//				 br=new BufferedReader(isr);		//속도개선, 줄단위 읽기 (buffer들어간 놈들은 속도개선 해주는 method)
				//위 코드 3줄도 길어 1줄로 간략화 해 보겠다.
				br=new BufferedReader(new InputStreamReader( new FileInputStream(file)));
				
				String temp="";
				while( (temp=br.readLine()) !=null) { // 줄단위(\n전까지)로 읽어서 읽어들인 내용이 있다면  출력해라
					System.out.println( temp );	//출력
				}//end while
//				br.close();	//반드시 연결을 종료해주어야 한다.		
				
				
//			} catch (FileNotFoundException e) {		//throws 로 날려버림
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
			}finally {
				if(br !=null) {
					br.close();
				}
				
//				try {
//					br.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}	//반드시 연결을 종료해주어야 한다.		//1.에러나는 이유 BufferedReader가 지역변수라서 위에 인스턴스변수로 선언한다
																	//또 에러나는 이유 예외처래 해줘야 한다.. 코드가 길어 가독성이 떨어지니 간략화 해준다
			}//end catch											// throws 로 날려버림
			
		}else {
			System.out.println("경로나 파일명을 확인하세요.");
		}//end else
		
		
	}//UseFileInputStream
	public static void main(String[] args) {
		try {
			new UseFileInputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
