package day0107;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WorkProcessor extends JFrame{

	private JLabel jlblSelect;
	private JComboBox<String> jcb;
	private JButton jbtOk;
	
	public WorkProcessor() {
		super("접속한계정");
		jlblSelect=new JLabel("테이블 선택");
		
		jcb=new JComboBox<String>();
		jbtOk =new JButton("선택");
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(jlblSelect);
		jpNorth.add(jcb);
		jpNorth.add(jbtOk);
		
		add("North",jpNorth);
		
		try {
			selectAllTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 500, 300);
		
		//이벤트 처리
		WorkProcessorEvt wpe=new WorkProcessorEvt(this);
		addWindowListener(wpe);
		
		
		
		
	}//workProcessor
	
	
	public Connection getConn() throws SQLException {
		Connection con=null;
		//1 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		//2.DB연동 Connection 얻기
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="scott";
		String pass="tiger";
		con=DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConn
	
	public  List<String> selectAllTable() throws SQLException {
		List<String>list=new ArrayList<String>();
				
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//1. 드라이버 로딩
		//2. connection 얻기
		con=getConn();
		
		//3. 쿼리문 생성객체 얻기
//			String selectTable="select * from ALL_TAB_COLUMNS where OWNER=SCOTT";
		String selectTable="select object_name from user_objects where object_type ='TABLE'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(selectTable);
		//4 바인드 변수 값 넣기
			while(rs.next()) {
				jcb.addItem(rs.getString("object_name"));
			}
		
			
		//5. 쿼리문 수행후 결과 얻기
		}finally {
			//5. 연결끊기
			if( rs!=null) { rs.close(); }
			if( stmt!=null) { stmt.close(); }
			if( con!=null) { con.close(); }
		}//end finally
		return list;
	}//selectAllTable
	
	
}//class
