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
 *	사용할 인스턴스변수 선언
 * @author owner
 */
public class RunCBX extends JFrame{

	private JLabel jlblSelect;
	private JComboBox<String>jcbTable;
	private JButton jbtSearch;
	private DefaultTableModel dtmSelectedTable;
	
	/**
	 *  생성자
	 */
	public RunCBX() {
		super("Table Search");
		jlblSelect =new JLabel("테이블 선택");
		
		jcbTable =new JComboBox<String>();
		
		jbtSearch = new JButton("선택");
		
		String[] columnNames = {"컬럼명","데이터형","크기","제약사항"};
		dtmSelectedTable = new DefaultTableModel(columnNames, 0);  // 디폴트 모델로 만들어서 담는다.
		
		JTable jtabSelectedTable = new JTable(dtmSelectedTable);
		jtabSelectedTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtabSelectedTable.getColumnModel().getColumn(1).setPreferredWidth(40);
		jtabSelectedTable.getColumnModel().getColumn(2).setPreferredWidth(40);
		jtabSelectedTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		jtabSelectedTable.getTableHeader().setReorderingAllowed(false); //컬럼 이동 못하게 설정
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
