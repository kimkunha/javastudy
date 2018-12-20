package day1217;
//18.12.17 -1�� �ڷ�- ( JTable)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *	MVC Pattern�� ����� class
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener{
private JButton btnAdd;
private DefaultTableModel dtm;
private JTable jt;
private UseJTable ujt;
	public UseJTable() {
		super("JTable ����");
		ujt=this;	
	//1.�����͸� �����ϴ� Model Ŭ���� ����
		String[] columnNames= {"��ȣ", "�̸�", "�ּ�", "�̸���"};
		String[][] rowData= {   {"1","������","��õ�� �ҷ���","chan@test.com"},
									 {"2","���ü�","����� ���ε�","teack@test.com"},
									 {"3","���ü�","��⵵ �Ⱦ��","hyun@test.com"}
		};
		dtm=new DefaultTableModel(rowData, columnNames) {
		//���� ����Ŭ�� ������� ������ �Ұ��� �ϰ� ����� method ��ϸս��� Ŭ������ �����ߴ�.
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
			}	
		};
	
		//2. �����͸� �����ִ� View Ŭ���� ����
			jt=new JTable(dtm);
		//2-2. ���̺� �÷��� ũ�� ���� : �÷��� �ϳ���  ���̸� �����ϸ� ���� ��� �÷��� ������ ũ�⸦ ���� �ް� �ȴ�.
			//�÷� ũ�� ���� 1. : �÷��� ��´�.
				TableColumn tc=jt.getColumnModel().getColumn(0);			//���̺� �÷��� ��ü�� ���
//			�÷� ũ�� ���� 2. : �÷��� ũ�⺯��.
				tc.setPreferredWidth(10);												//ũ�⺯���ϴ� Method
			//2�� ����ϸ� �ڵ尡 ������� ���� ��ü�������� �Ʒ��� ���� ����Ҽ� �ִ�.
				
//				jt.getColumnModel().getColumn(0).setPreferredWidth(10);	
				jt.getColumnModel().getColumn(1).setPreferredWidth(30);	
				jt.getColumnModel().getColumn(2).setPreferredWidth(100);
				jt.getColumnModel().getColumn(3).setPreferredWidth(150);
				
		//2-3. ���̺��� ���� ����
				jt.setRowHeight(25);
				
			btnAdd=new JButton("������ �߰�");
			//2-1. Column�� �̸��� ScrollBar�� ��� �� �� �ֵ��� JScrollPane�� ��ġ
				JScrollPane jsp=new JScrollPane(jt);
				JPanel jp=new JPanel();
				jp.add(btnAdd);
			
		//3. ��ġ
			add("Center", jsp);
			add("South", jp);
			setBounds(100, 100, 500, 300);
		//3-1. �̺�Ʈ���
			btnAdd.addActionListener(this);
			//inner Ŭ���� ��üȭ
			UseJTable.TableEvt te= this.new TableEvt();
			jt.addMouseListener(te);
	
			
		//4. ����ȭ
			setVisible(true);
		//5. ����ó��
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}//UseJTable
	

@Override
public void actionPerformed(ActionEvent ae) {
	String inputData=JOptionPane.showInputDialog("�������Է�\n��)��ȣ,�̸�,�ּ�,�̸���");
	String[] tempData=inputData.split(",");
	//��ȿ������ �޸��� �������� 4�� �� �־���Ѵ� 
	if(tempData.length !=4) {
		JOptionPane.showMessageDialog(this, "�Էµ������� ���´� \n��ȣ,�̸�,�ּ�,�̸��� �̾�� �մϴ�", "�Է¿���", JOptionPane.ERROR_MESSAGE);
		return;	//method void�ΰ�� return�ΰ��� �� �������� ���� ȣ���Ѱ����� ���ư���.
	}//end if
	//�Էµ� �����͸� ȭ�鿡 �����ֱ� ���� DefaultTableModel�� �߰�(���߰�)
	dtm.addRow(tempData);
	
	
}//actionPerformed

//////////////////////////////////////////////////////////// inner class ���� ////////////////////////////////////////////////////////////////////
public class TableEvt extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent me) {
//		System.out.println("�༱�� : "+jt.getSelectedRow()+", ������ : "+jt.getSelectedColumn());	//������ ��� ���� �ƴ� method
		System.out.println(jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn())); 	//��� �� ��ġ�� �ִ� ���� ��� method (���� �ϳ� �̴� ���)
//		String selectedValue=(String)jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());
//		String selectedValue0=(String)jt.getValueAt(jt.getSelectedRow(), 0);
//		String selectedValue1=(String)jt.getValueAt(jt.getSelectedRow(), 1);
//		String selectedValue2=(String)jt.getValueAt(jt.getSelectedRow(), 2);
//		String selectedValue3=(String)jt.getValueAt(jt.getSelectedRow(), 3);
		
		StringBuilder viewData=new StringBuilder();
		int selectedRow=jt.getSelectedRow();
		int columnCount=jt.getColumnCount();
		
		//�� �����ϱ�
		int flag=JOptionPane.showConfirmDialog(ujt, "���� ������ ��ȸ, �ƴϿ� ������ ������ �����մϴ�.");
		switch (flag) {
		case JOptionPane.OK_OPTION :
			for(int i=0; i< columnCount; i++) {
				viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
			}//end for
			
			JOptionPane.showMessageDialog(ujt , viewData);
			break;
			
		case JOptionPane.NO_OPTION :
			
			switch (JOptionPane.showConfirmDialog(ujt, "���� �����Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION : 
				dtm.removeRow(selectedRow);
			}//end switch

		}//end switch
	}//mousClicked
	
//		for(int i=0; i< columnCount; i++) {
//			viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
//		}//end for
//		
//			JOptionPane.showMessageDialog(ujt , viewData);
//	}//mouseClicked
	
}//class
//////////////////////////////////////////////////////////// inner class �� //////////////////////////////////////////////////////////////////////


public static void main(String[] args) {
	new UseJTable();
	}//main
}//class
