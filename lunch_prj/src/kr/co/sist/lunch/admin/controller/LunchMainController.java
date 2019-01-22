package kr.co.sist.lunch.admin.controller;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;

public class LunchMainController extends WindowAdapter implements ActionListener, MouseListener, Runnable {

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;

	public static final int DBL_CLICK = 2;

	private String orderNum;
	private String lunchName;
	private int selectedRow;

	private Thread threadOrdering;

	public LunchMainController(LunchMainView lmv) {
		this.lmv = lmv;
		la_dao = LunchAdminDAO.getInstance();
		// 도시락 목록을 설정한다.
		setLunch();
		orderNum = "";
	}// LunchMainController

	/**
	 * JTable에 DB에서 조회한 도시락정보를 보여준다.
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch = lmv.getDtmLunch();
		dtmLunch.setRowCount(0);

		try {
			// DB에서 도시락 정보를 조회
			List<LunchVO> listLunch = la_dao.selectLunch();
			// JTable 에 조회한 정보를 출력.
			LunchVO lv = null;
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";

			Object[] rowData = null;
			for (int i = 0; i < listLunch.size(); i++) {
				lv = listLunch.get(i);
				// DTM 에 데이터를 추가하기 위한 일차원배열(Vector)을 생성하고 데이터를 추가
				rowData = new Object[5];
				rowData[0] = new Integer(i + 1);
				rowData[1] = lv.getLunchCode();
				rowData[2] = new ImageIcon(imgPath + lv.getImg());
				rowData[3] = lv.getLunchName();
				rowData[4] = new Integer(lv.getPrice());

				// DTM에 추가
				dtmLunch.addRow(rowData);

			} // end for
			if (listLunch.isEmpty()) { // 입력된 도시락이 없을 때
				JOptionPane.showMessageDialog(lmv, "입력된 제품이 없습니다.");
			} // end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB에서 데이터를 받아오는 중 문제 발생...");
			e.printStackTrace();
		} // catch

	}// setLunch

	@Override
	public void windowClosing(WindowEvent we) {
		lmv.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0); // JVM의 모든 인스턴스 종료.
	}

	/**
	 * 년,월, 일 정보를 가져와서 정산
	 */
	private void searchCalc() {
		int selYear = ((Integer) lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth = ((Integer) lmv.getJcbMonth().getSelectedItem()).intValue();
		int selDay = ((Integer) lmv.getJcbDay().getSelectedItem()).intValue();

		StringBuilder searchDate = new StringBuilder();
		searchDate.append(selYear).append("-").append(selMonth).append("-").append(selDay);

		DefaultTableModel dtmCalc = lmv.getDtmCalc();
		dtmCalc.setRowCount(0);

		try {
			// 선택한 일자의 조회결과를 받아서 JTable 출력
			List<CalcVO> list = la_dao.selectCalc(searchDate.toString());
			CalcVO cv = null;
			// JTable에 데이터를 추가하는 코드 작성해보세요.
			// 데이터가 없는 날에는 "판매된 도시락이 없습니다" 출력

			Object[] rowData = null;
			for (int i = 0; i < list.size(); i++) {
				cv = list.get(i);
				// DTM 에 데이터를 추가하기 위한 일차원배열(Vector)을 생성하고 데이터를 추가
				rowData = new Object[5];
				rowData[0] = new Integer(i + 1);
				rowData[1] = cv.getLunchName() + "(" + cv.getLunchCode() + ")"; // 도시락명(도시락코드)
				rowData[2] = cv.getTotal();
				rowData[3] = cv.getPrice();
				// DTM에 추가
				dtmCalc.addRow(rowData);
			} // end for
//			if(list.size()==0) {
//				JOptionPane.showMessageDialog(lmv, "판매된 도시락이 없습니다.");
//			}
			if (list.isEmpty()) { // 입력된 도시락이 없을 때
				JOptionPane.showMessageDialog(lmv, searchDate + "일에는 판매된 도시락이 없습니다.");
			} // end if

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
		System.out.println(searchDate);
	}// searchCalc

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == lmv.getJbtAddLunch()) { // 도시락 추가버튼
			new LunchAddView(lmv, this);
		}
		if (ae.getSource() == lmv.getJcbMonth()) { // 월별 마지막 일자 변경
			setDay();
		} // end if
		if (ae.getSource() == lmv.getJbtCalcOrder()) { // 정산버튼 클릭
			searchCalc();
		} // end if

		if (ae.getSource() == lmv.getJmOrderRemove()) {
			// 제작상태가 'N'인 상태에서만 동작
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {
				switch (JOptionPane.showConfirmDialog(lmv, orderNum + " " + lunchName + "]주문정보를 삭제하시겠습니까?")) {
				case JOptionPane.OK_OPTION:
					try {
						if (la_dao.deleteOrder(orderNum)) {// DBTable에서 해당 레코드 삭제
							msgCenter(lmv, orderNum + "주문이 삭제 되었습니다.");
							// 주문 테이블 갱신
							searchOrder();
							jt.remove(selectedRow); // 테이블에서만 삭제
						} else {
							msgCenter(lmv, orderNum + "주문이 삭제 되지 않았습니다.");

						} // end else
					} catch (SQLException e) {
						msgCenter(lmv, orderNum + "DB에서 문제발생.....");
						e.printStackTrace();
					} // end catch
				}
			} else {
				msgCenter(lmv, "제작된 도시락은 삭제할 수 없습니다.");
			}
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);// popup 메뉴 숨김
		} // end if
		if (ae.getSource() == lmv.getJmOrderStatus()) {
			// 제작상태가 'N'인 상태에서만 동작
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {

				switch (JOptionPane.showConfirmDialog(lmv, "[" + orderNum + lunchName + " ] 주문이 완료되었습니까?")) {
				case JOptionPane.OK_OPTION:
					// DB Table의 해당 레코드 변경
					try {
						if (la_dao.updateStatus(orderNum)) { // 상태변환 성공
							jt.setValueAt("Y", selectedRow, 10); // J테이블의 값만 변경

							JOptionPane.showMessageDialog(lmv, "도시락 제작이 완료되었습니다");

						} else { // 상태변환 실패
							JOptionPane.showMessageDialog(lmv, "도시락 제작상태 변환이 실패!!");
						} // end else
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(lmv, "DB에서 문제 발생.......");
						e.printStackTrace();
					} // end catch
				}// end switch
			} else {
				JOptionPane.showMessageDialog(lmv, "이미 제작이 완료된 도시락입니다.");
			} // end else

			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);// popup 메뉴 숨김
		} // end if
	}// actionPerformed

	/**
	 * 월이 선택되면 해당년의 해당월의 마지막날을 설정
	 */
	private void setDay() {
		int selYear = ((Integer) lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth = ((Integer) lmv.getJcbMonth().getSelectedItem()).intValue();

		// 마지막날 얻기
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, selYear);
		cal.set(Calendar.MONTH, selMonth - 1);

		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int nowDay = cal.get(Calendar.DAY_OF_MONTH);

		lmv.getCbmDay().removeAllElements(); // 모델을 초기화하고
		for (int day = 1; day < lastDay + 1; day++) {
			lmv.getCbmDay().addElement(day); // 마지막 날을 설정한다.
		} // end for

//		lmv.getCbmDay().setSelectedItem(new Integer(nowDay)); //오늘을 선택한다.
	}

	public void searchOrder() {
		try {
			List<OrderVO> list = la_dao.selectOrderList();
			DefaultTableModel dtm = lmv.getDtmOrder();
			dtm.setRowCount(0); // 초기화

			// 테이블에 값넣기 벡터로 생성하는 법.
			Vector<Object> vec = null;
			OrderVO ovo = null;
			for (int i = 0; i < list.size(); i++) {
				ovo = list.get(i);
				vec = new Vector<Object>();

				vec.add(new Integer(i + 1));
				vec.add(ovo.getOrderNum());
				vec.add(ovo.getLunchCode());
				vec.add(ovo.getLunchName());
				vec.add(ovo.getOrderName());
				vec.add(ovo.getQuan());
				vec.add(ovo.getPrice());
				vec.add(ovo.getOrderDate());
				vec.add(ovo.getPhone());
				vec.add(ovo.getIpAddress());
				vec.add(ovo.getStatus());
				// 추가
				dtm.addRow(vec);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getSource() == lmv.getJtb()) {
			if (lmv.getJtb().getSelectedIndex() == 1) { // 두번째 탭에서 이벤트 발생
				// 주문현황을 계속 조회하여 실시간으로 DB를 조회하여 갱신
				if (threadOrdering == null) {
					threadOrdering = new Thread(this);
					threadOrdering.start();
				} // end if

				// 현재까지의 주문사항을 조회
				searchOrder();
				System.out.println("-------");
			} // end if
		}

		if (me.getSource() == lmv.getJtOrder() && me.getButton() == MouseEvent.BUTTON3) {
			JTable jt = lmv.getJtOrder();
			int row = jt.getSelectedRow();
			// 마우스 포인터가 클릭되면 테이블에서 클릭한 행을 가져오는 일
			int r = jt.rowAtPoint(me.getPoint());
			if (r >= 0 && r < jt.getRowCount()) {
				jt.setRowSelectionInterval(r, r);
			} else {
				jt.clearSelection();
			} // end else
				// 선택한 행을 넣는다.
			selectedRow = r;

//			if(row ==-1) {
//				JOptionPane.showMessageDialog(lmv, "작업할 행을 먼저 선택해주세요.");
//				return;
//			}//end if
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setLocation(me.getXOnScreen(), me.getYOnScreen());
			jp.setVisible(true);

			orderNum = (String) jt.getValueAt(jt.getSelectedRow(), 1);
			lunchName = (String) jt.getValueAt(jt.getSelectedRow(), 3) + " "
					+ (String) jt.getValueAt(jt.getSelectedRow(), 4);

		} else {
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);
		}

		switch (me.getClickCount()) {
		case DBL_CLICK:
			if (me.getSource() == lmv.getJtLunch()) { // 도시락테이블에서
				// 도시락 코드로 DB Table을 검색을 하여 상세정보를 전달한다.
				JTable jt = lmv.getJtLunch();
				try {
					LunchDetailVO ldvo = la_dao.selectDetailLunch((String) jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView(lmv, ldvo, this);

				} catch (SQLException se) {
					JOptionPane.showMessageDialog(lmv, "DB에서 문제가 발생했습니다.");
					se.printStackTrace();
				}
			} // end if

		}
	}// mouseClicked

	private void msgCenter(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message);
	}

	@Override
	public void run() {
		try {
			while (true) { // 이렇게 무한루프로 계속돌리면 좋지않음 끊어줘서 해줘야함.
				// 30초마다 한번씩 조회 수행
				searchOrder();
				Thread.sleep(1000 * 30);
			} // end while
		} catch (InterruptedException e) {
			msgCenter(lmv, "주문 조회 중 문제가 발생했습니다.");
			e.printStackTrace();
		}//end catch
	}// run

	///////////////////// 미사용 메소드/////////////////////////
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
