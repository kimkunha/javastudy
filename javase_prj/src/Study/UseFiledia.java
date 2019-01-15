package Study;

import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UseFiledia  extends JFrame{

	private JButton jbtOpen, jbtClose;
	private  JLabel jlbl;
	
	public UseFiledia() {
		super("파일 다이얼로그 연습");
		
		jbtOpen=new JButton("열기모드");
		jbtClose=new JButton("저장모드");
		jlbl =new JLabel("출력창 : ");
		
		JPanel jp=new JPanel();
				jp.add(jbtOpen);
				jp.add(jbtClose);
				add("Center", jp);
				add("South",jlbl);
				
				setBounds(100, 100, 400, 150);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				//이벤트 처리
				
				UseFilediaEvt ufe= new UseFilediaEvt(this);
				addWindowListener(ufe);
				
				jbtOpen.addActionListener(ufe);
				jbtClose.addActionListener(ufe);
				
				
				
	}//생성자
	
	
	
	
	
	
	public JButton getJbtOpen() {
		return jbtOpen;
	}


	public JButton getJbtClose() {
		return jbtClose;
	}

	public JLabel getJlbl() {
		return jlbl;
	}



	public static void main(String[] args) {
		new UseFiledia();
	}//main

}//class
