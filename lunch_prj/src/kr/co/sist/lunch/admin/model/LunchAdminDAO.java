package kr.co.sist.lunch.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.admin.vo.AdminLoginVO;
import kr.co.sist.lunch.admin.vo.LunchVO;

public class LunchAdminDAO {

	private static LunchAdminDAO la_dao;
	
	private LunchAdminDAO() { // 생성자를 private로
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}//생성자
	
	public static LunchAdminDAO getInstance() {	//싱글턴 작성
		if(la_dao == null) {
			la_dao=new LunchAdminDAO();
		}//end if
		return la_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException {
		Connection con=null;
		//2. connection 얻기
		String url="jdbc:oracle:thin:@211.63.89.137:1521:orcl";
		String id="scott";
		String pass="tiger";
		con=DriverManager.getConnection(url, id, pass);
		return con;
		
	}//getConn
	
	
	
	
	/**
	 * 	ID 와 PASSWORD를 입력받아 lunch_admin에서 이름을 조회하는 일
	 * @param alvo
	 * @return
	 * @throws SQLException
	 */
	public String login( AdminLoginVO alvo ) throws SQLException{
		String adminName="";
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectName="SELECT NAME FROM LUNCH_ADMIN WHERE ID=? AND PASS=?";
			pstmt=con.prepareStatement(selectName);
		//4
			pstmt.setString(1, alvo.getId());
			pstmt.setString(2, alvo.getPass());
		//5
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				adminName=rs.getString("NAME");
			}//end if
			
		}finally {
		//6. 연결 끊기
			if( rs != null ) { rs.close();}
			if( pstmt != null ) { pstmt.close();}
			if( con != null ) { con.close();}
			
		}//end finally
		
		
		
		return adminName;
	}//login
	
	/**
	 * 	입력된 도시락의 코드, 이미지, 도시락명, 단가, 조회
	 * @return
	 * @throws SQLException
	 */
	public List<LunchVO>selectLunch() throws SQLException{ //런치vo들어가서 설정해야한다.
		List<LunchVO>list=new ArrayList<LunchVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1. 드라이버 로딩
		//2 connection 얻기
		con=getConn();
		//3. 쿼리 생성객체 얻기
		String selectAllLunch="SELECT LUNCH_CODE, LUNCH_NAME,IMG,PRICE FROM LUNCH";
		pstmt=con.prepareStatement(selectAllLunch);
		
		LunchVO lv= null;
		//4
		rs=pstmt.executeQuery();
		//5
		while(rs.next()) {
			lv=new LunchVO(rs.getString("LUNCH_CODE"), rs.getString("LUNCH_NAME"), rs.getString("IMG"), rs.getInt("PRICE"));
			list.add(lv);
		}//end wile
		}finally {
		//6. 연결끊기
			if( rs != null ) { rs.close(); }
			if( pstmt != null ) { pstmt.close(); }
			if( con != null ) { con.close(); }
		}//end finally
		
		return list;
	}//selectLunch
	
	
	
	
	public static void main(String[] args) {
		try {
//			System.out.println(getInstance().login(new AdminLoginVO("root", "1234"))); // 단위 테스트 
			System.out.println(getInstance().selectLunch()); // 단위 테스트 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
	
}//class
