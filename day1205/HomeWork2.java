package day1205;

import java.util.StringTokenizer;

/*
 * "
 * ��Ʈ�� �迭�� ���� ��ȯ �޼ҵ�
 * 
 * 
 * */
public class HomeWork2 {
	public HomeWork2() {
		String names="������,������.������,���ü�~������!,������.����ö,������,������,���ü�.������";
		StringTokenizer stk = new StringTokenizer(names, ",.~!");
		while(stk.hasMoreTokens()) {
			stk.nextToken();
		}//end while
	
	}//HomeWork2
	
	
	public String [] names() {
		String [] name = new String[11];
		String names="������,������.������,���ü�~������!,������.����ö,������,������,���ü�.������";
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
