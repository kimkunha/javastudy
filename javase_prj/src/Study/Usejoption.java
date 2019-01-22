package Study;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Usejoption extends JFrame implements ActionListener{
	private JButton jb1, jb2, jb3;
	private JLabel jlOut;
	public Usejoption() {
		super("joptionpane 연습!");
		
		jb1=new JButton("inputDialog");
		jb2=new JButton("message");
		jb3=new JButton("confirm");
		
		JLabel jlOut =new JLabel("입력 : ");
		jlOut.setBorder(new TitledBorder("출력창"));

		JPanel jp=new JPanel();
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		
		//이벤트처리
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		add("Center", jp);
		add("South",jlOut);
		
		setBounds(100, 100, 400, 200);
		setVisible(true);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae)  {
		if(ae.getSource() == jb1) {
		String flag=JOptionPane.showInputDialog("이름입력","김건하");
		jlOut.setText(flag);
		}
			
		
		}
	
	public static void main(String[] args) {
		new Usejoption();
	}


}
