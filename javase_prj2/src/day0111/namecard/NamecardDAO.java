package day0111.namecard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day0108.login.preparedStatementLogin;
import kr.co.sist.connection.GetConnection;

/**
 *	DB Table 명함 정보를 추가, 모든 명함 정보를 조회
 * @author owner
 */
public class NamecardDAO {

	private static NamecardDAO n_dao; //싱글톤을 만들기 위한 스태틱
	
	private NamecardDAO() {//생성자.
	}
	
	public static NamecardDAO getInstance() {
		if(n_dao == null) {
			n_dao =new NamecardDAO();
		}//end if
		return n_dao ;
	}//getInstance
	
	public void insertNamecard( NamecardVO nvo) throws SQLException	{	//vo를 매개변수로 받는다.
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1
		//2
			String url="jdbc:oracle:thin:@211.63.89.137:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. 쿼리문 생성객체 얻기
			String insertNamecard="insert into namecard(name,addr,img)values(?,?,?)";
			pstmt=con.prepareStatement(insertNamecard);
		//4 바인드 변수에 값 넣기
			pstmt.setString(1, nvo.getName());
			pstmt.setString(2, nvo.getAddr());
			pstmt.setString(3, nvo.getImg());
		//5. 쿼리문
			pstmt.executeUpdate();
		}finally {
		//6. 연결끊기
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
	}//insertNamecard
	
	public List<NamecardVO> selectNamecard() throws SQLException{
		List<NamecardVO> list=new ArrayList<NamecardVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		//1
		//2
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3
			String selectNamecard="select name, addr, img from namecard order by input_date";//orderby사용으로 순서정렬
			pstmt=con.prepareStatement(selectNamecard);
			
		//4
		//5
			rs=pstmt.executeQuery();
			
			NamecardVO nvo=null;
			while(rs.next()) {
				nvo=new NamecardVO(rs.getString("name"), rs.getString("addr"),rs.getString("img"));
				list.add(nvo);
			}//end while
		}finally {
		//6
			if( rs !=null ) { rs.close();}
			if( pstmt !=null ) {pstmt.close(); }
			if( pstmt !=null ) {pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
		return list;
	}//selectNamecard
	
	
	
	
	
	
	
	
	
	
	//단일 테스트를 위한 main method
	public static void main(String[] args) {
		NamecardDAO n=new NamecardDAO();
		try {
//			System.out.println(n.selectNamecard().size());		//size() method로 쿼리 갯수확인
			n.insertNamecard(new NamecardVO("김건하","서울시 성동구 옥수동","no_image.png"));
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
	
	
	
	
}//class
