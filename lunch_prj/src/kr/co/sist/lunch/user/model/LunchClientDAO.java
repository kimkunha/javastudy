package kr.co.sist.lunch.user.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchLIstVO;
import kr.co.sist.lunch.user.vo.OrderAddVO;
import kr.co.sist.lunch.user.vo.OrderInfoVO;
import kr.co.sist.lunch.user.vo.OrderListVO;
import oracle.jdbc.OracleTypes;

/**
 *	���ö� �ֹ��ڿ� ���� DBó�� 
 * @author owner
 */
public class LunchClientDAO {

	private static LunchClientDAO lc_dao;
	
	 private LunchClientDAO() {
		 
	try {
		Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}//endcatch
		 
		
	}//������
	
	public static LunchClientDAO getInstance() {
		if(lc_dao == null) {
			lc_dao=new LunchClientDAO();
		}//end if
		return lc_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException {
		Connection con=null;
	//2
		String url="jdbc:oracle:thin:@211.63.89.137:1521:orcl";
		String id="scott";
		String pass="tiger";
		con=DriverManager.getConnection(url, id, pass);
	
		return con;
	}//getConn
	
	/**
	 * 	DB�� �߰��� ��� ���ö��� ��� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	public List<LunchLIstVO> selectLunchList( )throws SQLException{
		List<LunchLIstVO>list=new ArrayList<LunchLIstVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//1 ����̹� �ε�
		//2 connecton ���
		try {
		con=getConn();
		//3 
		String selectLunch="	select lunch_code, lunch_name, img, spec from lunch order by lunch_code desc";
		pstmt=con.prepareStatement(selectLunch);
		
		//4
		rs=pstmt.executeQuery();
		
		LunchLIstVO llv=null;
		
		while(rs.next()) {						//" �Ķ����� " �������� ����Ŭ �������ϰ� ������� VO�� ���� ������ �ִ�.
			llv=new LunchLIstVO(rs.getString("img"),rs.getString("lunch_code"), rs.getString("lunch_name"),rs.getString("spec"));//����Ŭ���� �������� ������
			list.add(llv);
		}//end while
		//5
		}finally {
		//6
			if( rs != null) { rs.close(); }
			if( pstmt != null) { pstmt.close(); }
			if( con != null) { con.close(); }
		}//end finally
		
		return list;
	}//selectLunchList
	
	/**
	 * 	���ö��� ������ ��ȸ
	 * @param lunchCode
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String lunchCode) throws SQLException{
		LunchDetailVO ldvo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectLunch="select img, lunch_name, spec, lunch_req, price from lunch where lunch_code=?";
		//4.
			pstmt=con.prepareStatement(selectLunch);
			
			pstmt.setString(1, lunchCode);
		//5.
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				ldvo=new LunchDetailVO(lunchCode, rs.getString("lunch_name"), rs.getString("img"), rs.getString("spec"), rs.getString("lunch_req"),rs.getInt("price"));
				
			}//end if
			
		}finally {
		//6.
			if(rs!=null) { rs.close();}
			if(pstmt!=null) { pstmt.close();}
			if(con!=null) { con.close();}
		}//end finally
		
//		List<LunchDetailVO>list=lad
		return ldvo;
		
	}//selectDetailLunch
	
	public void insertOrder(OrderAddVO oavo)throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.	
		//2.
			con=getConn();
			
		//3.
			String insertOrder="insert into ordering(order_num, quan, order_name, phone, ip_address, lunch_code) values(order_code, ?, ?, ?, ?, ?)";
			pstmt=con.prepareStatement(insertOrder);
			
			//4.
			pstmt.setInt(1, oavo.getQuan());
			pstmt.setString(2, oavo.getOrderName());
			pstmt.setString(3, oavo.getPhone());
			pstmt.setString(4, oavo.getIpAddress());
			pstmt.setString(5, oavo.getLunchCode());
			
		//5.
			pstmt.executeUpdate();
		}finally {
		//6. �������
			if( pstmt !=null ) { pstmt.close();}
			if( con !=null ) { con.close();}
		}//end finally
	}//insertOrder
	
	public List<OrderListVO> selectOrderList(OrderInfoVO oivo) throws SQLException{
		List<OrderListVO>list=new ArrayList<OrderListVO>();
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
		try {
			//1
			//2
			con=getConn();
			//3
			cstmt=con.prepareCall(" { call lunch_order_select(?,?,?) }  ");
			//4
				//in parameter
				cstmt.setString(1, oivo.getOrderName());
				cstmt.setString(2, oivo.getOrderTel());
				//out parameter
				cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			//5. ���� ����( ���ν��� ����)
				cstmt.execute();
				//out parameter�� ����� �� �ڹ��� ����(rs)�� ����
				rs=(ResultSet)cstmt.getObject(3);
				
				OrderListVO olvo=null;
				
				while( rs.next() ) {
					olvo=new OrderListVO(rs.getString("lunch_name"),rs.getString("order_date"), rs.getInt("quan"));
					list.add(olvo);
				}//end while
		}finally {
			//6
			if( rs != null ) { rs.close(); }
			if(  cstmt!= null ) { cstmt.close(); }
			if(	con != null ) { con.close(); }
		}//end finally
		

		return list;
	}//selectOrderList
	
	
	
/*	
  public static void main(String[] args) {
		try {
//			System.out.println(LunchClientDAO.getInstance().selectLunchList());
//			System.out.println(LunchClientDAO.getInstance().selectDetailLunch("L_000002"));
			System.out.println(LunchClientDAO.getInstance().selectOrderList(new OrderInfoVO("������", "010-1231-4231")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
	}//main
	*/
	
}//class
