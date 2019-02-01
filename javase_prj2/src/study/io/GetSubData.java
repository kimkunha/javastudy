package study.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 프로그램이 실행되면 "디렉터리명 입력 : " 메시지가 출력되고, 
 * 사용자가 디렉터리 "예) c:/dev"를 입력했을 때, 
 * 디렉터리라면 해당 디렉터리 내 파일 정보를 JOptionPane.showMessageDialog에 출력하는 프로그램<br>
 * 디렉터리가 아니라면 "파일은 취급하지 않습니다." console에 출력<br>
 * 
 * 출력)
 * 이름			유형		크기		마지막으로 수정한 날짜<br>
 * apis			폴더<br>
 * test.java	파일		17byte	yyyy-MM-dd hh:mm<br>
 * 
 * - 폴더인 경우 크기를 출력하지 않는다.<br>
 * @author owner
 */
@SuppressWarnings("serial")
public class GetSubData extends JFrame {
	
	public GetSubData() throws IOException {
		CheckDirectory();
		
		
	}//생성자

	private void CheckDirectory() throws IOException {
		System.out.println("입력해주세요.");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String fileDir=br.readLine();
			File file=new File(fileDir);
			if(file.isDirectory()) {//폴더가 존재하니?
				selectFile(file);
			}else {
				System.out.println("파일은 취급하지 않습니다.");
			}//end else
			
		}finally {
			if(br !=null ) { br.close(); }
		}//end chatch
		
		
	}//checkDirectory
	
	private void selectFile(File file) {
		JTextArea jta=new JTextArea(10,80);
		jta.setEditable(false);
		jta.append("이름\t\t유형\t\t크기\t\t마지막으로 수정한 날짜\n");
//		* test.java	파일		17byte	yyyy-MM-dd hh:mm<br>
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		Date d=null;
		File[] fileArr=file.listFiles();
		for( File f : fileArr) {
			d=new Date(f.lastModified());
			jta.append(f.getName()+"\t\t"+(f.isFile()?"파일":"폴더")+"\t\t"+f.length()+"byte\t\t"+sdf.format(d)+"\n");
			
		}//end for
		JScrollPane jsp=new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
		
		
		
	}//selectFile
	
	public static void main(String[] args) {
		try {
			new GetSubData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
