package day0107.zipcode;
//19.01.07 -5번자료- (주소 만들기 이벤트 처리)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialStruct;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ZipcodeViewEvt extends WindowAdapter implements ActionListener {

	private ZipcodeView zv;
	
	public ZipcodeViewEvt( ZipcodeView zv) {
		this.zv=zv;
	}//ZipcodeViewEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		zv.dispose();
	}//windowClosting
	
	//추가 메소드 sqlinjection막는 method
	public String blockInjection(String sql) {
		return sql.replaceAll("'", "").replaceAll("--", "");
	}
	
	
	
	public List<ZipcodeVO> selectZipcode(String dong)throws SQLException{
		List<ZipcodeVO> list =new ArrayList<ZipcodeVO>();
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
				
	try {	
		//2. DB연결 Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		
		
		//3. 쿼리 생성객체 얻기
			stmt=con.createStatement();
			
		//4. 쿼리 수행 후 결과 얻기
			StringBuilder selectZipcode=new StringBuilder();
			selectZipcode
			.append(" select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji ")
			.append(" from zipcode ")
			.append(" where dong like '").append( blockInjection(dong) ).append("%' ");
			
			rs=stmt.executeQuery(selectZipcode.toString());
			//여기서 중요 
			ZipcodeVO  zv=null;
			
			while(rs.next() ) { //조회된 레코드가 존재한다면
			zv=new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"), rs.getString("dong"), rs.getString("bunji") );
			//같은 이름의 객체를 여러개 관리 하기 위해 List에 추가
			list.add(zv);
			}//end while
			
	}finally {
		//5.연결끊기
		if( rs !=null ) { rs.close(); }
		if( stmt !=null ) { stmt.close(); }
		if( con !=null ) { con.close(); }
	}//end finally
		return list;
	}//selectZipcod
	
	public void searchZipcode(String dong) {
	try {
		//DB에서 조회한 결과를 받아서
		List<ZipcodeVO>listZip=selectZipcode(dong);
		System.out.println( listZip.size());
		//DefaultTableModel에 추가 => JTable에 반영된다.  DefaultTableModel을 받아준다.
		DefaultTableModel dtm=zv.getDtmZipcode();
		//D.T.M 초기화
		dtm.setRowCount(0);
		//D.T.M에 행(Row : 우편번호, 주소 ) 추가
		
		String[] rowData=null;
		//조회된 결과를 가지고
		for(ZipcodeVO zv : listZip) {
			//배열에 넣고
			rowData=new String[2];
			rowData[0]=zv.getZipcode();
			rowData[1]=zv.getSido()+" "+zv.getGugun()+" "+zv.getDong()+" "+zv.getBunji();
			
			dtm.addRow(rowData);
		}//end for
		
		if(listZip.isEmpty()) {
			rowData=new String[2];
			rowData[0]="";
			rowData[1]="해당 동은 존재하지 않습니다. ";
			
			dtm.addRow(rowData);
		}//end if
		
		
	} catch (SQLException se) {
		JOptionPane.showMessageDialog(zv, "DB에서 문제 발생");
		se.printStackTrace();
	}//end catch
		
	}//searchZipcode
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String dong=zv.getJtfDong().getText().trim();
		System.out.println( dong );
		if(!dong.equals("") ) {
			searchZipcode(dong);
		}//end if

	}//actionPerformed

}//class
