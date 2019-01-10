package day0104;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *	Statement ��ü�� ����Ͽ� CRUD�� �����ϴ� Ŭ����
 *	CRUD Create Read Update Delete�� ����.
 * @author owner
 */
public class UseStatementCRUD {

	/**
	 *	VO�� �Է¹޾� VO�� ���� CP_DEPT���̺��� �߰�
	 * @param cdvo �μ���ȣ, �μ���, ��ġ�� ���� VO
	 * @throws SQLException 
	 */
	public void insertCpDept(CpDeptVO cdvo) throws SQLException{
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		Statement stmt=null;
		
		try {
		//2. Connection���
				String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";  //url�ܿ�� �ʼ�, 127.0.0.1 �Ǵ� localhost
				String id="scott";
				String pwd="tiger";
				
				con=DriverManager.getConnection(url, id, pwd);
		//3. ������ ������ü ���
				stmt=con.createStatement();
		//4. �������� �� ��� ���   //�乮�ڿ��̹Ƿ� ��Ʈ������ ��Ʈ�� ���� ����Ұ�.
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
		//5. ���� ����
			if( stmt != null) { stmt.close(); }
			if( con != null) { con.close(); }
		}//end finally
		
		
		
	}//insertCpDept
	
	public boolean updateCpDept(CpDeptVO cdvo) throws SQLException{
		boolean flag=false;
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		Connection con=null;
		Statement stmt=null;
		try {
		//2. Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3. ������ ������ü ���
			stmt=con.createStatement();
		//4. ���� ������ ��� ���
			StringBuilder updateCpDept=new StringBuilder();
			updateCpDept
			.append("update cp_dept set ") //������� ����
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());
			
			int cnt=stmt.executeUpdate(updateCpDept.toString());
			//���̺��� ������ �μ���ȣ�� PK�̹Ƿ� ���ุ ���� �ȴ�.
			if(cnt !=0) {
				flag=true;
			}//end if
			
		}finally {
		//5. ���� ����
			if( stmt !=null ) { stmt.close(); } //end if
			if( con !=null ) { con.close(); } //end if
		}//end finally
		
		return flag;
	}//updateCpDept
	
	public boolean deleteCpDept(int deptno) throws SQLException{
		boolean flag=false;
		//1.����̹� �ε�
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		 
		 Connection con=null;
		 Statement stmt=null;
		 
		 try {
		//2.Connection ���
			  String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			  String id="scott";
			  String pass="tiger";
			  con=DriverManager.getConnection(url, id, pass);
		//3.������ ������ü ���
			  stmt=con.createStatement();
		//4.���� ������ ��� ���
			  StringBuilder deleteCpDept=new StringBuilder();
			  deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);
			  
			  int cnt=stmt.executeUpdate(deleteCpDept.toString());
			  if( cnt ==1 ) {		//cnt !=0 �� �ȴ�.
				  flag=true;
				  
			  }//end if
			  
		 }finally {
		//5.���� ����
			 if( stmt != null) { stmt.close(); }
			 if( con != null) { con.close(); }
		 }//end finally
		return flag;
	}//deleteCpDept
	
	
	public List<CpDeptVO> selectAllCpDept()throws SQLException{
		List<CpDeptVO> list=new ArrayList<CpDeptVO>();
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch

		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
				
		try {
		//2. Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=DriverManager.getConnection(url, id, pass);
		//3. ������ ������ü ���
			stmt=con.createStatement();
		//4. ������ ������ ��� ���
			String selectCpDept="select deptno,dname,loc from cp_dept";	// +�ȵ��� String���� ���� ���� 
			
			rs=stmt.executeQuery( selectCpDept );  //�ٸ��Ͱ� �ٸ��� ���⼭ �߰���
			CpDeptVO cdvo=null;
			
			while(rs.next()) { //��ȸ�� ���ڵ尡 �����Ѵٸ�
				
				//�ε��� 0���� Ŀ�� �ڸ��� ��¾ȵȴ�. ���� : �������� ���� ����
//				System.out.println( rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				//�÷������� ��ȸ. �� ����� ��ȣ��
//				System.out.println( rs.getInt("deptno")+" "+rs.getString("dname")+" "+rs.getString("loc"));	
				
				//��ȸ����� VO�� ����
				cdvo=new CpDeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				
				//�����̸����� ������ cdvo��ü�� ������� �ʵ��� �����ϱ����� List�� �߰�
				list.add(cdvo);
				
				
			}//end while
			
		}finally {
		//5 ���� ����
			if( rs !=null ) { rs.close(); }
			if( stmt !=null ) { stmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
	
		
		return list;
	}//selectAllCpDept
	
	
	public OneCpDeptVO selectCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo=null;
		//1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2. Connection ���
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="scott";
		String pass="tiger";
			
		con=DriverManager.getConnection(url, id, pass);
		//3. ������ ���� ��ü ���
		stmt=con.createStatement();
		//4. ���� ������ ��� ���
		StringBuilder selectCpdept=new StringBuilder();
		selectCpdept.append("select dname,loc from cp_dept where deptno=")
		.append(deptno);
		
		rs=stmt.executeQuery(selectCpdept.toString());
		
		if(rs.next()) { //��ȸ�� ���ڵ尡 �����Ѵٸ�			//if���� ������ primarykey ���� ������ �־ ��¥�� �ϳ��ۿ� ����. �������  while
			ocdvo=new OneCpDeptVO(rs.getString("dname"), rs.getString("loc"));
		}//end while
		
		
		
		
		}finally {
		//5. �������
		if( rs !=null ) { rs.close(); }
		if( stmt !=null ) { stmt.close(); }
		if( con !=null ) { con.close(); }
		}//end finally
		
		
		return ocdvo;
	}//selectCpDept

	/**
	 * 	CP_DEPT ���̺��� ��� �μ���ȣ�� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectAllCpDeptNo() throws SQLException{
		List<Integer> list=new ArrayList<Integer>();
		
		//1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		ResultSet rs=null;
		Connection con=null;
		Statement stmt=null;
		
		//2. Connection ���
		try {
		
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		
		//3. ������ ���� ���
			stmt=con.createStatement();
			
		//4. ���� ������ 
			String selectCpDept ="select deptno from cp_dept";
			rs=stmt.executeQuery(selectCpDept.toString());
			
			while(rs.next()) {
//				list.add(new Integer(rs.getInt("deptno"))); //����ڽ����� ���Ұ�� �̸��ϸ� ��
				list.add(rs.getInt("deptno"));	//����ڽ����� ó������
			}//end while
			
		}finally {
		//5. ���� ����
			if( rs !=null ) { rs.close(); }
			if( con !=null ) { con.close(); }
			if( stmt !=null ) { stmt.close(); }
		}//end finally
		
		
		
		
	return list;
	}//selectAllCpDeptno
	
	
	
	
	
	
	
	
	
	
	
	
	/*  ��� �׽�Ʈ������ ���� main method
	  	public static void main(String[] args) {
		UseStatementCRUD u =new UseStatementCRUD();
		
		try {
			u.selectAllCpDept();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/
	
}//class