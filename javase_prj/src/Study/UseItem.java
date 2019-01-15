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
 *	������ ������ �����غ��ھƾƾƾƾƾ�
 * @author owner
 */
@SuppressWarnings("serial")
public class UseItem extends JFrame implements ItemListener {

	private JComboBox<String> jcb;
	private DefaultListModel<String> dlm;
	private JLabel jlbl;
	
	public UseItem() {
		String[] name= { "�����", "�ڿ���", "����ö"};
		
		jcb=new JComboBox<String>(name);
		dlm=new DefaultListModel<String>();
		JList<String> list=new JList<String>(dlm);
		JScrollPane jsp=new JScrollPane(list);
		jsp.setBorder(new TitledBorder("����"));
		
		jlbl=new JLabel("���� : ");
		
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
