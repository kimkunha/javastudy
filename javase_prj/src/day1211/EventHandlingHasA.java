package day1211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//18.12.11  -3��° �ڷ�-  ( Event ó����� 2��° Has a���� )    2-3�� ���� has a���谡 ���� ���ֻ��
/**
 *	Has a ����� �̺�Ʈ ó��
 * @author owner
 */
//1. �̺�Ʈ ó�� ��ü�� ����
public class EventHandlingHasA implements ActionListener {		//Overriding�� �ؾ� ���� ����
	//EventHandlingHasA �� Design�� ������ �ִ�.
//2. has a ���� �����ϰ� ����� ��ü ����
	private Design design;

	public  EventHandlingHasA( Design design) {
		this.design=design;
	}//EventHandlingHasA
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�̺�Ʈ�� �߻������� ó���� �ڵ�
		System.out.println("���޹��� Design��ü"+ design);
		design.dispose();
	}//actionPerformed
	
	
	
}//class
