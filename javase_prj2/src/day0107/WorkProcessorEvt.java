package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.activation.ActivationInstantiator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkProcessorEvt extends WindowAdapter implements ActionListener{

	private WorkProcessor wp;
	
	public WorkProcessorEvt(WorkProcessor wp) {
		this.wp=wp;
		
	}//WorkProcessorEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		wp.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed
	
	
	
	
}//class
