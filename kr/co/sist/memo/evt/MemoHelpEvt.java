package kr.co.sist.memo.evt;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.MemoHelp;

/**
 *
 * @author owner
 */
public class MemoHelpEvt extends WindowAdapter implements ActionListener{
	private MemoHelp mh;
	
	public MemoHelpEvt(MemoHelp mh) {
		this.mh=mh;
	}//MemoHelpEvt
		
		@Override
		public void windowClosing(WindowEvent e) {
			mh.dispose();
		}//windowClosing
	

		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==mh.getBtnHelp()) {
				mh.dispose();
				
			}//end if
			
		
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
}//class
