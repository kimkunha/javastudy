package study;

import java.math.MathContext;
import java.util.Random;

public class UseMath {

	public UseMath() {
		
		
		
	}//생성자
		public void mathRandom() {
			Random rd=new Random();
			char[] math=new char[12];
			String random="123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			for(int i=0; i<math.length; i++) {
				math[i]=random.charAt(rd.nextInt(random.length()));
				System.out.print(math[i]);
			}//end for
			System.out.println();
		}//비밀번호 만들기
		
		public void createId() {
			Random rd=new Random();
			
			String[] name={"kim","gong","oh","choi","park","lee","jh","yk","kh","hw","jm","sw"};
			String[] pass= {"1","2","3","4","5","6","7","8","9","0"};
	
			String temp2="";
			for(int j=0; j<name.length; j++) {
				temp2=name[rd.nextInt(name.length)]+pass[rd.nextInt(pass.length)];
			}//end for
			System.out.println(temp2);
		}
		
	
	public static void main(String[] args) {
		new UseMath().mathRandom();
		new UseMath().createId();
		
		
	}//main

}//class
