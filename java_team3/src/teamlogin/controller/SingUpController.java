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
				JOptionPane.showMessageDialog(suv, "���̵�� �ʼ� �Է��Դϴ�.");
				return;
			} // end if

//		}catch (SQLException se) {
//				if (se.getErrorCode() == 000001) {
//					JOptionPane.showMessageDialog(suv, "���̵�� �ߺ��� �ɼ������ϴ�.");
//					se.printStackTrace();
//			} // end if
		
//		} // end catch

		String pass = new String(suv.getJpfPw1().getPassword());
		String pass2 = new String(suv.getJpfPw2().getPassword());
		if (pass.isEmpty()) {
			JOptionPane.showMessageDialog(suv, "��й�ȣ�� �Է����ּ���");
			return;
		} // end if
		if (!pass.equals(pass2)) {
			JOptionPane.showMessageDialog(suv, "��й�ȣ�� �ٸ��ϴ� Ȯ�����ּ���");
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
//				JOptionPane.showMessageDialog(suv, " 3 ~ 4�ڸ� ������ �����մϴ�.");
//			}
			String tel3 = suv.getJtfTel3().getText().trim();
			tel = tel1.concat("-").concat(tel2).concat("-").concat(tel3);
//			Integer.parseInt(tel);
//		} catch (NumberFormatException nfe) {
//			JOptionPane.showMessageDialog(suv, "�ڵ��� ��ȣ�� ���ڸ� �����մϴ�.");
//			nfe.getStackTrace();
//			return;
//		} // end catch

		String email1 = suv.getJtfEmail1().getText().trim();
		if(email1.isEmpty()) {
			JOptionPane.showMessageDialog(suv, "������ �Է����ּ���");
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
			JOptionPane.showMessageDialog(suv, id + "�� �߰��Ǿ����ϴ�");
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
			JOptionPane.showMessageDialog(suv, "�̹� ������� ���̵� �Դϴ�.");
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
