package day0111;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
//�̷��� �Ϸ������� �迭�� ����ϴ°��� �˰ԵǾ� �ٲٰ� ��
public class TestJbutton extends JFrame {

	private JButton name1, name2, name3, name4, name5, name6, name7, name8, name9, name10;
	
	public TestJbutton() {
		name1= new JButton("������");
		name2= new JButton("�ڿ���");
		name3= new JButton("������");
		name4= new JButton("����ö");
		name5= new JButton("������");
		name6= new JButton("������");
		name7= new JButton("������");
		name8= new JButton("������");
		name9= new JButton("�����");
		name10= new JButton("������");
		
		setLayout(new GridLayout(5, 2));
		setVisible(true);
		
		
		
	}//������
	
	public static void main(String[] args) {

	}//main

}//class
