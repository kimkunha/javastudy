package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//18.12.10  - 4��° - (������ġ)
/**
 *	������ġ : �����ڰ� ������Ʈ�� ��ġ ��ġ�� ũ�⸦ �����ϴ� ��ġ���
 * @author owner
 */
//1. ������ ������Ʈ�� ���
@SuppressWarnings("serial")
public class UseManualLayout extends Frame {

	public UseManualLayout() {
		super("������ġ");
		//1. ������Ʈ�� ����
		Label lbl=new Label();
		lbl.setText("��");
		TextField tf=new TextField();
		Button btn=new Button("Ŭ��");
		
		//2. ��ġ�����ڸ� ����( ���� ) : BorderLayout
		setLayout(null);
		//3. ��ġ  (ũ�� 2���� ��ǥ����, ũ�⼳��)
		//��ǥ, ũ�� ����
		lbl.setLocation(10,35); //��ġ ��ǥ
		lbl.setSize(80, 20);//��ġ ũ��
		tf.setBounds(50, 100, 120, 25);// x, y, w, h
		btn.setBounds(250, 200, 120, 23);// x, y, w, h
		
		add( lbl ); //Frame�� ��ġ
		add( tf ); //Frame�� ��ġ
		add( btn ); //Frame�� ��ġ
		
		
		//4. ������ ��ǥ ����
//		setLocation(100, 200);
		//5. ������ ũ�� ����
//		setSize(500, 600);
		
		//4+5)��ǥ�� ũ�⸦ �ѹ��� ����
		setBounds(200,100,400,250);
		
		//ũ�⸦ Ȯ��, ��Ҹ� ���ϰ� ����
		setResizable(false);
		
		//6. ����ڿ��� �����ֱ�
		setVisible(true);
		
		//7. ����ó��
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent we) {
			dispose();
		}//windowClosing
		});
		
		
		
	}//endUseManualLayout
	public static void main(String[] args) {
		new UseManualLayout();
		
		
		
	}//main

}//class
