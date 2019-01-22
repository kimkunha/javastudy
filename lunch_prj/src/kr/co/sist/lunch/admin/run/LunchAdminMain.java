package kr.co.sist.lunch.admin.run;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.file.FileServer;
import kr.co.sist.lunch.admin.view.LunchLoginView;

public class LunchAdminMain {

	public static List<String>lunchImageLIst;
	
	public LunchAdminMain() { 
		lunchImageLIst=new ArrayList<String>();
		//������ �����ϴ� �̹����� ū �̹����� �Է�
		
		File file=new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/");
		for(String tempName : file.list()) {
			if(!tempName.startsWith("s_")) {
				lunchImageLIst.add( tempName );
			}//end if
		}//end if
	}//������
	
	public static void main(String[] args) {
		new LunchAdminMain();
		FileServer fs=new FileServer();
		fs.start();
		new LunchLoginView();
	}//main

}//class
