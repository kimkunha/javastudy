package study;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *	이미지를 삽입하는 Jtable을 만들어 보자
 * @author owner
 */
public class TestJTable  extends JFrame{

	private DefaultTableModel dtm;
	private JTable jt;
	private JScrollPane jsp;
	private String[] logo;
	private Object[][] column;
	private ImageIcon img1, img2, img3;
	
	public TestJTable() {
		super("인터넷");
		img1=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/daum.png");
		img2=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/google.png");
		img3=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/naver.png");
		
		logo=new String[] {"URL","LOGO","특징"};
		column=new Object[3][3];
		column[0][0]=img1;
		column[0][1]="https://";
		column[0][2]="카카오프렌즈";
				
		column[1][0]=img2;
		column[1][1]="https://";
		column[1][2]="웹툰";
				
		column[2][0]=img3;
		column[2][1]="https:";
		column[2][2]="구글링";
		
		dtm=new DefaultTableModel(column, logo) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
			
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		jt=new JTable(dtm);
		jt.getColumnModel().getColumn(0).setPreferredWidth(20);
		jt.getColumnModel().getColumn(1).setPreferredWidth(70);
		jt.getColumnModel().getColumn(2).setPreferredWidth(20);
		jt.setRowHeight(40);
		jsp=new JScrollPane(jt);
		add(jsp);
		
		setBounds(100, 100, 500, 300);
		setVisible(true);
				
		
	}//TestJTable
	
	
	
	
	
	public static void main(String[] args) {
		new TestJTable();
	}//main

}//class
