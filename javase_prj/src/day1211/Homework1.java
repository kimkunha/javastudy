package day1211;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class Homework1 extends Frame implements ItemListener  {
	// �ν��Ͻ����� ����
	public Choice color;
	public Label lblMsg;
	public TextField tfName;

	public Homework1() {
		color = new Choice();
		color.add("������");
		color.add("������");
		color.add("�Ķ���");
		color.add("������");
		color.add("���");
		color.add("��ȫ��");

		lblMsg = new Label("Label");
		tfName = new TextField("������ ȭ����");

//		Panel PanelCenter=new Panel();
//		PanelCenter.setLayout(new GridLayout(1, 1));
//		PanelCenter.add(color);
//		

		color.addItemListener(this);
//		Homework2 hk2 = new Homework2(this);
//		tfName.addActionListener(hk2);

		// 3
		setLayout(null);

		// 4
		add("East", color);
		add("West", lblMsg);
		add("West", tfName);

		setVisible(true);

		color.setBounds(240, 100, 120, 20);
		lblMsg.setBounds(100, 100, 120, 20);
		tfName.setBounds(80, 150, 120, 20);

		setBounds(200, 100, 400, 400);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}// Homework1

	public Choice  getColor() {
		return color;
	}
	
	public static void main(String[] args) {
		new Homework1();

	}// main

	@Override
	public void itemStateChanged(ItemEvent e) {
		String flag=color.getSelectedItem();
		Color c;
		switch (flag) {
		case  "�Ķ���":
			c = Color.blue ;
			break;
		case "������" :
			c = Color.red ;
			break;
		case "���" :
			c = Color.GREEN ;
			break;
		case "��ȫ��":	
			c = Color.magenta ;

		default :
			c = Color.BLACK;
			break;
		}
		tfName.setForeground(c);
	}



}// class
