package kr.co.sist.lunch.admin.view;

import java.awt.BorderLayout;
import java.util.Calendar;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.controller.LunchMainController;

@SuppressWarnings("serial")
public class LunchMainView extends JFrame{
	
	private JTabbedPane jtb;
	private DefaultTableModel dtmLunch, dtmOrder, dtmCalc; //메뉴, 주문, 정산
	private JButton jbtAddLunch, jbtCalcOrder;
	private JComboBox<Integer>jcbYear, jcbMonth, jcbDay;
	private JTable jtLunch, jtOrder;//메뉴, 주문
	
	private DefaultComboBoxModel<Integer> cbmYear, cbmMonth, cbmDay;
	
	//calendar 추가
	private Calendar cal;
	
public LunchMainView(String adminName ) {
	super("[도시락 관리 [ 로그인 계정 : "+adminName+" ]");
	
			cal=Calendar.getInstance();
			
			jtb=new JTabbedPane();
			//도시락
			String[] lunchColumns= {"번호","도시락코드","이미지","도시락명","가격"};
			dtmLunch=new DefaultTableModel(lunchColumns,4);
			jtLunch=new JTable( dtmLunch );
			
			
			//정산
			String[] calcColumns= {"번호","도시락명","수량","가격"};
			dtmCalc=new DefaultTableModel(calcColumns, 4);
			JTable jtCalc=new JTable( dtmCalc );
			
			
			//주문
			String[] orderColumns= {"번호","주문번호","도시락코드","도시락명","주문자명",
					"수량","가격","주문일","연락처","주문자ip","제작상태"};
			dtmOrder=new DefaultTableModel(orderColumns, 4);
			jtOrder=new JTable(dtmOrder);
			
			jbtAddLunch=new JButton("도시락 추가");
			jbtCalcOrder=new JButton("정산");
			
			cbmYear=new DefaultComboBoxModel<Integer>();
			jcbYear=new JComboBox<Integer>(cbmYear);
			
			cbmMonth=new DefaultComboBoxModel<Integer>();
			jcbMonth=new JComboBox<Integer>(cbmMonth);
			
			cbmDay=new DefaultComboBoxModel<Integer>();
			jcbDay=new JComboBox<Integer>(cbmDay);
			
			JScrollPane jspLunch=new JScrollPane(jtLunch);
			jspLunch.setBorder(new TitledBorder("도시락 목록"));
			
			JScrollPane jspOrder=new JScrollPane(jtOrder);
			jspOrder.setBorder(new TitledBorder("주문목록"));
			
			JScrollPane jspCalc=new JScrollPane(jtCalc);
			jspCalc.setBorder(new TitledBorder("정산"));
			
			//처음탭에 들어갈 컴포넌트 배치
			JPanel jpLunch =new JPanel();
			JPanel jpLunchNorth =new JPanel();
			
			jpLunch.setLayout(new BorderLayout());
			jpLunchNorth.add(jbtAddLunch);
			
			jpLunch.add("Center", jspLunch);
			jpLunch.add("North", jpLunchNorth);
			
			jtb.add("도시락", jpLunch);
			
			//두번째탭에 들어갈 컴포넌트 배치
			JPanel jpOrder =new JPanel();
			jpOrder.setLayout(new BorderLayout());
			jpOrder.add(jspOrder);
			jtb.add("주문", jspOrder);
			
			//세번째탭에 들어갈 컴포넌트 배치
			JPanel jpCalc=new JPanel();
			jpCalc.setLayout(new BorderLayout());
			
			JPanel jpCalcNorth=new JPanel();
			jpCalcNorth.setBorder(new TitledBorder("정산일자 선택"));
			jpCalcNorth.add(jcbYear);
			jpCalcNorth.add(new JLabel("년"));
			jpCalcNorth.add(jcbMonth);
			jpCalcNorth.add(new JLabel("월"));
			jpCalcNorth.add(jcbDay);
			jpCalcNorth.add(new JLabel("일"));
			jpCalcNorth.add(jbtCalcOrder);
		
			jpCalc.add("North", jpCalcNorth);
			jpCalc.add("Center", jspCalc);
			
			jtb.addTab("정산", jpCalc);
	
			//탭을 프레임에 배치
			add("Center", jtb);
			
			setYear(); //JCB Year설정
			setMonth();//JCB Month설정
			setDay();//JCB Day설정
			
			//이벤트 처리
			LunchMainController lmc=new LunchMainController(this);
			addWindowListener(lmc);
			
			jtb.addMouseListener(lmc);//탭에서 이벤트가 발생했을 때
			jtLunch.addMouseListener(lmc);
			jtOrder.addMouseListener(lmc);
			
			jbtAddLunch.addActionListener(lmc);
			jbtCalcOrder.addActionListener(lmc);
			
			jcbMonth.addActionListener(lmc);
			
			
	setBounds(100, 100, 800, 600);
	setVisible(true);
	
	
}//생성자

	private void setYear() { //현재년도 4년전까지
		
		int year=cal.get(Calendar.YEAR); //현재년도
		for (int temp=0; temp<4; temp++) {
			cbmYear.addElement(year-temp);
		}//end for
		jcbYear.setSelectedItem(new Integer(year));
		
		
	}//setYear
	
	private void setMonth() { //월 1 ~ 12월
		int now_month=cal.get(Calendar.DAY_OF_MONTH)+1;
		for(int month=1; month<13; month++) {
			cbmMonth.addElement(month);
		}//end for
		jcbMonth.setSelectedItem(new Integer(now_month));
				
	}//setYear
	
	private void setDay() {// 그월의 마지막 날
		int lastDay=cal.getActualMaximum(Calendar.DATE);
		int nowDay=cal.get(Calendar.DAY_OF_MONTH);
		for(int day=1; day<lastDay+1; day++) {
			cbmDay.addElement(day);
		}//end for
		jcbDay.setSelectedItem(new Integer(nowDay));
	}//setYear


public JTabbedPane getJtb() {
	return jtb;
}

public DefaultTableModel getDtmLunch() {
	return dtmLunch;
}

public DefaultTableModel getDtmOrder() {
	return dtmOrder;
}

public DefaultTableModel getDtmCalc() {
	return dtmCalc;
}

public JButton getJbtAddLunch() {
	return jbtAddLunch;
}

public JButton getJbtCalcOrder() {
	return jbtCalcOrder;
}

public JComboBox<Integer> getJcbYear() {
	return jcbYear;
}

public JComboBox<Integer> getJcbMonth() {
	return jcbMonth;
}

public JComboBox<Integer> getJcbDay() {
	return jcbDay;
}

public JTable getJtLunch() {
	return jtLunch;
}

public JTable getJtOrder() {
	return jtOrder;
}

public DefaultComboBoxModel<Integer> getCbmYear() {
	return cbmYear;
}

public DefaultComboBoxModel<Integer> getCbmMonth() {
	return cbmMonth;
}

public DefaultComboBoxModel<Integer> getCbmDay() {
	return cbmDay;
}



}//class

