package day1214;


import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//18.12.14  - 1�� �ڷ�-   ( �̹��� ������ )
/**
 *	Icon class�� ����� �̹��� ���.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseImageIcon extends JFrame {
	
	public UseImageIcon() {
		super("ImageIcon���");
	
		ImageIcon ii1=new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day1214\\images\\img1.PNG");
		ImageIcon ii2=new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day1214\\images\\img2.PNG");
		ImageIcon ii3=new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day1214\\images\\img3.PNG");
	
		JButton btn1=new JButton("��ư1", ii1);
		JButton btn2=new JButton("��ư2", ii2);
		JButton btn3=new JButton("��ư3", ii3);
		
		//ToolTip Text ����
		btn1.setToolTipText("��ư1");
		btn2.setToolTipText("��ư�� Ŭ���ϼ���");
		btn3.setToolTipText("������ �ݿ��� �Դϴ�");
		
		//RollOver Icon
		btn3.setRolloverIcon(ii2);
		
		//��ư ����ġ ����
		//������ġ ���� : LEFT, CENTER, RIGHT
		btn1.setHorizontalTextPosition(JButton.RIGHT );
		//���� ��ġ�� ���� : TOP, CENTER, BOTTOM
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		//��� �Ʒ��� ��ġ �ϱ�
		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		
		setLayout(new GridLayout(1, 3));
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		setBounds(100, 100, 1500, 400);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//UseImageIcon
	
public static void main(String[] args) {
	new UseImageIcon();
	

	
	
	
	}//main
}//class
