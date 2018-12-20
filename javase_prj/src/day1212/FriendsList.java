package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
//18.12.12  -3��° �ڷ�- ( 3 ~ 4�� has a �ڷ� ���� )
/**
 *	Has a ����� Event ó��
 * @author owner
 */
/**
 * @author owner
 *
 */
@SuppressWarnings("serial")
public class FriendsList extends Frame {
	private List listFriend, listBlockFriend;
	private Button btnAllBlock, btnAllunblock;
	
	
	public FriendsList() {
		super("ģ������");
		
		Label lbl1 = new Label("ģ�� ���");
		Label lbl2 = new Label("���ܵ� ģ��");
		
		 listFriend = new List();
		listBlockFriend = new List();
		listFriend.add("������");
		listFriend.add("������");
		listFriend.add("���ü�");
		listFriend.add("���ý�");
		
		btnAllBlock = new Button(">>");
		btnAllunblock = new Button("<<");
		
		
		setLayout(null);
		lbl1.setBounds(80, 100, 150, 50);
		lbl2.setBounds(355, 100, 150, 50);
		listFriend.setBounds(30, 150, 150, 200);
		listBlockFriend.setBounds(320, 150, 150, 200);
		btnAllBlock.setBounds(225, 200, 50, 30);
		btnAllunblock.setBounds(225, 250, 50, 30);
		
		
		
		add(lbl1);
		add(lbl2);
		add(listFriend);
		add(listBlockFriend);
		add(btnAllBlock);
		add(btnAllunblock);
		
		
		//�̺�Ʈ ���
		//������ Ŭ������ �̺�Ʈ ó�� Ŭ������ has a ����
		FriendsListEvt fle=new FriendsListEvt(this);
		btnAllBlock.addActionListener( fle );
		btnAllunblock.addActionListener( fle );
		
		listBlockFriend.addItemListener( fle );
		listFriend.addItemListener( fle );
		
		addWindowListener(fle);
		
		setBounds(200, 200, 500, 400);
		setResizable(false);
		
		setVisible(true);
		
	}//FriendList
	
	

	public List getListFriend() {
		return listFriend;
	}//getListFriend



	public List getListBlockFriend() {
		return listBlockFriend;
	}//getListBlockFriend



	public Button getBtnAllBlock() {
		return btnAllBlock;
	}



	public Button getBtnAllunblock() {
		return btnAllunblock;
	}



	public static void main(String[] args) {
		new FriendsList();
	}//main

}//class
