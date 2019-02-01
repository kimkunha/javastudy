package study.filecopy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 *	파일 복사해보기.
 * @author owner
 */
public class TestCopy {
	
	public TestCopy() throws IOException {
		//파일을 복사하는거니 파일스트림을 사용해야 된다.
		//인풋 스트림으로 복사할 파일을 읽자
		BufferedReader br=null;
		//아웃풋 스트림으로 복사한것을 출력 
		BufferedWriter bw=null;
		try {
//		File file=new File("c:/dev/temp/kim/kim.txt");
			
//			File file =new File("c:/dev/temp/kim/kim.txt");
			
//		br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		br=new BufferedReader(new InputStreamReader(new FileInputStream( new File("c:/dev/temp/kim/kim.txt"))));
		bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("c:/dev/temp/kim/kims.txt"))));	
			
			int temp=0;
					
			while( (temp=br.read()) != -1) {
				bw.write(temp);
				bw.flush();
			}
			
			JOptionPane.showMessageDialog(null, "복사성공요!");
		
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if( br!=null) { br.close();}
			if( bw!=null) { bw.close();}
		}
		
		
	}//생성자
	
	public static void main(String[] args) {
		try {
			new TestCopy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main
	
}//class
