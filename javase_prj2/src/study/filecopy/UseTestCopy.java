package study.filecopy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *	���� ���̾�α׸� ��� ������ ������ "���ϸ�_bak"���� �����ϱ�.
 * @author owner
 */
public class UseTestCopy extends JFrame implements ActionListener{

	private JButton jbtOpen;
	private JLabel jlResult;
	
	public UseTestCopy() {
		super("������ �����Ͻÿ�");
		jbtOpen =new JButton("���ϼ���");
		
		add("South",jbtOpen);
		setBounds(100,100,300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//������
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//action
	
	public static void main(String[] args) {
		new UseTestCopy();
	}//main


}//class
