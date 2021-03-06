package day0111.namecard;

import javax.swing.CellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class NamecardView extends JFrame {

	private JButton jbtImg, jbtAdd;
	private DefaultTableModel dtmNamecard;
	private JLabel jlPreview;
	private JTextField jtfName, jtfAddr;
	
	
	public NamecardView() {
		super("명함관리");
		JLabel jlName=new JLabel("이름");
		JLabel jlAddr=new JLabel("주소");
		JLabel jlImg=new JLabel("이미지");
		
		jbtImg=new JButton("이미지 선택");
		jbtAdd=new JButton("명함 추가");
		
		String[] columnNames= {"번호","이미지","성명","주소"};
		Object[][] data=new Object[1][4];
		data[0][0]="";
		data[0][1]="";
		data[0][2]="";
		data[0][3]="";
		dtmNamecard=new DefaultTableModel(data,columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}//iscellEditable
		};
		
		
		//라벨에 그림을 넣음 
		jlPreview=new JLabel(new ImageIcon("C:\\dev\\workspace\\javase_prj2\\src\\day0111\\upload\\no_image.png"));
		jtfName=new JTextField();
		jtfAddr=new JTextField();
		
		JTable jtaNamecardList=new JTable(dtmNamecard) {
			public java.lang.Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();			}
		};
			
		JScrollPane jsp=new JScrollPane(jtaNamecardList);
		jsp.setBorder(new TitledBorder("명함리스트"));
		
		jtaNamecardList.getColumnModel().getColumn(0).setPreferredWidth(40);
		jtaNamecardList.getColumnModel().getColumn(1).setPreferredWidth(120);
		jtaNamecardList.getColumnModel().getColumn(2).setPreferredWidth(120);
		jtaNamecardList.getColumnModel().getColumn(3).setPreferredWidth(260);
		
		jtaNamecardList.setRowHeight(200);
		
		jtaNamecardList.getTableHeader().setReorderingAllowed(false);
	
		setLayout(null);//수동 배치
		
		//이벤트 등록
		NamecardViewController nvc=new NamecardViewController(this);
		addWindowListener(nvc);
		jbtAdd.addActionListener(nvc);
		jbtImg.addActionListener(nvc);
		
		setBounds(100, 100, 850, 400);
		setVisible(true);
		setResizable(false);
		
		jlName.setBounds(10,20,80,25);
		jtfName.setBounds(60,20,120,25);
		jlAddr.setBounds(10,50,80,25);
		jtfAddr.setBounds(60,50,120,25);
		jlImg.setBounds(10,80,80,25);
		jlPreview.setBounds(60,80,120,199); //이미지 넣음
		
		jbtImg.setBounds(65, 290, 110, 25);
		jbtAdd.setBounds(65, 320, 110, 25);
		
		jsp.setBounds(210, 12, 600, 340);
		
		add(jlName);
		add(jtfName);
		add(jlAddr);
		add(jtfAddr);
		add(jlImg);
		add(jlPreview); // 이미지
		add(jbtImg); // 이미지
		add(jbtAdd); // 이미지
		add(jsp);
	}//Namecardview
	
	
	
	public JButton getJbtImg() {
		return jbtImg;
	}

	public JButton getJbtAdd() {
		return jbtAdd;
	}

	public DefaultTableModel getDtmNamecard() {
		return dtmNamecard;
	}

	public JLabel getJlPreview() {
		return jlPreview;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfAddr() {
		return jtfAddr;
	}

	public static void main(String[] args) {
		new NamecardView();
		
	}//main

}//class