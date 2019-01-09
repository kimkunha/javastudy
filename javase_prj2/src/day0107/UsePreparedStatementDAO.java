package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	/**
	 * 	�����ȣ, �����, ������ �Է¹޾� CpEmp2���̺� ���� �ϴ� ��
	 * @param cevo
	 * @throws SQLException
	 */
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
	
	
	/**
	 * 	�����ȣ, �����, ������ �Է¹޾� �����ȣ�� �ش��ϴ� �����, ������ �����ϴ� ��
	 * @param cevo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCpEmp2( CpEmp2VO cevo) throws SQLException{
		boolean flag=false;
		Connection con =null;
		PreparedStatement pstmt=null;
		
		try {
		//1. ����̹� �ε�
		//2. DB���� Connection ���
			con=getConn();
		//3. ������ ������ü ���
			String updateCpEmp2="update cp_emp2 set ename=?,sal=? where empno=?";
			pstmt=con.prepareStatement(updateCpEmp2);
			
		//4. ���ε� ������ �� �ֱ�
			pstmt.setString(1, cevo.getEname());
			pstmt.setInt(2, cevo.getSal());
			pstmt.setInt(3, cevo.getEmpno());
			
		//5. ������ ������ ��� ���
			int cnt=pstmt.executeUpdate();
			if( cnt !=0 ) {
				flag=true;
			}//end if
			
		}finally {
		//6. ���� ����
		}//end finally
		return flag;
	}//updateCpEmp2
	
	/**
	 * 	�����ȣ�� �Է¹޾� �����ȣ�� �ش��ϴ� ����� �����ϴ� ��
	 * 	
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteCpEmp2( int empno) throws SQLException{
		boolean flag=false;
		Connection con=null;
		PreparedStatement pstmt=null;
	try {
		//1. ����̹� �ε�
		//2. DB����Connection ���
			con=getConn();   //���Ⱑ 2������
		//3. ������ ������ü ���
			String deleteCpEmp2="delete from cp_emp2 where empno=?";  //���ε庯�� �� ��� ' ���� �ʴ´�.
			pstmt=con.prepareStatement(deleteCpEmp2);
		//4. ���ε� ���� �� ����
			pstmt.setInt(1, empno);
		//5. ������ ���� �� �� ���
			int cnt=pstmt.executeUpdate();
			
			if(cnt !=0) {
				flag=true;
			}//end if
	}finally {
		//6. ���� ����
		if( pstmt !=null ) { pstmt.close(); }
		if( con !=null ) { con.close(); }
	}//end finally
		return flag;
	}//deleteCpEmp2
	
	/**
	 * 	��� �μ� ��������� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException{
		List<CpEmp2AllVO>list=new ArrayList<CpEmp2AllVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	try {	
		//1. ����̹� �ε�
		//2. DB���� Connection ���
		con=getConn();
		//3. ������ ������ü ���
		String selectAllCpEmp2 ="select empno, ename, sal, to_char(hiredate, 'yyyy-mm-dd') hiredate from cp_emp2";
		pstmt=con.prepareStatement(selectAllCpEmp2);
		//4. ���ε� ���� �� ���
		//?�� ��� �� ����
		
		//5. ������ ����� ��� ���
		rs=pstmt.executeQuery();
		
		//��ȸ����� VO�� �Ҵ�
		CpEmp2AllVO cda_vo=null;
		while (rs.next()) {
			cda_vo=new CpEmp2AllVO(rs.getInt("empno"), rs.getInt("sal"), 
					rs.getString("ename"), rs.getString("hiredate"));
			
			list.add(cda_vo);
			
		}//end while
		
	}finally {
		//6. ���� ����
		if( rs !=null ) { rs.close(); }
		if( pstmt !=null ) { pstmt.close(); }
		if( con !=null ) { con.close(); }
	}//end  finally
		
		return list;
		
	}//selsectAllCpEmp2
	
	/**
	 * �ԷµǴ� �����ȣ�� 
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException{
		CpEmp2OneVO cevo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		//1. ����̹� �ε�
		//2. DB���� Connection ���
			con=getConn();
		//3. ������ ������ü ���
			String selsectOneCpEmp="select ename, sal, hiredate from cp_emp2 where empno=?";
			pstmt=con.prepareStatement(selsectOneCpEmp);
			
		//4. ���ε� ���� �� �ֱ�
			pstmt.setInt(1, empno);
		//5. ������ ������ ��� ���
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cevo=new CpEmp2OneVO(rs.getInt("sal"), rs.getString("ename"),
								rs.getDate("hiredate"));
			}//end if
		}finally {
		//6. ���� ����
			if( rs !=null ) { rs.close(); }
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		
		
		return cevo;
	}//selectOneCpEmp2
	
/*
	public static void main(String[] args) { //���� ����޼ҵ尡 �� �۵��ϴ��� ���θ޼ҵ带 �����ؼ� Ȯ���Ѵ�.
		//1. Ŭ���� ��üȭ
		UsePreparedStatementDAO u= new UsePreparedStatementDAO();
		//2.������VO�� ��üȭ
//		CpEmp2VO c=new CpEmp2VO(1234,4000,"������");
		try {
//			u.deleteCpEmp2(1234);	//�����ϴ� method Ȯ��
			
//			List<CpEmp2AllVO>list =u.selectAllCpEmp2();	// �� ����Ȯ�� �ϴ� method Ȯ�� ->�ּҰ��� ����.
//			System.out.println(list);				//�� ������ �ϰ������ tostring ����. Ȯ���غ���.
			
			CpEmp2OneVO c=u.selectOneCpEmp2(7566);
			System.out.println(c); //��, ��, ������ �������ϰ� ������ simpleformat
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
*/

}//class
