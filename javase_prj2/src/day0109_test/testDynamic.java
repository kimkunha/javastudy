package day0109_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class testDynamic {
	
	public testDynamic() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String [] columnName = {"ename", "job", "mgr", "hiredate", "sal", "comm", "deptno"};
		
		String input=JOptionPane.showInputDialog(null,"�����ȣ�� �÷��� �ϳ��� �Է����ּ���\n ��)�����ȣ, �÷���");
		String[] temp=input.split(",");
	
		if(temp.length !=2) {
			JOptionPane.showMessageDialog(null, "�Է������� Ȯ���ϼ���.");
			return;
		}//end if
	
		int empno = Integer.parseInt(temp[0].trim());
		String inputColumn=temp[1].trim();
	
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
	
	
	
	
	
	
	
	
	
	}//������
	
	
	
	
	
public static void main(String[] args) {
	
}//main
}//class
