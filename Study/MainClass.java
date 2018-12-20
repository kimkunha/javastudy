package Study;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainClass {

	public static void main(String[] args) {
		try {
		InputStream is=new FileInputStream("C:\\dev\\workspace\\javase_prj\\src\\Study\\aaa.txt");
		while(true) {
			int i=is.read();
			System.out.println("ตฅภฬลอ : "+i);
			if(i==-1) break; 
		};
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}// main

}// class
