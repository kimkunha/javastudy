package day0109;
//19.01.19 -1���ڷ�- 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 *	�÷����� �������� ����Ǵ� ���<br>
 *	�÷����� �Է¹޾� �ش� �÷������� ��ȸ<br>
 *	EMP���̺� ��ȸ �����ȣ�� �÷���(�� �Է¹޾� ��ȸ
 * @author owner
 */
public class DynamicColumn {
	
	public DynamicColumn() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String[] columnName = {"ename", "job", "mgr","hiredate","sal", "comm", "deptno"};
		
		String input=JOptionPane.showInputDialog("�����ȣ�� �÷��� �ϳ��� �Է����ּ���\n ��)�����ȣ, �÷���");
		String[] temp=input.split(",");
		
		if(temp.length != 2) {
			JOptionPane.showMessageDialog(null, "�Է������� Ȯ���ϼ���.");
			return;
		}//end if
		
		int empno=Integer.parseInt(temp[0].trim());
		String inputColumn=temp[1].trim();
		
		try {
		boolean columnFlag=false;
		for(String column : columnName) {
			if( column.equals(inputColumn.toLowerCase())) { //DB���̺��� �÷���� ���� �÷����̶��
				columnFlag=true;
			}//end if
		}//end for
		if(!columnFlag) {
			JOptionPane.showMessageDialog(null, inputColumn+"�� EMP���̺� �÷����� �������� �ʽ��ϴ�");
			return;
		}//end if
		
		try {
		
		//1. ����̹� �ε�
		//2 DB���� Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. ������ ������ü ���
			//�÷����� hiredate�� ��� ���ڿ��� ó���ϱ� ���ؼ� to_char �Լ��� ���.
			if( inputColumn.equals("hiredate") ) {
				inputColumn="to_char(hiredate,'yyyy-mm-dd day') hiredate";
			}//end if
			
			StringBuilder selectEmp=new StringBuilder();
			//�÷���, ���̺���� bind������ ó������ �ʴ´�. �������� ���� �־� ����Ѵ�.
			selectEmp.append("select ").append(inputColumn).append(" from emp ") //���� �����ؾ� �Ѵ�. 
			.append(" where empno=?");
			
			pstmt=con.prepareStatement(selectEmp.toString() );
			
		//4. ���ε� ������ �ֱ�
			pstmt.setInt(1, empno);
			
		//5. ������ ������ ������
			rs=pstmt.executeQuery();
			
			if(rs.next() ){ //�����ȣ�� ��ȸ�� ���ڵ尡 �����Ѵٸ�
				
				String stringData="";
				int intData=0;
				if( temp[1].trim().equals("ename")|| temp[1].trim().equals("job") ||
						temp[1].trim().equals("hiredate")){
					stringData=rs.getString(temp[1].trim());
				}else {
					intData=rs.getInt(temp[1].trim());
				}//end else
				JOptionPane.showMessageDialog(null, temp[1]+"���� ��ȸ�� �� :"+(intData == 0? stringData : intData));
			}else {	
				JOptionPane.showMessageDialog(null,"�Է��� �����ȣ�� �������� �ʽ��ϴ�.");
			}//end if
			
		}finally {
		//6. �������
			if( rs !=null ) { rs.close(); }
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾�� �մϴ�.");
		}//end catch
	}//DynamicColumn
	
	
	
	public static void main(String[] args) {
		try {
			new DynamicColumn();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
