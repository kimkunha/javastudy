package day0111.use.test;

import java.awt.ScrollPane;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame {

	private DefaultTableModel dtm;
	private JButton jbtAdd;
	
	public JTableTest() {
		String[] rowDate= { "이름", "자바", "파이썬", "자바스크립트", "오라클" };
		String[][] column={ 
				{"김건하", "99", "99","99","99"},
				{"조현정", "60", "69", "39","49"},
				{"이빛나", "59", "29","69","59"},
				{"견민지", "69", "79", "59","79"} 
				};
		jbtAdd=new JButton("점수입력");
		
		dtm= new DefaultTableModel(column, rowDate) {
			public boolean isCellEditable(int row, int column) {
			return false;
		}
		};
		
		JTable jt=new JTable(dtm);
		jt.getColumnModel().getColumn(0).setPreferredWidth(10);
		jt.getColumnModel().getColumn(1).setPreferredWidth(30);
		jt.getColumnModel().getColumn(2).setPreferredWidth(30);
		jt.getColumnModel().getColumn(3).setPreferredWidth(30);
		jt.getColumnModel().getColumn(4).setPreferredWidth(30);
		
		JScrollPane jsp=new JScrollPane(jt);
		add("Center", jsp);
		add("South", jbtAdd);
		
		JTableTestEvt jte=new JTableTestEvt(this);
		addWindowListener(jte);
		jbtAdd.addActionListener(jte);
	
		
		
		
		setBounds(100, 100, 500, 300);
		setVisible(true);
	}//생성자
	
	
	
	
	
	public DefaultTableModel getDtm() {
		return dtm;
	}

	public JButton getJbtAdd() {
		return jbtAdd;
	}






	public static void main(String[] args) {
		new JTableTest();
	}//main
	
}//class
