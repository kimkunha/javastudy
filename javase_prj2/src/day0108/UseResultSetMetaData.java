package day0108;
//19.01.08 -    (     )
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

/**
 *	����Ǵ� ��ȸ �������� ����Ͽ� �÷� ������ ���� �� ����ϴ� interface
 * @author owner
 */
public class UseResultSetMetaData  {

	public UseResultSetMetaData() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;   //���� �༮�� �ƴ�
	
	try {
		//2. DB���� Connection ���
			GetConnection gc=GetConnection.getInstance();
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=gc.getConn(url, id, pass);
		//3. ������ ������ü ���
			String selectEmp="select * from emp";
			pstmt = con.prepareStatement(selectEmp);
		//4. ���ε� ������ ���
			
		//5. ������ ���� �� ��� ���
			rs=pstmt.executeQuery();
			
			rsmd=rs.getMetaData();
			//�÷��� ���� ���
			
			int cnt=rsmd.getColumnCount();
			System.out.println("�÷��� �� "+cnt);
			
			String columnName = rsmd.getColumnLabel(1);
//			String columnName = rsmd.getColumnName(1);
			System.out.println("ó�� �÷��� �÷��� : "+columnName);
			
			String columnType=rsmd.getColumnTypeName(1);
			System.out.println("ó�� �÷��� �������� �� : "+columnType);
			
			int columnprecision=rsmd.getPrecision(1);
			System.out.println("ó�� �÷��� �������� ũ�� : "+columnprecision);
			
			System.out.println("--------------------------------------------------------------------------");
			
			StringBuilder output=new StringBuilder();
			
			for (int i=1; i< cnt+1; i++) {
				output
				.append(rsmd.getColumnLabel(i)).append("\t")
//				.(rsmd.getColumnName(i)).append("\t")
				.append(rsmd.getColumnTypeName(i)).append("(")
				.append(rsmd.getPrecision(i)).append(")\n");
			}//end for
			
			System.out.println( output );
	}finally {
		//6. �������
		if( rs != null ) { rs.close(); }
		if( pstmt != null ) { pstmt.close(); }
		if( con != null ) { con.close(); }
	}
		
	}//UseResultSetMetaData
	
	public static void main(String[] args) {
		try {
			new UseResultSetMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
