package day0111.use.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class JTableTestEvt extends WindowAdapter implements ActionListener, MouseListener {


	private JTableTest jt;
	
	public JTableTestEvt( JTableTest jt ) {
		this.jt=jt;
	}//������

	@Override
	public void windowClosing(WindowEvent e) {
		jt.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jt.getJbtAdd() ) {
			String inputScore="";
			String[]score=null;
			inputScore=JOptionPane.showInputDialog(jt, "���� �Է����ּ���\n��)�̸�,�ڹ�����,���̽�����,�ڹٽ�ũ��Ʈ����,����Ŭ����");
			score=inputScore.split(",");
			if(score.length !=5) {
				JOptionPane.showMessageDialog(jt, "�Է»����� Ȯ�����ּ���.");
				return;
			}//end if
			jt.getDtm().addRow(score);
			
		}//end if
		
		

		
	
	}//action

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println(jt.getDtm().getValueAt(jt.getDtm().getsele, column); 
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
	
}//class
