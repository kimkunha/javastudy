package day0107;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class WorkProcessor extends JFrame{

	private JLabel jlblSelect;
	private JComboBox<String> jcb;
	private JButton jbtOk;
	private DefaultTableModel dtmChart;
	
	public WorkProcessor() {
		super("접속한계정");
		jlblSelect=new JLabel("테이블 선택");
		
		jcb=new JComboBox<String>();
		jbtOk =new JButton("선택");
		
		String [] columnChart= {"컬럼명","데이터형","크기","제약사항"};
		dtmChart=new DefaultTableModel(columnChart, 10);
		
		JTable tabChart =new JTable(dtmChart);
		tabChart.getTableHeader().setReorderingAllowed(false);// 컬럼이동막기
		tabChart.setRowHeight(20);//행의 크기
		
		tabChart.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabChart.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabChart.getColumnModel().getColumn(2).setPreferredWidth(50);
		tabChart.getColumnModel().getColumn(3).setPreferredWidth(50);
		
		JScrollPane jsp=new JScrollPane(tabChart);
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(jlblSelect);
		jpNorth.add(jcb);
		jpNorth.add(jbtOk);
		
		add("North", jpNorth);
		add("Center", jsp);
		
	
		
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 500, 300);
		
		//이벤트 처리
		WorkProcessorEvt wpe=new WorkProcessorEvt(this);
		
		addWindowListener(wpe);
		jcb.addActionListener(wpe);
		
		
		
		
		
		
	}//workProcessor
	
	
	public JLabel getJlblSelect() {
		return jlblSelect;
	}

	public JComboBox<String> getJcb() {
		return jcb;
	}

	public JButton getJbtOk() {
		return jbtOk;
	}

	public DefaultTableModel getDtmChart() {
		return dtmChart;
	}

}//class
