package day0107.cpemp2;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import day0104.CpDeptVO;
import day0104.OneCpDeptVO;

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
		String tempData = JOptionPane.showInputDialog("������� ����\n �����ȣ�� ��ġ�ϴ� ������ ������ �����մϴ�.\n�Է� ��) �����ȣ,�����,����");
		if(tempData != null && !tempData.equals("")) {	//�������� &&
			String [] data=tempData.split(",");
			if(data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;
			}//end if
			
			int empno=0, sal=0;
			String ename="";
			
			try {
				empno = Integer.parseInt(data[0].trim());	//���� ��������� ������ �־ Ʈ������ ����ش�.
				ename =data[1].trim();
				sal=Integer.parseInt(data[2].trim());
				
			}catch( NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ ���� �Դϴ�.");
				return;
			}//end catch
			
			//ó���� �Էµ����͸� VO�� �����ϰ�
			CpEmp2VO cdvo=new CpEmp2VO(empno,sal, ename);
			//VO�� ���� DB�� update�Ѵ�
			try {
				String msg="";
			if(ups_dao.updateCpEmp2(cdvo)) { //����� ���ڵ� ����
				msg=empno+"�� ����������� �����Ͽ����ϴ�.";
			}else {//����� ���ڵ� �������� X
				msg=empno+"�� ����� �������� �ʽ��ϴ�.";
			}//end else
				JOptionPane.showMessageDialog(null, msg);
			}catch(SQLException se) { //���� 
				
				//���ܹ�ȣ�� �޼���â���� ���� �����ֱ�
				String errMsg="";
				switch(se.getErrorCode()) {
					case 12899 : errMsg="�μ����̳� ��ġ�� �ʹ� ��ϴ�.";break;
					default : errMsg="�˼��մϴ�. �ý��ۿ� ���ڰ� �߻� �߽��ϴ�. ��� �� �ٽ� �õ�";
				}//end switch
					JOptionPane.showMessageDialog(null, errMsg);
					se.printStackTrace();
			}//end catch
			
		}//end if
	}//modify
	
	
	
	public void removeCpEmp2() {
		String inputData=JOptionPane.showInputDialog("�������\n������ �����ȣ �Է�");
		if(inputData != null && !inputData.equals("")) {
			int empno=0;
			try {
				empno=Integer.parseInt( inputData.trim() );
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾�� �մϴ�.");
				return;
			}//end catch
			
		try {
			String msg=empno+"�� ����� �������� �ʽ��ϴ�.";
			
			if(ups_dao.deleteCpEmp2(empno)){
				msg=empno+" �� ��� ������ �����Ͽ����ϴ�.";
			}//end if
			JOptionPane.showMessageDialog(null, msg);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "�˼��մϴ�. ������ �߻��Ͽ����ϴ�.");
			e.printStackTrace();
			}
		}//end if
	}//remove
	
	public void searchAllCpEmp2() {
		
		StringBuilder viewCpEmp=new StringBuilder();
		viewCpEmp
		.append("----------------------------------------------------------------------------------------------------------------------------------------\n")
		.append("��ȣ\t�����ȣ\t�����\t����\t�Ի���\n")
		.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
		
		
		int rowCount=0;
		try {
			//DB���� ��ȸ�� ��� �ޱ�
			List<CpEmp2AllVO> list=ups_dao.selectAllCpEmp2();
			CpEmp2AllVO cevo=null;
			
			rowCount=list.size();
			for(int i=0; i< list.size(); i++) {
				cevo=list.get(i);
				viewCpEmp.append(i+1).append("\t")
				.append(cevo.getEmpno()).append("\t")
				.append(cevo.getEname()).append("\t")
				.append(cevo.getSal()).append("\t")
				.append(cevo.getHiredate()).append("\n");
			}//end for
			
			if( list.isEmpty() ) {	//list.size()==0
				viewCpEmp.append("�Էµ� �μ������� �������� �ʽ��ϴ�.");
			}//end if
			
		} catch (SQLException e) {
			viewCpEmp.append("DBMS���� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		}//end catch
		
		viewCpEmp.append("---------------------------------------------------------------------------------------------------------------------------------------\n")
		.append("\t\t\t�� ").append(rowCount).append("���� ��������� ��ȸ�Ǿ����ϴ�.");
		
		
		JTextArea jta=new JTextArea(20, 50);
		jta.setEditable(false);
		jta.setText(viewCpEmp.toString()); //������� ��µ����͸� T.A�� �����Ѵ�.
		
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü ��� ��ȸ���"));
		JOptionPane.showMessageDialog(null, jsp);
	}//selectAll
	
	public void searchOneCpEmp2() {
		
		String inputData=JOptionPane.showInputDialog("�����ȸ\n��ȸ�� �����ȣ �Է�");
		if( inputData !=null && !inputData.equals("")) {
			try {
			int empno=Integer.parseInt(inputData.trim());
			//�����ȣ�� �Է��Ͽ� �����ȣ�� �ش��ϴ� ��������� ��ȸ
			//��ȸ�� ����� �ִٸ� ������ ��ü(CpEmp2OnoVO)�� ��ȯ�ǰ� ��ȸ�� �μ��� ���ٸ� null�� ��ȯ�ȴ�.
			CpEmp2OneVO ce_vo=ups_dao.selectOneCpEmp2(empno);
			
			//��¥ �����ϱ�
			SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy EEEEE");
			
			
			StringBuilder viewData=new StringBuilder();
			viewData.append("����� : ").append(ce_vo.getEname())
			.append(", ���� : ").append(ce_vo.getSal())
			.append(", �Ի��� : ").append(sdf.format(ce_vo.getHiredate())); //sdfformat ��ü�� �־ ���
			
			JLabel lbl=new JLabel(viewData.toString());
			lbl.setFont(new Font("SansSerif", Font.BOLD, 15));
			
			JOptionPane.showMessageDialog(null, lbl);
			}catch(NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData+" ����� �������� �ʽ��ϴ�.");
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ���� ���·� �Է��ϼž� �մϴ�.");
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�������� �����߻�!!");
				e.printStackTrace();
			}//end catch
		}//end if
	}//selectOne
	
	
	
	public static void main(String[] args) {
		RunPreparedStatement rps=new RunPreparedStatement();
		
		boolean exitFlag=false;
		String inputMenu="";
		int resMsg=0;
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
		resMsg= JOptionPane.showConfirmDialog(null, "������ �����ǰǰ���?","Ȯ��â",JOptionPane.YES_NO_CANCEL_OPTION);
		if(resMsg==JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "������ �� �̿��� �ּ���", "�����մϴ�",JOptionPane.CLOSED_OPTION);
		}else {
			
		}
//		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�");
		
		
	}//main

}//class
