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
		super("���� ���̾�α� ����");
		
		jbtOpen=new JButton("������");
		jbtClose=new JButton("������");
		jlbl =new JLabel("���â : ");
		
		JPanel jp=new JPanel();
				jp.add(jbtOpen);
				jp.add(jbtClose);
				add("Center", jp);
				add("South",jlbl);
				
				setBounds(100, 100, 400, 150);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				//�̺�Ʈ ó��
				
				UseFilediaEvt ufe= new UseFilediaEvt(this);
				addWindowListener(ufe);
				
				jbtOpen.addActionListener(ufe);
				jbtClose.addActionListener(ufe);
				
				
				
	}//������
	
	
	
	
	
	
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
