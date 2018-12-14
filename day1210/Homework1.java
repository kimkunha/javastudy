package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *	
 * @author owner
 */
//1. Window Component ���
@SuppressWarnings("serial")
public class Homework1 extends Frame {

	public Homework1() {
		super("homework1");
		//2.����� �Ϲ� ������Ʈ�� ����
		//north
		Label lblStudents=new Label("�л�����");
		
		
		
		//Center
		Label lblName=new Label("�̸�");
		TextField rfName1=new TextField(20);
		Label lblAge=new Label("����");
		TextField rfName2=new TextField(20);
		Label lblTel=new Label("��ȭ��ȣ");
		TextField rfName3=new TextField(20);
		Label lblSex=new Label("����");
		CheckboxGroup cg=new CheckboxGroup();
		Checkbox cbGender1=new Checkbox("��",false,cg);
		Checkbox cbGender2=new Checkbox("��",false,cg);

		TextArea nfEast =new TextArea();

		
		
		//south
		Button btnAdd=new Button("�߰�");
		Button btnUpdate=new Button("����");
		Button btnDelete=new Button("����");
		Button btnClose=new Button("����");
		
		//�Ϲ� ������Ʈ�� ��ġ�� �� �ִ� �����̳� ������Ʈ�� ����
		Panel panelNorth=new Panel();
		Panel panelSouth=new Panel();
		Panel panelWest=new Panel();
		Panel panelEast=new Panel();
		Panel gender = new Panel();
		
		
		//������ �����̳� ������Ʈ�� �Ϲ� ������Ʈ ��ġ
		
		//North
		panelNorth.add(lblStudents);
		
		
		//West
		panelWest.setLayout(new GridLayout(4,2 ));
		panelWest.add( lblName );
		panelWest.add( rfName1 );
		panelWest.add( lblAge );
		panelWest.add( rfName2 );
		panelWest.add(lblTel);
		panelWest.add( rfName3 );
		panelWest.add(lblSex);
		panelWest.add(gender);
		
		//South
		panelSouth.add(btnAdd);
		panelSouth.add(btnUpdate);
		panelSouth.add(btnDelete);
		panelSouth.add(btnClose);
		
		//Gender
		gender.add(cbGender1);
		gender.add(cbGender2);
		
		//East
		panelEast.add(nfEast);
		
		//3. ��ġ������ ����
		setLayout(new BorderLayout());
//		setLayout(new GridLayout(1, 2));
		
		//4. ��ġ borderLayout 
		add("North", panelNorth);
		add("South",panelSouth);
		add("West",panelWest);
		add("East",panelEast);
			
		
		
		
		
		
		
		
		
		//5. ������ ũ�� ����
				setSize(400, 400);
				
				//6. ����ڿ��� �����ֱ�
				setVisible(true);
				//������ ���� �̺�Ʈ ó��
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent we) {
						dispose();
					}//windowClosing
				});//windowClosing
		
		
		
		
		
		
		
		
		
	}//end Homework1
	
	public static void main(String[] args) {
		new Homework1();
		
		
		
	}//main

}//class
