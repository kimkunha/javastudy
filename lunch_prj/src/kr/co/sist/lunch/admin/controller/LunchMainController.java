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
		// ���ö� ����� �����Ѵ�.
		setLunch();
		orderNum = "";
	}// LunchMainController

	/**
	 * JTable�� DB���� ��ȸ�� ���ö������� �����ش�.
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch = lmv.getDtmLunch();
		dtmLunch.setRowCount(0);

		try {
			// DB���� ���ö� ������ ��ȸ
			List<LunchVO> listLunch = la_dao.selectLunch();
			// JTable �� ��ȸ�� ������ ���.
			LunchVO lv = null;
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";

			Object[] rowData = null;
			for (int i = 0; i < listLunch.size(); i++) {
				lv = listLunch.get(i);
				// DTM �� �����͸� �߰��ϱ� ���� �������迭(Vector)�� �����ϰ� �����͸� �߰�
				rowData = new Object[5];
				rowData[0] = new Integer(i + 1);
				rowData[1] = lv.getLunchCode();
				rowData[2] = new ImageIcon(imgPath + lv.getImg());
				rowData[3] = lv.getLunchName();
				rowData[4] = new Integer(lv.getPrice());

				// DTM�� �߰�
				dtmLunch.addRow(rowData);

			} // end for
			if (listLunch.isEmpty()) { // �Էµ� ���ö��� ���� ��
				JOptionPane.showMessageDialog(lmv, "�Էµ� ��ǰ�� �����ϴ�.");
			} // end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB���� �����͸� �޾ƿ��� �� ���� �߻�...");
			e.printStackTrace();
		} // catch

	}// setLunch

	@Override
	public void windowClosing(WindowEvent we) {
		lmv.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0); // JVM�� ��� �ν��Ͻ� ����.
	}

	/**
	 * ��,��, �� ������ �����ͼ� ����
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
			// ������ ������ ��ȸ����� �޾Ƽ� JTable ���
			List<CalcVO> list = la_dao.selectCalc(searchDate.toString());
			CalcVO cv = null;
			// JTable�� �����͸� �߰��ϴ� �ڵ� �ۼ��غ�����.
			// �����Ͱ� ���� ������ "�Ǹŵ� ���ö��� �����ϴ�" ���

			Object[] rowData = null;
			for (int i = 0; i < list.size(); i++) {
				cv = list.get(i);
				// DTM �� �����͸� �߰��ϱ� ���� �������迭(Vector)�� �����ϰ� �����͸� �߰�
				rowData = new Object[5];
				rowData[0] = new Integer(i + 1);
				rowData[1] = cv.getLunchName() + "(" + cv.getLunchCode() + ")"; // ���ö���(���ö��ڵ�)
				rowData[2] = cv.getTotal();
				rowData[3] = cv.getPrice();
				// DTM�� �߰�
				dtmCalc.addRow(rowData);
			} // end for
//			if(list.size()==0) {
//				JOptionPane.showMessageDialog(lmv, "�Ǹŵ� ���ö��� �����ϴ�.");
//			}
			if (list.isEmpty()) { // �Էµ� ���ö��� ���� ��
				JOptionPane.showMessageDialog(lmv, searchDate + "�Ͽ��� �Ǹŵ� ���ö��� �����ϴ�.");
			} // end if

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
		System.out.println(searchDate);
	}// searchCalc

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == lmv.getJbtAddLunch()) { // ���ö� �߰���ư
			new LunchAddView(lmv, this);
		}
		if (ae.getSource() == lmv.getJcbMonth()) { // ���� ������ ���� ����
			setDay();
		} // end if
		if (ae.getSource() == lmv.getJbtCalcOrder()) { // �����ư Ŭ��
			searchCalc();
		} // end if

		if (ae.getSource() == lmv.getJmOrderRemove()) {
			// ���ۻ��°� 'N'�� ���¿����� ����
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {
				switch (JOptionPane.showConfirmDialog(lmv, orderNum + " " + lunchName + "]�ֹ������� �����Ͻðڽ��ϱ�?")) {
				case JOptionPane.OK_OPTION:
					try {
						if (la_dao.deleteOrder(orderNum)) {// DBTable���� �ش� ���ڵ� ����
							msgCenter(lmv, orderNum + "�ֹ��� ���� �Ǿ����ϴ�.");
							// �ֹ� ���̺� ����
							searchOrder();
							jt.remove(selectedRow); // ���̺����� ����
						} else {
							msgCenter(lmv, orderNum + "�ֹ��� ���� ���� �ʾҽ��ϴ�.");

						} // end else
					} catch (SQLException e) {
						msgCenter(lmv, orderNum + "DB���� �����߻�.....");
						e.printStackTrace();
					} // end catch
				}
			} else {
				msgCenter(lmv, "���۵� ���ö��� ������ �� �����ϴ�.");
			}
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);// popup �޴� ����
		} // end if
		if (ae.getSource() == lmv.getJmOrderStatus()) {
			// ���ۻ��°� 'N'�� ���¿����� ����
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {

				switch (JOptionPane.showConfirmDialog(lmv, "[" + orderNum + lunchName + " ] �ֹ��� �Ϸ�Ǿ����ϱ�?")) {
				case JOptionPane.OK_OPTION:
					// DB Table�� �ش� ���ڵ� ����
					try {
						if (la_dao.updateStatus(orderNum)) { // ���º�ȯ ����
							jt.setValueAt("Y", selectedRow, 10); // J���̺��� ���� ����

							JOptionPane.showMessageDialog(lmv, "���ö� ������ �Ϸ�Ǿ����ϴ�");

						} else { // ���º�ȯ ����
							JOptionPane.showMessageDialog(lmv, "���ö� ���ۻ��� ��ȯ�� ����!!");
						} // end else
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(lmv, "DB���� ���� �߻�.......");
						e.printStackTrace();
					} // end catch
				}// end switch
			} else {
				JOptionPane.showMessageDialog(lmv, "�̹� ������ �Ϸ�� ���ö��Դϴ�.");
			} // end else

			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false);// popup �޴� ����
		} // end if
	}// actionPerformed

	/**
	 * ���� ���õǸ� �ش���� �ش���� ���������� ����
	 */
	private void setDay() {
		int selYear = ((Integer) lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth = ((Integer) lmv.getJcbMonth().getSelectedItem()).intValue();

		// �������� ���
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, selYear);
		cal.set(Calendar.MONTH, selMonth - 1);

		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int nowDay = cal.get(Calendar.DAY_OF_MONTH);

		lmv.getCbmDay().removeAllElements(); // ���� �ʱ�ȭ�ϰ�
		for (int day = 1; day < lastDay + 1; day++) {
			lmv.getCbmDay().addElement(day); // ������ ���� �����Ѵ�.
		} // end for

//		lmv.getCbmDay().setSelectedItem(new Integer(nowDay)); //������ �����Ѵ�.
	}

	public void searchOrder() {
		try {
			List<OrderVO> list = la_dao.selectOrderList();
			DefaultTableModel dtm = lmv.getDtmOrder();
			dtm.setRowCount(0); // �ʱ�ȭ

			// ���̺� ���ֱ� ���ͷ� �����ϴ� ��.
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
				// �߰�
				dtm.addRow(vec);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getSource() == lmv.getJtb()) {
			if (lmv.getJtb().getSelectedIndex() == 1) { // �ι�° �ǿ��� �̺�Ʈ �߻�
				// �ֹ���Ȳ�� ��� ��ȸ�Ͽ� �ǽð����� DB�� ��ȸ�Ͽ� ����
				if (threadOrdering == null) {
					threadOrdering = new Thread(this);
					threadOrdering.start();
				} // end if

				// ��������� �ֹ������� ��ȸ
				searchOrder();
				System.out.println("-------");
			} // end if
		}

		if (me.getSource() == lmv.getJtOrder() && me.getButton() == MouseEvent.BUTTON3) {
			JTable jt = lmv.getJtOrder();
			int row = jt.getSelectedRow();
			// ���콺 �����Ͱ� Ŭ���Ǹ� ���̺��� Ŭ���� ���� �������� ��
			int r = jt.rowAtPoint(me.getPoint());
			if (r >= 0 && r < jt.getRowCount()) {
				jt.setRowSelectionInterval(r, r);
			} else {
				jt.clearSelection();
			} // end else
				// ������ ���� �ִ´�.
			selectedRow = r;

//			if(row ==-1) {
//				JOptionPane.showMessageDialog(lmv, "�۾��� ���� ���� �������ּ���.");
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
			if (me.getSource() == lmv.getJtLunch()) { // ���ö����̺���
				// ���ö� �ڵ�� DB Table�� �˻��� �Ͽ� �������� �����Ѵ�.
				JTable jt = lmv.getJtLunch();
				try {
					LunchDetailVO ldvo = la_dao.selectDetailLunch((String) jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView(lmv, ldvo, this);

				} catch (SQLException se) {
					JOptionPane.showMessageDialog(lmv, "DB���� ������ �߻��߽��ϴ�.");
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
			while (true) { // �̷��� ���ѷ����� ��ӵ����� �������� �����༭ �������.
				// 30�ʸ��� �ѹ��� ��ȸ ����
				searchOrder();
				Thread.sleep(1000 * 30);
			} // end while
		} catch (InterruptedException e) {
			msgCenter(lmv, "�ֹ� ��ȸ �� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		}//end catch
	}// run

	///////////////////// �̻�� �޼ҵ�/////////////////////////
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
