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
		//1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		//2.  DB ����Connection ���
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
		
		//1. ����̹� �ε�
		//2. DB���� Connection ���
			con=getConn();    //�̷� ����� �Ǵ±�...
		//3. ������ ������ü ��� : preparedStatement ��ü�� ����Ǵ� �������� �˰��ִ�.
			String insertCpEmp="insert into cp_emp2(empno,ename,hiredate,sal) values(?,?,sysdate,?)";		// ?�� bind������� �Ѵ�  bind���� �ε����� 1������ ����
			pstmt=con.prepareStatement(insertCpEmp);		
		//4. ���ε� ������ �� �ֱ�    //4.�߰��Ȱ�. 
			pstmt.setInt(1, cevo.getEmpno());	//empno�� ������� �ε��� 1������ ����
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
			
		//5. ������ ������ ��� ���
			pstmt.executeUpdate();
			
		}finally {
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		//6. �������
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
	public static void main(String[] args) { //���� ����޼ҵ尡 �� �۵��ϴ��� ���θ޼ҵ带 �����ؼ� Ȯ���Ѵ�.
		//1. Ŭ���� ��üȭ
		UsePreparedStatementDAO u= new UsePreparedStatementDAO();
		//2.������VO�� ��üȭ
		CpEmp2VO c=new CpEmp2VO(9876,3000,"����ö");
		try {
			u.insertCpEmp2(c);	//�޼ҵ� �ҷ��� ���� �־�� �Ű������� �ޱ⶧���� �׷�����.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
*/	
	
}//class
