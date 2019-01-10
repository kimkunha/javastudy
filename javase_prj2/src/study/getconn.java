package study;

import java.sql.Connection;
import java.sql.DriverManager;

import kr.co.sist.connection.GetConnection;

public class getconn {

	private static getconn gc;
	
	private getconn() {
	}//private »ý¼ºÀÚ
	
	private static getconn getinstance() {
		if( gc==null) {
			gc=new getconn();
		}
		return gc;
	}
	
	public Connection getConn(String url, String id, String pass ) {
		Connection con=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="tiger";
		
		con=DriverManager.getConnection(url, id, pass);
		
		
		
		
		return con;
	}

	
	
	public static void main(String[] args) {
		
	
	} 
}//clsas
