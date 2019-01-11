package day0111;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.ServantRetentionPolicyValue;

public class UseJtableimages extends JFrame {

	private DefaultTableModel dtm;
	private String [] columnNames;
	private Object [][]rowData;
	private ImageIcon img1, img2, img3;
	private JTable jt;
	private JScrollPane jsp;
	
	public UseJtableimages() {
			super("Net");
		img1=new ImageIcon("C:\\dev\\workspace\\javase_prj2\\src\\day0111\\images\\daum.png");
		img2=new ImageIcon("C:\\dev\\workspace\\javase_prj2\\src\\day0111\\images\\google.png");
		img3=new ImageIcon("C:\\dev\\workspace\\javase_prj2\\src\\day0111\\images\\naver.png");
		 columnNames= new String[]{"로고", "URL", "특징"};
		 rowData=new Object[3][3] ;
		 rowData[0][0]= img1; 
		 rowData[0][1]= "https://www.daum.net"; 
		 rowData[0][2]= "카카오 프렌즈"; 
		 
		 rowData[1][0]=img2;
		 rowData[1][1]="https://www.naver.com";
		 rowData[1][2]="웹툰";
		 
		 rowData[2][0]=img3;
		 rowData[2][1]="https://www.google.co.kr";
		 rowData[2][2]="구글링";
				 
		dtm=new DefaultTableModel(rowData, columnNames)	{
			@Override //셀을 더블클릭 했을경우 편집을 불가능하게 만드는 method
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			@Override
			public Class getColumnClass(int column) {
			//row - Jtable에 입력된 이차원 배열의 행에 속한다면
			//모든 컬럼의 값을 입력된 형으로 반환한다.
			return getValueAt(0, column).getClass();
			}
		};	
		
		jt=new JTable(dtm);
		jsp=new JScrollPane(jt); 
		jt.getColumnModel().getColumn(0).setPreferredWidth(50);
		jt.getColumnModel().getColumn(1).setPreferredWidth(50);
		jt.getColumnModel().getColumn(2).setPreferredWidth(50);
	
		jt.setRowHeight(35);
		jt.getTableHeader().setResizingAllowed(false); //컬럼의 크기변경 막기
		jt.getTableHeader().setReorderingAllowed(false);//컬럼의 이동 막기
		add("Center", jsp);
		setBounds(100,100,500,300);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		UseJtableimages uji= new UseJtableimages();
	}//main

}//class
