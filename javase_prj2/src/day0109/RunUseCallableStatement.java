package day0109;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import day0107.CpEmp2VO;

public class RunUseCallableStatement {

	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog("사원정보 추가\n입력 예) 사원번호,사원명,연봉,직무");
		if(tempData != null && !tempData.equals("")) {
			String [] data=tempData.split(",");
			if(data.length != 4) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;
			}//end if
			
			int empno=0, sal=0;
			String ename="", job="";
			
			try {
				empno = Integer.parseInt(data[0].trim());
				ename =data[1].trim();
				sal=Integer.parseInt(data[2].trim());
				job=data[3].trim();
				
			}catch( NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자 입니다.");
				return;
			}//end catch
			
			//처리된 입력데이터를 VO에 설정하고
			//VO의 값을 DB에 insert한다
			TestProcVO tpvo=new TestProcVO(empno, sal, ename, job);
			try {
				String msg="";
				msg=UseCallableStatementDAO.getInstance().insertProc(tpvo);
				JOptionPane.showMessageDialog(null, empno+"번 사원정보 입력되었습니다.");
			}catch(SQLException se) { //예외 
					JOptionPane.showMessageDialog(null, "DBMS에 사소한 문제 발생");
					se.printStackTrace();
			}//end catch
			
		}//end if
	}//addTestProc
	
	
	
	public static void main(String[] args) {
		RunUseCallableStatement rucs=new RunUseCallableStatement();
		boolean exitFlag=false;
		String inputMenu="";
		int resMsg=0;
		do {
			inputMenu=JOptionPane.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
			if( inputMenu !=null ) {	//6번 누르지 않으면 프로세서가 종료되지 않게 조건
				
			switch(inputMenu) {
			case "1":
				rucs.addTestProc();
			break;
//			case "2":
//				rps.modifyCpEmp2();
//				break;
//			case "3":
//				rps.removeCpEmp2();
//				break;
//			case "4":
//				rps.searchAllCpEmp2();
//				break;
//			case "5":
//				rps.searchOneCpEmp2();
//				break;
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
		resMsg= JOptionPane.showConfirmDialog(null, "정말로 나가실건가요?","확인창",JOptionPane.YES_NO_CANCEL_OPTION);
		if(resMsg==JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "다음에 또 이용해 주세요", "감사합니다",JOptionPane.CLOSED_OPTION);
		}else {
			
		}
//		JOptionPane.showMessageDialog(null, "사용해 주셔서 감사합니다");
		
		
		
	}//main
}//class
