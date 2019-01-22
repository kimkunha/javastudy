package teamlogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import teamlogin.vo.LoginVO;
import teamlogin.vo.UserInfoVO;

/**
 *	싱글톤 작성
 * @author KIM
 */
public class LoginDAO {

	private static LoginDAO l_dao;
	
	private LoginDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		}//end catch
		
	}//생성자
	
	public static LoginDAO getInstance() {
		if(l_dao==null) {
			l_dao=new LoginDAO();
		}//end if
		return l_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException {
		Connection con=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="tiger";
		con=DriverManager.getConnection(url, id, pass);
		return con;
	}//getConn
	
	public String login(LoginVO lv) throws SQLException {
		String adminEmail="";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;		
		try {		
		//1. 드라이버 로딩
		//2 conneciton 얻기
		con=getConn();
		//3 생성된 쿼리문 얻기
		String selectEmail="SELECT EMAIL FROM SIMPLE_LOGIN WHERE ID=? AND PASSWORD=?";
		pstmt=con.prepareStatement(selectEmail);
		//4 바인드 변수 값 넣기
		pstmt.setString(1, lv.getId() );
		pstmt.setString(2, lv.getPassword());
		
		rs=pstmt.executeQuery();
		//5 쿼리문 수행후 값넣기
		if(rs.next()) {//다음이 있는지
			adminEmail= rs.getString("EMAIL");
		}//end wile
		
		}finally {
		//6 연결 끊기
			if(rs !=null) { rs.close(); }
			if(pstmt !=null) { pstmt.close(); }
			if(con !=null) { con.close(); }
		}//end finally
		
		return adminEmail;
	}//login
	
	public boolean insertInfo(UserInfoVO uivo) throws SQLException {
		boolean flag=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1
		//2
		con=getConn();
		//3
		String insertInfo="insert into simple_login(id,password,tel,email) values(?,?,?,?)";
		//4
		pstmt=con.prepareStatement(insertInfo);
		pstmt.setString(1, uivo.getId());
		pstmt.setString(2, uivo.getPassword());
		pstmt.setString(3, uivo.getTel());
		pstmt.setString(4, uivo.getEmail());
		//5
		pstmt.executeUpdate();
		
		}finally {
		//6
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
	return flag=true;
	}//insertInfo
	
	public List<UserInfoVO>selectAllUser() throws SQLException{
		List<UserInfoVO> list=new ArrayList<>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1
		//2
			con=getConn();
		//3
			String selectAllUser="select id, password, tel, email from simple_login";
			pstmt=con.prepareStatement(selectAllUser);
		//4
			rs=pstmt.executeQuery();
		//5
			UserInfoVO uivo=null;
//			try {
			while(rs.next()) {
			uivo=new UserInfoVO(rs.getString("id"),rs.getString("password"),rs.getString("tel"),rs.getString("email"));
//			}catch(NullPointerException npe) {
//				npe.printStackTrace();
				list.add(uivo);
			}//end while
//			}
			
		}finally {
		//6
			if(rs !=null ) { rs.close(); }
			if(pstmt !=null ) { pstmt.close(); }
			if(con !=null ) { con.close(); }
		}//end finally
	
		return list;
	}//selectAllUser
	
	
	
	
	public static void main(String[] args) {
		LoginDAO ld=new LoginDAO();
		try {
//			System.out.println(getInstance().login(new LoginVO("admin","1234")));
//			System.out.println(getInstance().insertInfo(new UserInfoVO("gong", "1234", "12341234", "gong@naver.com")));
			List<UserInfoVO>list=ld.selectAllUser();
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
	
}//class
