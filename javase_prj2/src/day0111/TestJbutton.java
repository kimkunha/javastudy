package day0111;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
//이렇게 하려했으나 배열을 사용하는것을 알게되어 바꾸게 됨
public class TestJbutton extends JFrame {

	private JButton name1, name2, name3, name4, name5, name6, name7, name8, name9, name10;
	
	public TestJbutton() {
		name1= new JButton("김정윤");
		name2= new JButton("박영민");
		name3= new JButton("노진경");
		name4= new JButton("김희철");
		name5= new JButton("김정운");
		name6= new JButton("이재찬");
		name7= new JButton("이재현");
		name8= new JButton("공선의");
		name9= new JButton("김건하");
		name10= new JButton("오영근");
		
		setLayout(new GridLayout(5, 2));
		setVisible(true);
		
		
		
	}//생성자
	
	public static void main(String[] args) {

	}//main

}//class
