package day1210;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//18.12.10  - 1번째 - (BorederLayout)
/**
 *	일반컴포넌트와 LayoutManager의 사용
 * @author owner
 */
//1. Window Component 상속    //받아야 되는 이유?  사용자에게 보여지는 일을 해야하기 때문
@SuppressWarnings("serial")//이거 하는 이유는 나중에 배우게 됨
public class UseBorderLayout  extends Frame{
	
	public UseBorderLayout() {
		super("BorderLayout 연습");			//하는 역할 : 부모의 생성자를 호출
		//2. 사용할 일반 컴포넌트를 생성
		TextField tfNorth = new TextField("North");
		Label lblEast= new Label("East");
		TextArea taCenter =new TextArea("Center");
		Label lblWest = new Label("West");
		Choice choSouth = new Choice();
		choSouth.add("South");
		
		//3. 배치관리자 설정 : Window Component인 Frame, Dialog는 BorderLayout 기본 설정
//		setLayout(new BorderLayout()); //기본설정 되어 있다. 썻다고 달라지는건 없다.
		
		//4. 컴포넌트의 배치관리자를 사용하여 배치
		// add("배치위치", 컴포넌트);		add(상수, 컴포넌트);
		// 문자열 상수 사용하여 배치
		add("North",tfNorth);
		add("Center",taCenter);// center만 배치하면 테두리인 North, West, South, East는 자리가 사라진다.
		//Constant( Field )를 사용하여 배치
		add(BorderLayout.WEST, lblWest);
		add(BorderLayout.EAST, lblEast);
		add(BorderLayout.SOUTH,choSouth);
		
		
		
		//5. 윈도우의 크기 설정
		setSize(400, 400);
									
		//6. 사용자에게 보여주기   (이것을 해야 보여지는 출력이 된다)
		setVisible(true);
		
		//7.종료
		addWindowListener(new WindowAdapter() {		// WindowAdapter()는 추상클래스이다
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
