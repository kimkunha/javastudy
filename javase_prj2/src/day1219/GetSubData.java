package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		checkDirectory();
	} // GetSubData
	
	public void checkDirectory() throws IOException {
		System.out.print("디렉터리명 입력 : ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String dirName = br.readLine();
		
		File fileName = new File(dirName);
		
		if (fileName.isDirectory()) {
			getFileData(fileName);
		} else {
			System.err.println("파일은 취급하지 않습니다.");
		} // end else
		
		br.close();
	} // checkDirectory
	
	public void getFileData(File file) {
		JTextArea jta = new JTextArea(10, 70);
		jta.setEditable(false);
		jta.append("이름\t\t유형\t\t크기\t\t마지막으로 수정한 날짜\n");
		
		SimpleDateFormat sdf =
				new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		Date d=null;
		
		// 해당 디렉터리의 하위 디렉터리, 파일의 정보를 받아오면 된다.
		// 이걸 수행하는 method는? listFiles()
		File[] fileArr = file.listFiles();
		
		for (File f : fileArr) {
			d = new Date(f.lastModified());
			
			jta.append(f.getName() + 
					"\t\t" + (f.isFile()? "파일" : "폴더") + 
					"\t\t" + f.length() + 
					"byte\t\t" + sdf.format(d) + "\n");
		} // end for
		
		JScrollPane jsp = new JScrollPane(jta);
		
		JOptionPane.showMessageDialog(null, jsp);
	} // getFileData
	
	public static void main(String[] args) throws IOException {
		new GetSubData();
		
	} // main

} // class
