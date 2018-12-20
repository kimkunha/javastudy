package day1210;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//18.12.10  - 1��° - (BorederLayout)
/**
 *	�Ϲ�������Ʈ�� LayoutManager�� ���
 * @author owner
 */
//1. Window Component ���    //�޾ƾ� �Ǵ� ����?  ����ڿ��� �������� ���� �ؾ��ϱ� ����
@SuppressWarnings("serial")//�̰� �ϴ� ������ ���߿� ���� ��
public class UseBorderLayout  extends Frame{
	
	public UseBorderLayout() {
		super("BorderLayout ����");			//�ϴ� ���� : �θ��� �����ڸ� ȣ��
		//2. ����� �Ϲ� ������Ʈ�� ����
		TextField tfNorth = new TextField("North");
		Label lblEast= new Label("East");
		TextArea taCenter =new TextArea("Center");
		Label lblWest = new Label("West");
		Choice choSouth = new Choice();
		choSouth.add("South");
		
		//3. ��ġ������ ���� : Window Component�� Frame, Dialog�� BorderLayout �⺻ ����
//		setLayout(new BorderLayout()); //�⺻���� �Ǿ� �ִ�. ���ٰ� �޶����°� ����.
		
		//4. ������Ʈ�� ��ġ�����ڸ� ����Ͽ� ��ġ
		// add("��ġ��ġ", ������Ʈ);		add(���, ������Ʈ);
		// ���ڿ� ��� ����Ͽ� ��ġ
		add("North",tfNorth);
		add("Center",taCenter);// center�� ��ġ�ϸ� �׵θ��� North, West, South, East�� �ڸ��� �������.
		//Constant( Field )�� ����Ͽ� ��ġ
		add(BorderLayout.WEST, lblWest);
		add(BorderLayout.EAST, lblEast);
		add(BorderLayout.SOUTH,choSouth);
		
		
		
		//5. �������� ũ�� ����
		setSize(400, 400);
									
		//6. ����ڿ��� �����ֱ�   (�̰��� �ؾ� �������� ����� �ȴ�)
		setVisible(true);
		
		//7.����
		addWindowListener(new WindowAdapter() {		// WindowAdapter()�� �߻�Ŭ�����̴�
			@Override
			public void windowClosing(WindowEvent we) {
			 dispose();	
			}//windowClosing
		}/*anonymous inner class*/ );
		
	
		
		
	}//UseBoderLayout
	
	public static void main(String[] args) {
		new UseBorderLayout();
	
	
	
	
	
	
	
	}//main

}//class
