package day0109;
//19.01.09 테이블 만들기 + 존재하는지? + 삭제 + 재생성
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 *	DDL( Data Definition Language) : create, drop, truncate 을 사용하여
 *	테이블 생성
 * @author owner
 */
public class CreateTable {

	public CreateTable() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1. 드라이버 로딩
		//2. Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			
			String tableName=JOptionPane.showInputDialog("생성할 테이블명 입력");
		//3. //테이블이 존재하는 지?
			StringBuilder selectTname=new StringBuilder();
			selectTname.append("select tname from tab where tname=?"); 
		//4.
			pstmt=con.prepareStatement(selectTname.toString());
			pstmt.setString(1, tableName.toUpperCase());			//오라클에 테이블은 대문자라 toUpper로 맞춰서 바꿔준다.
		//5.
			rs=pstmt.executeQuery();
			boolean flag=false;
			if(rs.next()) {
				flag=JOptionPane.showConfirmDialog(null, tableName+" 테이블이 존재합니다. 삭제한 후 생성하시겠습니까?")
					==JOptionPane.OK_OPTION ;
			}// end if
			
			pstmt.close(); // 여기서 한번 끊어줍니다.
			
			if(flag) { //삭제 한 후 테이블을 생성합니다.
				//3. 테이블 지우기 쿼리
				StringBuilder dropTable=new StringBuilder();
				dropTable.append("drop table ").append(tableName);
				pstmt=con.prepareStatement(dropTable.toString());
				//4.
				pstmt.execute();
				
				//사용했으니 다시 닫아주기.
				pstmt.close();
			}//end if
			
		//3.
			StringBuilder createTable= new StringBuilder(); 
			
			createTable		//table 만드는 쿼리
			.append(" create table ").append( tableName).append("(")
			.append(" name varchar2(12) not null, ")
			.append(" age number(3) not null, ")
			.append(" id varchar2(20) constraint pk_").append( tableName).append(" primary key)");
			
			pstmt=con.prepareStatement( createTable.toString() );
		//4. bind 변수값 넣기
			
		//5. 쿼리문 수행 후 결과 얻기
			pstmt.execute();
			JOptionPane.showMessageDialog(null, "테이블이 생성되었습니다.");
		}finally {
			//6. 연결끊기
			if( rs !=null ) { rs.close(); }
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
		
		
		
	}//CreateTable
	
	
	public static void main(String[] args) {
		try {
			new CreateTable();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "테이블이 이미 존재합니다");
			e.printStackTrace();
		}//end catch
		
		
	}//main	

}//class
