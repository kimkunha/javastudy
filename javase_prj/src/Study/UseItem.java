package Study;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *	아이템 리스너 공부해보자아아아아아아
 * @author owner
 */
@SuppressWarnings("serial")
public class UseItem extends JFrame implements ItemListener {

	private JComboBox<String> jcb;
	private DefaultListModel<String> dlm;
	private JLabel jlbl;
	
	public UseItem() {
		String[] name= { "김건하", "박영민", "김희철"};
		
		jcb=new JComboBox<String>(name);
		dlm=new DefaultListModel<String>();
		JList<String> list=new JList<String>(dlm);
		JScrollPane jsp=new JScrollPane(list);
		jsp.setBorder(new TitledBorder("정보"));
		
		jlbl=new JLabel("정보 : ");
		
		add("North", jcb);
		add("Center", jsp);
		add("South", jlbl);
		setBounds(100, 100, 300, 300);
		setVisible(true);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
	
	public static void main(String[] args) {
		new UseItem();
	}//main



}//class
