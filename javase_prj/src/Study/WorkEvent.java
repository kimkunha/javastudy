package Study;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;

public class WorkEvent extends WindowAdapter implements ActionListener, ItemListener{

	private WorkDesign wd;
	public WorkEvent(WorkDesign wd ) {
		this.wd=wd;
	}
	
	
	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == )
	}

}//class
