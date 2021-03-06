package study;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import oracle.net.ns.MarkerPacket;

public class Test_readFile extends JFrame{

	Map<String, Integer>mapKey;
	File file;
	
	
	public Test_readFile() {
		initInstance();
		fdOpen();
		try {
			readLog();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//test_log
	
	public void initInstance() {
		mapKey=new HashMap<String, Integer>();
		
	}
	
	
	public void fdOpen() {
		FileDialog fd=new FileDialog(this,"파일열기" , FileDialog.LOAD);
		fd.setVisible(true);
		
		String path=fd.getDirectory();
		String name=fd.getFile();
		
		file=new File(path+name);
		
	}//fdOpen
	
	public void readLog() throws IOException {
		BufferedReader br=null;
		String temp="";
		if( file.exists()) {
			br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while( (temp=br.readLine()) !=null){
					System.out.println(temp);
			}//end if
			
		}else {
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다");
		}
		
		
	}//readLog
	
	
	
	
	
	public static void main(String[] args) {
		new Test_readFile();
	}//main

}//class
