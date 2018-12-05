package day1205;

import java.util.StringTokenizer;

/*
 * "
 * 스트링 배열로 저장 반환 메소드
 * 
 * 
 * */
public class HomeWork2 {
	public HomeWork2() {
		String names="이재찬,이재현.공선의,정택성~이재현!,최지우.김희철,이재찬,이재찬,정택성.공선의";
		StringTokenizer stk = new StringTokenizer(names, ",.~!");
		while(stk.hasMoreTokens()) {
			stk.nextToken();
		}//end while
	
	}//HomeWork2
	
	
	public String [] names() {
		String [] name = new String[11];
		String names="이재찬,이재현.공선의,정택성~이재현!,최지우.김희철,이재찬,이재찬,정택성.공선의";
		StringTokenizer stk = new StringTokenizer(names, ",.~!");
		while(stk.hasMoreTokens()) {
			System.out.println(stk.nextToken()+" ");
		}//end while
		return name;
	}//method
	
	
	
	
	
	
	public static void main(String[] args) {
		HomeWork2 hk2=new HomeWork2();
		hk2.names();
		
		
		
		
		
		
	}//main

}//class
