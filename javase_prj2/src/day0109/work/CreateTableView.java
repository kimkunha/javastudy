package day0109.work;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class CreateTableView extends JFrame{


	private JLabel jlblTabName;
	private JLabel jlblComName;
	private JLabel jlblDataType;
	private JLabel jlblSize;
	private JLabel jlblCons;
	private JLabel jlblConsName;
	private JTextField jtfTabName;
	private JTextField jtfColName;
	//콤보박스 데이터형
	private JComboBox<String> jcbColType;
	private JTextField jtfColSize;
	//콤보박스 제약사항
	private JComboBox<String> jcbConstraint;
	private JTextField jtfConstName;
	private JButton jbAddTab;
	private JButton jbAddCo1;
	private JButton jbCreateTab;
	private JButton jbClean;
	private JTextArea jtaQueryView;
	private JScrollPane jspQueryView;

	public CreateTableView() {
		super("JDBC");

		//라벨
		jlblTabName=new JLabel("테이블명");
		jlblComName=new JLabel("컬럼명");
		jlblDataType=new JLabel("데이터형");
		jlblSize=new JLabel("크기");
		jlblCons=new JLabel("제약사항");
		jlblConsName=new JLabel("제약사항명");

		//T.F
		jtfTabName =new JTextField(10);
		jtfColName=new JTextField(10);
		jcbColType =new JComboBox<String>();
		jtfColSize=new JTextField();
		jcbConstraint=new JComboBox<String>();
		jtfConstName=new JTextField();
		//버튼

		jbAddTab=new JButton("추가");
		jbAddCo1=new JButton("추가");
		jbCreateTab=new JButton("테이블 생성");
		jbClean=new JButton("초기화");

		//T.A		

		jtaQueryView=new JTextArea();	
		jspQueryView=new JScrollPane(jtaQueryView);
		jspQueryView.setBorder(new TitledBorder("QueryView"));
		
		String [] dataType = {"VARCHAR2" ,"CHAR" ,"NUMBER", "DATE"};
		jcbColType=new JComboBox<String>(dataType);
		String[] constraintType = { "NULL", "PRIMARY KEY", "UNIQUE", "NOT NULL"};
		jcbConstraint =new JComboBox<String>(constraintType);
		
		setLayout(null);
		setBounds(400, 100, 585, 600);	

		//수동 배치

		jlblTabName.setBounds(20,0,100,50);
		add(jlblTabName);
		jtfTabName.setBounds(80, 15, 150, 20);
		add(jtfTabName);
		jbAddTab.setBounds(240, 15, 90, 20);
		add(jbAddTab);

		jlblComName.setBounds(20, 0, 150, 120);
		add(jlblComName);
		jtfColName.setBounds(80, 50, 100, 20);
		add(jtfColName);
		jlblDataType.setBounds(200, 50, 100, 20);
		add(jlblDataType);
		jcbColType.setBounds(260, 50, 180, 20);
		add(jcbColType);
		jlblSize.setBounds(460, 50, 150, 20);
		add(jlblSize);
		jtfColSize.setBounds(500, 50, 60, 20);
		add(jtfColSize);
		jlblCons.setBounds(15, 40, 150, 120);
		add(jlblCons);
		jcbConstraint.setBounds(80, 90, 150, 20);
		add(jcbConstraint);
		jlblConsName.setBounds(250,90,190,20);
		add(jlblConsName);
		jtfConstName.setBounds(320,90,130,20);
		add(jtfConstName);
		jbAddCo1.setBounds(470,90,90,20);
		add(jbAddCo1);
		jspQueryView.setBounds(10, 130, 560, 400);
		add(jspQueryView);
		jbCreateTab.setBounds(318, 535, 120, 20);
		add(jbCreateTab);
		jbClean.setBounds(447, 535, 120, 20);
		add(jbClean);
		
		
		jtaQueryView.setEditable(false);
		setVisible(true);
		setResizable(false);

		//이벤트 처리
		CreateTableViewEvt cte=new CreateTableViewEvt( this );
		jbAddTab.addActionListener(cte);
		jbAddCo1.addActionListener(cte);
		jbCreateTab.addActionListener(cte);
		jbClean.addActionListener(cte);
		
		jtfTabName.addActionListener( cte);
		jtfColName.addActionListener(cte);
		jtfColSize.addActionListener(cte);
		jtfConstName.addActionListener( cte);
		
		addWindowListener(cte);
		
		
	}//생성자

	public JLabel getJlblTabName() {
		return jlblTabName;
	}

	public JLabel getJlblComName() {
		return jlblComName;
	}

	public JLabel getJlblDataType() {
		return jlblDataType;
	}

	public JLabel getJlblSize() {
		return jlblSize;
	}

	public JLabel getJlblCons() {
		return jlblCons;
	}

	public JLabel getJlblConsName() {
		return jlblConsName;
	}

	public JTextField getJtfTabName() {
		return jtfTabName;
	}

	public JTextField getJtfColName() {
		return jtfColName;
	}

	public JComboBox<String> getJcbColType() {
		return jcbColType;
	}

	public JTextField getJtfColSize() {
		return jtfColSize;
	}

	public JComboBox<String> getJcbConstraint() {
		return jcbConstraint;
	}

	public JTextField getJtfConstName() {
		return jtfConstName;
	}

	public JButton getJbAddTab() {
		return jbAddTab;
	}

	public JButton getJbAddCo1() {
		return jbAddCo1;
	}

	public JButton getJbCreateTab() {
		return jbCreateTab;
	}

	public JButton getJbClean() {
		return jbClean;
	}

	public JTextArea getJtaQueryView() {
		return jtaQueryView;
	}

	public JScrollPane getJspQueryView() {
		return jspQueryView;
	}
	
	public void setJtfTabName(JTextField jtfTabName) {
		this.jtfTabName = jtfTabName;
	}

	public void setJtfColName(JTextField jtfColName) {
		this.jtfColName = jtfColName;
	}

	public void setJtfConstName(JTextField jtfConstName) {
		this.jtfConstName = jtfConstName;
	}

	public void setJtaQueryView(JTextArea jtaQueryView) {
		this.jtaQueryView = jtaQueryView;
	}

	



}//class

