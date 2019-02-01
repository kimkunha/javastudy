package study.filecopy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *	파일 다이얼로그를 열어서 선택할 파일을 "파일명_bak"으로 복사하기.
 * @author owner
 */
public class UseTestCopy extends JFrame implements ActionListener{

	private JButton jbtOpen;
	private JLabel jlResult;
	
	public UseTestCopy() {
		super("파일을 복사하시오");
		jbtOpen =new JButton("파일선택");
		
		add("South",jbtOpen);
		setBounds(100,100,300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//생성자
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//action
	
	public static void main(String[] args) {
		new UseTestCopy();
	}//main


}//class
