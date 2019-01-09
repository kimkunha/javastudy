package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.activation.ActivationInstantiator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkProcessorEvt extends WindowAdapter implements ActionListener{

	private WorkProcessor wp;
	
	public WorkProcessorEvt(WorkProcessor wp) {
		this.wp=wp;
		
	}//WorkProcessorEvt
	
	
	public Connection getConn() throws SQLException {
		Connection con=null;
		//1 ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		//2.DB���� Connection ���
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="scott";
		String pass="tiger";
		con=DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConn
	
	
	public  List<String> selectAllTable() throws SQLException {
		List<String>list=new ArrayList<String>();
				
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1. ����̹� �ε�
		//2. connection ���
		con=getConn();
		
		//3. ������ ������ü ���
//			String selectTable="select * from ALL_TAB_COLUMNS where OWNER=SCOTT";
		String selectTable="select object_name from user_objects where object_type ='TABLE'";
			pstmt=con.prepareStatement(selectTable);
			
		//4 ���ε� ���� �� �ֱ�
			
		//5. ������ ������ ��� ���
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
//				wp.getJcb().addItem(rs.getString("object_name"));
				
			}//end while
			
		}finally {
			//5. �������
			if( rs!=null) { rs.close(); }
			if( pstmt!=null) { pstmt.close(); }
			if( con!=null) { con.close(); }
		}//end finally
		return list;
	}//selectAllTable
	
	public void searchTable() {
		
	}
	
	
	@Override
	public void windowClosing(WindowEvent we) {
		wp.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==wp.getJcb()) {
			try {
				selectAllTable();
			} catch (SQLException e) {
				e.printStackTrace();
			}//end catch
		}//end if
	}//actionPerformed
	
}//class
