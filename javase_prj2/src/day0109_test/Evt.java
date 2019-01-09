package day0109_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class Evt extends WindowAdapter implements ActionListener {
	
	private Run r;
	
	public Evt(Run r ) {
		this.r=r;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==r.getJcomDataType()) {
			String[] data= {"varchar2","number"};
			
//			r.getJcomDataType().
		}

	}//actionPerformed
}//class