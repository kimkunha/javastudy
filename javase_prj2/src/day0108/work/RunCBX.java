package day0108.work;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *	����� �ν��Ͻ����� ����
 * @author owner
 */
public class RunCBX extends JFrame{

	private JLabel jlblSelect;
	private JComboBox<String>jcbTable;
	private JButton jbtSearch;
	private DefaultTableModel dtmSelectedTable;
	
	/**
	 *  ������
	 */
	public RunCBX() {
		super("Table Search");
		jlblSelect =new JLabel("���̺� ����");
		
		jcbTable =new JComboBox<String>();
		
		jbtSearch = new JButton("����");
		
		String[] columnNames = {"�÷���","��������","ũ��","�������"};
		dtmSelectedTable = new DefaultTableModel(columnNames, 0);  // ����Ʈ �𵨷� ���� ��´�.
		
		JTable jtabSelectedTable = new JTable(dtmSelectedTable);
		jtabSelectedTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtabSelectedTable.getColumnModel().getColumn(1).setPreferredWidth(40);
		jtabSelectedTable.getColumnModel().getColumn(2).setPreferredWidth(40);
		jtabSelectedTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		jtabSelectedTable.getTableHeader().setReorderingAllowed(false); //�÷� �̵� ���ϰ� ����
		jtabSelectedTable.setRowHeight(24);
		
		JScrollPane jsp = new JScrollPane(jtabSelectedTable);
		
		JPanel jpNorth = new JPanel();
		jpNorth.setBackground(Color.WHITE);
		
		jpNorth.add(jlblSelect);
		jpNorth.add(jcbTable);
		jpNorth.add(jbtSearch);
		
		add("North", jpNorth);
		add("Center", jsp);
		
		
	}//RunCBX
	
	
	
	
	
}//class
