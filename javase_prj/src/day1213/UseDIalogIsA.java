package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//18.12.13  - 2�� �ڷ� - Dialog is a ����� �ۼ�. �����Ұ�. 2 ~ 3 ����
/**
 * FrameŬ�������� is a �� ������ DialogŬ������ ���
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseDIalogIsA extends Frame implements ActionListener {

	private Button btn1/* Frame�� ��ġ */, btn2/* Dialog */;

	public UseDIalogIsA() {
		super("���̾�α� ���");

		btn1 = new Button("���̾�α� ���");
		Panel panel = new Panel();
		panel.add(btn1);

		add("Center", panel);

		btn1.addActionListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}// end windowClosing
		});

	}// UseDialogHasA

	@Override
	public void actionPerformed(ActionEvent ae) {
		createDialog();
	}// actionPerformed

	public void createDialog() {
		new DialogIsA( this );
	}// createDialog

	public static void main(String[] args) {
		new UseDIalogIsA();
	}// main

}// class
