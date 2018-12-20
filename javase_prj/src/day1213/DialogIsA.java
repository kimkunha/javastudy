package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//18.12.13  - 3�� �ڷ� - Dialog is a ����� �ۼ�. �����Ұ�. 2 ~ 3����
@SuppressWarnings("serial")
//1. Dialog ���
public class DialogIsA extends Dialog implements ActionListener {
//2. �̺�Ʈ�� �����ִ� ������Ʈ�� ����
	private Button btn;

	//���� ���̾�α��� �θ� �� ��ü�� has a
	public DialogIsA( UseDIalogIsA uda ) {
		super( uda, "���̾�α�", true );
		
		//������Ʈ ����
		Label	lbl=new Label("������ ����� �Դϴ�.");			//�̺�Ʈ�� ���þ����� ������ �ȿ��� ���������� �����ϴ°͵� ������.
		
		btn=new Button("����");
		
		add("Center", lbl);
		add("South", btn);
		
		btn.addActionListener( this );
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});
		//���̾�α��� ��ġ�� �θ������� ���ʿ��� ����
		System.out.println("�θ� X"+uda.getX()+", �θ� y "+uda.getY());
		setBounds(uda.getX()+100, uda.getY()+100,300,300);
		setVisible(true);
		
	}//DialogIsA
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();

	}//actionPerformed

}//class
