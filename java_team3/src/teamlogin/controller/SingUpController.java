package teamlogin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import teamlogin.dao.LoginDAO;
import teamlogin.view.SingUpView;
import teamlogin.vo.UserInfoVO;

public class SingUpController extends WindowAdapter implements ActionListener {

	private SingUpView suv;
	private LoginDAO l_dao;
	public SingUpController(SingUpView suv) {
		this.suv = suv;
		l_dao.getInstance();
		
	}// SingUpController

	public void addInfo() {
		String id="";
//		try {	
			id = suv.getJtfId().getText().trim();
			if (id.isEmpty()) {
				JOptionPane.showMessageDialog(suv, "아이디는 필수 입력입니다.");
				return;
			} // end if

//		}catch (SQLException se) {
//				if (se.getErrorCode() == 000001) {
//					JOptionPane.showMessageDialog(suv, "아이디는 중복이 될수없습니다.");
//					se.printStackTrace();
//			} // end if
		
//		} // end catch

		String pass = new String(suv.getJpfPw1().getPassword());
		String pass2 = new String(suv.getJpfPw2().getPassword());
		if (pass.isEmpty()) {
			JOptionPane.showMessageDialog(suv, "비밀번호를 입력해주세요");
			return;
		} // end if
		if (!pass.equals(pass2)) {
			JOptionPane.showMessageDialog(suv, "비밀번호가 다릅니다 확인해주세요");
			return;
		} // end if
		String tel = "";
		
//		try {
			String tel1 = suv.getJtfTel1().getText().trim();
//			int tel1 = Integer.parseInt(suv.getJtfTel1().getText().trim());
//			int tel2 = Integer.parseInt(suv.getJtfTel2().getText().trim());
//			int tel3 = Integer.parseInt(suv.getJtfTel3().getText().trim());
//			tel=tel1+""+tel2+""+tel3;
			String tel2 = suv.getJtfTel2().getText().trim();
//			if(tel2.length()>3 && tel2.length()<4) {
//				JOptionPane.showMessageDialog(suv, " 3 ~ 4자리 까지만 가능합니다.");
//			}
			String tel3 = suv.getJtfTel3().getText().trim();
			tel = tel1.concat("-").concat(tel2).concat("-").concat(tel3);
//			Integer.parseInt(tel);
//		} catch (NumberFormatException nfe) {
//			JOptionPane.showMessageDialog(suv, "핸드폰 번호는 숫자만 가능합니다.");
//			nfe.getStackTrace();
//			return;
//		} // end catch

		String email1 = suv.getJtfEmail1().getText().trim();
		if(email1.isEmpty()) {
			JOptionPane.showMessageDialog(suv, "메일을 입력해주세요");
			return;
		}//end if

//			String name= suv.getJcbEmail().getSelectedItem().toString();
//			JTextField jtfEmail2=suv.getJtfEmail2();
//			jtfEmail2.setText(name);
//			JTextField jtfEmail=suv.getJtfEmail2();
//		int cnt=suv.getJcbEmail().getSelectedIndex();
//		suv.getJtfEmail2().setText

		String email2 = suv.getJtfEmail2().getText().trim();
		String email = email1.concat("@").concat(email2);
//		String [] info= {id,pass,tel,email};
		UserInfoVO uivo = new UserInfoVO(id, pass, tel, email);
		try {
			l_dao.getInstance().insertInfo(uivo);
			JOptionPane.showMessageDialog(suv, id + "가 추가되었습니다");
			suv.getJtfId().setText("");
			suv.getJpfPw1().setText("");
			suv.getJpfPw2().setText("");
			suv.getJtfEmail1().setText("");
			suv.getJtfEmail2().setText("");
			suv.getJtfTel1().setText("");
			suv.getJtfTel2().setText("");
			suv.getJtfTel3().setText("");
			
		} catch (SQLException se) {
			if(se.getErrorCode()==1) {
			JOptionPane.showMessageDialog(suv, "이미 사용중인 아이디 입니다.");
				se.printStackTrace();
			}//end if
		}	//end catch

	}// UserInfoVO

	public void selectAllInfo() {
//		List<String>list=l_dao.getInstance().selectAllUser();
		
		
		
	}//end selectAllInfo
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		suv.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == suv.getJbSinnUp()) {
			addInfo();

		} // end if

		if(ae.getSource() == suv.getJcbEmail()) {
		int email1=	suv.getJcbEmail().getSelectedIndex();
	
		if(email1 == 0) {
			suv.getJtfEmail2().setText("daum.net");
		}//end if
		
		if(email1 == 1) {
			suv.getJtfEmail2().setText("google.com");
		}//end if
		
		if(email1 == 2) {
			suv.getJtfEmail2().setText("naver.com");
		}//end if
		
		
		
		}//end if
		
		
	}// actionPerformed




}// class
