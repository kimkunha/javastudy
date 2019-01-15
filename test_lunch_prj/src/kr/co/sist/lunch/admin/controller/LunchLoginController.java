package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.view.LunchLoginView;

public class LunchLoginController extends WindowAdapter implements ActionListener{

	private LunchLoginView llv;
	
	public LunchLoginController(LunchLoginView llv) {
		this.llv=llv;
		
	}//생성자
	
	@Override
	public void windowClosing(WindowEvent e) {
		llv.dispose();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
		
		
		
	}//actionPerformed

//	public boolean checkIdEmpty() {
//		boolean flag=false;
//		//아이디 검증
//		JTextField jtf=llv.getJtfId();
//		if(jtf.getText().trim().equals("")) {
//			jtf.setText("");
//			jtf.requestFocus();
//		}//end if
		
		
	}//checkIdEmpty
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
