package day0108.login;
//19.01.07 -2���ڷ�- (�α���â ����� �̺�Ʈ â)
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

	//has a����� �����Ѱ��̴�.
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
			JOptionPane.showMessageDialog(sl, "���̵�� �ʼ� �Է�");
			sl.getJtfId().requestFocus(); //�ٽ����� ���� ��ȯ
			flag=true;
			//���ܸ� ������ �߻� ��Ű�� ������ �̹���� ����Ѵ�.  : throw new ����ó��Ŭ������();
				throw new LoginException();
				
//			return flag; �̹���� �����ϳ� ����õ (�����̰� ���� ���)
		}//end if
	
		if( pass.equals("")) {
			JOptionPane.showMessageDialog(sl, "��й�ȣ�� �ʼ� �Է�");
			sl.getJpfPass().requestFocus(); //�ٽ����� ���� ��ȯ
			flag=true;
		}//end if
		
	} catch (LoginException le) {
		le.printStackTrace();
	}//end catch
		return !flag;
		
	}//chkNull
	
	public String login(String id, String pass) throws SQLException {
		String name="";  //�Ҹ����� �̸��� ���� string name���� ����
		//1.����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
	try {
		//2. DB����Connection���
			String url="jdbc:oracle:thin:@127.0.01:1521:orcl";  // ip �ּҴ� localhost �� ����ص� �ȴ�.
			String dbo_id="scott";
			String dbo_pass="tiger";
			
			con=DriverManager.getConnection(url, dbo_id, dbo_pass);
			
			StringBuilder selectName=new StringBuilder();
			selectName
			.append("select name ")
			.append("from test_login ")
			.append("where id=? and pass=?");
			//3. ������ ������ü ���
			pstmt=con.prepareStatement(selectName.toString());
			
			//4 ���ε� ������ �� �ֱ�
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			System.out.println(selectName);
			//5. ������ ���� �� ��� ���
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) { //�Էµ� ���̵�� ��й�ȣ�� �´� �̸��� ���� => �α��� ����
				name=rs.getString("name");
			}//end if
			
	}finally {
		//5. ���� ����
		if( rs != null) { rs.close(); }
		if( pstmt != null) { pstmt.close(); }
		if( con != null) { con.close(); }
	}//end finally
		return name;
	}//login
	

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==sl.getJtfId() || ae.getSource() == sl.getJpfPass() || 
				ae.getSource()==sl.getJbtLogin()) {						//�Ȱ����� �ι��ؾ��ϴ� �ϳ��� ��ħ
			String id=sl.getJtfId().getText().trim();
			String pass=new String(sl.getJpfPass().getPassword()).trim();  //���� getPassword�� ��ȯ���� char�̹Ƿ� �̰��� �ٽ� new string���� �������̵� �Ͽ� ���
			
			if(chkNull(id,pass) ) {
				try {
					String name=login(id, pass);
					
					if(name.isEmpty()) {
						JOptionPane.showMessageDialog(sl, "���̵� ��й�ȣ�� Ȯ�����ּ���");
						sl.getJtfId().setText("");
						sl.getJpfPass().setText("");
						sl.getJtfId().requestFocus();
						return;  //�� �������� ���ϰ� ȣ���Ѱ����� ����
					}//end if
				
					JDialog jd=new JDialog(sl, "�α��� ����", true);
					jd.add(new JLabel(name+"�� �α��� �ϼ̽��ϴ�."));
					jd.setBounds(sl.getX()+100, sl.getY()+100, 300, 200);
					jd.setVisible(true);
				
					//�α��� ������ �ٽ� �ʱ�ȭ ���ش�. 
					sl.getJtfId().setText("");
					sl.getJpfPass().setText("");
					sl.getJtfId().requestFocus();
					
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); //exit_on_close �ƴ� �����Ұ�.
					//�α��� ������ �α��� â�� ������� �ϴ¹�.. �غ���..
					
					
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(sl, "DB �۾��� ������ �߻��Ͽ����ϴ�.");
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
