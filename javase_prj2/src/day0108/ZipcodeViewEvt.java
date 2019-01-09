package day0108;
//19.01.08 -3���ڷ�- (�ּ� ����� �̺�Ʈ ó��)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	
	
	/**
	 *  19.01.08 �߰�����
	 * 	PreparedStatement�� ����Ͽ� SQLInjection ���
	 * @param dong
	 * @return
	 * @throws SQLException
	 */
	public List<ZipcodeVO> selectZipcode(String dong)throws SQLException{
		List<ZipcodeVO> list =new ArrayList<ZipcodeVO>();
		//1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
				
	try {	
		//2. DB���� Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		
		//3. ���� ������ü ���
			StringBuilder selectZipcode=new StringBuilder();
			selectZipcode
			.append(" select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji ")
			.append(" from zipcode ")
			.append(" where dong like ?||'%'");
			
			System.out.println(selectZipcode);
			pstmt=con.prepareStatement(selectZipcode.toString());
		//4.���ε� ������ �� �ֱ�
			pstmt.setString(1, dong);
			
		//5. ���� ���� �� ��� ���
			
			rs=pstmt.executeQuery();
			
			//���⼭ �߿� 
			ZipcodeVO  zv=null;
			
			while(rs.next() ) { //��ȸ�� ���ڵ尡 �����Ѵٸ�
			zv=new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"), rs.getString("dong"), rs.getString("bunji") );
			//���� �̸��� ��ü�� ������ ���� �ϱ� ���� List�� �߰�
			list.add(zv);
			}//end while
			
	}finally {
		//5.�������
		if( rs !=null ) { rs.close(); }
		if( pstmt !=null ) { pstmt.close(); }
		if( con !=null ) { con.close(); }
	}//end finally
		return list;
	}//selectZipcod
	
	public void searchZipcode(String dong) {
	try {
		//DB���� ��ȸ�� ����� �޾Ƽ�
		List<ZipcodeVO>listZip=selectZipcode(dong);
		System.out.println( listZip.size());
		//DefaultTableModel�� �߰� => JTable�� �ݿ��ȴ�.  DefaultTableModel�� �޾��ش�.
		DefaultTableModel dtm=zv.getDtmZipcode();
		//D.T.M �ʱ�ȭ
		dtm.setRowCount(0);
		//D.T.M�� ��(Row : �����ȣ, �ּ� ) �߰�
		
		String[] rowData=null;
		//��ȸ�� ����� ������
		for(ZipcodeVO zv : listZip) {
			//�迭�� �ְ�
			rowData=new String[2];
			rowData[0]=zv.getZipcode();
			rowData[1]=zv.getSido()+" "+zv.getGugun()+" "+zv.getDong()+" "+zv.getBunji();
			
			dtm.addRow(rowData);
		}//end for
		
		if(listZip.isEmpty()) {
			rowData=new String[2];
			rowData[0]="";
			rowData[1]="�ش� ���� �������� �ʽ��ϴ�. ";
			
			dtm.addRow(rowData);
		}//end if
		
		
	} catch (SQLException se) {
		JOptionPane.showMessageDialog(zv, "DB���� ���� �߻�");
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
