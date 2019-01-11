package study;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *	버튼 배열로 담아서 코드를 줄이는 방법
 * @author owner
 */
public class TestJbt extends JFrame{

	private JButton[] jbtName;	//버튼 
	private String[] name;
	private String[] msg;

	public TestJbt() {
		super("TestJbutton");
		jbtName = new JButton[10];
		name= new String[] {"김건하", "공선의", "이재찬", "오영근","김정운","이재현","박영민","김희철","이봉현","최혜원" };
		msg= new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		
		//객체생성을 하기 위해 for문으로 입력
		for(int i=0; i<jbtName.length; i++) {
			jbtName[i]=new JButton(name[i]); //for문이 한번 돌때 jbutton안에 스트링 name 인덱스 순서대로 1들어가고 jbtname 객체 생성
			add(jbtName[i]);
		}//end for
		setBounds(100, 100, 300, 300);
		setLayout(new GridLayout(5, 2));
		setVisible(true);
		
		TestJbtEvt tje=new TestJbtEvt(this);
		addWindowListener(tje);
		for(int i=0; i<jbtName.length; i++) {
			jbtName[i].addActionListener(tje);
		}
		
	}//생성자
	
	
	
	public JButton[] getJbtName() {
		return jbtName;
	}

	public String[] getMsg() {
		return msg;
	}

	public static void main(String[] args) {
		new TestJbt();
	}
	

}//class
