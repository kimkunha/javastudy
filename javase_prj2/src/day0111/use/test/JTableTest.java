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
		String[] rowDate= { "�̸�", "�ڹ�", "���̽�", "�ڹٽ�ũ��Ʈ", "����Ŭ" };
		String[][] column={ 
				{"�����", "99", "99","99","99"},
				{"������", "60", "69", "39","49"},
				{"�̺���", "59", "29","69","59"},
				{"�߹���", "69", "79", "59","79"} 
				};
		jbtAdd=new JButton("�����Է�");
		
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
	}//������
	
	
	
	
	
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
