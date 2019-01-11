package day0111.test.jbtn;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//19.01.11 -1번자료- (Jbutton Array)
public class BtnMsg extends JFrame  {
//컴포넌트라고 배열을 못쓰는건 아니다. 이번에 배열을 사용해서 사용해보자. 코드 단축.
	private JButton[] jbtNames;  //사용할 컴포넌트
	private String[] names;	//배열에 넣을 이름
	private String[] msg, msg2;	//배열에 넣을 메세지
	
	public BtnMsg() {
		super("이름을 클릭해 주세요.");
		
		names=new String[] 
				{ "김정윤", "박영민", "노진경", "김희철", "김정운", "이재찬", "이재현", "공선의", "김건하", "오영근" };
		msg=new String[] 
				{ "서울은 춥다.", "각자해보세요", "담배피우러 가자!!", "집에 가고 싶다.", "재찬이가 좋아요 *^-^*", "조퇴하고 싶다.",
						"형! 제가 캐리할께요.", "수영하고 싶다.", "점심 먹으러 가자", "주말에 공부하세요." };
		
		jbtNames=new JButton[10];
		
		//for문으로 객체 생성
		for(int i=0; i<jbtNames.length; i++) {
			jbtNames[i]=new JButton(names[i]);
//			jbtNames[i].addActionListener(this); // 이벤트도 같이 for문 돌려서 등록
			add(jbtNames[i]);
		}//end for
		
		setLayout(new GridLayout(5, 2));
		
//		//for문으로 Jbutton에 값 넣기
//		for(int i=0; i<jbtNames.length; i++) {
//		}//end for
		
		setBounds(200, 150, 300,400);
		setVisible(true);
		
	}//생성자

	public JButton[] getJbtNames() {
		return jbtNames;
	}
	
	
		

}//class
