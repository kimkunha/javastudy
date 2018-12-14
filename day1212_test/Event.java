package day1212_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Event extends WindowAdapter implements ItemListener,ActionListener {
	private Design ds;
	
	public Event( Design ds) {
		this.ds=ds;
	}//Event
	
	@Override
	public void windowClosing(WindowEvent wc) {
		ds.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}//class
