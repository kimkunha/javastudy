package day0109.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreateTableDAO {

	public CreateTableDAO( String sql, CreateTableView ctv ) throws SQLException{
		
		try {
			//1. ����̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			//2. Connection ���
				String url="jdbc:oracle:thin:@127.0.0.1:1520:orcl";
				String id="scott";
				String pass="tiger";
			con = DriverManager.getConnection(url, id, pass);
			//3. ������ ������ ��ü ���
			pstmt=con.prepareStatement(sql);
			//4. ������ ���� �� ��� ���
			pstmt.execute();
			JOptionPane.showMessageDialog(ctv, "���̺��� ���� �Ǿ����ϴ�.");
			
		}finally {
			//5. �������
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
		
		
	}//CreateTableDAO
	
}//class
