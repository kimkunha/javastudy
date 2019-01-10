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
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			//2. Connection 얻기
				String url="jdbc:oracle:thin:@127.0.0.1:1520:orcl";
				String id="scott";
				String pass="tiger";
			con = DriverManager.getConnection(url, id, pass);
			//3. 쿼리문 생성후 객체 얻기
			pstmt=con.prepareStatement(sql);
			//4. 쿼리문 수행 후 결과 얻기
			pstmt.execute();
			JOptionPane.showMessageDialog(ctv, "테이블이 생성 되었습니다.");
			
		}finally {
			//5. 연결끊기
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
		
		
	}//CreateTableDAO
	
}//class
