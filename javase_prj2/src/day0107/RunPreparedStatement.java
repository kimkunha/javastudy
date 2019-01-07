package day0107;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import day0104.CpDeptVO;

public class RunPreparedStatement {

	private UsePreparedStatementDAO ups_dao;
	
	public RunPreparedStatement() {
		ups_dao=new UsePreparedStatementDAO(); //여기서 인스턴스화 하는 이유는?
	}//생성자
	
	
	public void addCpEmp2() {
		String tempData = JOptionPane.showInputDialog("사원정보 추가\n입력 예) 사원번호,사원명,연봉");
		if(tempData != null && !tempData.equals("")) {
			String [] data=tempData.split(",");
			if(data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;
			}//end if
			
			int empno=0, sal=0;
			String ename="";
			
			try {
				empno = Integer.parseInt(data[0]);
				ename =data[1];
				sal=Integer.parseInt(data[2]);
				
			}catch( NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자 입니다.");
				return;
			}//end catch
			
			//처리된 입력데이터를 VO에 설정하고
			//VO의 값을 DB에 insert한다
			CpEmp2VO cevo=new CpEmp2VO(empno, sal, ename);
			try {
			ups_dao.insertCpEmp2(cevo); //추가성공
				JOptionPane.showMessageDialog(null, empno+"번 사원정보 입력되었습니다.");
			}catch(SQLException se) { //예외 
				
				//예외번호를 메세지창으로 떠서 보여주기
				String errMsg="";
				switch(se.getErrorCode()) {
					case 1438 : errMsg="사원번호는 4자리이고, 연봉은 5자리 입니다.";break;
					case 12899 : errMsg="사원명이 너무 깁니다.";break;
					default : errMsg="죄송합니다. 시스템에 문자가 발생 했습니다. 잠시 후 다시 시도";
				}//end switch
					JOptionPane.showMessageDialog(null, errMsg);
					se.printStackTrace();
			}//end catch
			
		}//end if
	}//addCpEmp2
	
	public void modifyCpEmp2() {
		
	}//modify
	
	public void removeCpEmp2() {
		
	}//remove
	
	public void searchAllCpEmp2() {
		
	}//selectAll
	
	public void searchOneCpEmp2() {
		
	}//selectOne
	
	
	
	public static void main(String[] args) {
		RunPreparedStatement rps=new RunPreparedStatement();
		
		boolean exitFlag=false;
		String inputMenu="";
		do {
			inputMenu=JOptionPane.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
			if( inputMenu !=null ) {	//6번 누르지 않으면 프로세서가 종료되지 않게 조건
				
			switch(inputMenu) {
			case "1":
				rps.addCpEmp2();
			break;
			case "2":
				rps.modifyCpEmp2();
				break;
			case "3":
				rps.removeCpEmp2();
				break;
			case "4":
				rps.searchAllCpEmp2();
				break;
			case "5":
				rps.searchOneCpEmp2();
				break;
			case "6":
				exitFlag=true;
				break;
			
			default :
					JOptionPane.showMessageDialog(null, inputMenu+"는(은)제공되는 서비스가 아닙니다.");
				}//end switch
			}else{
				exitFlag=true;  //exit flag로 취소, X눌러도 나갈수 있게 설정
			}//end else
			
		}while(!exitFlag);
//		JOptionPane.showConfirmDialog(null, message)
		JOptionPane.showMessageDialog(null, "사용해 주셔서 감사합니다");
		
		
	}//main

}//class
