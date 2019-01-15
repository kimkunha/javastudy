package Study;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JList;
import javax.swing.JTextField;

public class TestUseAction extends WindowAdapter implements ActionListener {
	
	private TestAction ta;
	
	public TestUseAction(TestAction ta) {
		this.ta=ta;
	}//»ý¼ºÀÚ
	
	@Override
	public void windowClosing(WindowEvent e) {
		ta.dispose();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==ta.getJbt1()) {
//			String value=ta.getJtf().getText();
//			if(!value.isEmpty()) {
//				ta.getDlm().addElement(value);
//				ta.getJtf().setText("");
//				ta.getJtf().requestFocus();
//			}
			String name=ta.getJtf().getText().trim();
			JTextField jtf=ta.getJtf();
			if(name !=null ) {
				ta.getDlm().addElement(name);
				jtf.setText("");
				jtf.requestFocus();
			}
			
			
		}
		
		if(ae.getSource() == ta.getJbt2()) {
			JTextField jtf=ta.getJtf();
			
			jtf.setText("");
			jtf.requestFocus();
		}
		
	}//actionPerformed

	
}//class
