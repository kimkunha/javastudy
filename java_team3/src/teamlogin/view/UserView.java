package teamlogin.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UserView extends JFrame{

	private DefaultTableModel dtm;
	
	
	public UserView(){
		super("유저 정보");
		String[] userInfo= {"아이디", "비밀번호", "전화번호", "이메일"};
		dtm=new DefaultTableModel(userInfo,5);
		
		JTable jtInfo=new JTable(dtm);
		JScrollPane jsp=new JScrollPane(jtInfo);
		jsp.setBorder(new TitledBorder("유저정보"));
		add("Center", jsp);
		
		setBounds(100, 100, 700, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
	}//생성자
	

}//class