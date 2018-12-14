package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

//18.12.11  -2��° �ڷ�-  ( Event ó����� 2��° Has a���� )  2 ~ 3�ڷ� ����
/**
 *	has a ������ �̺�Ʈ ó��<br>
 *	�����ΰ� �̺�Ʈ ó�� �ڵ带 �и��Ͽ� �ڵ��� ���⵵�� ���� �� �ִ�.
 * @author owner
 */
@SuppressWarnings("serial")
//1. Window Component ���
public class Design extends Frame{
	//2. �̺�Ʈ ó���� �����ִ� Component�� ����
	private Button btn;
	
	public Design() {
		super("������");
	//3. ������Ʈ ����
		btn =new Button("Ŭ��");
		
	//4. ��ġ
		Panel panel=new Panel();
		panel.add( btn );
		
		add("Center", panel);
	//4��-5�� ���̿� 5. Event ���
	//�̺�Ʈ ó�� ��ü �����ϰ� has a ����
		EventHandlingHasA ehha=new EventHandlingHasA(this);
		System.out.println("������ ������ ��ü"+ehha);
	//������Ʈ�� Event�� ���
		btn.addActionListener(ehha);//��ư���� �̺�Ʈ�� �߻��ϸ� ehha��ü�� Override�� method���� �̺�Ʈ�� ó��
		
		
	//6. ������ ũ�� ����
		setBounds(100, 100, 400, 300);
		
	//7. ����ڿ��� �����ֱ� 
		setVisible(true);
		
		
	}//end Design
	
	//Button�� �޾ư� getter����
	public Button getBtn() {
		return btn;
	}//getBtn
	
	
	
	
	
	public static void main(String[] args) {
		new Design();
		
	}//main

}//class
