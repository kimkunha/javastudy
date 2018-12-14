package day1211;
//18.12.11  -5��° �ڷ�-  ( Event ó����� 4��° Anonymous inner class ),    
/**
 *	anonymous inner class�� �̺�Ʈ ó��
 * @author owner
 */

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//1.Window Component ���
@SuppressWarnings("serial")
public class EventHandlingAnonymous extends Frame {
	//2. �̺�Ʈ ó���� ����� Component ����
		private Button btn;
	
		public EventHandlingAnonymous() {
			super();
		//3. ������Ʈ ����
			btn=new Button("Ŭ��");
			//4. ��ġ
			Panel panel=new Panel();
			panel.add(btn);
			
			add("Center",btn);
		//5. �̺�Ʈ ��� : anonymous inner class
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("��ư Ŭ��");
				}//actionPerformed
			});
		
		//6. ������ ũ�� ����
			setBounds(200,100,400,200);
		//7. ����ڿ��� �����ֱ�
			setVisible(true);
		}//EventHandlingAnonymous
	
		public Button getBtn() {
			return getBtn();
		}//end getBtn
		
		
		public static void main(String[] args) {
		new EventHandlingAnonymous();
	}//main

}//class
