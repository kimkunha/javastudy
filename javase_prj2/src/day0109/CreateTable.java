package day0109;
//19.01.09 ���̺� ����� + �����ϴ���? + ���� + �����
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 *	DDL( Data Definition Language) : create, drop, truncate �� ����Ͽ�
 *	���̺� ����
 * @author owner
 */
public class CreateTable {

	public CreateTable() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1. ����̹� �ε�
		//2. Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			
			String tableName=JOptionPane.showInputDialog("������ ���̺�� �Է�");
		//3. //���̺��� �����ϴ� ��?
			StringBuilder selectTname=new StringBuilder();
			selectTname.append("select tname from tab where tname=?"); 
		//4.
			pstmt=con.prepareStatement(selectTname.toString());
			pstmt.setString(1, tableName.toUpperCase());			//����Ŭ�� ���̺��� �빮�ڶ� toUpper�� ���缭 �ٲ��ش�.
		//5.
			rs=pstmt.executeQuery();
			boolean flag=false;
			if(rs.next()) {
				flag=JOptionPane.showConfirmDialog(null, tableName+" ���̺��� �����մϴ�. ������ �� �����Ͻðڽ��ϱ�?")
					==JOptionPane.OK_OPTION ;
			}// end if
			
			pstmt.close(); // ���⼭ �ѹ� �����ݴϴ�.
			
			if(flag) { //���� �� �� ���̺��� �����մϴ�.
				//3. ���̺� ����� ����
				StringBuilder dropTable=new StringBuilder();
				dropTable.append("drop table ").append(tableName);
				pstmt=con.prepareStatement(dropTable.toString());
				//4.
				pstmt.execute();
				
				//��������� �ٽ� �ݾ��ֱ�.
				pstmt.close();
			}//end if
			
		//3.
			StringBuilder createTable= new StringBuilder(); 
			
			createTable		//table ����� ����
			.append(" create table ").append( tableName).append("(")
			.append(" name varchar2(12) not null, ")
			.append(" age number(3) not null, ")
			.append(" id varchar2(20) constraint pk_").append( tableName).append(" primary key)");
			
			pstmt=con.prepareStatement( createTable.toString() );
		//4. bind ������ �ֱ�
			
		//5. ������ ���� �� ��� ���
			pstmt.execute();
			JOptionPane.showMessageDialog(null, "���̺��� �����Ǿ����ϴ�.");
		}finally {
			//6. �������
			if( rs !=null ) { rs.close(); }
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
		
		
		
	}//CreateTable
	
	
	public static void main(String[] args) {
		try {
			new CreateTable();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���̺��� �̹� �����մϴ�");
			e.printStackTrace();
		}//end catch
		
		
	}//main	

}//class
