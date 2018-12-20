package day1217;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//18.12.17 -2번 자료- ( JTab )
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
 *	문제 풀어보기 4번째 탭을 만들어
 *	비밀번호 창이 인풋다이얼로그로 나와 비민번호 123을 입력하면 들어가져 그림하나를 띄운다
 *	비밀번호가 틀렸을경우 1번쨰 탭으로 되돌아 간다.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTab extends JFrame implements MouseListener{

	public UseJTab() {
		super("Tab");
		//1. 탭을 추가할 수 있는 객체 생성
			JTabbedPane jtp=new JTabbedPane();
		
		//2. 각 탭의 들어갈 컴포넌트를 생성
			ImageIcon ii=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img1.PNG");
			JLabel jl=new JLabel(ii);
			
			
			//두번째 탭에 들어갈 컴포넌트
			JPanel jp=new JPanel();
			jp.add(new JLabel("이름"));
			jp.add(new JTextField(30));
			
			jp.add(new JButton("입력"));
			jp.add(new JButton("입력"));
			
			JPanel tab2=new JPanel();
			tab2.setLayout(new BorderLayout());
			
			jp.setBorder(new TitledBorder("입력데이터"));
			
			JTextArea jta=new JTextArea();
			JScrollPane jsp=new JScrollPane(jta);
			jsp.setBorder(new TitledBorder("결과창"));
			
			tab2.add("North",jp);
			tab2.add("Center",jsp);
			
			//4번째 들어갈 탭
			ImageIcon ii2=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img2.PNG");
			JLabel jl2=new JLabel(ii2);
			
			jtp.add("처음탭", jl);
			jtp.addTab("두번째 탭", tab2);
			jtp.add("세번째 탭", new JButton("클릭"));
			jtp.add("네번째 탭", jl2);
			
			//이벤트 처리
			addMouseListener(this);
			
			
			//배치
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
