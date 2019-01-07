package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	
	public boolean updateCpEmp2( CpEmp2VO cevo) throws SQLException{
		boolean flag=false;
		
		return flag;
	}//updateCpEmp2
	
	public boolean deleteCpEmp2( int empno) throws SQLException{
		boolean flag=false;
		
		return flag;
	}//deleteCpEmp2
	
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException{
		List<CpEmp2AllVO>list=new ArrayList<CpEmp2AllVO>();
		
		return list;
		
	}//selsectAllCpEmp2
	
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException{
		CpEmp2OneVO cevo=null;
		
		return cevo;
	}//selectOneCpEmp2
	
/*	
	public static void main(String[] args) { //내가 만든메소드가 잘 작동하는지 메인메소드를 생성해서 확인한다.
		//1. 클래스 객체화
		UsePreparedStatementDAO u= new UsePreparedStatementDAO();
		//2.데이터VO도 객체화
		CpEmp2VO c=new CpEmp2VO(9876,3000,"김희철");
		try {
			u.insertCpEmp2(c);	//메소드 불러서 값을 넣어본다 매개변수를 받기때문에 그런거임.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
*/	
	
}//class
