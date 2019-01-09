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
 *	실행되는 조회 쿼리문을 사용하여 컬럼 정보를 얻을 때 사용하는 interface
 * @author owner
 */
public class UseResultSetMetaData  {

	public UseResultSetMetaData() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;   //끊는 녀석이 아님
	
	try {
		//2. DB연동 Connection 얻기
			GetConnection gc=GetConnection.getInstance();
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=gc.getConn(url, id, pass);
		//3. 쿼리문 생성객체 얻기
			String selectEmp="select * from emp";
			pstmt = con.prepareStatement(selectEmp);
		//4. 바인드 변수값 얻기
			
		//5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			rsmd=rs.getMetaData();
			//컬럼의 정보 얻기
			
			int cnt=rsmd.getColumnCount();
			System.out.println("컬럼의 수 "+cnt);
			
			String columnName = rsmd.getColumnLabel(1);
//			String columnName = rsmd.getColumnName(1);
			System.out.println("처음 컬럼의 컬럼명 : "+columnName);
			
			String columnType=rsmd.getColumnTypeName(1);
			System.out.println("처음 컬럼의 데이터형 명 : "+columnType);
			
			int columnprecision=rsmd.getPrecision(1);
			System.out.println("처음 컬럼의 데이터형 크기 : "+columnprecision);
			
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
		//6. 연결끊기
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
