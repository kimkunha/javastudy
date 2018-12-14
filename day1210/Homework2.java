package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//1.Window Component 상속
@SuppressWarnings("serial")
public class Homework2 extends Frame {

	public Homework2() {
		super("Homework2");
		
		//West
		Label lblWrite=new Label("글꼴");
		TextField tfWriteText=new TextField(20);
		List write=new List();
		write.add("Dialog");
		write.add("Serif");
		write.add("SansSerif");
		write.add("SansSerif");
		write.add("DialogInput");
		
		//Center
		Label lblWriteStyle=new Label("글꼴스타일");
		TextField tfWriteStyleText=new TextField(20);
		List writeList=new List();
		writeList.add("일반");
		writeList.add("굵게");
		writeList.add("기울임꼴");
		writeList.add("굵게기울임꼴");
		
		//East
		Label lblSize=new Label("크기");
		TextField tfSize=new TextField(20);
		List sizeList =new List();
		int temp =0;
		for(int i=1; i<81; i++) {
			if(i<6) {
				temp =i*2;
				sizeList.add(String.valueOf(temp));				
			}else if(i>10){
				sizeList.add(String.valueOf(i));
				}
			
		}//end for
		
		//North
		Label lblExample=new Label("보기");
		TextField tfCheck=new TextField("AaBbYyZz");
		Button btnCheck=new Button("확인");
		Button btnCancel=new Button("취소");
		
		//2 배치관리자를 설정( 해제 )
		setLayout(null);
		
		//3. 좌표, 크기 설정
		
		//West
		lblWrite.setBounds(50,100,120,20);
		tfWriteText.setBounds(50, 130, 130, 20);
		write.setBounds(50, 155, 130, 80);
		add(lblWrite);
		add(tfWriteText);
		add(write);
		
		
		
		//Center
		lblWriteStyle.setBounds(300,100,120,20);
		tfWriteStyleText.setBounds(300,130,130,20);
		writeList.setBounds(300,155,130,80 );
		add(lblWriteStyle);
		add(tfWriteStyleText);
		add(writeList);
		
		//East
		lblSize.setBounds(550, 100,120,20);
		tfSize.setBounds(550,130,130,20);
		add(lblSize);
		add(tfSize);
		sizeList.setBounds(550,155,130,80);
		add(sizeList);
		
		
		//south
		lblExample.setBounds(300,500,120,20);
		tfCheck.setBounds(300,600,150,20);
		btnCheck.setBounds(300,700,150,20);
		btnCancel.setBounds(470, 700,150,20);
		
		add(lblExample);
		add(btnCheck);
		add(btnCancel);
		add(tfCheck);
		//창크기
		setBounds(200, 100, 800, 800);
		
		//6. 사용자에게 보여주기   (이것을 해야 보여지는 출력이 된다)
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
			});
		
		
		
	}//endHomework2
	
	public static void main(String[] args) {
		new Homework2();
		
		
		
		
	}//main

}//class
