package day1219;

import java.io.File;

import javax.swing.JOptionPane;

/**
 * 	프로그램이 실행되면 
 * 	"디렉토리명 입력 : " 메세지가 출력되고 
 *	사용자가 디렉토리 예)"c:/dev" 를 입력했을 때
 *	디렉토리라면 해당 디렉토리내 파일 정보를
 *	JOptionPane.show.messageDialog에 출력 하는 프로그램 작성
 *
 *	디렉토리가 아니라면 "파일은 취급하지 않습니다." console출력
 *
 *	출력
 *	이름			유형	크기		마지막으로 수정한 날짜
 *	apis			폴더
 *	test.java		파일	164byte	yyyy-MM-dd a hh:mm
 * @author owner
 */
public class Processor {


	public Processor() {
		System.out.println("디렉토리명 입력 : ");
		
		
		
		
		
	}//printFile
	
	
	public static void main(String[] args) {
		new Processor();
	}//main

}//class
