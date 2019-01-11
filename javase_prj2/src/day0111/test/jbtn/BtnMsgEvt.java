package day0111.test.jbtn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BtnMsgEvt extends WindowAdapter implements ActionListener {

	private BtnMsg bm;
	
	public BtnMsgEvt( BtnMsg bm) {
		this.bm=bm;
	}//������

	@Override
	public void windowClosing(WindowEvent ae) {
		bm.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		for(int i=0; i<bm.getJbtNames().length; i++) {
			if(ae.getSource() == bm.getJbtNames()[i]) {
				JOptionPane.showMessageDialog(bm, bm.getMsg()[i]);
				break;
			}
		}
	}//actionPerformed
	
	
}//class
