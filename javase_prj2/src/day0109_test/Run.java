package day0109_test;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Run extends JFrame{

	private JLabel jlblTabName;
	private JLabel jlblComName;
	private JLabel jlblDataType;
	private JLabel jlblSize;
	private JLabel jlblCons;
	private JLabel jlblConsName;
	
	private JTextField jtfTabName;
	private JTextField jtfComName;
	//�޺��ڽ� ��������
	private JComboBox<String> jcomDataType;
	private JTextField jtfSize;
	//�޺��ڽ� �������
	private JComboBox<String> jcomCons;
	private JTextField jtfConsName;
	
	private JButton jbtAdd;
	private JButton jbtAdd2;
	private JButton jbtCre;
	private JButton jbtInit;
	
	private JTextArea jtaField;
	private JScrollPane jsp;
	public Run() {
		super("JDBC");
		//��
		jlblTabName=new JLabel("���̺��");
		jlblComName=new JLabel("�÷���");
		jlblDataType=new JLabel("��������");
		jlblSize=new JLabel("ũ��");
		jlblCons=new JLabel("�������");
		jlblConsName=new JLabel("������׸�");
		
		//T.F
		jtfTabName =new JTextField(10);
		jtfComName=new JTextField(10);
		jcomDataType =new JComboBox<String>();
		jtfSize=new JTextField();
		jcomCons=new JComboBox<String>();
		jtfConsName=new JTextField();
		//��ư
		jbtAdd=new JButton("�߰�");
		jbtAdd2=new JButton("�߰�");
		jbtCre=new JButton("���̺� ����");
		jbtInit=new JButton("�ʱ�ȭ");
		
		//T.A		
		jtaField=new JTextArea();	
		jsp=new JScrollPane(jtaField);
		jsp.setBorder(new TitledBorder("QueryView"));
		
		setLayout(null);
		setBounds(400, 100, 585, 600);	
		//���� ��ġ
		jlblTabName.setBounds(20,0,100,50);
		add(jlblTabName);
		jtfTabName.setBounds(80, 15, 150, 20);
		add(jtfTabName);
		jbtAdd.setBounds(240, 15, 90, 20);
		add(jbtAdd);
		
		jlblComName.setBounds(20, 0, 150, 120);
		add(jlblComName);
		jtfComName.setBounds(80, 50, 100, 20);
		add(jtfComName);
		jlblDataType.setBounds(200, 50, 100, 20);
		add(jlblDataType);
		jcomDataType.setBounds(260, 50, 180, 20);
		add(jcomDataType);
		jlblSize.setBounds(460, 50, 150, 20);
		add(jlblSize);
		jtfSize.setBounds(500, 50, 60, 20);
		add(jtfSize);
		jlblCons.setBounds(15, 40, 150, 120);
		add(jlblCons);
		jcomCons.setBounds(80, 90, 150, 20);
		add(jcomCons);
		jlblConsName.setBounds(250,90,190,20);
		add(jlblConsName);
		jtfConsName.setBounds(320,90,130,20);
		add(jtfConsName);
		jbtAdd2.setBounds(470,90,90,20);
		add(jbtAdd2);
		jsp.setBounds(10, 130, 560, 400);
		add(jsp);
		jbtCre.setBounds(318, 535, 120, 20);
		add(jbtCre);
		jbtInit.setBounds(447, 535, 120, 20);
		add(jbtInit);
		
		setVisible(true);
		setResizable(false);
		
	}//������
	
	
	
	public JComboBox<String> getJcomDataType() {
		return jcomDataType;
	}

	public JComboBox<String> getJcomCons() {
		return jcomCons;
	}

	public JButton getJbtAdd() {
		return jbtAdd;
	}

	public JButton getJbtAdd2() {
		return jbtAdd2;
	}

	public JButton getJbtCre() {
		return jbtCre;
	}

	public JButton getJbtInit() {
		return jbtInit;
	}

	public static void main(String[] args) {
		Run r=new Run();
	}//main

}//class
