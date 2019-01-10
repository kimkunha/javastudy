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
 * Procedure�� ����� CRUD
 * 
 * @author owner
 */
public class UseCallableStatementDAO{
	//private static���� ����ƽ ���� �����Ѵ�.
	private static UseCallableStatementDAO ucs_dao ;
	
	private UseCallableStatementDAO() {//�����ڸ� private�� �����.
	}
	
	public static UseCallableStatementDAO getInstance() {
		if(ucs_dao== null) {
			ucs_dao = new UseCallableStatementDAO();
		}//end if
		return ucs_dao;
	}//getInstance
	
	/**
	 * test_proc ���̺� �����ȣ, �����, ����,������ �߰��ϴ� ��
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
			// 3. ���ν��� ���ఴü ���
			cstmt = con.prepareCall(" { call insert_test_proc(?,?,?,?,?,?) } ");
			// 4. ���ε� ������ �� �ֱ�
				//in parameter
				cstmt.setInt(1, tpvo.getEmpno());
				cstmt.setString(2, tpvo.getEname());
				cstmt.setInt(3, tpvo.getSal());
				cstmt.setString(4, tpvo.getJob());
				//out parameter :���ν����� ó���� ����� ������ ���������� ����
				cstmt.registerOutParameter(5, Types.VARCHAR );
				cstmt.registerOutParameter(6, Types.NUMERIC);
			
			// 5.
				
				cstmt.execute();
				//���ν����� ����� �� out parameter�� ������ �� ���
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
			//bind������ �� �ֱ� => procedure �� �Ű�����
			//in parameter
			cstmt.setInt(1, tpuvo.getEmpno() );
			cstmt.setString(2, tpuvo.getJob());
			cstmt.setInt(3, tpuvo.getSal());
			//out parameter :procedure �� ó���� ����� ������ �Ű�����
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
		//5.
			cstmt.execute();
			//�θ��� method ��� procedure�� ����. ==> �������� out parameter�� ����
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
		//1. ����̹� �ε�
		//2. connection ���
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. 
			cstmt=con.prepareCall("{ call delete_test_proc(?,?,?) }");
		//4. ���ε� ������ �� ����
			//in parameter
			cstmt.setInt(1, empno);
			//out parameter
			cstmt.registerOutParameter(2, Types.VARCHAR );
			cstmt.registerOutParameter(3, Types.NUMERIC );
			
		//5. ���� ������ ��� ���
			cstmt.execute();
			//out parameter�� ������ �� �ޱ�
			msg=cstmt.getString(2);
			int cnt=cstmt.getInt(3);
			
			System.out.println(cnt+"�� ����");
			
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
			//1. ����̹� �ε�
			//2. Connection ���
				String url="jdbc:oracle:thin:@localhost:1521:orcl";
				String id="scott";
				String pass="tiger";
				
				con=GetConnection.getInstance().getConn(url, id, pass);
			//3. ������ ������ü ���
				cstmt=con.prepareCall("{ call select_all_test_proc(?,?) }"); 
			//4. ���ε� ������ �ֱ�
				//out parameter : sys_refcursor -> OracleTypes.CURSOR   //in out ������ ������� �ص���.
				cstmt.registerOutParameter(1, OracleTypes.CURSOR );
//				cstmt.registerOutParameter(1, Types.REF_CURSOR );	//�� ������δ� �ȵȴ�. 
				
				//in parameter
				cstmt.setString(2, "mm-dd-yyyy day hh24:mi");
			//5. ������ ���� �� ��� ���.
				cstmt.execute();
				//Ŀ���� ����� �ޱ�
				rs=(ResultSet)cstmt.getObject(1);	//��Ӱ����� �ڽ����δ� casting �� �ȴ�.
				
				//������� �޾� ��ȸ�� ��� �÷����� VO�� �Ҵ��ϰ� List �߰�
				TestProcAllVO tpavo=null;
				
				while(rs.next()) {
					tpavo=new TestProcAllVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"),rs.getString("hiredate"), rs.getString("job"));
					//�ݺ��� �������� list�� ���� �־��ش�.
					list.add( tpavo );
				}//end while
				
		}finally {
			//6. �������
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
		//1. ����̹� �ε�
		//2. Connection ���
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. ������ ���� ��ü ���
			cstmt=con.prepareCall("{ call select_one_test_proc(?,?,?) }");
		//4. ���ε� ���� �� ���
			//in parameter
			cstmt.setInt(1, empno);
			
			//out parameter
			cstmt.registerOutParameter(2, OracleTypes.CURSOR );
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR ); //Types.VARCHAR �ϰ� ����.
		
		//5. ������ ���� �� ��� ���
			cstmt.execute();
			
			rs=(ResultSet)cstmt.getObject(2);
			if(rs.next()) {
				tpovo=new TestProcOneVO(rs.getInt("sal"), rs.getString("ename"), rs.getString("job"),rs.getString("hiredate"));
			}//end if
		}finally {
		//6. �������
			if( rs !=null ) { rs.close();}
			if( cstmt !=null ) { cstmt.close();}
			if( con !=null ) { con.close();}
		}//end finally
		return tpovo;
	}//selectOneTestProc
	
	public static void main(String[] args) {
		UseCallableStatementDAO u = new UseCallableStatementDAO();
//		TestProcUpdateVO t = new TestProcUpdateVO(1234 ,3000,"����");
//		TestProcVO t=new TestProcVO(2222,4200,"������","����");
		
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
