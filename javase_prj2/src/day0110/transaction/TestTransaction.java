package day0110.transaction;
//19.01.10 -6번째- 트랙잭션 처리
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 *	Transaction 처리
 * @author owner
 */
public class TestTransaction {
	// commit과 rollback을 DB작업 외부에서 처리할 수 있도록 class filed 정의
	private Connection con=null;

	public boolean insert( TransactionVO tv) throws SQLException{		//void가 아니라 boolean 형으로 변경
		
		//transaction에 사용할 쿼리의 수만큼 쿼리실행객체 선언
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		
		boolean flag=false;
		
		try {
		//1. 드라이버 로딩
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			//auto commit 해제 <추가내용>
			con.setAutoCommit(false);
			
		//3. 쿼리문 생성객체 얻기
			String sql="insert into test_transaction1(subject,writer)values(?,?)";
			pstmt=con.prepareStatement(sql);
			//바인드변수 값 넣기
			pstmt.setString(1, tv.getSubject());
			pstmt.setString(2, tv.getWrite());
		//4. 쿼리문 수행후 결과 얻기
			int cnt=pstmt.executeUpdate();
			
				//3. 쿼리문 생성객체 얻기
				String sql1="insert into test_transaction2(subject,writer)values(?,?)";
				pstmt1=con.prepareStatement(sql1);
				//바인드변수 값 넣기
				pstmt1.setString(1, tv.getSubject());
				pstmt1.setString(2, tv.getWrite());
			//////////////////////////////////////////////// 커밋과 롤백을 메소드 밖에서 해야 한다.
				//4. transaction에 해당하는 모든 쿼리의 목표 수행 수를 비교하여
				//commit과 rollback여부를 설정한다.
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
		JOptionPane.showInputDialog("제목과 작성자를 입력해 주세요.\n제목-작성자");
		
		String[] data=inputData.split("-");
		
		if(data.length !=2 ) {
			JOptionPane.showMessageDialog(null, "입력형식을 확인 해주세요.");
			return;
		}//end if
		TransactionVO tv=new TransactionVO(data[0], data[1]);
		
		try {
			//DB업무를 사용하는 곳에서 수행 결과를 받아
			boolean flag=insert(tv);
			if(flag) {
				//커밋하거나
				con.commit();
				System.out.println("커밋!!!");
			}else {//update나 delete가 transaction 일때
				//롤백한다.
				con.rollback();
				System.out.println("update나 delete 롤백 !!");
			}//end else
			
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("insert 롤백!!");
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
