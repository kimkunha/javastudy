package day0110.callalbestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.connection.GetConnection;
import oracle.jdbc.OracleTypes;

/**
 * Procedure를 사용한 CRUD
 * 
 * @author owner
 */
public class UseCallableStatementDAO{
	//private static으로 스태틱 변수 선언한다.
	private static UseCallableStatementDAO ucs_dao ;
	
	private UseCallableStatementDAO() {//생성자를 private로 만든다.
	}
	
	public static UseCallableStatementDAO getInstance() {
		if(ucs_dao== null) {
			ucs_dao = new UseCallableStatementDAO();
		}//end if
		return ucs_dao;
	}//getInstance
	
	/**
	 * test_proc 테이블에 사원번호, 사원명, 연봉,직무를 추가하는 일
	 * 
	 * @param tpvo
	 * @return
	 * @throws SQLException
	 */
	public String insertProc(TestProcVO tpvo) throws SQLException {
		String resultMsg = "";

		Connection con = null;
		CallableStatement cstmt = null;

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = GetConnection.getInstance().getConn(url, id, pass);
			// 3. 프로시저 실행객체 얻기
			cstmt = con.prepareCall(" { call insert_test_proc(?,?,?,?,?,?) } ");
			// 4. 바인드 변수에 값 넣기
				//in parameter
				cstmt.setInt(1, tpvo.getEmpno());
				cstmt.setString(2, tpvo.getEname());
				cstmt.setInt(3, tpvo.getSal());
				cstmt.setString(4, tpvo.getJob());
				//out parameter :프로시저가 처리한 결과를 저장할 데이터형을 설정
				cstmt.registerOutParameter(5, Types.VARCHAR );
				cstmt.registerOutParameter(6, Types.NUMERIC);
			
			// 5.
				
				cstmt.execute();
				//프로시저가 실행된 후 out parameter에 설정된 값 얻기
				resultMsg = cstmt.getString(5);
				int cnt = cstmt.getInt(6);
				System.out.println(cnt);
				System.out.println(resultMsg);
				
		} finally {
			// 6.
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return resultMsg;

	}// insertProc
	
	public String updateProc(TestProcUpdateVO tpuvo)throws SQLException{
		String msg ="";
		
		Connection con = null;
		CallableStatement cstmt = null;
		
		try {
		//1. 
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id ="scott";
			String pass = "tiger";		
			con= GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt = con.prepareCall("{ call update_test_proc(?,?,?,?,?) }");
		//4.
			//bind변수에 값 넣기 => procedure 의 매개변수
			//in parameter
			cstmt.setInt(1, tpuvo.getEmpno() );
			cstmt.setString(2, tpuvo.getJob());
			cstmt.setInt(3, tpuvo.getSal());
			//out parameter :procedure 가 처리한 결과를 저장한 매개변수
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
		//5.
			cstmt.execute();
			//부모의 method 사용 procedure를 실행. ==> 실행결과가 out parameter에 저장
			int cnt = cstmt.getInt(4);
			msg = cstmt.getString(5);
			
			System.out.println("update: " + cnt );
		}finally {
			//6.
			if(cstmt!=null) {cstmt.close();}
			if(con!=null) {con.close();}
		}
		return msg;
	}//updateProc
	
	public String deleteProc(int empno) throws SQLException {
		String msg="";
		
		Connection con=null;
		CallableStatement cstmt=null;
		try {
		//1. 드라이버 로딩
		//2. connection 얻기
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. 
			cstmt=con.prepareCall("{ call delete_test_proc(?,?,?) }");
		//4. 바인드 변수에 값 설정
			//in parameter
			cstmt.setInt(1, empno);
			//out parameter
			cstmt.registerOutParameter(2, Types.VARCHAR );
			cstmt.registerOutParameter(3, Types.NUMERIC );
			
		//5. 쿼리 수행후 결과 얻기
			cstmt.execute();
			//out parameter에 설정된 값 받기
			msg=cstmt.getString(2);
			int cnt=cstmt.getInt(3);
			
			System.out.println(cnt+"건 삭제");
			
		}finally {
			if( cstmt !=null ) { cstmt.close(); }
			if( con !=null ) { con.close(); }
		//6
		}//end finally
		return msg;
	}//end delteProc
	
	public List<TestProcAllVO> selectAllTestProc()throws SQLException{
		List<TestProcAllVO> list=new ArrayList<TestProcAllVO>();
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
		try {
			//1. 드라이버 로딩
			//2. Connection 얻기
				String url="jdbc:oracle:thin:@localhost:1521:orcl";
				String id="scott";
				String pass="tiger";
				
				con=GetConnection.getInstance().getConn(url, id, pass);
			//3. 쿼리문 생성객체 얻기
				cstmt=con.prepareCall("{ call select_all_test_proc(?,?) }"); 
			//4. 바인드 변수값 넣기
				//out parameter : sys_refcursor -> OracleTypes.CURSOR   //in out 순서는 상관없이 해도됨.
				cstmt.registerOutParameter(1, OracleTypes.CURSOR );
//				cstmt.registerOutParameter(1, Types.REF_CURSOR );	//이 방법으로는 안된다. 
				
				//in parameter
				cstmt.setString(2, "mm-dd-yyyy day hh24:mi");
			//5. 쿼리문 수행 후 결과 얻기.
				cstmt.execute();
				//커서의 제어권 받기
				rs=(ResultSet)cstmt.getObject(1);	//상속관계인 자식으로는 casting 이 된다.
				
				//제어권을 받아 조회한 모든 컬럼값을 VO에 할당하고 List 추가
				TestProcAllVO tpavo=null;
				
				while(rs.next()) {
					tpavo=new TestProcAllVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"),rs.getString("hiredate"), rs.getString("job"));
					//반복문 돌린것을 list에 값을 넣어준다.
					list.add( tpavo );
				}//end while
				
		}finally {
			//6. 연결끊기
			if( rs !=null ) { rs.close(); }
			if( cstmt !=null ) { cstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
		return list;
	}//selectAllTestProc
	
	public TestProcOneVO selectOneTestProc(int empno) throws SQLException{
		TestProcOneVO tpovo=null;
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
		try {
		//1. 드라이버 로딩
		//2. Connection 얻기
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. 쿼리문 생성 객체 얻기
			cstmt=con.prepareCall("{ call select_one_test_proc(?,?,?) }");
		//4. 바인드 변수 값 얻기
			//in parameter
			cstmt.setInt(1, empno);
			
			//out parameter
			cstmt.registerOutParameter(2, OracleTypes.CURSOR );
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR ); //Types.VARCHAR 하고 같다.
		
		//5. 쿼리문 수행 후 결과 얻기
			cstmt.execute();
			
			rs=(ResultSet)cstmt.getObject(2);
			if(rs.next()) {
				tpovo=new TestProcOneVO(rs.getInt("sal"), rs.getString("ename"), rs.getString("job"),rs.getString("hiredate"));
			}//end if
		}finally {
		//6. 연결끊기
			if( rs !=null ) { rs.close();}
			if( cstmt !=null ) { cstmt.close();}
			if( con !=null ) { con.close();}
		}//end finally
		return tpovo;
	}//selectOneTestProc
	
	public static void main(String[] args) {
		UseCallableStatementDAO u = new UseCallableStatementDAO();
//		TestProcUpdateVO t = new TestProcUpdateVO(1234 ,3000,"과장");
//		TestProcVO t=new TestProcVO(2222,4200,"공선의","과장");
		
		try {
			System.out.println(u.selectOneTestProc(1234));
//			List<TestProcAllVO> l=u.selectAllTestProc();
//			System.out.println(l);
//			u.insertProc(t);
//			System.out.println(u.deleteProc(1234));
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//end main
	
	
}//class
