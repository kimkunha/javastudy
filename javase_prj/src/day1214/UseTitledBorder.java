package day1214;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.memo.view.JavaMemo;
//18.12.14  - 2�� �ڷ�-   ( �̹��� ������ )
/**
 *
 * @author owner
 */
@SuppressWarnings("serial")
public class UseTitledBorder extends JFrame implements ActionListener {
	private JTextField jtfld;
	private JPasswordField jpfPass;
	private JLabel jlOutput;
	
	public UseTitledBorder() {
		 super("Border ���");
		 
		 jtfld=new JTextField();
		 jpfPass=new JPasswordField();
		 jlOutput=new JLabel("��� : ");
		 
		 //�Ϲ�������Ʈ
		 jtfld.setBorder(new TitledBorder("���̵�"));	//Ÿ��Ʋ�ִ� �׵θ� ����
		 jpfPass.setBorder(new TitledBorder("��й�ȣ"));
		 jlOutput.setBorder(new TitledBorder("���â"));
		 
		 JPanel panel=new JPanel();
		 panel.setLayout(new GridLayout(3, 1));
		 
		 //�����̳� ������Ʈ
		 panel.setBorder(new TitledBorder("�α���"));
		 
		 
		 panel.add(jtfld);
		 panel.add(jpfPass);
		 panel.add(jlOutput);
		 
		 //�̺�Ʈ���
		 jtfld.addActionListener(this);
		 jpfPass.addActionListener(this);
		 
		 
		 add("Center",panel);
		 setBounds(100, 100, 250, 300);
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
				 
	}//UseTitledBorder
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String id=jtfld.getText().trim();
		
		if(ae.getSource()==jtfld) {	//���̵𿡼� �̺�Ʈ�� �߻��ϸ�
			//���̵� ���� ����ִٸ� Ŀ���� ��й�ȣ�� �̵�
			if(!id.equals("")) {
				jpfPass.requestFocus();
			}//end if
		}//end if
		if(ae.getSource()==jpfPass) {	//��й�ȣ���� �̺�Ʈ�� �߻��ϸ�
			//���̵� ���� ���ٸ� Ŀ���� ���̵�� �̵�,
			if(id.equals("")) {
				jtfld.requestFocus();
				jlOutput.setText("���̵� �Է����ּ���");
				return;//��ȯ���� void�� method���� �ڵ��� ������ ���߰� ȣ���� ������ ���ư���
			}//end if
			//��й�ȣ�� ���� ���ٸ� ���â�� "����Է�"�� �����ְ� Ŀ���� ��й�ȣ�� �̵�
			
			String pass=new String(jpfPass.getPassword());
			if(pass.trim().equals("")) {
				jlOutput.setText("��й�ȣ�� �Է����ּ���");
				return;
			}//end if
			
			//��й�ȣ�� ���� �ִٸ� ���̵� admin ��й�ȣ�� 123�� ������ 
			//���Ͽ� ���ٸ� �ڹٸ޸��� Ŭ������ ����
			if(id.equals("admin") && pass.equals("123")) {
//				new JavaMemo();
				dispose();
			}else {
				jlOutput.setText("���̵� ��й�ȣ�� Ȯ���� �ּ���.");
			}//end if
			
		}//end if
	}//actionPerformed

	public static void main(String[] args) {
		new UseTitledBorder();
	
	}//main

}//class
