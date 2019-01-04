package day0104;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *	Statement 객체를 사용하여 CRUD를 구현하는 클래스
 *	CRUD Create Read Update Delete의 약자.
 * @author owner
 */
public class UseStatementCRUD {

	/**
	 *	VO를 입력받아 VO의 값을 CP_DEPT테이블에 추가
	 * @param cdvo 부서번호, 부서명, 위치를 가진 VO
	 * @throws SQLException 
	 */
	public void insertCpDept(CpDeptVO cdvo) throws SQLException{
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		Statement stmt=null;
		
		try {
		//2. Connection얻기
				String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";  //url외우기 필수, 127.0.0.1 또는 localhost
				String id="scott";
				String pwd="tiger";
				
				con=DriverManager.getConnection(url, id, pwd);
		//3. 쿼리문 생성객체 얻기
				stmt=con.createStatement();
		//4. 쿼리수행 후 결과 얻기   //긴문자열이므로 스트링보다 스트링 빌더 사용할것.
//				String insertCpdpet = "insert into cp_dept(deptno,dname,loc) values("+
//								cdvo.getDname()+",'"+cdvo.getDname()+"',' "+cdvo.getLoc()+"')"; 
				StringBuilder insertCpDept=new StringBuilder();
				insertCpDept.append("insert into cp_dept(deptno,dname,loc) values(").
				append(cdvo.getDeptno()).append(",' ")
				.append(cdvo.getDname()).append("',' ")
				.append(cdvo.getLoc()).append("')");
				
				int cnt=stmt.executeUpdate(insertCpDept.toString());
				System.out.println(cnt);
				
		}finally {
		//5. 연결 끊기
			if( stmt != null) { stmt.close(); }
			if( con != null) { con.close(); }
		}//end finally
		
		
		
	}//insertCpDept
	
	public boolean updateCpDept(CpDeptVO cdvo) throws SQLException{
		boolean flag=false;
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		Connection con=null;
		Statement stmt=null;
		try {
		//2. Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3. 쿼리문 생성객체 얻기
			stmt=con.createStatement();
		//4. 쿼리 수행후 결과 얻기
			StringBuilder updateCpDept=new StringBuilder();
			updateCpDept
			.append("update cp_dept set ") //띄워쓰기 주의
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());
			
			int cnt=stmt.executeUpdate(updateCpDept.toString());
			//테이블의 구조상 부서번호는 PK이므로 한행만 변경 된다.
			if(cnt !=0) {
				flag=true;
			}//end if
			
		}finally {
		//5. 연결 끊기
			if( stmt !=null ) { stmt.close(); } //end if
			if( con !=null ) { con.close(); } //end if
		}//end finally
		
		return flag;
	}//updateCpDept
	
	public boolean deleteCpDept(int deptno) throws SQLException{
		boolean flag=false;
		//1.드라이버 로딩
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		 
		 Connection con=null;
		 Statement stmt=null;
		 
		 try {
		//2.Connection 얻기
			  String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			  String id="scott";
			  String pass="tiger";
			  con=DriverManager.getConnection(url, id, pass);
		//3.쿼리문 생성객체 얻기
			  stmt=con.createStatement();
		//4.쿼리 수행후 결과 얻기
			  StringBuilder deleteCpDept=new StringBuilder();
			  deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);
			  
			  int cnt=stmt.executeUpdate(deleteCpDept.toString());
			  if( cnt ==1 ) {		//cnt !=0 도 된다.
				  flag=true;
				  
			  }//end if
			  
		 }finally {
		//5.연결 끊기
			 if( stmt != null) { stmt.close(); }
			 if( con != null) { con.close(); }
		 }//end finally
		return flag;
	}//deleteCpDept
	
	
	public List<CpDeptVO> selectAllCpDept()throws SQLException{
		List<CpDeptVO> list=new ArrayList<CpDeptVO>();
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch

		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
				
		try {
		//2. Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 생성객체 얻기
			stmt=con.createStatement();
		//4. 쿼리문 수행후 결과 얻기
			String selectCpDept="select deptno,dname,loc from cp_dept";	// +안들어가면 String으로 만들어도 무방 
			
			rs=stmt.executeQuery( selectCpDept );  //다른것과 다르게 여기서 추가됨
			CpDeptVO cdvo=null;
			
			while(rs.next()) { //조회된 레코드가 존재한다면
				
				//인덱스 0번은 커서 자리라서 출력안된다. 단점 : 가독성이 좋지 않음
//				System.out.println( rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				//컬럼명으로 조회. 이 방법을 선호함
//				System.out.println( rs.getInt("deptno")+" "+rs.getString("dname")+" "+rs.getString("loc"));	
				
				//조회결과를 VO에 저장
				cdvo=new CpDeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				
				//같은이름으로 생성된 cdvo객체를 사라지지 않도록 관리하기위해 List에 추가
				list.add(cdvo);
				
				
			}//end while
			
		}finally {
		//5 연결 끊기
			if( rs !=null ) { rs.close(); }
			if( stmt !=null ) { stmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
	
		
		return list;
	}//selectAllCpDept
	
	
	public OneCpDeptVO selectCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo=null;
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2. Connection 얻기
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="scott";
		String pass="tiger";
			
		con=DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 생성 객체 얻기
		stmt=con.createStatement();
		//4. 쿼리 수행후 결과 얻기
		StringBuilder selectCpdept=new StringBuilder();
		selectCpdept.append("select dname,loc from cp_dept where deptno=")
		.append(deptno);
		
		rs=stmt.executeQuery(selectCpdept.toString());
		
		if(rs.next()) { //조회된 레코드가 존재한다면			//if쓰는 이유는 primarykey 제약 사항이 있어서 어짜피 하나밖에 없음. 많을경우  while
			ocdvo=new OneCpDeptVO(rs.getString("dname"), rs.getString("loc"));
		}//end while
		
		
		
		
		}finally {
		//5. 연결끊기
		if( rs !=null ) { rs.close(); }
		if( stmt !=null ) { stmt.close(); }
		if( con !=null ) { con.close(); }
		}//end finally
		
		
		return ocdvo;
	}//selectCpDept

	/**
	 * 	CP_DEPT 테이블의 모든 부서번호를 조회
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectAllCpDeptNo() throws SQLException{
		List<Integer> list=new ArrayList<Integer>();
		
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		ResultSet rs=null;
		Connection con=null;
		Statement stmt=null;
		
		//2. Connection 얻기
		try {
		
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		
		//3. 쿼리문 생성 얻기
			stmt=con.createStatement();
			
		//4. 쿼리 얻은후 
			String selectCpDept ="select deptno from cp_dept";
			rs=stmt.executeQuery(selectCpDept.toString());
			
			while(rs.next()) {
//				list.add(new Integer(rs.getInt("deptno"))); //오토박싱으로 안할경우 이리하면 됨
				list.add(rs.getInt("deptno"));	//오토박싱으로 처리해줌
			}//end while
			
		}finally {
		//5. 연결 끊기
			if( rs !=null ) { rs.close(); }
			if( con !=null ) { con.close(); }
			if( stmt !=null ) { stmt.close(); }
		}//end finally
		
		
		
		
	return list;
	}//selectAllCpDeptno
	
	
	
	
	
	
	
	
	
	
	
	
	/*  출력 테스트용으로 만든 main method
	  	public static void main(String[] args) {
		UseStatementCRUD u =new UseStatementCRUD();
		
		try {
			u.selectAllCpDept();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/
	
}//class
