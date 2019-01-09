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
		super("�����Ѱ���");
		jlblSelect=new JLabel("���̺� ����");
		
		jcb=new JComboBox<String>();
		jbtOk =new JButton("����");
		
		String [] columnChart= {"�÷���","��������","ũ��","�������"};
		dtmChart=new DefaultTableModel(columnChart, 10);
		
		JTable tabChart =new JTable(dtmChart);
		tabChart.getTableHeader().setReorderingAllowed(false);// �÷��̵�����
		tabChart.setRowHeight(20);//���� ũ��
		
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
		
		//�̺�Ʈ ó��
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
