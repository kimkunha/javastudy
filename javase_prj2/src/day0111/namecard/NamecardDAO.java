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
 *	DB Table ���� ������ �߰�, ��� ���� ������ ��ȸ
 * @author owner
 */
public class NamecardDAO {

	private static NamecardDAO n_dao; //�̱����� ����� ���� ����ƽ
	
	private NamecardDAO() {//������.
	}
	
	public static NamecardDAO getInstance() {
		if(n_dao == null) {
			n_dao =new NamecardDAO();
		}//end if
		return n_dao ;
	}//getInstance
	
	public void insertNamecard( NamecardVO nvo) throws SQLException	{	//vo�� �Ű������� �޴´�.
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1
		//2
			String url="jdbc:oracle:thin:@211.63.89.137:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. ������ ������ü ���
			String insertNamecard="insert into namecard(name,addr,img)values(?,?,?)";
			pstmt=con.prepareStatement(insertNamecard);
		//4 ���ε� ������ �� �ֱ�
			pstmt.setString(1, nvo.getName());
			pstmt.setString(2, nvo.getAddr());
			pstmt.setString(3, nvo.getImg());
		//5. ������
			pstmt.executeUpdate();
		}finally {
		//6. �������
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
			String selectNamecard="select name, addr, img from namecard order by input_date";//orderby������� ��������
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
	
	
	
	
	
	
	
	
	
	
	//���� �׽�Ʈ�� ���� main method
	public static void main(String[] args) {
		NamecardDAO n=new NamecardDAO();
		try {
//			System.out.println(n.selectNamecard().size());		//size() method�� ���� ����Ȯ��
			n.insertNamecard(new NamecardVO("�����","����� ������ ������","no_image.png"));
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
	
	
	
	
}//class
