package day0109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.connection.GetConnection;

/**
 *	Procedure를 사용한 CRUD
 * @author owner
 */
public class UseCallableStatementDAO {
	//싱글턴 작성 시작
	private static UseCallableStatementDAO ucs_dao;
	
	private UseCallableStatementDAO() {
	}

	public static UseCallableStatementDAO getInstance() {
		if( ucs_dao == null) {
			ucs_dao=new UseCallableStatementDAO();
		}//end if
		return ucs_dao;
	}//getInstance
		//싱글턴 작성 끝
	
	/**
	 * test_proc 테이블에 사원번호, 사원명, 연봉, 직무를 추가하는 일
	 * @param tpvo
	 * @return
	 * @throws SQLException
	 */
	public String insertProc( TestProcVO tpvo ) throws SQLException {
		String resultMsg="";
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
		//1. 드라이버 로딩
		//2. Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. 프로시저  실행 객체 얻기
			cstmt=con.prepareCall(" { call insert_test_proc(?, ?, ?, ?, ?, ?) }"); //in 4개 out 2개
		//4. 바인드 변수 값 얻기
			cstmt.setInt(1, tpvo.getEmpno() );
			cstmt.setString(2, tpvo.getEname());
			cstmt.setInt(3, tpvo.getSal());
			cstmt.setString(4, tpvo.getJob());
			//out parameter : 프로시저가 처리한 결과를 저장할 데이터형을 설정
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.NUMERIC);
			
		//5.
			cstmt.execute();
			//프로시저가 실행된 후 out parameter에 설정된 값 얻기
			resultMsg=cstmt.getString(5);
			int cnt=cstmt.getInt(6);
			System.out.println( cnt );
			
		}finally {
			//6.
			if( cstmt !=null ) { cstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
		return  resultMsg;
	}//insertProc
	
	
	
	public static void main(String[] args) {
		UseCallableStatementDAO u=new UseCallableStatementDAO();
		TestProcVO tp=new TestProcVO(1112, 9000,"김정윤","수강생");
		try {
			System.out.println(u.insertProc(tp));
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
	
}//class
