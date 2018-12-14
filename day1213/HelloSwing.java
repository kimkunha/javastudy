package day1213;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

//18.12.13  - 4�� �ڷ� -  Swing �պκ�
/**
 *	Swing�� ����� Window Application
 * @author owner
 */
//1. JFrame ���
@SuppressWarnings("serial")
public class HelloSwing extends JFrame implements ActionListener{

	public HelloSwing() {
		super("��������");
		//������Ʈ ����
		JButton jb=new JButton("�ȳ�! �� �����̶�� ��");
		Button btn=new Button("AWT��ư");
		//��ġ������ ��ȯ
		setLayout(new GridLayout(1, 2));
		//��ġ
		add( jb );
		add( btn );
		//�̺�Ʈ ���
		jb.addActionListener( this );
		btn.addActionListener(this);
		//ũ�� ����
		setBounds(100, 100, 300, 200);
		//����ڿ��� �����ֱ�(����ȭ)
		setVisible(true);
		//������ ����ó��
		/*	//Swing�� �̷��� ������� �Ҽ� ������ �Ʒ� ����� �� ȿ�����̴�.
		 * addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		*/   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//HelloSwing
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}//actionPerformed
	
	public static void main(String[] args) {
		new HelloSwing();
	}//main

}//class
