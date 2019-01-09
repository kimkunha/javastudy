package day0109;
//19.01.19 -1번자료- 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 *	컬럼명이 동적으로 변경되는 경우<br>
 *	컬럼명을 입력받아 해당 컬럼명으로 조회<br>
 *	EMP테이블 조회 사원번호와 컬럼명(을 입력받아 조회
 * @author owner
 */
public class DynamicColumn {
	
	public DynamicColumn() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String[] columnName = {"ename", "job", "mgr","hiredate","sal", "comm", "deptno"};
		
		String input=JOptionPane.showInputDialog("사원번호와 컬럼명 하나를 입력해주세요\n 예)사원번호, 컬럼명");
		String[] temp=input.split(",");
		
		if(temp.length != 2) {
			JOptionPane.showMessageDialog(null, "입력형식을 확인하세요.");
			return;
		}//end if
		
		int empno=Integer.parseInt(temp[0].trim());
		String inputColumn=temp[1].trim();
		
		try {
		boolean columnFlag=false;
		for(String column : columnName) {
			if( column.equals(inputColumn.toLowerCase())) { //DB테이블의 컬럼명과 같은 컬럼명이라면
				columnFlag=true;
			}//end if
		}//end for
		if(!columnFlag) {
			JOptionPane.showMessageDialog(null, inputColumn+"은 EMP테이블에 컬럼으로 존재하지 않습니다");
			return;
		}//end if
		
		try {
		
		//1. 드라이버 로딩
		//2 DB연동 Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. 쿼리문 생성객체 얻기
			//컬럼명이 hiredate인 경우 문자열로 처리하기 위해서 to_char 함수를 사용.
			if( inputColumn.equals("hiredate") ) {
				inputColumn="to_char(hiredate,'yyyy-mm-dd day') hiredate";
			}//end if
			
			StringBuilder selectEmp=new StringBuilder();
			//컬럼명, 테이블명은 bind변수로 처리되지 않는다. 쿼리문에 직접 넣어 사용한다.
			selectEmp.append("select ").append(inputColumn).append(" from emp ") //띄어쓰기 주위해야 한다. 
			.append(" where empno=?");
			
			pstmt=con.prepareStatement(selectEmp.toString() );
			
		//4. 바인드 변수값 넣기
			pstmt.setInt(1, empno);
			
		//5. 쿼리문 수행후 결과얻기
			rs=pstmt.executeQuery();
			
			if(rs.next() ){ //사원번호로 조회된 레코드가 존재한다면
				
				String stringData="";
				int intData=0;
				if( temp[1].trim().equals("ename")|| temp[1].trim().equals("job") ||
						temp[1].trim().equals("hiredate")){
					stringData=rs.getString(temp[1].trim());
				}else {
					intData=rs.getInt(temp[1].trim());
				}//end else
				JOptionPane.showMessageDialog(null, temp[1]+"으로 조회된 값 :"+(intData == 0? stringData : intData));
			}else {	
				JOptionPane.showMessageDialog(null,"입력한 사원번호는 존재하지 않습니다.");
			}//end if
			
		}finally {
		//6. 연결끊기
			if( rs !=null ) { rs.close(); }
			if( pstmt !=null ) { pstmt.close(); }
			if( con !=null ) { con.close(); }
		}//end finally
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자이어야 합니다.");
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
