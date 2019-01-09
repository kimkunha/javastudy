package day0109;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import day0107.CpEmp2VO;

public class RunUseCallableStatement {

	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog("������� �߰�\n�Է� ��) �����ȣ,�����,����,����");
		if(tempData != null && !tempData.equals("")) {
			String [] data=tempData.split(",");
			if(data.length != 4) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
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
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ ���� �Դϴ�.");
				return;
			}//end catch
			
			//ó���� �Էµ����͸� VO�� �����ϰ�
			//VO�� ���� DB�� insert�Ѵ�
			TestProcVO tpvo=new TestProcVO(empno, sal, ename, job);
			try {
				String msg="";
				msg=UseCallableStatementDAO.getInstance().insertProc(tpvo);
				JOptionPane.showMessageDialog(null, empno+"�� ������� �ԷµǾ����ϴ�.");
			}catch(SQLException se) { //���� 
					JOptionPane.showMessageDialog(null, "DBMS�� ����� ���� �߻�");
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
			inputMenu=JOptionPane.showInputDialog("�޴�����\n1.����߰� 2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");
			if( inputMenu !=null ) {	//6�� ������ ������ ���μ����� ������� �ʰ� ����
				
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
					JOptionPane.showMessageDialog(null, inputMenu+"��(��)�����Ǵ� ���񽺰� �ƴմϴ�.");
				}//end switch
			}else{
				exitFlag=true;  //exit flag�� ���, X������ ������ �ְ� ����
			}//end else
			
		}while(!exitFlag);
		resMsg= JOptionPane.showConfirmDialog(null, "������ �����ǰǰ���?","Ȯ��â",JOptionPane.YES_NO_CANCEL_OPTION);
		if(resMsg==JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "������ �� �̿��� �ּ���", "�����մϴ�",JOptionPane.CLOSED_OPTION);
		}else {
			
		}
//		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�");
		
		
		
	}//main
}//class
