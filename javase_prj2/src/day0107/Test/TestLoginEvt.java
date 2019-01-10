package day0107.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TestLoginEvt extends WindowAdapter implements ActionListener {

	private TestLogin tl;

	public TestLoginEvt(TestLogin tl) {
		this.tl = tl;
	}// ������

	private void windoeclosing() {
		tl.dispose();
	}// windowClosing

	public boolean chkNull(String id, String pass) {
		boolean flag = false;

		try {
			if (id.equals("")) {
				JOptionPane.showMessageDialog(tl, "���̵�� �ʼ��Է�");
				tl.getJtfId().requestFocus(); // Ŀ�� ������ �ٽ� �� ��ġ�� ��ȯ
				flag = true;
				// ���ܸ� ������ �߻� ��Ű�� ������ �̹���� ����Ѵ�.
				throw new LoginException();

			} // end if

			if (pass.equals("")) {
				JOptionPane.showMessageDialog(tl, "��й�ȣ�� �ʼ��Է�");
				tl.getJpfPass().requestFocus();
				flag = true;
			} // end if

		} catch (LoginException e) {
			e.printStackTrace();
		} // end catch

		return !flag;
	}// chkNull

	public String login(String id, String pass) throws SQLException {
		String name = "";
		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 2. Connection ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String dbo_id = "scott";
			String dbo_pass = "tiger";
			con = DriverManager.getConnection(url, dbo_id, dbo_pass);

			// 3 ������ ������ü ���
			stmt = con.createStatement();
			// 4. ������ ������ ��� ���
			StringBuilder selectName = new StringBuilder();
			selectName.append("select name ").append("from test_login ").append("where id= '").append(dbo_id)
					.append("' and ").append(" pass= '").append(dbo_pass).append("'");

			rs = stmt.executeQuery(selectName.toString());

		} finally {
			// 5
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}

		} // end finally
		return name;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == tl.getJtfId() || ae.getSource() == tl.getJpfPass()
				|| ae.getSource() == tl.getJbtLogin()) {
			String id = tl.getJtfId().getText().trim();
			String pass = new String(tl.getJpfPass().getPassword()).trim(); // getpassword�� ��Ȳ���� char�� new string����
																			// ���ذ�.

			try {
				if (chkNull(id, pass)) {
					String name = login(id, pass);

					if (name.isEmpty()) {
						JOptionPane.showMessageDialog(tl, "���̵� ��й�ȣ�� Ȯ�����ּ���");
						tl.getJtfId().setText("");
						tl.getJpfPass().setText("");
						tl.getJtfId().requestFocus();
						return;
					} // end if

				} // end if

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end if
	}// actionPeformed

}// class
