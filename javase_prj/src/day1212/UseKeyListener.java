package day1212;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//18.12.12  -1번째 자료- (  )
/**
 *	Keyboard Event 처리
 * @author owner
 */
//1. Window component 상속, 이벤트 처리 리스너를 구현
@SuppressWarnings("serial")
public class UseKeyListener extends Frame implements KeyListener{
	
	public static final int ENTER=10;

//2. 이벤트와 관련있는 컴포넌트 선언
	private TextField tf;
	private Label lbl;
	
	public UseKeyListener() {
		super("키보드 이벤트의 연습");
	//3. 컴포넌트 생성	
		tf=new TextField();
		lbl=new Label("출력창",Label.CENTER );  //라벨을 가운데에 설정
		
	//4. 배치	
		setLayout(new BorderLayout());
		add("North",tf);
		add("Center", lbl);
		
	//5. 컴포넌트를 이벤트에 등록
		tf.addKeyListener( this );
		
	//6. 윈도우 크기 설정
		setBounds(100, 100, 400, 150);
		
	//7. 사용자에게 보여주기 (가시화)
		setVisible(true);
		
	//8. 윈도우 종료처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});
	}//UsedKeyListener
	

	@Override
	public void keyTyped(KeyEvent ke) {
	//2. 키가 눌려 정보가 전달되는 순간. 눌린 키의 정보중 문자만 를 알 수 있다.
//		System.out.println("KeyTyped");
	}//KeyTyped

	@Override
	public void keyPressed(KeyEvent ke) { 
	//1. 키보드의 키가 눌리는 순간이어서 키의 정보를 알수 없다.
//		System.out.println("KeyPressed");
	}//KeyPressed

	@Override
	public void keyReleased(KeyEvent ke) {
	//3. 눌린 키가 정보를 전달하고 다시 올라오는 순간. 눌린키의 정보를 알수 있다.
//		System.out.println("KeyEvent");
		
		//눌린키의 문자와 코드값을 얻어
		char inputKey=ke.getKeyChar();
		int inputCode=ke.getKeyCode(); 
		//keyCode는 키보드 키의 고유값 : uniCode와 다르게 같은 값이 나온다.
//		System.out.println(inputKey+" "+inputCode);
//		//출력 Label에 뿌린다.
		StringBuilder output=new StringBuilder();
		output.append("눌린키 문자 : ").append(inputKey).append(", 눌린키의 키코드 : ").append(inputCode);
		
		lbl.setText( output.toString());
		
		switch (inputCode) {
		case ENTER :
				//JDK1.7에서 발생한 버그 : TextField, TextArea는 setText("")를 바로 사용하면 초기화 되지 않는다.
				tf.getText(); //값을 한번 얻어낸후
				tf.setText(""); //초기화를 하면 초기화가 잘 된다.
			break;
		case KeyEvent.VK_ESCAPE :
			dispose();
		}//	end switch	
			
	
	}//KeyReleased

	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new UseKeyListener();
		
		
	}//main
}//class
