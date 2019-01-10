package day0109.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import day0108.login.preparedStatementLogin;
import kr.co.sist.connection.GetConnection;

/**
 *	DDL : create, drop, truncate DDL임
 *	테이블 생성
 * @author owner
 */
public class CreateTable {

		public CreateTable() throws SQLException{
			Connection con=null;
			preparedStatementLogin pstmt=null;
			ResultSet rs=null;
			
			try {
			//1. 드라이버 로딩
			//2 커넥션 얻기
				String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
				String id="scott";
				String pass="tiger";
				con=GetConnection.getInstance().getConn(url, id, pass);
			//3 쿼리문 생성객체 얻기
			//4 바인드
			//5
			//6
			
			
			
			
			
			
		}//생성자
		
}//class
