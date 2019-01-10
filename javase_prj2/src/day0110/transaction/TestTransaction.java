package day0110.transaction;
//19.01.10 -6��°- Ʈ����� ó��
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 *	Transaction ó��
 * @author owner
 */
public class TestTransaction {
	// commit�� rollback�� DB�۾� �ܺο��� ó���� �� �ֵ��� class filed ����
	private Connection con=null;

	public boolean insert( TransactionVO tv) throws SQLException{		//void�� �ƴ϶� boolean ������ ����
		
		//transaction�� ����� ������ ����ŭ �������ఴü ����
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		
		boolean flag=false;
		
		try {
		//1. ����̹� �ε�
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			//auto commit ���� <�߰�����>
			con.setAutoCommit(false);
			
		//3. ������ ������ü ���
			String sql="insert into test_transaction1(subject,writer)values(?,?)";
			pstmt=con.prepareStatement(sql);
			//���ε庯�� �� �ֱ�
			pstmt.setString(1, tv.getSubject());
			pstmt.setString(2, tv.getWrite());
		//4. ������ ������ ��� ���
			int cnt=pstmt.executeUpdate();
			
				//3. ������ ������ü ���
				String sql1="insert into test_transaction2(subject,writer)values(?,?)";
				pstmt1=con.prepareStatement(sql1);
				//���ε庯�� �� �ֱ�
				pstmt1.setString(1, tv.getSubject());
				pstmt1.setString(2, tv.getWrite());
			//////////////////////////////////////////////// Ŀ�԰� �ѹ��� �޼ҵ� �ۿ��� �ؾ� �Ѵ�.
				//4. transaction�� �ش��ϴ� ��� ������ ��ǥ ���� ���� ���Ͽ�
				//commit�� rollback���θ� �����Ѵ�.
				int cnt1=pstmt1.executeUpdate();
				if( cnt ==1 && cnt1 == 1) {
					flag=true;
				}//end else
			////////////////////////////////////////////////	
		}finally {
		//6.
		}//end finally
		return flag;
	}//insert
	
	public void add() {
		String inputData=
		JOptionPane.showInputDialog("����� �ۼ��ڸ� �Է��� �ּ���.\n����-�ۼ���");
		
		String[] data=inputData.split("-");
		
		if(data.length !=2 ) {
			JOptionPane.showMessageDialog(null, "�Է������� Ȯ�� ���ּ���.");
			return;
		}//end if
		TransactionVO tv=new TransactionVO(data[0], data[1]);
		
		try {
			//DB������ ����ϴ� ������ ���� ����� �޾�
			boolean flag=insert(tv);
			if(flag) {
				//Ŀ���ϰų�
				con.commit();
				System.out.println("Ŀ��!!!");
			}else {//update�� delete�� transaction �϶�
				//�ѹ��Ѵ�.
				con.rollback();
				System.out.println("update�� delete �ѹ� !!");
			}//end else
			
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("insert �ѹ�!!");
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			}finally {
				
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}//end catch
		}//end catch
		
	
	}//add
	
	public static void main(String[] args) {
		TestTransaction tt=new TestTransaction();
		tt.add();
	}//main

}//class
