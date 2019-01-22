package teamlogin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import teamlogin.dao.LoginDAO;
import teamlogin.view.LoginView;
import teamlogin.view.SingUpView;
import teamlogin.view.UserView;
import teamlogin.vo.LoginVO;

public class LoginController extends WindowAdapter implements ActionListener {

	private LoginView lv;
	
	
	public LoginController( LoginView lv)  {
		this.lv=lv;
		
	}//생성자
	
	private boolean idCheckEmpty(){
		boolean flag=false;
		String jtfid=lv.getJtfId().getText().trim();
		
		if(jtfid.isEmpty()) {
			lv.getJtfId().setText("");
			lv.getJtfId().requestFocus();
			flag=true;
		}//end if
		
		return flag;
	}//idCheckEmpty
	
	private boolean passCheckEmpty() {
		boolean flag=false;
		
		String jpfPass=new String(lv.getJpfPw().getPassword());
		if(jpfPass.trim().isEmpty()) {
//			JOptionPane.showMessageDialog(lv, "아이디, 비밀번호를 입력해주세요.");
			lv.getJpfPw().setText("");
			lv.requestFocus();
			flag=true;
		}//end if
		return flag;
		
	}//passCheckEmpty
	
	private String login(LoginVO lvo) {
		String adminEmail="";
		LoginDAO l_dao=LoginDAO.getInstance();
		
		try {
			adminEmail=l_dao.login(lvo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lv, "DB에서 문제발생!");
			e.printStackTrace();
		}
		
		return adminEmail;
	}//login
		
		
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		lv.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == lv.getJbLogin()) {
			
			if( idCheckEmpty())   {
				JOptionPane.showMessageDialog(lv, "아이디를 입력해주세요.");
				return;
			}else if(passCheckEmpty()){
				JOptionPane.showMessageDialog(lv, "비밀번호를 입력해주세요.");
				return;
			}//end else if
			
			if( !idCheckEmpty() && !passCheckEmpty()) {
				String id =lv.getJtfId().getText().trim();
				String pass=new String(lv.getJpfPw().getPassword());
				
				LoginVO lvo=new LoginVO(id, pass);
				String adminEmail=login(lvo);
				
				if(adminEmail.equals("")) {
					JOptionPane.showMessageDialog(lv, "아이디 또는 비밀번호가 틀렸습니다.");
					lv.getJtfId().setText("");
					lv.getJpfPw().setText("");
					lv.getJtfId().requestFocus();
				}else {
					new UserView();
					
				}//end else
			}//end if
			
			
		}//end if
		
		
		if(ae.getSource() == lv.getJbsingUp()) {
			new SingUpView(lv);
		}//end if
		
	}//actionPerformed

	
}//class
