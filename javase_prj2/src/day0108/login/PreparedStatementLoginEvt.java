package day0108.login;
//19.01.07 -2번자료- (로그인창 만들기 이벤트 창)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PreparedStatementLoginEvt extends WindowAdapter implements ActionListener {
	private preparedStatementLogin sl;

	//has a관계로 연결한것이다.
	public PreparedStatementLoginEvt( preparedStatementLogin sl) {
		this.sl=sl;
		
	}//statementLoginEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		sl.dispose();
	}//windowClosing
	
	
	public boolean chkNull(String id, String pass) {
		boolean flag=false;
		
	try {
		if( id.equals("")) {
			JOptionPane.showMessageDialog(sl, "아이디는 필수 입력");
			sl.getJtfId().requestFocus(); //다시이쪽 으로 소환
			flag=true;
			//예외를 강제로 발생 시키고 싶을때 이방법을 사용한다.  : throw new 예외처리클래스명();
				throw new LoginException();
				
//			return flag; 이방법도 가능하나 비추천 (재찬이가 말한 방법)
		}//end if
	
		if( pass.equals("")) {
			JOptionPane.showMessageDialog(sl, "비밀번호는 필수 입력");
			sl.getJpfPass().requestFocus(); //다시이쪽 으로 소환
			flag=true;
		}//end if
		
	} catch (LoginException le) {
		le.printStackTrace();
	}//end catch
		return !flag;
		
	}//chkNull
	
	public String login(String id, String pass) throws SQLException {
		String name="";  //불린에서 이름을 얻어가는 string name으로 변경
		//1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
	try {
		//2. DB연동Connection얻기
			String url="jdbc:oracle:thin:@127.0.01:1521:orcl";  // ip 주소는 localhost 로 사용해도 된다.
			String dbo_id="scott";
			String dbo_pass="tiger";
			
			con=DriverManager.getConnection(url, dbo_id, dbo_pass);
			
			StringBuilder selectName=new StringBuilder();
			selectName
			.append("select name ")
			.append("from test_login ")
			.append("where id=? and pass=?");
			//3. 쿼리문 생성객체 얻기
			pstmt=con.prepareStatement(selectName.toString());
			
			//4 바인드 변수에 값 넣기
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			System.out.println(selectName);
			//5. 쿼리문 수행 후 결과 얻기
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) { //입력된 아이디와 비밀번호에 맞는 이름이 존재 => 로그인 성공
				name=rs.getString("name");
			}//end if
			
	}finally {
		//5. 연결 끊기
		if( rs != null) { rs.close(); }
		if( pstmt != null) { pstmt.close(); }
		if( con != null) { con.close(); }
	}//end finally
		return name;
	}//login
	

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==sl.getJtfId() || ae.getSource() == sl.getJpfPass() || 
				ae.getSource()==sl.getJbtLogin()) {						//똑같은거 두번해야하니 하나로 합침
			String id=sl.getJtfId().getText().trim();
			String pass=new String(sl.getJpfPass().getPassword()).trim();  //질문 getPassword의 반환형이 char이므로 이것을 다시 new string으로 오버라이딩 하여 사용
			
			if(chkNull(id,pass) ) {
				try {
					String name=login(id, pass);
					
					if(name.isEmpty()) {
						JOptionPane.showMessageDialog(sl, "아이디나 비밀번호를 확인해주세요");
						sl.getJtfId().setText("");
						sl.getJpfPass().setText("");
						sl.getJtfId().requestFocus();
						return;  //더 내려가지 못하게 호출한곳으로 리턴
					}//end if
				
					JDialog jd=new JDialog(sl, "로그인 성공", true);
					jd.add(new JLabel(name+"님 로그인 하셨습니다."));
					jd.setBounds(sl.getX()+100, sl.getY()+100, 300, 200);
					jd.setVisible(true);
				
					//로그인 성공시 다시 초기화 해준다. 
					sl.getJtfId().setText("");
					sl.getJpfPass().setText("");
					sl.getJtfId().requestFocus();
					
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); //exit_on_close 아님 주의할것.
					//로그인 성공시 로그인 창을 사라지게 하는법.. 해볼것..
					
					
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(sl, "DB 작업중 문제가 발생하였습니다.");
					se.printStackTrace();
				}//end catch
			}//end if
			
		}//end if
		
		if(ae.getSource()==sl.getJbtCancel()) {
			sl.getJtfId().setText("");
			sl.getJpfPass().setText("");
			sl.getJtfId().requestFocus();
		}//end if
		
	}//actionPerformed
	
}//class
