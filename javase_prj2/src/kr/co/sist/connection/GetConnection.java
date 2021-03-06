package kr.co.sist.connection;
//19.01.08 생성 
/**
 *	Singleton pattern으로 만드는 클래스
 *	DB Connection을 반환하는 일.
 * @author owner
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private static GetConnection gc ;
	
	private GetConnection() {
		
	}//private 생성자
	
	public static GetConnection getInstance() {
		if( gc == null) {
			gc=new GetConnection();
		}//end if
		
		return gc;
	}//getInstance
	
	public Connection getConn(String url, String id, String pass) throws SQLException{
		Connection con=null;
			//1. 드라이버 로딩
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}//end catch
			
			//2. Connection 얻기
			con=DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConn
	
}//class
