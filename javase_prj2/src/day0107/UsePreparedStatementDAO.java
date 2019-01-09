package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsePreparedStatementDAO {

	public UsePreparedStatementDAO() {
		
	}//UsePreparedStatementDAO 
	
	private Connection getConn() throws SQLException{
		Connection con=null;
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		//2.  DB 연결Connection 얻기
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="scott";
		String pass="tiger";
		con=DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConn
	
	/**
	 * 	사원번호, 사원명, 연봉을 입력받아 CpEmp2테이블에 삽입 하는 일
	 * @param cevo
	 * @throws SQLException
	 */
	public void insertCpEmp2( CpEmp2VO cevo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		
		//1. 드라이버 로딩
		//2. DB연동 Connection 얻기
			con=getConn();    //이런 방법도 되는군...
		//3. 쿼리문 생성객체 얻기 : preparedStatement 객체는 실행되는 쿼리문을 알고있다.
			String insertCpEmp="insert into cp_emp2(empno,ename,hiredate,sal) values(?,?,sysdate,?)";		// ?을 bind변수라고 한다  bind변수 인덱스는 1번부터 시작
			pstmt=con.prepareStatement(insertCpEmp);		
		//4. 바인드 변수에 값 넣기    //4.추가된것. 
			pstmt.setInt(1, cevo.getEmpno());	//empno을 순서대로 인덱스 1번으로 시작
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
			
		//5. 쿼리문 수행후 결과 얻기
			pstmt.executeUpdate();
			
		}finally {
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		//6. 연결끊기
		}//end finally
		
	}//insertCpEmp2
	
	
	/**
	 * 	사원번호, 사원명, 연봉을 입력받아 사원번호의 해당하는 사원명, 연봉을 변경하는 일
	 * @param cevo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCpEmp2( CpEmp2VO cevo) throws SQLException{
		boolean flag=false;
		Connection con =null;
		PreparedStatement pstmt=null;
		
		try {
		//1. 드라이버 로딩
		//2. DB연동 Connection 얻기
			con=getConn();
		//3. 쿼리문 생성객체 얻기
			String updateCpEmp2="update cp_emp2 set ename=?,sal=? where empno=?";
			pstmt=con.prepareStatement(updateCpEmp2);
			
		//4. 바인드 변수에 값 넣기
			pstmt.setString(1, cevo.getEname());
			pstmt.setInt(2, cevo.getSal());
			pstmt.setInt(3, cevo.getEmpno());
			
		//5. 쿼리문 수행후 결과 얻기
			int cnt=pstmt.executeUpdate();
			if( cnt !=0 ) {
				flag=true;
			}//end if
			
		}finally {
		//6. 연결 끊기
		}//end finally
		return flag;
	}//updateCpEmp2
	
	/**
	 * 	사원번호를 입력받아 사원번호에 해당하는 사원을 삭제하는 일
	 * 	
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteCpEmp2( int empno) throws SQLException{
		boolean flag=false;
		Connection con=null;
		PreparedStatement pstmt=null;
	try {
		//1. 드라이버 로딩
		//2. DB연동Connection 얻기
			con=getConn();   //여기가 2번까지
		//3. 쿼리문 생성객체 얻기
			String deleteCpEmp2="delete from cp_emp2 where empno=?";  //바인드변수 쓸 경우 ' 쓰지 않는다.
			pstmt=con.prepareStatement(deleteCpEmp2);
		//4. 바인드 변수 값 설정
			pstmt.setInt(1, empno);
		//5. 쿼리문 수행 후 값 얻기
			int cnt=pstmt.executeUpdate();
			
			if(cnt !=0) {
				flag=true;
			}//end if
	}finally {
		//6. 연결 끊기
		if( pstmt !=null ) { pstmt.close(); }
		if( con !=null ) { con.close(); }
	}//end finally
		return flag;
	}//deleteCpEmp2
	
	/**
	 * 	모든 부서 사원정보를 조회
	 * @return
	 * @throws SQLException
	 */
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException{
		List<CpEmp2AllVO>list=new ArrayList<CpEmp2AllVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	try {	
		//1. 드라이버 로딩
		//2. DB연동 Connection 얻기
		con=getConn();
		//3. 쿼리문 생성객체 얻기
		String selectAllCpEmp2 ="select empno, ename, sal, to_char(hiredate, 'yyyy-mm-dd') hiredate from cp_emp2";
		pstmt=con.prepareStatement(selectAllCpEmp2);
		//4. 바인드 변수 값 얻기
		//?가 없어서 안 생략
		
		//5. 쿼리문 수행수 결과 얻기
		rs=pstmt.executeQuery();
		
		//조회결과를 VO에 할당
		CpEmp2AllVO cda_vo=null;
		while (rs.next()) {
			cda_vo=new CpEmp2AllVO(rs.getInt("empno"), rs.getInt("sal"), 
					rs.getString("ename"), rs.getString("hiredate"));
			
			list.add(cda_vo);
			
		}//end while
		
	}finally {
		//6. 연결 끊기
		if( rs !=null ) { rs.close(); }
		if( pstmt !=null ) { pstmt.close(); }
		if( con !=null ) { con.close(); }
	}//end  finally
		
		return list;
		
	}//selsectAllCpEmp2
	
	/**
	 * 입력되는 사원번호의 
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException{
		CpEmp2OneVO cevo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		//1. 드라이버 로딩
		//2. DB연동 Connection 얻기
			con=getConn();
		//3. 쿼리문 생성객체 얻기
			String selsectOneCpEmp="select ename, sal, hiredate from cp_emp2 where empno=?";
			pstmt=con.prepareStatement(selsectOneCpEmp);
			
		//4. 바인드 변수 값 넣기
			pstmt.setInt(1, empno);
		//5. 쿼리문 수행후 결과 얻기
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cevo=new CpEmp2OneVO(rs.getInt("sal"), rs.getString("ename"),
								rs.getDate("hiredate"));
			}//end if
		}finally {
		//6. 연결 끊기
			if( rs !=null ) { rs.close(); }
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
		
		return cevo;
	}//selectOneCpEmp2
	
/*
	public static void main(String[] args) { //내가 만든메소드가 잘 작동하는지 메인메소드를 생성해서 확인한다.
		//1. 클래스 객체화
		UsePreparedStatementDAO u= new UsePreparedStatementDAO();
		//2.데이터VO도 객체화
//		CpEmp2VO c=new CpEmp2VO(1234,4000,"공선의");
		try {
//			u.deleteCpEmp2(1234);	//삭제하는 method 확인
			
//			List<CpEmp2AllVO>list =u.selectAllCpEmp2();	// 값 전부확인 하는 method 확인 ->주소값만 나옴.
//			System.out.println(list);				//값 나오게 하고싶으면 tostring 으로. 확인해볼것.
			
			CpEmp2OneVO c=u.selectOneCpEmp2(7566);
			System.out.println(c); //월, 일, 년으로 나오게하고 싶으면 simpleformat
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
*/

}//class
