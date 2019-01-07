package day0107;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import day0104.CpDeptVO;

public class RunPreparedStatement {

	private UsePreparedStatementDAO ups_dao;
	
	public RunPreparedStatement() {
		ups_dao=new UsePreparedStatementDAO(); //���⼭ �ν��Ͻ�ȭ �ϴ� ������?
	}//������
	
	
	public void addCpEmp2() {
		String tempData = JOptionPane.showInputDialog("������� �߰�\n�Է� ��) �����ȣ,�����,����");
		if(tempData != null && !tempData.equals("")) {
			String [] data=tempData.split(",");
			if(data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;
			}//end if
			
			int empno=0, sal=0;
			String ename="";
			
			try {
				empno = Integer.parseInt(data[0]);
				ename =data[1];
				sal=Integer.parseInt(data[2]);
				
			}catch( NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ ���� �Դϴ�.");
				return;
			}//end catch
			
			//ó���� �Էµ����͸� VO�� �����ϰ�
			//VO�� ���� DB�� insert�Ѵ�
			CpEmp2VO cevo=new CpEmp2VO(empno, sal, ename);
			try {
			ups_dao.insertCpEmp2(cevo); //�߰�����
				JOptionPane.showMessageDialog(null, empno+"�� ������� �ԷµǾ����ϴ�.");
			}catch(SQLException se) { //���� 
				
				//���ܹ�ȣ�� �޼���â���� ���� �����ֱ�
				String errMsg="";
				switch(se.getErrorCode()) {
					case 1438 : errMsg="�����ȣ�� 4�ڸ��̰�, ������ 5�ڸ� �Դϴ�.";break;
					case 12899 : errMsg="������� �ʹ� ��ϴ�.";break;
					default : errMsg="�˼��մϴ�. �ý��ۿ� ���ڰ� �߻� �߽��ϴ�. ��� �� �ٽ� �õ�";
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
			inputMenu=JOptionPane.showInputDialog("�޴�����\n1.����߰� 2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");
			if( inputMenu !=null ) {	//6�� ������ ������ ���μ����� ������� �ʰ� ����
				
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
					JOptionPane.showMessageDialog(null, inputMenu+"��(��)�����Ǵ� ���񽺰� �ƴմϴ�.");
				}//end switch
			}else{
				exitFlag=true;  //exit flag�� ���, X������ ������ �ְ� ����
			}//end else
			
		}while(!exitFlag);
//		JOptionPane.showConfirmDialog(null, message)
		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�");
		
		
	}//main

}//class
