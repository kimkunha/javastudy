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
		
		String input=JOptionPane.showInputDialog(null,"사원번호와 컬럼명 하나를 입력해주세요\n 예)사원번호, 컬럼명");
		String[] temp=input.split(",");
	
		if(temp.length !=2) {
			JOptionPane.showMessageDialog(null, "입력형식을 확인하세요.");
			return;
		}//end if
	
		int empno = Integer.parseInt(temp[0].trim());
		String inputColumn=temp[1].trim();
	
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
	
	
	
	
	
	
	
	
	
	}//생성자
	
	
	
	
	
public static void main(String[] args) {
	
}//main
}//class
