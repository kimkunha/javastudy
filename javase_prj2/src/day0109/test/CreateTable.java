package day0109.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import day0108.login.preparedStatementLogin;
import kr.co.sist.connection.GetConnection;

/**
 *	DDL : create, drop, truncate DDL��
 *	���̺� ����
 * @author owner
 */
public class CreateTable {

		public CreateTable() throws SQLException{
			Connection con=null;
			preparedStatementLogin pstmt=null;
			ResultSet rs=null;
			
			try {
			//1. ����̹� �ε�
			//2 Ŀ�ؼ� ���
				String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
				String id="scott";
				String pass="tiger";
				con=GetConnection.getInstance().getConn(url, id, pass);
			//3 ������ ������ü ���
			//4 ���ε�
			//5
			//6
			
			
			
			
			
			
		}//������
		
}//class
