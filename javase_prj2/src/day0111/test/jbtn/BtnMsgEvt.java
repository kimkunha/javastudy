package day0111.test.jbtn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class BtnMsgEvt extends WindowAdapter implements ActionListener {

	private BtnMsg bm;
	
	public BtnMsgEvt( BtnMsg bm) {
		this.bm=bm;
	}//»ý¼ºÀÚ

	@Override
	public void windowClosing(WindowEvent ae) {
		bm.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
//		for(int i=0; i<jb)
//		ae.getSource()
	}//actionPerformed
	
	
}//class
