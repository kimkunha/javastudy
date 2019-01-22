package kr.co.sist.lunch.user.controller;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.OrderAddVO;

public class LunchOrderDetailController extends WindowAdapter implements ActionListener {

	private LunchOrderDetailView lodv;
	private String lunchCode;
	
	public LunchOrderDetailController(LunchOrderDetailView lodv, String lunchCode) {
		this.lodv = lodv;
		this.lunchCode=lunchCode;
	}// 생성자

	private void lunchOrder() {
		JTextField jtfOrderName = lodv.getJtfOrderName();
		String name = jtfOrderName.getText().trim();
		
		if (name.equals("")) {
			showMessageDialog(lodv, "주문자명은 필수 입력");
			jtfOrderName.setText("");
			jtfOrderName.requestFocus();
			return;
		} // end if

		JTextField jtfTel = lodv.getJtfPhone();
		String tel = jtfTel.getText().trim();

		if (tel.equals("")) {
			showMessageDialog(lodv, "전화번호는 필수 입력입니다.");
			jtfTel.setText("");
			jtfTel.requestFocus();
			return;
		} // end if

		// 전화번호는 3-4이하 4이하 총 13자이하
		String[] arrTel = tel.split("-");
		try {
			if (arrTel.length == 3) {// 제대로된 형식 전화번호
				if (arrTel[0].length() != 3 || !(arrTel[1].length() > 2 && arrTel[1].length() < 5)
						|| arrTel[2].length() != 4) {
					showMessageDialog(lodv, "전화번호의 자릿수가 잘못되었습니다");
					return;
				} // end if
				for (int i = 0; i < arrTel.length; i++) {
					Integer.parseInt(arrTel[i]); // 숫자로만 되어 있는지
				} // end for

				//// 주문수행/////
				printOrder();
			} else {
				showMessageDialog(lodv, "전화번호의 형식이 올바르지 않습니다.");
			} // end if
		} catch (NumberFormatException nfe) {
			showMessageDialog(lodv, "전화번호에 문자열이 들어있습니다.");
			return;
		}//end catch

		
		
//		//전화번호는 앞자리 3 ~ 4자리 - 4자이하 총 13자   ?
//		if(tel.length() != 13) {
//			showMessageDialog(lodv, "번호를 다시 입력해주세요.");
//			jtfTel.setText("");
//			jtfTel.requestFocus();
//			return;
//		}
//		//010-2968-6118
//		if(Integer.parseInt( jtfTel.getText().trim().substring(0, tel.indexOf("-")))<4 ) {
//			showMessageDialog(lodv, "앞자리는 3~ 4자리 까지 입니다.");
//			jtfTel.setText("");
//			jtfTel.requestFocus();
//			return;
//		}//endif
//		
//		if(Integer.parseInt(jtfTel.getText().trim().substring(tel.lastIndexOf("-"))) == 4 ){
//			showMessageDialog(lodv, "뒷자리는 4자리입니다.");
//			jtfTel.setText("");
//			jtfTel.requestFocus();
//			return;
//		}
//		printOrder();
		
		
	}// lunchOrder

	/**
	 * 	주문사항을 보여주고 주문을 할 것인지 처리
	 */
	private void printOrder() {
		
		JTextArea jtaReceipt=new JTextArea(26,22);
		jtaReceipt.setEditable(false);
		JScrollPane jspReceipt=new JScrollPane(jtaReceipt);
		
		StringBuilder data=new StringBuilder();
		try {
			data.append("------------------------------------------------------------\n")
				.append("\t재찬 도시락\n")
				.append("\t현금(소득공제)\n")
				.append("소래포구점(본점)\n")
				.append("대표 : 이재찬 201-11-1121\n")
				.append("--------------------------------------------------------------\n")
				.append("도시락 명 : ").append(lodv.getJtfLunchName().getText()).append("(")
				.append(lunchCode).append(")").append("\n")
				.append("--------------------------------------------------------------\n")
				.append("수량 : ").append( lodv.getJbQuan().getSelectedItem()).append("개\n")
				.append("--------------------------------------------------------------\n")
				.append("결재금액 : ").append( lodv.getJtfTotalPrice().getText()).append("원\n")
				.append("--------------------------------------------------------------\n")
				.append("주문자 명 : ").append(lodv.getJtfOrderName().getText()).append("\n")
				.append("--------------------------------------------------------------\n")
				.append("전화번호 : ").append( lodv.getJtfPhone().getText()).append("\n")
				.append("--------------------------------------------------------------\n")
				.append("ip address : ")
				.append(InetAddress.getLocalHost().getHostAddress()).append("\n")
				.append("--------------------------------------------------------------\n")
				.append("요청사항 : ").append("\n")
				.append(lodv.getJtaLunchReq().getText())
				.append("\n")
				.append("--------------------------------------------------------------\n")
				.append("위의 정보로 도시락을 주문하시겠습니까?\n")
				.append("\n")
				.append("\n")
				.append("\n")
				.append("\n")
				.append("--------------------------------------------------------------\n");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
			jtaReceipt.setText(data.toString());
			
		switch(JOptionPane.showConfirmDialog(lodv, jspReceipt)) {
		case JOptionPane.OK_OPTION :
			try {
				OrderAddVO oavo=new OrderAddVO(
						lodv.getJtfOrderName().getText(),
						lodv.getJtfPhone().getText(),
						InetAddress.getLocalHost().getHostAddress(), lunchCode,
						lodv.getJbQuan().getSelectedIndex()+1);
				
					LunchClientDAO.getInstance().insertOrder(oavo);
					showMessageDialog(lodv, "도시락 주문이 완료 되었습니다. \n 항상최선을 다하는 재찬 도시락이 되겠습니다.\n감사합니다.");
					//주문이 완료되었으므로 주문창을 닫는다.
					lodv.dispose();
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			
			}//end catch
			
		}//end switch
		
	}//printOrder
	

	
	@Override
	public void windowClosing(WindowEvent we) {
		lodv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lodv.getJbQuan()) { // 수량 선택시 전체 가격 보여준다.
			try {
				int price = Integer.parseInt(lodv.getJtfLunchPrice().getText());
				int quan = ((Integer) lodv.getJbQuan().getSelectedItem()).intValue();
				lodv.getJtfTotalPrice().setText(String.valueOf(price * quan));
				
			} catch (NumberFormatException nfe) {
				showMessageDialog(lodv, "가격은 정수 이어야 합니다.");
			} // end catch
		} // end if

		if (ae.getSource() == lodv.getJbEnd()) {
			lodv.dispose();
		} // end if

		if (ae.getSource() == lodv.getJbOrder()) { // 주문
			lunchOrder();
		} // end if

	}// actionPerformed

}// class
