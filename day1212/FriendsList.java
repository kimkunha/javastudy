package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
//18.12.12  -3번째 자료- ( 3 ~ 4번 has a 자료 연계 )
/**
 *	Has a 관계로 Event 처리
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
		super("친구관리");
		
		Label lbl1 = new Label("친구 목록");
		Label lbl2 = new Label("차단된 친구");
		
		 listFriend = new List();
		listBlockFriend = new List();
		listFriend.add("이재찬");
		listFriend.add("이재현");
		listFriend.add("정택성");
		listFriend.add("정택승");
		
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
		
		
		//이벤트 등록
		//디자인 클래스와 이벤트 처리 클래스는 has a 관계
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
