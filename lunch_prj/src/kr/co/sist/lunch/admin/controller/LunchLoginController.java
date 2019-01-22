package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchLoginView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.AdminLoginVO;

public class LunchLoginController extends WindowAdapter implements ActionListener{

	private LunchLoginView llv;
	
	public LunchLoginController( LunchLoginView llv ) {
		this.llv=llv;
		
		
	}//생성자
	
	
	
	
	@Override
	public void windowClosing(WindowEvent we) {
		llv.dispose();
	}//windowCiosing
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(!checkIdEmpty() && !checkPassEmpty()) { //아이디와 비밀번호가 empty가 아니면
			JTextField jtf=llv.getJtfId();
			JPasswordField jpf=llv.getJpfPass();
			
			String id=jtf.getText().trim();
			String pass=new String(jpf.getPassword());
			
			//입력한 아이디와 비밀번호를 가지고
			AdminLoginVO alvo=new AdminLoginVO(id, pass);
			String adminName=login(alvo);		//DB로그인 인증을 수행한 결과를 받았음
			
			if( adminName.equals("")) { //수행한 결과가 empty라면
				JOptionPane.showMessageDialog(llv, "아이디나 비밀번호를 확인하세요.");
				jtf.setText("");
				jpf.setText("");
				jtf.requestFocus();
			}else {
				new LunchMainView(adminName);
				LunchMainView.adminId=id; // 로그인이 성공했다면 모든 ida를 모든 객체에서 사용할 수 있또록 static변수에 설정한다.
				llv.dispose();
		}//end if
		}//end if
		
	}//actionPerformed

	/**
	 * 	입력 id값이 ""인지 체크하는 method
	 * @return
	 */
	private boolean checkIdEmpty() {
		boolean flag=false;
		JTextField jtfId=llv.getJtfId();
		if(jtfId.getText().trim().equals("")) { //JTextFiled에 값이 없다면 커서를 이동
			jtfId.setText("");//공백을 입력한 후 enter 쳤을때 처리
			jtfId.requestFocus();
			flag=true;
		}//end if
		
		
		
		return flag;
		
	}//checkId
	
	/**
	 * 	입력비밀번호가 ""인지 
	 * @return
	 */
	private boolean checkPassEmpty() {
		boolean flag=false;
		JPasswordField jpfPass=llv.getJpfPass();
		String pass=new String(jpfPass.getPassword());
		
		if(pass.trim().equals("")) {
			jpfPass.setText("");// 공백을 입력하고 엔터친 경우 JPasswordField의 값을 초기화
			jpfPass.requestFocus();
			flag=true;
		}//end if
		
		
		
		
		return flag;
		
	}//checkPass
	
	private String login( AdminLoginVO alvo) {   //vo를 받아준다 vo안에 (String id, pass받는다) 
		String adminName="";
		
		LunchAdminDAO la_dao=LunchAdminDAO.getInstance();
		try {
			adminName=la_dao.login(alvo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(llv, "DB쪽에 문제가 발생하였습니다.");
			e.printStackTrace();
		}//end catch
		

		return adminName;
	}
	
	
}//class
