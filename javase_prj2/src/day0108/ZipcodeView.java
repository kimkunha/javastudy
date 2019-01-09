package day0108;
import java.awt.ScrollPane;

import javax.swing.JButton;
//19.01.07 -4���ڷ�- (�ּ� ����� )
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
class ZipcodeView extends JFrame {

	private JTextField jtfDong;
	private JButton jbtSearch;
	private DefaultTableModel dtmZipcode;
	
	public ZipcodeView() {
		super("�����ּ� �˻�");
		jtfDong=new JTextField(10);
		jbtSearch=new JButton("�˻�");
		
		//�̺κ� �����Ұ�. 
		String [] columnNames= {"�����ȣ", "�ּ�"};
		dtmZipcode=new DefaultTableModel(columnNames, 5);
		
		JTable tabZipcode=new JTable(dtmZipcode);
		tabZipcode.getTableHeader().setReorderingAllowed(false); // �÷��̵� ����
		tabZipcode.setRowHeight(24); //���� ũ��
		
		tabZipcode.getColumnModel().getColumn(0).setPreferredWidth(60);
		tabZipcode.getColumnModel().getColumn(0).setPreferredWidth(300);
		//������
		
		JScrollPane jsp=new JScrollPane(tabZipcode);
		
		JPanel panelNorth=new JPanel();
		panelNorth.add(new JLabel("�� �̸�"));
		panelNorth.add(jtfDong);
		panelNorth.add(jbtSearch);

		add("North", panelNorth);
		add("Center", jsp);
		
		//�̺�Ʈ ó��
		ZipcodeViewEvt zve=new ZipcodeViewEvt( this);
		addWindowListener( zve);
		
		jtfDong.addActionListener(zve);
		jbtSearch.addActionListener(zve);
		
		setBounds(10, 100, 470, 500);
		setVisible(true);
		setResizable(false);
		
	}//ZipcodeView
	
	
	public JTextField getJtfDong() {
		return jtfDong;
	}

	public JButton getJbtSearch() {
		return jbtSearch;
	}
	public DefaultTableModel getDtmZipcode() {
		return dtmZipcode;
	}

	public static void main(String[] args) {
		new ZipcodeView();
	}//main

}//class
