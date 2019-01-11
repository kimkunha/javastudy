package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

public class getconn {

	private static getconn gc;
	
	private getconn() {
	}//private 생성자
	
	private static getconn getinstance() {
		if( gc==null) {
			gc=new getconn();
		}
		return gc;
	}
	
	public Connection getConn(String url, String id, String pass ) throws SQLException {
		Connection con=null;
		
		//1. 드라이버 로딩
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}//end catch
		
		//2. Connection
			con=DriverManager.getConnection(url, id, pass);
	
		
		return con;
	}

	
	
	public static void main(String[] args) {
		
	
	} 
}//clsas
