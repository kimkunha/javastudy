package day0109.callalbestatement;
import java.awt.Font;
//19.01.09
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import day0107.cpemp2.CpEmp2AllVO;
import day0107.cpemp2.CpEmp2OneVO;
import day0107.cpemp2.CpEmp2VO;
import day0110.TestProcAllVO;
import day0110.TestProcOneVO;
import day0110.TestProcUpdateVO;

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
	
	public void modifyTestProc() {
		String tempData = JOptionPane.showInputDialog("사원정보 변경\n 사원번호에 일치하는 직무와 연봉를 변경합니다.\n입력 예) 사원번호,직무,연봉");
		if(tempData != null && !tempData.equals("")) {	//논리연산자 &&
			String [] data=tempData.split(",");
			if(data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;
			}//end if
			
			int empno=0, sal=0;
			String job="";
			
			try {
				empno = Integer.parseInt(data[0].trim());	//값에 공백넣을수 있을수 있어서 트림으로 잡아준다.
				job =data[1].trim();
				sal=Integer.parseInt(data[2].trim());
				
			}catch( NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자 입니다.");
				return;
			}//end catch
			
			//처리된 입력데이터를 VO에 설정하고
			TestProcUpdateVO tpuvo=new TestProcUpdateVO(empno, sal, job);
			//VO의 값을 DB에 update한다
			try {
				String msg="";
				
				msg=UseCallableStatementDAO.getInstance().updateProc(tpuvo);
				
				JOptionPane.showMessageDialog(null, msg);
			}catch(SQLException se) { //예외 
				
				//예외번호를 메세지창으로 떠서 보여주기
					JOptionPane.showMessageDialog(null, "죄송합니다 잠시후 다시 시도 해주세요");
					se.printStackTrace();
			}//end catch
			
		}//end if
	}//modify
	
	public void removeTestProc() {
		
		String inputData=JOptionPane.showInputDialog("사원삭제\n삭제할 사원번호 입력");
		if(inputData != null && !inputData.equals("")) {
			int empno=0;
			try {
				empno=Integer.parseInt( inputData.trim() );
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 숫자이어야 합니다.");
				return;
			}//end catch
			
		try {
			String msg="";
			msg=UseCallableStatementDAO.getInstance().deleteProc(empno);
			JOptionPane.showMessageDialog(null, msg);
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "죄송합니다. 문제가 발생하였습니다.");
			e.printStackTrace();
			}
		}//end if
	}//end removeTesrProc
	
	public void searchAllTestProc() {
		StringBuilder viewTestProc=new StringBuilder();
		viewTestProc
		.append("----------------------------------------------------------------------------------------------------------------------------------------\n")
		.append("번호\t사원번호\t사원명\t연봉\t직무\t입사일\n")
		.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
		
		
		int rowCount=0;
		try {
			//DB에서 조회한 결과 받기
			List<TestProcAllVO> list=
					UseCallableStatementDAO.getInstance().selectAllTestProc();
			TestProcAllVO tpavo=null;
			
			rowCount=list.size();
			for(int i=0; i< list.size(); i++) {
				tpavo=list.get(i);
				viewTestProc.append(i+1).append("\t")
				.append(tpavo.getEmpno()).append("\t")
				.append(tpavo.getEname()).append("\t")
				.append(tpavo.getSal()).append("\t")
				.append(tpavo.getJob()).append("\t")
				.append(tpavo.getHiredate()).append("\n");
			}//end for
			
			if( list.isEmpty() ) {	//list.size()==0
				viewTestProc.append("입력된 부서정보가 존재하지 않습니다.");
			}//end if
			
		} catch (SQLException e) {
			viewTestProc.append("DBMS에서 문제가 발생했습니다.");
			e.printStackTrace();
		}//end catch
		
		viewTestProc.append("---------------------------------------------------------------------------------------------------------------------------------------\n")
		.append("\t\t\t총 ").append(rowCount).append("명의 사원정보가 조회되었습니다.");
		
		
		JTextArea jta=new JTextArea(20, 50);
		jta.setEditable(false);
		jta.setText(viewTestProc.toString()); //만들어진 출력데이터를 T.A에 설정한다.
		
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("전체 사원 조회결과"));
		JOptionPane.showMessageDialog(null, jsp);
		
	}//end searchAlllTestProc
	
	public void searhOneTestProc(){
	
		String inputData=JOptionPane.showInputDialog("사원조회\n조회할 사원번호 입력");
		if( inputData !=null && !inputData.equals("")) {
			try {
			int empno=Integer.parseInt(inputData.trim());
			//사원번호를 입력하여 사원번호에 해당하는 사원정보를 조회
			//조회한 사원가 있다면 생성된 객체(TestProcOneVO)가 반환되고 조회된 부서가 없다면 null이 반환된다.
			TestProcOneVO tpovo=UseCallableStatementDAO.getInstance().selectOneTestProc(empno);
			
			StringBuilder viewData=new StringBuilder();
			viewData.append("사원명 : ").append(tpovo.getEname())
			.append(", 연봉 : ").append(tpovo.getSal())
			.append(", 직급 : ").append(tpovo.getJob())
			.append(", 입사일 : ").append(tpovo.getHiredate()); //sdfformat 객체를 넣어서 사용
			
			JLabel lbl=new JLabel(viewData.toString());
			lbl.setFont(new Font("SansSerif", Font.BOLD, 15));
			
			JOptionPane.showMessageDialog(null, lbl);
			}catch(NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData+" 사원은 존재하지 않습니다.");
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 정수 형태로 입력하셔야 합니다.");
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "서버에서 문제발생!!");
				e.printStackTrace();
			}//end catch
		}//end if
	}//searchOneTestProc
	
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
			case "2":
				rucs.modifyTestProc();
				break;
			case "3":
				rucs.removeTestProc();
				break;
			case "4":
				rucs.searchAllTestProc();
				break;
			case "5":
				rucs.searhOneTestProc();
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
		resMsg= JOptionPane.showConfirmDialog(null, "정말로 나가실건가요?","확인창",JOptionPane.YES_NO_CANCEL_OPTION);
		if(resMsg==JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "다음에 또 이용해 주세요", "감사합니다",JOptionPane.CLOSED_OPTION);
		}else {
			
		}
//		JOptionPane.showMessageDialog(null, "사용해 주셔서 감사합니다");
		
		
		
	}//main
}//class
