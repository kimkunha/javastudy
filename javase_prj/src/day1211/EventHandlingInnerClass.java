package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//18.12.11  -4��° �ڷ�-  ( Event ó����� 3��° Inner Class )
/**
 *	Inner Class �� ����� �̺�Ʈ ó�� : 
 *	�����ο� �ش��ϴ� �̺�Ʈó�� �ڵ尡 �ſ� ���ų�, Ư�� �����ο� �ش��ϴ� �̺�Ʈ�� ó���� ��
 * @author owner
 */
//1. Window component ���
@SuppressWarnings("serial")
public class EventHandlingInnerClass extends Frame {
	//2.�̺�Ʈ ó�� ���� ������Ʈ�� ��üȭ
	private Button btn;
	
	public EventHandlingInnerClass() {
		super("Inner Class�� �̺�Ʈ ó��");
	//3. ������Ʈ ����
		btn=new Button("Ŭ��");
	//4. ��ġ
		Panel panel=new Panel();
		panel.add(btn);
		
		add("Center",panel);
	//5. �̺�Ʈ ���	
		//Inner Class ����.
		EventHandlingInnerClass.InnerActionImpl iai=this.new InnerActionImpl();
		//������Ʈ�� �̺�Ʈ�� ���
		btn.addActionListener( iai );
		
	//6. ������ ũ�� ����
		setBounds(100, 100, 300, 300);
		
	//7. ����ڿ��� �����ֱ�
		setVisible(true);
		
		
	}//EventHandlingInnerClass
	
	///////////////////////////////////////////////////// Inner class ���� ////////////////////////////////////////////////////
	//5-1. Inner Class�� �̺�Ʈó�� �����ʸ� ����
	public class InnerActionImpl implements ActionListener{

		@Override
		//5-2. abstract method Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ư�� Ŭ���Ͽ����ϴ�. o(>.<)o ��~~~");
			dispose();// ����Ŭ���������� �ٱ� Ŭ������ �ڿ��� ���� ó�� ����� �� �ִ�.
		
		}//actionPerformed
		
		
		
	}//class
	///////////////////////////////////////////////////// Inner class �� //////////////////////////////////////////////////////
	
	
	
	public Button getBtn() {
		return btn;
	}//getBtn
	
	
	
	public static void main(String[] args) {
		new EventHandlingInnerClass();
	}//main

}//class