package study;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 *	TestJbtŬ�������� has a ���� Ŭ����
 * @author owner
 */
public class TestJbtEvt extends WindowAdapter implements ActionListener {

	private TestJbt jb;
	
	public TestJbtEvt( TestJbt jb) {
		this.jb=jb;
	}//������

	@Override
	public void windowClosing(WindowEvent e) {
		jb.dispose();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		for(int i=0; i<jb.getJbtName().length; i++) {
			if(ae.getSource() == jb.getJbtName()[i]) {
				JOptionPane.showMessageDialog(jb, jb.getMsg()[i]);
				
			}
		}//end for
	}//action
	
	
}//clas
