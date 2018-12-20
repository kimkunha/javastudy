package day1217;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//18.12.17 -2�� �ڷ�- ( JTab )
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *	���� Ǯ��� 4��° ���� �����
 *	��й�ȣ â�� ��ǲ���̾�α׷� ���� ��ι�ȣ 123�� �Է��ϸ� ���� �׸��ϳ��� ����
 *	��й�ȣ�� Ʋ������� 1���� ������ �ǵ��� ����.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTab extends JFrame implements MouseListener{

	public UseJTab() {
		super("Tab");
		//1. ���� �߰��� �� �ִ� ��ü ����
			JTabbedPane jtp=new JTabbedPane();
		
		//2. �� ���� �� ������Ʈ�� ����
			ImageIcon ii=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img1.PNG");
			JLabel jl=new JLabel(ii);
			
			
			//�ι�° �ǿ� �� ������Ʈ
			JPanel jp=new JPanel();
			jp.add(new JLabel("�̸�"));
			jp.add(new JTextField(30));
			
			jp.add(new JButton("�Է�"));
			jp.add(new JButton("�Է�"));
			
			JPanel tab2=new JPanel();
			tab2.setLayout(new BorderLayout());
			
			jp.setBorder(new TitledBorder("�Էµ�����"));
			
			JTextArea jta=new JTextArea();
			JScrollPane jsp=new JScrollPane(jta);
			jsp.setBorder(new TitledBorder("���â"));
			
			tab2.add("North",jp);
			tab2.add("Center",jsp);
			
			//4��° �� ��
			ImageIcon ii2=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img2.PNG");
			JLabel jl2=new JLabel(ii2);
			
			jtp.add("ó����", jl);
			jtp.addTab("�ι�° ��", tab2);
			jtp.add("����° ��", new JButton("Ŭ��"));
			jtp.add("�׹�° ��", jl2);
			
			//�̺�Ʈ ó��
			addMouseListener(this);
			
			
			//��ġ
			add("Center",jtp);
			
			setBounds(100, 100, 600, 400);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
	}//UseTab

	@Override
	public void mouseClicked(MouseEvent me) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public static void main(String[] args) {
		new UseJTab();
	}//main
}//class
